package features;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AndroidManifestFeatures {
	private String md2Pfad;

	public AndroidManifestFeatures(String md2Pfad) {
		this.md2Pfad = md2Pfad;
	}

	public void erzeugePermissions() {
		String datei = "\\testprojekt.androidLollipop\\md2_app_TestprojektApp\\app\\src\\main\\AndroidManifest.xml";
		try {
			FileReader fileIn = new FileReader(md2Pfad + datei);
			BufferedReader bufIn = new BufferedReader(fileIn);

			String zeile = bufIn.readLine();
			String newText = "";

			while (zeile != null) {

				newText += zeile + "\n";

				if (zeile.equals("    package=\"md2.testprojekt\" >")) {
					newText += "    <uses-permission android:name=\"android.permission.INTERNET\" />\n";
				}
				zeile = bufIn.readLine();
			}

			fileIn.close();

			FileWriter fileOut = new FileWriter(md2Pfad + datei);
			fileOut.write(newText);

			fileOut.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
	}
}
