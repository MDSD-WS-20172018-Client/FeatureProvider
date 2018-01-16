package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JTextField;

import features.*;

/**
 * Diese Klasse implementiert den ActionListener nur für den Erzeugen-Button in dem Hauptfenster.
 * Hier werdeen alle Klassen aus dem Paket features benutzt.
 *
 */
public class ErzeugerButtonAction implements ActionListener{
	
	private String md2Pfad;
	private String baseUrlText;
	HashMap<String, Boolean> auswahlRest;
	
	public ErzeugerButtonAction(String md2Pfad, JTextField baseUrlText, HashMap<String, Boolean> auswahlRest){
		this.md2Pfad = md2Pfad;
		this.baseUrlText = baseUrlText.getText();
		this.auswahlRest = auswahlRest;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		erzeugeStartViewFeatures();
		
	}
	
	/**
	 * Methode für die Erzeugung der StartViewFeatures
	 */
	private void erzeugeStartViewFeatures(){
		StartViewFeatures svf = new StartViewFeatures(this.md2Pfad);
		svf.createCloseFunction();
		GradleBuildFeatures gbf = new GradleBuildFeatures(this.md2Pfad);
		gbf.setClassPath();
		gbf.setAppDependencies();
	}
	
}
