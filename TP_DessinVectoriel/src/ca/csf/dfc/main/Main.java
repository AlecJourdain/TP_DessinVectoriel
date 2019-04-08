package ca.csf.dfc.main;

import javax.swing.SwingUtilities;

import ca.csf.dfc.controleur.Controleur;
import ca.csf.dfc.modele.ModeleDessinVect;
import ca.csf.dfc.vueUtilisateur.Vue;



public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
public static void createAndShowGUI() throws Exception {
		
		// Cration Modele
		ModeleDessinVect modele = new ModeleDessinVect();
        
        // Creation controlateur, avec modele
		Controleur control = new Controleur ();
		
		//Creation de la view , avec modele et controlateur
		new Vue( control);
	}

}
