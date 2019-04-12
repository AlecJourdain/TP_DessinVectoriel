package ca.csf.dfc.main;

import javax.swing.SwingUtilities;
import ca.csf.dfc.vueUtilisateur.Vue;
import ca.csf.dfc.vueUtilisateur.VuePrueba;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Vue v = new Vue();
			v.pack();
			v.setVisible(true);//*/
			
			/*VuePrueba vp = new VuePrueba();
			vp.pack();
			vp.setVisible(true);//*/
		});
	}
}
