package com.grotteazuree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Hashtable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Page {
	private String title;
	private Date touched;
	private String content;
	
	/**
	 * Constructeur idéal pour les créations de page
	 * @param title titre de la page
	 */
	public Page(String title) {
		this.title = title;
		touched = new Date();
		content = null;
	}
	
	/**
	 * Constructeur pour PageCollection
	 * @param title titre de la page
	 * @param touched la date de dernière modif de la page
	 */
	public Page(String title, Date touched) {
		this.title = title;
		this.touched = touched;
		content = null;
	}
	
	/**
	 * Renvoie le titre de la page
	 * @return le titre de la page (sisi)
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Synchronise le backup
	 * <pre>api.php?action=query&prop=revisions&rvlimit=1&rvprop=content&format=xml&titles=MonTitre</pre>
	 * 
	 * @return le contenu textuel de la page
	 */
	public void sync() {
		getContent(false);
	}
	
	/**
	 * Fournit le contenu de la page. S'il n'a pas encore été chargé en mémoire, 
	 * on vérifie d'abord si une version à jour existe en backup, 
	 * puis on interroge l'api s'il le faut vraiment.
	 * <pre>api.php?action=query&prop=revisions&rvlimit=1&rvprop=content&format=xml&titles=MonTitre</pre>
	 * 
	 * @return le contenu textuel de la page
	 */
	public String getContent() {
		return getContent(true);
	}
	
	/**
	 * Fournit le contenu de la page. S'il n'a pas encore été chargé en mémoire, 
	 * on vérifie d'abord si une version à jour existe en backup, 
	 * puis on interroge l'api s'il le faut vraiment.
	 * <pre>api.php?action=query&prop=revisions&rvlimit=1&rvprop=content&format=xml&titles=MonTitre</pre>
	 * 
	 * @param useBackup si false, ignore le rechargement du texte depuis le backup, et récupère systématiquement depuis le wiki.
	 * 
	 * @return le contenu textuel de la page
	 */
	public String getContent(boolean useBackup) {
		if(content==null) {
			File file = new File(API.getBackupPath()+title.replaceAll("/","#slash#"));
			//interrogation du backup
			if(useBackup && file.exists() && file.lastModified()>=touched.getTime()) {
					//FileInputStream fis = null;
					BufferedReader in = null;
					try {
						
						StringBuffer b = new StringBuffer();
						/*
						int c;
						while ((c = fis.read()) != -1) {
							b.append((char) c);
						}
						content = b.toString();
						*/
						
						in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
						String str;
						while ((str = in.readLine()) != null) {
						    b.append(str+"\n");
						}
						content = b.toString();
						
						//System.out.println("["+title+"]loaded from backup");
					} catch (Exception e) {
						System.err.println(e.getMessage());
						e.printStackTrace();
					} finally {
						/*
						try {fis.close();} catch (Exception e) {}
						fis = null;
						 */						
						try {in.close();} catch (Exception e) {}
						in = null;
					}
			} else {
				// recuperation depuis le wiki
				Hashtable<String, String> parameters = new Hashtable<String, String>();
				parameters.put("action", "query");
				parameters.put("format", "xml");
				parameters.put("prop", "revisions");
				parameters.put("rvlimit", "1");
				parameters.put("rvprop", "content");
				parameters.put("titles", title);
				parameters.put("continue", "");
		
				Document document = API.post(parameters);
				Element root = (Element) document.getElementsByTagName("api").item(0);
				NodeList nodeList = root.getElementsByTagName("error");
				if(nodeList.getLength()>0) {
					Element error = (Element) nodeList.item(0);
					System.err.println("["+error.getAttribute("code")+"] : "+error.getAttribute("code"));
				} else {
					nodeList = root.getElementsByTagName("query");
					if(nodeList.getLength()>0) {
						nodeList = ((Element)nodeList.item(0)).getElementsByTagName("pages");
						if(nodeList.getLength()>0) {
							nodeList = ((Element)nodeList.item(0)).getElementsByTagName("page");
							if(nodeList.getLength()>0) {
								nodeList = ((Element)nodeList.item(0)).getElementsByTagName("revisions");
								if(nodeList.getLength()>0) {
									nodeList = ((Element)nodeList.item(0)).getElementsByTagName("rev");
									if(nodeList.getLength()>0) {
										content = nodeList.item(0).getTextContent();
										//System.out.println("["+title+"] loaded from wiki");
									} else {
										System.err.println("missing rev node in the response");
									}
								} else {
									System.err.println("missing revisions node in the response");
								}
							} else {
								System.err.println("missing page node in the response");
							}
						} else {
							System.err.println("missing pages node in the response");
						}
					} else {
						System.err.println("missing query node in the response");
					}
				}
				// copie vers le backup
//				if(content!=null) {
//					FileOutputStream fileOS = null;
//					try {
//						fileOS = new FileOutputStream(file);
//						fileOS.write(content.getBytes("UTF-8"));
//					} catch (Exception e) {
//						System.err.println(e.getMessage());
//						e.printStackTrace();
//					} finally {
//						try {fileOS.close();} catch (Exception e) {}
//						fileOS = null;
//					}
//				}
			}
		}
		return content;
	}
	
	/**
	 * Remplit l'article avec un nouveau contenu, et met à jour le cache
	 * @param content le contenu de l'article
	 * @param summary le résumé de la modification
	 * @return true en cas de réussite et false sinon
	 */
	public boolean setContent(String content, String summary) {
		boolean success = false;
		if(content!=null) {
			if(API.send(title, content, summary)) {
				File file = new File(API.getBackupPath()+title.replaceAll("/","#slash#"));
//				FileOutputStream fileOS = null;
//				try {
//					fileOS = new FileOutputStream(file);
//					fileOS.write(content.getBytes("UTF-8"));
//					success = true;
//				} catch (Exception e) {
//					System.err.println(e.getMessage());
//					e.printStackTrace();
//				} finally {
//					try {fileOS.close();} catch (Exception e) {}
//					fileOS = null;
//				}
			}
		}
		return success;
	}
	

}
