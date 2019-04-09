package ca.csf.dfc.main;

import javax.swing.SwingUtilities;

import ca.csf.dfc.fonctions.Controleur;
import ca.csf.dfc.modele.Modele;
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
		Modele modele = new Modele();
        
        // Creation controlateur, avec modele
		Controleur control = new Controleur (modele);
		
		//Creation de la view , avec modele et controlateur
		new Vue( control);
	}



}
