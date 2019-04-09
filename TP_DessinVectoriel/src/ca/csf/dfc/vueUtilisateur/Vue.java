/**
 * 
 */
package ca.csf.dfc.vueUtilisateur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import ca.csf.dfc.fonction.Controleur;




/**
 * @author ManueLMaldonado
 *
 */
public class Vue {
	
	private JFrame FenetrePrincipale;
	private JPanel m_EspaceTravail;	
	private Controleur m_Controleur;
	private IModele  m_Modele;

	public Vue( Controleur p_Controlateur) {
		
		
		this.m_Controleur = p_Controlateur;
		this.m_Modele = this.m_Controleur.getModele();
		//parametrer initial
		ParametrerFenetrePrincipale();
		
		//initialiser Composants swing UI fentre principal
		initialiserComposants();

	}
	
	/**
	 * Methode Parametrer la fanetre principale
	 */
	private void ParametrerFenetrePrincipale() {
		
		this.FenetrePrincipale = new JFrame("Dessin Vectoriel");
		this.FenetrePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.FenetrePrincipale.setSize(1000, 800);
		this.FenetrePrincipale.setLocationRelativeTo(null);
		this.FenetrePrincipale.setVisible(true);		
	}
	
	/**
	 * Methode de inicialisation de composants fenetre principal
	 */
	public void initialiserComposants() {
		
		//set et add layout
		this.FenetrePrincipale.setLayout(new BorderLayout());
		initialiserMenuBar();
		initialiserPaneauNorthBoutonForms();
		initialiserPaneauEstBoutonForms();
		intialiserPaneauCentre();
		initialiserEspaceTravail();
		
		
	}
	
	/**
	 * Initialisation de menu Bar
	 */
	public void initialiserMenuBar() {
		
		//cr�er bar menu
		JMenuBar menuBar=new JMenuBar();
				
		//choix dans la bar de menu Fichier
		JMenu menuFichier=new JMenu("Fichier");	
				
		menuBar.add(menuFichier);
				
		JMenuItem itemFichierNouveau	=new JMenuItem("Nouveau Dessin");
		JMenuItem itemFichierOuvrir		=new JMenuItem("Ouvrir Dessin");
		JMenuItem itemFichierEnregistre	=new JMenuItem("Enregistre Dessin au format XML");
		JMenuItem itemFichierEnregistreS=new JMenuItem("Enregistre Dessin sous");
		JMenuItem itemFichierExporter	=new JMenuItem("Exporter Dessin au format SVG");
		JMenuItem itemFichierQuiter		=new JMenuItem("Quiter");
				
		menuFichier.add(itemFichierNouveau);
		menuFichier.add(itemFichierOuvrir);
		menuFichier.addSeparator();
		menuFichier.add(itemFichierEnregistre);
		menuFichier.add(itemFichierEnregistreS);
		menuFichier.addSeparator();
		menuFichier.add(itemFichierExporter);
		menuFichier.addSeparator();
		menuFichier.add(itemFichierQuiter);
				
		//choix dans la bar de menu Selection
		JMenu menuSelection=new JMenu("Selection");
				
		menuBar.add(menuSelection);
				
		JMenuItem itemSelectionSelection	=new JMenuItem("Selection");
		JMenuItem itemSelectionSuprimer		=new JMenuItem("Suprimer");
				
		menuSelection.add(itemSelectionSelection);
		menuSelection.addSeparator();
		menuSelection.add(itemSelectionSuprimer);
				
		//choix dans la bar de menu Trait
		JMenu menuTrait=new JMenu("Trait");
						
		menuBar.add(menuTrait);
						
		JMenuItem itemTraitEpaisseur	=new JMenuItem("Epaisseur:");
		JMenuItem itemTraitCouleur		=new JMenuItem("Couleur:");
						
		menuTrait.add(itemTraitEpaisseur);
		menuTrait.add(itemTraitCouleur);
		
		//pour add au fenetre principal
		this.FenetrePrincipale.setJMenuBar(menuBar);
		
		//Actions pour les boutons		
			itemFichierNouveau.addActionListener(e -> {
					this.m_Modele.EspaceTravailDefault();				
					updateEspaceTravail();	});
		
		
	}
	
	/**
	 * initialiser icon north pour les forms
	 */
	private void initialiserPaneauNorthBoutonForms() {
		
		JPanel panneauNorth = new JPanel();
		BoxLayout panneauNorthGrid = new BoxLayout(panneauNorth, BoxLayout.X_AXIS );
		panneauNorth.setLayout(panneauNorthGrid);
		
		
		
		// btn_NouveauDessin
		JButton btn_NouveauDessin = new JButton();		
		btn_NouveauDessin.setIcon(Vue.chargerIcone("icons8-add-32.png"));	
		btn_NouveauDessin.setToolTipText("Nouveau Dessin");
		panneauNorth.add(btn_NouveauDessin);

		// btn_OpenDessin
		JButton btn_OpenDessin = new JButton();		
		btn_OpenDessin.setIcon(Vue.chargerIcone("icons8-open-view-32.png"));	
		btn_OpenDessin.setToolTipText("btn_OpenDessin Dessin");
		panneauNorth.add(btn_OpenDessin);
		
		// btn_EnregistrerDessin
		JButton btn_EnregistrerDessin = new JButton();		
		btn_EnregistrerDessin.setIcon(Vue.chargerIcone("icons8-save-32.png"));	
		btn_EnregistrerDessin.setToolTipText("Enregistrer Dessin");
		panneauNorth.add(btn_EnregistrerDessin);

		// btn_EnregistrerSousDessin
		JButton btn_EnregistrerSousDessin = new JButton();		
		btn_EnregistrerSousDessin.setIcon(Vue.chargerIcone("icons8-save-as-32.png"));	
		btn_EnregistrerSousDessin.setToolTipText("Enregistrer Sous Dessin");
		panneauNorth.add(btn_EnregistrerSousDessin);		

		// btn_ExporterDessin
		JButton btn_ExporterDessin = new JButton();		
		btn_ExporterDessin.setIcon(Vue.chargerIcone("icons8-export-32.png"));	
		btn_ExporterDessin.setToolTipText("Exporter  Dessin");
		panneauNorth.add(btn_ExporterDessin);//*/
		
		this.FenetrePrincipale.add(panneauNorth, BorderLayout.NORTH);
		
		//Actions pour les boutons		
		btn_NouveauDessin.addActionListener(e -> {			
					this.m_Modele.EspaceTravailDefault();					
					updateEspaceTravail();});	
	}
	
	
	
	
	/**
	 * 
	 */
	private void initialiserPaneauEstBoutonForms() {
		
		JPanel panneauGauche = new JPanel();
		BoxLayout panneauEstGrid = new BoxLayout(panneauGauche, BoxLayout.Y_AXIS );
		panneauGauche.setLayout(panneauEstGrid);
		
		
		// btn_SelectionDessin
		JButton btn_SelectionDessin = new JButton();		
		btn_SelectionDessin.setIcon(Vue.chargerIcone("icons8-mouse-32.png"));	
		//btn_SelectionDessin.setRolloverIcon(Vue.chargerIcone("icons8-mouse-32.png"));
		btn_SelectionDessin.setToolTipText("Selection Dessin");
		panneauGauche.add(btn_SelectionDessin);
		
		// btn_RemplissageDessin
		JButton btn_RemplissageDessin = new JButton();		
		btn_RemplissageDessin.setIcon(Vue.chargerIcone("icons8-paint-palette-32.png"));	
		btn_RemplissageDessin.setToolTipText("Remplissage Dessin");
		panneauGauche.add(btn_RemplissageDessin);
		
		// btn_EpaisseurDessin
		JButton btn_EpaisseurDessin = new JButton();		
		btn_EpaisseurDessin.setIcon(Vue.chargerIcone("icons8-merge-vertical-32.png"));	
		btn_EpaisseurDessin.setToolTipText("Epaisseur Dessin");
		panneauGauche.add(btn_EpaisseurDessin);	
		
		// btn_LigneDessin
		JButton btn_LigneDessin = new JButton();		
		btn_LigneDessin.setIcon(Vue.chargerIcone("icons8-line-32.png"));	
		btn_LigneDessin.setToolTipText("Ligne Dessin");
		panneauGauche.add(btn_LigneDessin);
				
		// btn_RectangleDessin
		JButton btn_RectangleDessin = new JButton();		
		btn_RectangleDessin.setIcon(Vue.chargerIcone("icons8-rectangular-32.png"));	
		btn_RectangleDessin.setToolTipText("Rectangle Dessin");
		panneauGauche.add(btn_RectangleDessin);

		// btn_EllipseDessin
		JButton btn_EllipseDessin = new JButton();		
		btn_EllipseDessin.setIcon(Vue.chargerIcone("icons8-oval-32.png"));	
		btn_EllipseDessin.setToolTipText("Ellipse Dessin");
		panneauGauche.add(btn_EllipseDessin);					
		
		this.FenetrePrincipale.add(panneauGauche, BorderLayout.WEST);
	}
	
	
	
	/**
	 * Espace du travail
	 */
	private void intialiserPaneauCentre() {
		
		JPanel panel_Centre = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel_Centre.setOpaque(true);
		panel_Centre.setBackground(Color.gray);
		this.FenetrePrincipale.add(panel_Centre, BorderLayout.CENTER);
	}
	
	/**
	 * @param p_Image
	 * @return icone
	 */
	private static ImageIcon chargerIcone(String p_Image) {
		ImageIcon icone = null;        
		
		String chemin = ".\\src\\res\\" + p_Image;
		
		try {
			icone = new ImageIcon(chemin);
			
		} catch (NullPointerException e) {
			System.err.println("Image introuvable : " + chemin);
		}
		return icone;
	}
	
	/**
	 * 
	 */
	private void initialiserEspaceTravail() {
		
		this.m_EspaceTravail = new JPanel();
		this.FenetrePrincipale.add(m_EspaceTravail, BorderLayout.CENTER);
		
		espaceTravailCouleurDeFond(Color.gray);		
		
	}
	
	/**
	 * set la taille d'espace de travail
	 */
	private void espaceTravailTaille(double p_Largeur, double p_Hauteur) {
		int largeur = (int) Math.floor(p_Largeur);
		int hauteur = (int) Math.floor(p_Hauteur);		
		this.m_EspaceTravail.setPreferredSize(
				new Dimension(	largeur,	hauteur));//*/
	}
	
	
	/**
	 * set le couleur d'espace de travail
	 */
	private void espaceTravailCouleurDeFond(Color p_color) {		
		this.m_EspaceTravail.setBackground(p_color);
	}
	
	

	
	
	
	/**
	 * update l'espace de travail
	 */
	public void updateEspaceTravail() {
		
		espaceTravailTaille(
				this.m_Modele.getLargeur(),
				this.m_Modele.getHauteur());
		
		espaceTravailCouleurDeFond(
				this.m_Modele.getColorFondEspaceTravail());
		
		this.m_EspaceTravail.repaint();
		//this.m_EspaceTravail.setVisible(true);
		
	}
}
