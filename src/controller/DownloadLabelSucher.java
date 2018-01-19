package controller;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DownloadLabelSucher {
	private String md2Pfad;
	
	public DownloadLabelSucher(String md2Pfad){
		this.md2Pfad = md2Pfad;
	}
	
	public List<String> findLables(){
		ArrayList<String> labels = new ArrayList<String>();
		String idDatei = "\\testprojekt.androidLollipop\\md2_app_TestprojektApp\\app\\src\\main\\res\\values\\ids.xml";
		
		try{
		FileReader fileIn2 = new FileReader(md2Pfad + idDatei);
		BufferedReader bufIn2 = new BufferedReader(fileIn2);

		String zeile2 = bufIn2.readLine();


		while (zeile2 != null) {


			if (zeile2.contains("DateiDownload_")) {
				labels.add(zeile2.substring(zeile2.indexOf('"') + 1, zeile2.indexOf("\" type")));	
			}

			zeile2 = bufIn2.readLine();
		}

		fileIn2.close();
		} catch (Exception e){
			e.printStackTrace();
		}

		return labels;
	}
}