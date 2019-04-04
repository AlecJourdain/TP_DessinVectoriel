package ca.csf.dfc.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

public class FenetrePrincipale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel fenetre=new JPanel();
	JMenu menuBar=new JMenu();
	
	//choix dans la bar de menu
	JMenu menuFichier=new JMenu();
	JMenu menuEdit=new JMenu();
	
	public FenetrePrincipale()
	{
		fenetre.setLayout(new BorderLayout());
		this.setSize(600, 400);
	}
	

}
