/**
 * 
 */
package tp_dessin.main;

import javax.swing.SwingUtilities;

import tp_dessin.controller.Controlateur;
import tp_dessin.model.ModeleDessinVect;
import tp_dessin.view.View;



/**
 * @author ManueLMaldonado
 *
 */
public class TP_DessinVect_MVC_Main {

	/**
	 * @param args
	 */
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
		Controlateur control = new Controlateur (modele);
		
		//Creation de la view , avec modele et controlateur
		new View( modele , control);
	}

}
