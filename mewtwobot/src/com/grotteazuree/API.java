package com.grotteazuree;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class API {

	private static String apiURL = "https://www.pokepedia.fr/api.php";
//	private static String apiURL = "https://bulbapedia.bulbagarden.net/w/api.php";
//	private static String apiURL = "http://localhost/wiki/api.php";
	
	private static String backupPath = "/home/mewtwo/Nintendo/Pokepedia/Articles/";
	private static String sessionCookie = null;// cookie renvoyé par l'api
	private static Hashtable<String, String> sessionCookies = new Hashtable<String, String>();
	private static String charset = "UTF-8";
	private static String token= null;// token renvoyé par l'api
	
	private static boolean showLog = false;
	
	
	public static final String TYPE_EDIT = "edit";
	public static final String TYPE_MOVE = "move";
	public static final String TYPE_DELETE = "delete";
	
	public static final String TYPE_LOGIN = "login";
	public static final String TYPE_CSRF = "csrf";
	
	public static final String FILTER_ALL = "all";
	public static final String FILTER_REDIRECTS = "redirects";
	public static final String FILTER_NONREDIRECTS = "nonredirects";
	public static final int SEARCH_LIMIT = 5000;// 5000 pour les robots, 500 pour les sacs de viande
	public static final int NS_MAIN = 0;
	public static final int NS_MAIN_TALK = 1;
	public static final int NS_USER = 2;
	public static final int NS_USER_TALK = 3;
	public static final int NS_META = 4;
	public static final int NS_META_TALK = 5;
	public static final int NS_IMAGES = 6;
	public static final int NS_IMAGES_TALK = 7;
	public static final int NS_FILES = 6;
	public static final int NS_FILES_TALK = 7;
	public static final int NS_MEDIAWIKI = 8;
	public static final int NS_MEDIAWIKI_TALK = 9;
	public static final int NS_TEMPLATE = 10;
	public static final int NS_TEMPLATE_TALK = 11;
	public static final int NS_HELP = 12;
	public static final int NS_HELP_TALK = 13;
	public static final int NS_CATEGORY = 14;
	public static final int NS_CATEGORY_TALK = 15;
	public static final int NS_PORTAL = 100;
	public static final int NS_PORTAL_TALK = 101;
	public static final int NS_PROJECT = 102;
	
	public static final int NS_BOOK = 108;
	public static final int NS_BOOL_TALK = 109;
	
	public static final int NS_SPECIAL = -1;
	public static final int NS_MEDIA = -2;
	
	public static final int[] NS_ALL = {NS_MAIN, NS_MAIN_TALK, NS_USER, NS_USER_TALK, NS_META, NS_META_TALK,
		NS_IMAGES, NS_IMAGES_TALK, NS_MEDIAWIKI, NS_MEDIAWIKI_TALK, NS_TEMPLATE, NS_TEMPLATE_TALK, 
		NS_HELP, NS_HELP_TALK, NS_CATEGORY, NS_CATEGORY_TALK, NS_PORTAL, NS_PORTAL_TALK, NS_PROJECT, 
		103, 710, 711, 106, 107, 112, 113, 828, 829, NS_BOOK, NS_BOOL_TALK};
	public static final int[] NS_ALLBUTIMAGE = {NS_MAIN, NS_MAIN_TALK, NS_USER, NS_USER_TALK, NS_META, NS_META_TALK,
		NS_IMAGES_TALK, NS_MEDIAWIKI, NS_MEDIAWIKI_TALK, NS_TEMPLATE, NS_TEMPLATE_TALK, 
		NS_HELP, NS_HELP_TALK, NS_CATEGORY, NS_CATEGORY_TALK, NS_PORTAL, NS_PORTAL_TALK, NS_PROJECT, 
		103, 710, 711, 106, 107, 112, 113, 828, 829, NS_BOOK, NS_BOOL_TALK};
	
	/**
	 * Demande de token
	 * <pre>api.php?action=query&meta=tokens&type=xxxxx</pre>
	 * @param type le type de token ("login", ...)
	 * @return true si un token a été obtenu, false sinon
	 */
	private static boolean getToken(String type) {
		boolean success = false;
		Hashtable<String, String> parameters = new Hashtable<String, String>();
		parameters.put("action", "query");
		parameters.put("meta", "tokens");
		parameters.put("type", type);
		Document document = post(parameters);
		Element root = (Element) document.getElementsByTagName("api").item(0);
		NodeList nodeList = root.getElementsByTagName("error");
		if(nodeList.getLength()>0) {
			Element error = (Element) nodeList.item(0);
			System.err.println("GENERAL ERROR ["+error.getAttribute("code")+"] : "+error.getAttribute("code"));
		} else {
			nodeList = root.getElementsByTagName("query");
			if(nodeList.getLength()>0) {
				nodeList = root.getElementsByTagName("tokens");
				if(nodeList.getLength()>0) {
					Element element = (Element) nodeList.item(0);
					token = element.getAttribute(type+"token");
					success = true;
				} else {
					System.err.println("GENERAL ERROR : missing tokens node in the response");
				}
			} else {
				System.err.println("GENERAL ERROR : missing query node in the response");
			}
		}
		
		return success;
	}
	
	/**
	 * Demande d'identification auprès d'un wiki
	 * <pre>api.php?action=login&lgname=Bob&lgpassword=secret</pre> (deprecated)
	 * demande maintenant un pass robot : (se logguer puis : http://www.pokepedia.fr/Sp%C3%A9cial:BotPasswords )
	 * @param name nom d'utilisateur
	 * @param password mot de passe utilisateur
	 * @return true si l'identifation a réussi, false sinon
	 */
	public static boolean login(String name, String password) {
		return login(name, password, true);
	}
	
	/**
	 * Demande d'identification auprès d'un wiki
	 * <pre>api.php?action=login&lgname=Bob&lgpassword=secret&lgtoken=xxxxxxxxxxxxxxxxx</pre>
	 * @param name nom d'utilisateur
	 * @param password mot de passe utilisateur
	 * @param first variable interne pour les demandes en deux temps
	 * @return true si l'identifation a réussi, false sinon
	 */
	public static boolean login(String name, String password, boolean first) {
		if(first) {
			getToken(TYPE_LOGIN);
		}
		
		boolean success = false;
		Hashtable<String, String> parameters = new Hashtable<String, String>();
		parameters.put("action", "login");
		parameters.put("lgname", name);
		parameters.put("lgpassword", password);
		if(token!=null) {
			parameters.put("lgtoken", token);
		}

		Document document = post(parameters);
		Element root = (Element) document.getElementsByTagName("api").item(0);
		NodeList nodeList = root.getElementsByTagName("error");
		if(nodeList.getLength()>0) {
			Element error = (Element) nodeList.item(0);
			System.err.println("GENERAL ERROR ["+error.getAttribute("code")+"] : "+error.getAttribute("code"));
		} else {
			nodeList = root.getElementsByTagName("login");
			if(nodeList.getLength()>0) {
				Element element = (Element) nodeList.item(nodeList.getLength()-1);
				String result = element.getAttribute("result");
				//System.out.println("LOGIN RESULT ["+result+"]");
				if("Success".equals(result)) {
					success = true;
				} else {
					System.err.println("LOGIN ERROR ["+result+"]");
				}
				
			} else {
				System.err.println("GENERAL ERROR : missing login node in the response");
			}
		}

		return success;
	}
	
	/**
	 * Demande un token d'édition
	 * <pre>api.php?action=query&prop=info&intoken=edit&titles=xxxxxxxxx</pre>
	 * @param title le titre de la page à éditer
	 * @parem type le type de token souhaité
	 * @return true si un token a pu être obtenu, false sinon
	 */
	private static boolean getToken(String title, String type) {
		boolean success = false;
		Hashtable<String, String> parameters = new Hashtable<String, String>();
		parameters.put("action", "query");
		parameters.put("prop", "info");
		parameters.put("intoken", type);
		parameters.put("titles", title);

		Document document = post(parameters);
		Element root = (Element) document.getElementsByTagName("api").item(0);
		NodeList nodeList = root.getElementsByTagName("error");
		if(nodeList.getLength()>0) {
			Element error = (Element) nodeList.item(0);
			System.err.println("GENERAL ERROR ["+error.getAttribute("code")+"] : "+error.getAttribute("code"));
		} else {
			nodeList = root.getElementsByTagName("query");
			if(nodeList.getLength()>0) {
				nodeList = root.getElementsByTagName("pages");
				if(nodeList.getLength()>0) {
					nodeList = root.getElementsByTagName("page");
					if(nodeList.getLength()>0) {
						Element element = (Element) nodeList.item(0);
						token = element.getAttribute(type+"token");
						success = true;
					} else {
						System.err.println("GENERAL ERROR : missing page node in the response");
					}
				} else {
					System.err.println("GENERAL ERROR : missing pages node in the response");
				}
			} else {
				System.err.println("GENERAL ERROR : missing query node in the response");
			}
		}
		return success;
	}
	
	/**
	 * Demande un token d'édition
	 * <pre>api.php?action=query&prop=info&intoken=edit&titles=xxxxxxxxx</pre>
	 * @param pageid l'id de la page à éditer
	 * @parem type le type de token souhaité
	 * @return true si un token a pu être obtenu, false sinon
	 */
	private static boolean getToken(int pageid, String type) {
		boolean success = false;
		Hashtable<String, String> parameters = new Hashtable<String, String>();
		parameters.put("action", "query");
		parameters.put("prop", "info");
		parameters.put("intoken", type);
		parameters.put("pageids", pageid+"");

		Document document = post(parameters);
		Element root = (Element) document.getElementsByTagName("api").item(0);
		NodeList nodeList = root.getElementsByTagName("error");
		if(nodeList.getLength()>0) {
			Element error = (Element) nodeList.item(0);
			System.err.println("GENERAL ERROR ["+error.getAttribute("code")+"] : "+error.getAttribute("code"));
		} else {
			nodeList = root.getElementsByTagName("query");
			if(nodeList.getLength()>0) {
				nodeList = root.getElementsByTagName("pages");
				if(nodeList.getLength()>0) {
					nodeList = root.getElementsByTagName("page");
					if(nodeList.getLength()>0) {
						Element element = (Element) nodeList.item(0);
						token = element.getAttribute(type+"token");
						success = true;
					} else {
						System.err.println("GENERAL ERROR : missing page node in the response");
					}
				} else {
					System.err.println("GENERAL ERROR : missing pages node in the response");
				}
			} else {
				System.err.println("GENERAL ERROR : missing query node in the response");
			}
		}
		return success;
	}
	
	/**
	 * Envoi POST vers l'api
	 * @param parameters la liste des parametres à envoyer en post
	 * @return la reponse xml de l'api
	 */
	public static Document post(Hashtable<String, String> parameters) {
		return post(parameters, null);
	}
	
	/**
	 * Envoi POST vers l'api
	 * @param parameters la liste des parametres à envoyer en post
	 * @param file un fichier à uploader.
	 * @return la reponse xml de l'api
	 */
	public static Document post(Hashtable<String, String> parameters, File file) {
		Document document = null;
		DataOutputStream writer = null;
		BufferedReader reader = null;
		
		parameters.put("format", "xml");
		
		try {
			//création de la connection
			String boundary = "===" + System.currentTimeMillis() + "===";
			URL url = new URL(apiURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput (true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			
			if(sessionCookie!=null) {
				conn.setRequestProperty("Cookie", sessionCookie);
				//System.out.println("Cookie sent back ["+sessionCookie+"]");
			}
			
			if(file==null) {
				//encodage des paramètres de la requête
				StringBuffer data = new StringBuffer();
				Enumeration<String> paramNames = parameters.keys();
				while(paramNames.hasMoreElements()) {
					if(data.length()>0) {
						data.append("&");
					}
					String paramName = paramNames.nextElement();
					String paramValue;
					try {
						paramValue = URLEncoder.encode(parameters.get(paramName), charset);
					} catch (Exception e) {
						paramValue = parameters.get(paramName);
					}
					data.append(paramName+"="+paramValue);
				}
				
				//System.out.println(apiURL+"?"+data);
				
				//ecriture de la requête
				writer = new DataOutputStream(conn.getOutputStream());
				writer.writeBytes(data.toString());
				writer.flush();
				
			} else {
		        conn.setRequestProperty("Content-Type", "multipart/form-data; boundary="+boundary);
				writer = new DataOutputStream(conn.getOutputStream());
		        				
				// fichier
				{
					String fileName = file.getName();
					writer.writeBytes("--" + boundary);
					writer.writeBytes("\r\n");
					writer.writeBytes("Content-Disposition: form-data; name=\"file\"; filename=\"" + fileName + "\"");
					writer.writeBytes("\r\n");
					writer.writeBytes("Content-Type: application/octet-stream");
					writer.writeBytes("\r\n");
					writer.writeBytes("Content-Transfer-Encoding: binary");
					writer.writeBytes("\r\n");
					writer.writeBytes("\r\n");
			        FileInputStream fis = new FileInputStream(file);
			        int c;
					while ((c = fis.read()) != -1) {
						writer.write(c);
					}
					fis.close();
					writer.writeBytes("\r\n");
				}
				
				//encodage des paramètres de la requête
				Enumeration<String> paramNames = parameters.keys();
				while(paramNames.hasMoreElements()) {
					String paramName = paramNames.nextElement();
					String paramValue = parameters.get(paramName);
					writer.writeBytes("--" + boundary);
					writer.writeBytes("\r\n");
					writer.writeBytes("Content-Disposition: form-data; name=\"" + paramName + "\"");
					writer.writeBytes("\r\n");
					writer.writeBytes("Content-Type: text/plain; charset="+charset);
					writer.writeBytes("\r\n");
					writer.writeBytes("\r\n");
					writer.writeBytes(new String(paramValue.getBytes("UTF-8"), "ISO-8859-1"));
					writer.writeBytes("\r\n");
				}
				
				writer.writeBytes("--" + boundary + "--");
				writer.writeBytes("\r\n");
		        writer.flush();
			}
			

			//lecture de la réponse
			String cookieHeader = conn.getHeaderField("Set-Cookie");
			if(cookieHeader!=null) {
				String cookieName = cookieHeader.split(";")[0].split("=")[0];
				String cookieValue = cookieHeader.split(";")[0].split("=")[1];
				sessionCookies.put(cookieName, cookieValue);
				sessionCookie = "";
				Enumeration<String> keys = sessionCookies.keys();
				while(keys.hasMoreElements()) {
					String key = keys.nextElement();
					sessionCookie += (sessionCookie.length()==0?"":"; ")+key+"="+sessionCookies.get(key);
				}
				//System.out.println("Cookie received");
				//System.out.println(cookieHeader);
			}
			
			Map<String,List<String>> headers = conn.getHeaderFields();
			Set<String> keys = headers.keySet();
			Iterator<String> iterator = keys.iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				/*
				System.out.println("header ["+key+"]");
				System.out.println("values : ");
				*/
				List<String> values = headers.get(key);
				/*
				for(int i=0; i<values.size(); i++) {
					System.out.println("\t["+values.get(i)+"]");
				}
				*/
				if("Set-Cookie".equals(key)) {
					for(int i=0; i<values.size(); i++) {
						String cookieName = values.get(i).split(";")[0].split("=")[0];
						String cookieValue = values.get(i).split(";")[0].split("=")[1];
						sessionCookies.put(cookieName, cookieValue);
					}
				}
			}
			
			sessionCookie = "";
			Enumeration<String> cookiesKeys = sessionCookies.keys();
			while(cookiesKeys.hasMoreElements()) {
				String key = cookiesKeys.nextElement();
				sessionCookie += (sessionCookie.length()==0?"":"; ")+key+"="+sessionCookies.get(key);
			}
			
			StringBuffer response = new StringBuffer();
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String ligne;
			while ((ligne = reader.readLine()) != null) {
				response.append(ligne+"\n");
			}
			
			if(showLog) {
				System.out.println(conn.getResponseCode());
				System.out.println(conn.getResponseMessage());
				System.out.println(response);
			}
			
			// parse xml
			DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = parser.parse(new InputSource(new StringReader(response.toString())));
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {writer.close();} catch (Exception e) {}
			try {reader.close();} catch (Exception e) {}
		}

		return document;
	}
	
	/**
	 * Upload d'un fichier
	 * <pre>api.php?action=upload&filename=Test.txt&file=file_contents_here&token=+\</pre>
	 * 
	 * Exemple d'utilisation :
	 * 
	 * 	File file = new File("/home/mewtwo/Bureau/Nintendo/Pokepedia/XY/Sprites/arobase.gif");
	 *	if(file.exists() && file.canRead()) {
	 *	bot.upload("Fichier:Mewtwo_Ex_Test.gif",
	 *			file,
	 *			"{{Image personnelle}}",
	 *			"Test d'upload");
	 *	} else {
	 *		System.err.println("file error");
	 *	}
	 * 
	 * @param filename nom de destination
	 * @param file fichier local
	 * @param text description du fichier
	 * @param comment resumé de modification
	 * @return true si l'upload a réussi, false sinon
	 */
	public static boolean upload(String filename, File file, String text, String comment) {
		boolean success = true;
		
		if(getToken(API.TYPE_CSRF)) {
			Hashtable<String, String> parameters = new Hashtable<String, String>();
			parameters.put("action", "upload");
			parameters.put("filename", filename);
			parameters.put("text", text);
			parameters.put("comment", comment);
			parameters.put("token", token);
			parameters.put("ignorewarnings", "1");

			Document document = post(parameters, file);
			//TODO traiter le xml de retour
		}
		
		return success;
	}
	
	/**
	 * Remplit un article avec un nouveau contenu
	 * @param content le contenu de l'article
	 * @param summary le résumé de la modification
	 * @return true en cas de réussite et false sinon
	 */
	public static boolean send(String title, String content, String summary) {
		boolean success = false;
		//if(getToken(title, API.TYPE_EDIT)) {
		if(getToken(API.TYPE_CSRF)) {
			Hashtable<String, String> parameters = new Hashtable<String, String>();
			parameters.put("action", "edit");
			parameters.put("title", title);
			parameters.put("text", content);
			if(summary!=null) {
				parameters.put("summary", summary);
			}
			parameters.put("bot", "true");
			parameters.put("token", token);
			
			Document document = API.post(parameters);
			Element root = (Element) document.getElementsByTagName("api").item(0);
			NodeList nodeList = root.getElementsByTagName("error");
			if(nodeList.getLength()>0) {
				Element error = (Element) nodeList.item(0);
				System.err.println("["+error.getAttribute("code")+"] : "+error.getAttribute("code"));
			} else {
				nodeList = root.getElementsByTagName("edit");
				if(nodeList.getLength()>0) {
					Element element = (Element) nodeList.item(0);
					success = (element.getAttribute("result").equals("Success"));
				} else {
					System.err.println("missing edit node in the response");
				}
			}
		}
		
		return success;
	}
	
	/**
	 * Déplacement/renommage d'un article
	 * 
	 * @param from le titre actuel de l'article
	 * @param to le nouveau titre de l'article
	 * @param keepRedirect true pour maintenir une redirection, false sinon
	 * @param reason raison du renommage
	 * @return true si le renommage a réussi, false sinon
	 */
	public static boolean rename(String from, String to, boolean keepRedirect, String reason) {
		boolean success = false;
		
		if(getToken(from, TYPE_MOVE)) {
			Hashtable<String, String> parameters = new Hashtable<String, String>();
			parameters.put("action", "move");
			parameters.put("from", from);
			parameters.put("to", to);
			if(!keepRedirect) {
				parameters.put("noredirect", "");
			}
			parameters.put("movetalk", "");
			parameters.put("movesubpages", "");
			parameters.put("ignorewarnings", "");
			if(reason!=null) {
				parameters.put("reason", reason);
			}
			parameters.put("token", token);

			Document document = post(parameters);
			//TODO traiter le xml de retour
		}
		
		return success;
	}
	
	
	/**
	 * Suppression d'un article
	 * <pre>api.php?action=delete&title=MonTitre&token=+\</pre>
	 * 
	 * Exemple d'utilisation :
	 * 
	 * 	bot.delete("Fichier:Miniat 5 n Keunotor.gif");
	 * 
	 * @param title titre de l'article
	 * @return true si la suppression a réussi, false sinon
	 */
	public static boolean delete(String title) {
		return delete(title, null);
	}
	
	/**
	 * Suppression d'un article
	 * <pre>api.php?action=delete&title=MonTitre&token=+\</pre>
	 * 
	 * Exemple d'utilisation :
	 * 
	 * 	bot.delete("Fichier:Miniat 5 n Keunotor.gif");
	 * 
	 * @param title titre de l'article
	 * @param reason raison de la suppression
	 * @return true si la suppression a réussi, false sinon
	 */
	public static boolean delete(String title, String reason) {
		boolean success = false;
		
		if(getToken(title, TYPE_DELETE)) {
			Hashtable<String, String> parameters = new Hashtable<String, String>();
			parameters.put("action", "delete");
			parameters.put("title", title);
			if(reason!=null) {
				parameters.put("reason", reason);
			}
			parameters.put("token", token);

			Document document = post(parameters);
			//TODO traiter le xml de retour
		}
		
		return success;
	}
	
	/**
	 * Suppression d'un article
	 * <pre>api.php?action=delete&pageid=xxx&token=+\</pre>
	 * 
	 * @param pageid id de l'article
	 * @param reason raison de la suppression
	 * @return true si la suppression a réussi, false sinon
	 */
	public static boolean delete(int pageid, String reason) {
		boolean success = false;
		
		if(getToken(pageid, TYPE_DELETE)) {
			Hashtable<String, String> parameters = new Hashtable<String, String>();
			parameters.put("action", "delete");
			parameters.put("pageid", pageid+"");
			if(reason!=null) {
				parameters.put("reason", reason);
			}
			parameters.put("token", token);

			Document document = post(parameters);
			//TODO traiter le xml de retour
		}
		
		return success;
	}
	
	/**
	 * Renvoie le chemin du dossier de backup
	 * @return le chemin du dossier de backup (sans blague)
	 */
	public static String getBackupPath() {
		return backupPath;
	}
	
}
