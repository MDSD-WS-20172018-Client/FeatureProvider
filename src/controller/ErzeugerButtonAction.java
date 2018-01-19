package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import features.*;
import gui.FeatureProviderHauptfenster;

/**
 * Diese Klasse implementiert den ActionListener nur f�r den Erzeugen-Button in
 * dem Hauptfenster. Hier werdeen alle Klassen aus dem Paket features benutzt.
 *
 */
public class ErzeugerButtonAction implements ActionListener {

	private String md2Pfad;
	private String baseUrlText;
	HashMap<String, Boolean> auswahlRest;
	private JComboBox dateiListViewPosition;
	private JComboBox ordnerListViewPosition;

	public ErzeugerButtonAction(String md2Pfad, JTextField baseUrlText, HashMap<String, Boolean> auswahlRest, JComboBox dateiPosition, JComboBox ordnerPosition) {
		this.md2Pfad = md2Pfad;
		this.baseUrlText = baseUrlText.getText();
		this.auswahlRest = auswahlRest;
		this.dateiListViewPosition = dateiPosition;
		this.ordnerListViewPosition = ordnerPosition;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		erzeugeStartViewFeatures(); // Immer erzeugen
		erzeugeKonfigurationen(); // Immer erzeugen (Behebt Probleme mit der Gradle-Version)
		if (auswahlRest.containsValue(true)) { //Wenn REST-Services ausgew�hlt wurden
			erzeugeNutzerOperationen();
			erzeugeAndroidManifestFeatures();
			erzeugeDownloadFeatures();
		}
	}

	/**
	 * Methode f�r die Erzeugung der StartViewFeatures
	 */
	private void erzeugeStartViewFeatures() {
		StartViewFeatures svf = new StartViewFeatures(this.md2Pfad);
		svf.createCloseFunction();
	}

	/**
	 * Methode zum Erzeugen der Konfigurationen der App
	 */
	private void erzeugeKonfigurationen() {
		GradleBuildFeatures gbf = new GradleBuildFeatures(this.md2Pfad);
		gbf.setClassPath();
		gbf.setAppDependencies();
	}

	/**
	 * Methode zum Erzeugen der Nutzeroperationen: Nutzer anlegen, Nutzer
	 * anmelden, Nutzer abmelden
	 */
	private void erzeugeNutzerOperationen() {
		NutzerFeatures nf = new NutzerFeatures(this.md2Pfad);
		nf.erstelleNutzerklasse();
		nf.erstelleNutzerTask();
		if (auswahlRest.get(FeatureProviderHauptfenster.REGISTERSTRING)){ //nur wenn Registerfunktion ausgew�hlt wurde
			nf.erstelleRegistrirungsfunktion();
		}
		if (auswahlRest.get(FeatureProviderHauptfenster.LOGINSTRING)){ //nur wenn Einloggenfunktion ausgew�hlt
			nf.erstelleEinloggenfunktion();
			nf.erstelleHomeFolderklasse();
		}
	}

	/**
	 * Methode zum Erzeugen der Downloadfeatures
	 */
	private void erzeugeDownloadFeatures() {
		DownloadFeatures df = new DownloadFeatures(md2Pfad, (String)dateiListViewPosition.getSelectedItem(), (String)ordnerListViewPosition.getSelectedItem());
		if (auswahlRest.get(FeatureProviderHauptfenster.LOGINSTRING)){ //nur wenn Einloggenfunktion ausgew�hlt
			df.erweitereDownloadView(); //Geh�rt mit zu Login
			df.erzeugeListenBefuellen(); //Geh�rt mit zu Login
		}
	}

	/**
	 * Methode zum Erzeugen der Eintr�ge in der Android Manifest xml-Datei
	 */
	private void erzeugeAndroidManifestFeatures() {
		AndroidManifestFeatures amf = new AndroidManifestFeatures(md2Pfad);
		amf.erzeugePermissions();
	}

}
