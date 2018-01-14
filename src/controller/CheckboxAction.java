package controller;

import java.awt.Checkbox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

public class CheckboxAction implements ItemListener {
	HashMap<String, Boolean> checkboxEntries;

	/**
	 * Dieser Konstruktor bekommt ein CheckboxElement und die Liste der
	 * Einträge.
	 * 
	 * @param box
	 * @param checkboxEntries
	 */
	public CheckboxAction(HashMap<String, Boolean> checkboxEntries) {
		this.checkboxEntries = checkboxEntries;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		//Die Checkbox verfügbar machen
		Checkbox box = (Checkbox) e.getSource();
		//Status in der Liste anpassen
		if (box.getState()){
			System.out.println("true");
			checkboxEntries.put(box.getLabel(), true);
		} else {
			checkboxEntries.put(box.getLabel(), false);
		}
	}

}
