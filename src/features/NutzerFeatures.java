package features;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class NutzerFeatures {
	private static final String NUTZERKLASSE="Quelldateien\\User.java";
	private static final String NUTZERTASK="Quelldateien\\AsyncTaskUser.java";
	
	private String md2Pfad;

	public NutzerFeatures(String md2Pfad){
		this.md2Pfad = md2Pfad;
	}
	
	/**
	 * Kopiert die Nutzerklasse in die md2-Struktur
	 */
	public void erstelleNutzerklasse(){
		try {
			Files.copy(new File(NUTZERKLASSE).toPath(), new File(this.md2Pfad + "\\testprojekt.androidLollipop\\md2_app_TestprojektApp\\app\\src\\main\\java\\md2\\testprojekt\\md2\\model\\User.java").toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Nutzerklasse nicht erstellt.");
		}

	}
	
	/**
	 * Kopiert die Asynctask-Klasse in die md2-Struktur
	 */
	public void erstelleNutzerTask(){
		try {
			Files.copy(new File(NUTZERTASK).toPath(), new File(this.md2Pfad + "\\testprojekt.androidLollipop\\md2_app_TestprojektApp\\app\\src\\main\\java\\md2\\testprojekt\\md2\\controller\\AsyncTaskUser.java").toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Task nicht erstellt");
		}
	}
}
