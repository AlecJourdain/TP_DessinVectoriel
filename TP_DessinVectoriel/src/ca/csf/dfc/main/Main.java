package ca.csf.dfc.main;

import javax.swing.*;

import ca.csf.dfc.vueUtilisateur.Vue;


public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Vue v = new Vue();
			v.pack();
			v.setVisible(true);//*/
			

		});
	}
}
