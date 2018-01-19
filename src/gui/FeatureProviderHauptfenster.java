package gui;

import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.CheckboxAction;
import controller.DownloadLabelSucher;
import controller.ErzeugerButtonAction;
import controller.FensterSchliesser;

public class FeatureProviderHauptfenster extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 874423262685922129L;
	
	/*
	 * Konstante zum allgemeinen Gebrauch
	 */
	public static final String LOGINSTRING = "Nutzer Login/Logout";
	public static final String REGISTERSTRING = "Nutzer Registrieren";
	public static final String DATEIANLEGENSTRING = "Datei hochladen";
	public static final String ORDNERANLEGENSTRING = "Ordner anlegen";
	
	public FeatureProviderHauptfenster(String title, String pfad) throws HeadlessException {
		super(title);
		
		//Variablen zur Verwaltung
		HashMap<String, Boolean> restAuswahl = new HashMap<String, Boolean>();
		
		//Allgemeine Einstellungen zum Fenster
		setSize(512, 512);
		addWindowListener(new FensterSchliesser());
		setLocationRelativeTo(null);
		GridLayout layout = new GridLayout(0, 1);
		getContentPane().setLayout(layout);
		
		//Elemente zur Auswahl der Position erzeugen
		DownloadLabelSucher dls = new DownloadLabelSucher(pfad);
		ArrayList<String> labels = (ArrayList<String>) dls.findLables();
		
		//Elemente erzeugen
		JButton erzeugerbutton = new JButton("Erzeuge Features");
		JTextField urlText = new JTextField("34.238.158.85:8080/api");  //Vorbereitung, wenn man das Tool universeller machen wollte
		JComboBox auswahlposition1 = new JComboBox(labels.toArray());
		JComboBox auswahlposition2 = new JComboBox(labels.toArray());
		//Die Elemente gruppieren, die bei dem REST-Service verwendet werden können
		Checkbox userLogin = new Checkbox(LOGINSTRING);
		Checkbox userRegister = new Checkbox(REGISTERSTRING);
		Checkbox dateiHochladen = new Checkbox(DATEIANLEGENSTRING);
		Checkbox ordnerErstellen = new Checkbox(ORDNERANLEGENSTRING);
		
		// Solange die Funktionen noch nicht implementiert worden sind
		dateiHochladen.setEnabled(false);
		ordnerErstellen.setEnabled(false);
		
		//Initialisierung der Hashmap mit den Werten zur Verwaltung der REST-Features
		restAuswahl.put(LOGINSTRING, false);
		restAuswahl.put(REGISTERSTRING, false);
		restAuswahl.put(DATEIANLEGENSTRING, false);
		restAuswahl.put(ORDNERANLEGENSTRING, false);
		
		//Checkboxen mit Itemlistener versehen
		userLogin.addItemListener(new CheckboxAction(restAuswahl));
		userRegister.addItemListener(new CheckboxAction(restAuswahl));
		dateiHochladen.addItemListener(new CheckboxAction(restAuswahl));
		ordnerErstellen.addItemListener(new CheckboxAction(restAuswahl));
		
		//Elemente zu dem Fenster hinzufügen
		getContentPane().add(new JLabel("Die Funktion die App zu schliessen wird immer erzeugt."));
		getContentPane().add(new JLabel("Rest-Service"));
		getContentPane().add(userLogin);
		getContentPane().add(new JLabel("Position ListView Dateien"));
		getContentPane().add(auswahlposition1);
		getContentPane().add(new JLabel("Position ListView Ordner"));
		getContentPane().add(auswahlposition2);
		getContentPane().add(userRegister);
		getContentPane().add(dateiHochladen);
		getContentPane().add(ordnerErstellen);
		//Button zum Schluss hinzufügen
		getContentPane().add(erzeugerbutton);
		
		//Aktion auf den Button legen
		erzeugerbutton.addActionListener(new ErzeugerButtonAction(pfad, urlText, restAuswahl, auswahlposition1, auswahlposition2));
	}

}
