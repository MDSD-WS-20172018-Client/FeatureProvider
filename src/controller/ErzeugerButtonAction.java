package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import features.*;

/**
 * Diese Klasse implementiert den ActionListener nur für den Erzeugen-Button in dem Hauptfenster.
 * Hier werdeen alle Klassen aus dem Paket features benutzt.
 *
 */
public class ErzeugerButtonAction implements ActionListener{
	
	private String md2Pfad;
	
	public ErzeugerButtonAction(String md2Pfad){
		this.md2Pfad = md2Pfad;
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
	}
	
}
