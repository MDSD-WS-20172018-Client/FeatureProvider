package md2.testprojekt.md2.model;

import java.io.Serializable;
import java.util.Map;

public class HomeFolder implements Serializable{
	private String folderID;
	private String token;
	private Map<String, String> files;
	private Map<String, String> folders;
	
	public HomeFolder(String folderID, String token, Map<String, String> files, Map<String, String> folders){
		this.folderID = folderID;
		this.token = token;
		this.files = files;
		this.folders = folders;
	}

	public String getFolderID() {
		return folderID;
	}

	public void setFolderID(String folderID) {
		this.folderID = folderID;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Map<String, String> getFiles() {
		return files;
	}

	public void setFiles(Map<String, String> files) {
		this.files = files;
	}
	
	public Map<String, String> getFolders() {
		return folders;
	}

	public void setFolders(Map<String, String> folders) {
		this.folders = folders;
	}
}
