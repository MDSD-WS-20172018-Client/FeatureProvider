package gui;

import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ErzeugerButtonAction;
import controller.FensterSchliesser;

public class FeatureProviderHauptfenster extends JFrame {
	private String pfad;

	public FeatureProviderHauptfenster(String title, String pfad) throws HeadlessException {
		super(title);
		this.pfad = pfad;
		
		setSize(512, 512);
		setLocationRelativeTo(null);
		GridLayout layout = new GridLayout(0, 1);
		getContentPane().setLayout(layout);
		getContentPane().add(new JLabel("Die Funktion die App zu schliessen wird immer erzeugt."));
		JButton erzeugerbutton = new JButton("Erzeuge Features");
		erzeugerbutton.addActionListener(new ErzeugerButtonAction(pfad));
		getContentPane().add(erzeugerbutton);
		addWindowListener(new FensterSchliesser());
	}

}
