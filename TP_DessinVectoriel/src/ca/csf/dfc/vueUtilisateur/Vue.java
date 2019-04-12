/**
 * 
 */
package ca.csf.dfc.vueUtilisateur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.KeyStroke;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import ca.csf.dfc.dessin.FormeType;
import ca.csf.dfc.fonctions.Sauvegarde;


public class Vue extends JFrame {
	
	private static final long serialVersionUID = 873083412301053821L;
	//private JMenuBar m_menuBarre;
	//private JMenu m_fichier, m_edition, m_trait;
	//private JMenuItem m_nouveau, m_ouvrir, m_enregistreXML, m_enregistreSous, m_exporter, m_quitter,
					 // m_selection, m_supprimer, m_epaisseur, m_couleurTrait;
	//private JButton btn_LigneDessin;
	private JPanel m_panel_Centre;
	private Canevas m_canevas;
	/**
	 * Ctor
	 */
	public Vue() {
		
		ParametrerVue();
		intialiserPaneauCentre();
		initialiserMenu();		
		initialiserPaneauNordBoutonForms();
		initialiserPaneauOuestBoutonForms();		
	}
	
	

	
	/**
	 * 
	 */
	private void ParametrerVue() {
		this.setTitle("Dessin Vectoriel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(800, 500));
		this.setLocationRelativeTo(null);			
	}
	
	
	/**
	 * Initialisation de la barre de menu
	 */
	private void initialiserMenu() {
			
		// Les sous-menus de la MenuBarre
		JMenu m_fichier 	= new JMenu("Fichier");
		JMenu m_edition 	= new JMenu("Édition");
		JMenu m_espaceTravail		= new JMenu("Espace Travail");	
		
		
		// Les items de chaque sous-menu		
		JMenuItem m_nouveau 		= new JMenuItem("Nouveau");
		JMenuItem m_ouvrir			= new JMenuItem("Ouvrir...");
		JMenuItem m_enregistreXML	= new JMenuItem("Enregistrer au format XML...");
		JMenuItem m_enregistreSous	= new JMenuItem("Enregistrer sous...");
		JMenuItem m_exporter 		= new JMenuItem("Exporter au format SVG...");
		JMenuItem m_quitter 		= new JMenuItem("Quitter");
		JMenuItem m_selection		= new JMenuItem("Sélection");
		JMenuItem m_supprimer		= new JMenuItem("Supprimer");
		
		
		// Sous-menu Fichier
		m_fichier.add(m_nouveau);
		m_fichier.add(m_ouvrir);
		m_fichier.addSeparator();
		m_fichier.add(m_enregistreXML);
		m_fichier.add(m_enregistreSous);
		m_fichier.addSeparator();
		m_fichier.add(m_exporter);
		m_fichier.addSeparator();
		m_fichier.add(m_quitter);
		
		// Sous-menu Edition
		m_edition.add(m_selection);
		m_edition.addSeparator();
		m_edition.add(m_supprimer);
		
		
		//Largeur Espace de travail		
		int LargeurInitial = this.m_canevas.getDimensionEspaceTravail().width;
		int HauteurInitial = this.m_canevas.getDimensionEspaceTravail().height;		
		JSpinner spin_LargeurEspaceTravail = new JSpinner(new SpinnerNumberModel(LargeurInitial, 100, 10000, 50));
		JPanel panel_LargeurEspacetravail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel_LargeurEspacetravail.add(new JLabel("Largeur: "));
		panel_LargeurEspacetravail.add(spin_LargeurEspaceTravail);	
						
		//Hauteur Espace de travail		
		JSpinner spin_HauteurEspaceTravail = new JSpinner(new SpinnerNumberModel(HauteurInitial, 100, 10000, 50));
		JPanel panel_HauteurEspacetravail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel_HauteurEspacetravail.add(new JLabel("Hauteur: "));
		panel_HauteurEspacetravail.add(spin_HauteurEspaceTravail);
		
		
		
		//Pour changer la taille
		spin_LargeurEspaceTravail.addChangeListener(e -> {			
					m_canevas.setDimensionEspaceTravail(
							(int) spin_LargeurEspaceTravail.getValue(),
							(int) spin_HauteurEspaceTravail.getValue());
					m_canevas.revalidate();
					m_canevas.repaint();
					//
					});
						
		spin_HauteurEspaceTravail.addChangeListener(e -> {			
					m_canevas.setDimensionEspaceTravail(
							(int) spin_LargeurEspaceTravail.getValue(),
							(int) spin_HauteurEspaceTravail.getValue());
					m_canevas.revalidate();
					m_canevas.repaint();
					//
					});
				
		
				
		// Dimension espace Travail
		m_espaceTravail.add(panel_LargeurEspacetravail);
		m_espaceTravail.add(panel_HauteurEspacetravail);
		m_espaceTravail.addSeparator();
		
		// Constitution de la barre de menu
		
		JMenuBar m_menuBarre = new JMenuBar();
		m_menuBarre.add(m_fichier);
		m_menuBarre.add(m_edition);		
		m_menuBarre.add(m_espaceTravail);

		// ajout de la barre de menu à la Vue
		this.setJMenuBar(m_menuBarre);
	}
	
	
	/**
	 * Initialisation du panneau de boutons au nord de la fenêtre Vue
	 */
	private void initialiserPaneauNordBoutonForms() {
		
		JPanel panneauNorth = new JPanel();		
		BoxLayout panneauNorthGrid = new BoxLayout(panneauNorth, BoxLayout.X_AXIS );
		panneauNorth.setLayout(panneauNorthGrid);
		
		// btn_NouveauDessin
		JButton btn_NouveauDessin = new JButton();		
		btn_NouveauDessin.setIcon(Vue.chargerIcone("icons8-add-32.png"));	
		btn_NouveauDessin.setToolTipText("Nouveau Dessin");
		btn_NouveauDessin.addActionListener(e -> { 
			m_canevas.effacer();} );
		panneauNorth.add(btn_NouveauDessin);

		// btn_OuvrirDessin
		JButton btn_OpenDessin = new JButton();		
		btn_OpenDessin.setIcon(Vue.chargerIcone("icons8-open-view-32.png"));	
		btn_OpenDessin.setToolTipText("Ouvrir Dessin");
		panneauNorth.add(btn_OpenDessin);
		
		// btn_EnregistrerDessin
		JButton btn_EnregistrerDessin = new JButton();		
		btn_EnregistrerDessin.setIcon(Vue.chargerIcone("icons8-save-32.png"));	
		btn_EnregistrerDessin.setToolTipText("Enregistrer Dessin");
		btn_EnregistrerDessin.addActionListener(e -> {
				Sauvegarde sauvegarde = new Sauvegarde();
				sauvegarde.sauvegarderFormesXML(m_canevas.m_formes);
		});
		panneauNorth.add(btn_EnregistrerDessin);

		// btn_EnregistrerSousDessin
		JButton btn_EnregistrerSousDessin = new JButton();		
		btn_EnregistrerSousDessin.setIcon(Vue.chargerIcone("icons8-save-as-32.png"));	
		btn_EnregistrerSousDessin.setToolTipText("Enregistrer Sous");
		panneauNorth.add(btn_EnregistrerSousDessin);		

		// btn_ExporterDessin
		JButton btn_ExporterDessin = new JButton();		
		btn_ExporterDessin.setIcon(Vue.chargerIcone("icons8-export-32.png"));	
		btn_ExporterDessin.setToolTipText("Exporter Dessin");
		panneauNorth.add(btn_ExporterDessin);//*/
		
		//p_conteneur.add(panneauNorth, BorderLayout.NORTH);
		this.add(panneauNorth, BorderLayout.NORTH);
	}

	/**
	 * Initialisation du panneau de boutons à l'ouest de la fenêtre Vue
	 */
	private void initialiserPaneauOuestBoutonForms() {
		
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
		btn_RemplissageDessin.setToolTipText("Couleur de remplissage");
		panneauGauche.add(btn_RemplissageDessin);
		
		// btn_EpaisseurDessin
		JButton btn_EpaisseurDessin = new JButton();		
		btn_EpaisseurDessin.setIcon(Vue.chargerIcone("icons8-merge-vertical-32.png"));	
		btn_EpaisseurDessin.setToolTipText("Epaisseur du trait");
		panneauGauche.add(btn_EpaisseurDessin);	
		
		// btn_LigneDessin
		JButton btn_LigneDessin= new JButton();	
		//btn_LigneDessin = new JButton();		
		btn_LigneDessin.setIcon(Vue.chargerIcone("icons8-line-32.png"));	
		btn_LigneDessin.setToolTipText("Ligne");
		btn_LigneDessin.addActionListener(e -> {
			m_canevas.setFormeTypeCourant(FormeType.LIGNE);
		});
		panneauGauche.add(btn_LigneDessin);
				
		// btn_RectangleDessin
		JButton btn_RectangleDessin = new JButton();		
		btn_RectangleDessin.setIcon(Vue.chargerIcone("icons8-rectangular-32.png"));	
		btn_RectangleDessin.setToolTipText("Rectangle");
		btn_RectangleDessin.addActionListener(e -> {
			m_canevas.setFormeTypeCourant(FormeType.RECTANGLE);
		});
		panneauGauche.add(btn_RectangleDessin);

		// btn_EllipseDessin
		JButton btn_EllipseDessin = new JButton();		
		btn_EllipseDessin.setIcon(Vue.chargerIcone("icons8-oval-32.png"));	
		btn_EllipseDessin.setToolTipText("Ellipse");
		btn_EllipseDessin.addActionListener(e -> {
			m_canevas.setFormeTypeCourant(FormeType.ELLIPSE);
		});
		panneauGauche.add(btn_EllipseDessin);					
		
		this.add(panneauGauche, BorderLayout.WEST);
	}
	
	/**
	 * Centre du Fenetre 
	 */
	private void intialiserPaneauCentre() {			

		//creation Paneau Centre
		this.m_panel_Centre = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.m_panel_Centre.setOpaque(true);
		this.m_panel_Centre.setBackground(Color.white);		
		
		//creation canevas
		this.m_canevas = new Canevas();
		this.m_panel_Centre.add(m_canevas, FlowLayout.LEFT);
				
		//creation scrollpanel
		JScrollPane jScrollPaneCentre = new JScrollPane();		
		jScrollPaneCentre.setViewportView(this.m_panel_Centre);		
		jScrollPaneCentre.setVerticalScrollBar(new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 300));
		jScrollPaneCentre.setHorizontalScrollBar(new JScrollBar(JScrollBar.HORIZONTAL, 30, 40, 0, 300));
		//jScrollPaneCentre.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//jScrollPaneCentre.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//jScrollPaneCentre.getViewport().setBackground(Color.gray);
		
		//Add scroll au JFrame
		this.add(jScrollPaneCentre);//*/
		
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
	
}

