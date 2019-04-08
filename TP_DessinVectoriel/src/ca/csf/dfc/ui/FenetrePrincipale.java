package ca.csf.dfc.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.Border;


public class FenetrePrincipale extends JFrame {
	private static final long serialVersionUID = 1L;
	

	
private void initialiserComposantesFenetrePrincipale()
{

	
	JPanel fenetre=new JPanel();
	JPanel espaceDeTravail=new JPanel();
	espaceDeTravail.setVisible(true);
	fenetre.setLayout(new BorderLayout());
	
	JMenuBar menuBar=new JMenuBar();
	super.setJMenuBar(menuBar);
	

	
	//menu fichier
	JMenu menuFichier=new JMenu("fichier");
	JMenuItem itemNouveau=new JMenuItem("Nouveau");
	JMenuItem itemCharger=new JMenuItem("Charger");
	JMenuItem itemEnregistrer=new JMenuItem("Enregistrer");
	JMenuItem itemSvg=new JMenuItem("Exporter (svg)");
	/////
	menuBar.add(menuFichier);
	menuFichier.add(itemNouveau);
	menuFichier.add(itemCharger);
	menuFichier.addSeparator();
	menuFichier.add(itemEnregistrer);
	menuFichier.add(itemSvg);
	
	//deuxieme choix menu
	JMenu menuDeux=new JMenu("autre");
	JMenuItem itemCinq=new JMenuItem("Cinq");
	JMenuItem itemSix=new JMenuItem("six");
	JMenuItem itemSept=new JMenuItem("sept");
	JMenuItem itemHuit=new JMenuItem("huit");
	JMenuItem itemNeuf=new JMenuItem("neuf");
	//////
	menuBar.add(menuDeux);
	menuDeux.add(itemCinq);
	menuDeux.add(itemSix);
	menuDeux.add(itemSept);
	menuDeux.add(itemHuit);
	menuDeux.addSeparator();
	menuDeux.add(itemNeuf);
	
	//option positioné en haut de l'application
	JPanel optionNordPanel=new JPanel();
	optionNordPanel.setLayout(new FlowLayout());
	Border bordure=BorderFactory.createLineBorder(Color.BLACK);
	
	
	//boutons radios pour forme pleine ou vide
	JPanel panelBoutonsRadio=new JPanel();    
	panelBoutonsRadio.setLayout(new GridLayout(2, 1));
	ButtonGroup groupeBouton=new ButtonGroup();
	JRadioButton formeVide=new JRadioButton("vide");
	JRadioButton formePleine=new JRadioButton("plein");
	
	panelBoutonsRadio.add(formePleine);
	panelBoutonsRadio.add(formeVide);
	groupeBouton.add(formePleine);
	groupeBouton.add(formeVide);
	formePleine.setSelected(true);
	
	//boutons pour dessiner les elements graphiques
	JPanel boutonPanel=new JPanel();
	JButton boutonEllipse = new JButton();
	JButton boutonRectangle =new JButton();
	JButton boutonLigne=new JButton();
	
	//ajout des icons et dimensions des boutons
	ImageIcon ellipseImage=new ImageIcon(("imagePng/Ellipse.png"));
	Image imgEllipse=ellipseImage.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	ImageIcon ellipseIcon=new ImageIcon(imgEllipse);
	boutonEllipse.setIcon(ellipseIcon);
	
	ImageIcon rectangleImage=new ImageIcon(("imagePng/Rectangle.png"));
	Image imgRectangle=rectangleImage.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rectangleIcon=new ImageIcon(imgRectangle);
	boutonRectangle.setIcon(rectangleIcon);
	
	ImageIcon ligneImage=new ImageIcon(("imagePng/Trait.png"));
	Image imgLigne=ligneImage.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	ImageIcon ligneIcon=new ImageIcon(imgLigne);
	boutonLigne.setIcon(ligneIcon);
	
	
	boutonPanel.add(boutonRectangle);
	boutonPanel.add(boutonEllipse);
	boutonPanel.add(boutonLigne);

	//choix de la grosseur du trait, JSpinner
	SpinnerNumberModel modelSpinner = new SpinnerNumberModel(1, 1, 20, 1);
	JSpinner selectionGrosseurTrait=new JSpinner(modelSpinner);
	JLabel labelGrosseurDuTrait=new JLabel("Trait");


	//ajout des boutons des elements graphique, boutons radios, JSpinner de la grosseur du trait au Panel Nord
	optionNordPanel.add(boutonPanel);
	optionNordPanel.add(panelBoutonsRadio);
	optionNordPanel.add(labelGrosseurDuTrait);
	optionNordPanel.add(selectionGrosseurTrait);
    optionNordPanel.setBorder(bordure);

	fenetre.add(optionNordPanel, BorderLayout.NORTH);	
	fenetre.add(espaceDeTravail,BorderLayout.CENTER);
	
	this.setContentPane(fenetre);
}
	

	
	public FenetrePrincipale()
	{
		
		super("dessin vectoriel");
		this.setSize(800, 600);
		initialiserComposantesFenetrePrincipale();
	
		
	}
	

}
