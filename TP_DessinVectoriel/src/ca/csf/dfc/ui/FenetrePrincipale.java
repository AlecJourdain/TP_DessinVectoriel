package ca.csf.dfc.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class FenetrePrincipale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel fenetre=new JPanel();
	JMenuBar menuBar=new JMenuBar();
	
	//choix dans la bar de menu
	JMenu menuFichier=new JMenu("fichier");
	JMenu menuDeux=new JMenu("autre");
	JMenuItem itemUn=new JMenuItem("un");
	JMenuItem itemDeux=new JMenuItem("deux");
	JMenuItem itemTrois=new JMenuItem("ttrois");
	JMenuItem itemQuatre=new JMenuItem("quatre");
	JMenuItem itemCinq=new JMenuItem("Cinq");
	JMenuItem itemSix=new JMenuItem("six");
	JMenuItem itemSept=new JMenuItem("sept");
	JMenuItem itemHuit=new JMenuItem("huit");
	JMenuItem itemNeuf=new JMenuItem("neuf");
	
	public FenetrePrincipale()
	{
		super("dessin vectoriel");
		
		fenetre.setLayout(new BorderLayout());
		
		this.setSize(600, 400);
		super.setJMenuBar(menuBar);
		menuBar.add(menuFichier);
		//menuBar.setOpaque(true);
		menuFichier.add(itemUn);
		menuFichier.add(itemDeux);
		menuFichier.addSeparator();
		menuFichier.add(itemTrois);
		menuFichier.add(itemQuatre);
		
		menuBar.add(menuDeux);
		menuDeux.add(itemCinq);
		menuDeux.add(itemSix);
		menuDeux.add(itemSept);
		menuDeux.add(itemHuit);
		menuDeux.addSeparator();
		menuDeux.add(itemNeuf);
		
	}
	

}
