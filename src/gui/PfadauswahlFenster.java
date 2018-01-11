package gui;

import javax.swing.JFileChooser;

public class PfadauswahlFenster {

	public PfadauswahlFenster() {
		JFileChooser selector = new JFileChooser();
		selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		selector.setAcceptAllFileFilterUsed(false);

		int ret = selector.showOpenDialog(null);

		if (ret == JFileChooser.APPROVE_OPTION) {
			new FeatureProviderHauptfenster("FeatureProvider", selector.getSelectedFile().getAbsoluteFile().toString())
					.setVisible(true);
			;

		}
		if (ret == JFileChooser.CANCEL_OPTION) {
			System.exit(0);
		}
	}
}
