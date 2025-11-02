package silvallie;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class PageCollection {

	private LinkedHashMap<String, Date> pages;
	private Iterator<String> titles;
	
	/**
	 * Constructeur par défaut. Charge les pages de l'espace de nom principal, redirections incluses.
	 */
	public PageCollection() {
		load(new int[] {API.NS_MAIN}, API.FILTER_ALL, null);
	}
	
	/**
	 * Constructeur permettant de charger les pages de plusieurs espaces de nom.
	 * @param namespaces un tableau d'espaces de nom
	 * @param filter_redirect filtre concernant les redirections
	 */
	public PageCollection(int[] namespaces, String filter_redirect) {
		load(namespaces, filter_redirect, null);
	}
	
	/**
	 * Constructeur permettant de charger les pages de plusieurs espaces de nom.
	 * @param namespaces un tableau d'espaces de nom
	 * @param filter_redirect filtre concernant les redirections
	 * @param category_name filtre suivant une catégorie (sans namespace devant). Si non null, filter_redirect est ignoré.
	 */
	public PageCollection(int[] namespaces, String filter_redirect, String category_name) {
		load(namespaces, filter_redirect, category_name);
	}

	/**
	 * Récupère la liste de tous les titres d'articles
	 * 
	 * @param namespaces les numéros des espaces de nom à explorer
	 * @param filter_redirect indique si on veut lister les rediections ou non
	 * @param category_name filtre suivant une catégorie (sans namespace devant). Si non null, filter_redirect est ignoré.
	 * @return la liste des noms d'articles
	 */
	private void load(int[] namespaces, String filter_redirect, String category_name) {
		pages = new LinkedHashMap<String, Date>();
		for(int i=0; i<namespaces.length; i++) {
			System.out.println("loading list for namespace "+namespaces[i]+"...");
			String offset = null;
			do {
				offset = loadsub(namespaces[i], filter_redirect, category_name, offset);
			} while (offset!=null);
		}
		titles = pages.keySet().iterator();
	}
	
	/**
	 * Subroutine pour load
	 * 
	 * La limite étant de 5000 (500 pour les humains), on doit effectuer plusieurs appels pour avoir une liste vraiment complète.
	 * <pre>api.php?action=query&format=xml&generator=allpages&aplimit=500&gapfrom=&prop=info</pre>
	 * 
	 * @param namespace le numéro de l'espace de nom à explorer
	 * @param filter_redirect indique si on veut lister les rediections ou non
	 * @param category_name filtre suivant une catégorie (sans namespace devant). Si non null, filter_redirect est ignoré.
	 * @param from le nom de l'article "d'offset". Fournir null la première fois.
	 * @return Le titre du prochain article d'offset. Si null, c'est qu'il n'y a plus rien à lister après l'appel courant de la fonction.
	 */
	private String loadsub(int namespace, String filter_redirect, String category_name, String from) {
		String offset = null;
		String offsetAttribute = "";
		Hashtable<String, String> parameters = new Hashtable<String, String>();
		parameters.put("action", "query");
		parameters.put("format", "xml");
		parameters.put("prop", "info");
		if(category_name!=null) {
			offsetAttribute = "gcmcontinue";
			parameters.put("generator", "categorymembers");
			parameters.put("gcmlimit", API.SEARCH_LIMIT+"");
			parameters.put("gcmnamespace", namespace+"");
			parameters.put("gcmtitle", "Catégorie:"+category_name);
			parameters.put("gcmtype", "page|file");
		} else {
			offsetAttribute = "gapcontinue";
			parameters.put("generator", "allpages");
			parameters.put("gaplimit", API.SEARCH_LIMIT+"");
			parameters.put("gapnamespace", namespace+"");
			parameters.put("gapfilterredir", filter_redirect);
		}
		if(from!=null) {
			parameters.put(offsetAttribute, from);
		}
		parameters.put("continue", "");

		Document document = API.post(parameters);
		Element root = (Element) document.getElementsByTagName("api").item(0);
		NodeList nodeList = root.getElementsByTagName("error");
		if(nodeList.getLength()>0) {
			Element error = (Element) nodeList.item(0);
			System.err.println("["+error.getAttribute("code")+"] : "+error.getAttribute("code"));
		} else {
			//recup offset
			nodeList = root.getElementsByTagName("continue");
			if(nodeList.getLength()>0) {
				offset = ((Element)nodeList.item(0)).getAttribute(offsetAttribute);
				if(offset.length()==0) {
					offset = null;
				}
			} // si noeud manquant, c'est qu'on est sur la dernière page du listing
			
			// recup titres
			nodeList = root.getElementsByTagName("query");
			if(nodeList.getLength()>0) {
				nodeList = ((Element)nodeList.item(0)).getElementsByTagName("pages");
				if(nodeList.getLength()>0) {
					nodeList = ((Element)nodeList.item(0)).getElementsByTagName("page");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
					for(int i=0; i<nodeList.getLength(); i++) {
						String title = ((Element)nodeList.item(i)).getAttribute("title");
						if(title.length()>0) {
							String touched = ((Element)nodeList.item(i)).getAttribute("touched");
							try {
								pages.put(title, sdf.parse(touched));
							} catch (Exception e) {
								System.err.println("page ["+title+"] touched  ["+touched+"] is invalid");
								e.printStackTrace();
							}
						}
					}
				} else {
					System.err.println("missing pages node in the response");
				}
			} else {
				System.err.println("missing query node in the response");
			}
		}
		return offset;
	}
	
	/**
	 * Renvoie la prochaine page de la collection
	 * @return un objet Page, ou null si la fin de la collection a été atteinte.
	 */
	public Page getNextPage() {
		if(titles.hasNext()) {
			String title = titles.next();
			return new Page(title, pages.get(title));
		} else {
			return null;
		}
	}
	
	/**
	 * "Rembobine" la collection pour d'éventuels parcours supplémentaires
	 */
	public void rewind() {
		titles = pages.keySet().iterator();
	}
	
	/**
	 * Indique si une page en particulier est présente dans la collection ou non
	 * @param title le titre de la page recherchée
	 * @return true si la page est bien présente dans la collection, false sinon
	 */
	public boolean hasPage(String title) {
		return (title!=null && pages.containsKey(title));
	}
	
	/**
	 * Renvoie une page en particulier de la collection
	 * @param title le titre de la page recherchée
	 * @return un objet Page, ou null si le titre n'a pas été trouvé
	 */
	public Page getPage(String title) {
		if(hasPage(title)) {
			return new Page(title, pages.get(title));
		}
		return null;
	}

}
