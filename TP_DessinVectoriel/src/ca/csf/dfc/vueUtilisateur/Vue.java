/**
 * 
 */
package ca.csf.dfc.vueUtilisateur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

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
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;

import ca.csf.dfc.dessin.FormeType;

/**
 * @author ManueLMaldonado
 *
 */
public class Vue extends JFrame {
	
	private static final long serialVersionUID = 873083412301053821L;
	private JMenuBar m_menuBarre;
	private JMenu m_fichier, m_edition, m_trait;
	private JMenuItem m_nouveau, m_ouvrir, m_enregistreXML, m_enregistreSous, m_exporter, m_quitter,
					  m_selection, m_supprimer, m_epaisseur, m_couleurTrait;
	private JButton btn_LigneDessin;
	private Canevas m_canevas;
	/**
	 * Ctor
	 */
	public Vue() {
		this.setTitle("Dessin Vectoriel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initialiserMenu();
		this.initialiserComposants(this.getContentPane());
	}
	
	/**
	 * Initialisation de la barre de menu
	 */
	private void initialiserMenu() {
			
		// Les sous-menus de la MenuBarre
		m_fichier = new JMenu("Fichier");
		m_edition = new JMenu("Édition");
		m_trait=new JMenu("Trait");		
		
		// Les items de chaque sous-menu		
		m_nouveau = new JMenuItem("Nouveau");
		m_ouvrir = new JMenuItem("Ouvrir...");
		m_enregistreXML	= new JMenuItem("Enregistrer au format XML...");
		m_enregistreSous = new JMenuItem("Enregistrer sous...");
		m_exporter = new JMenuItem("Exporter au format SVG...");
		m_quitter = new JMenuItem("Quitter");
		m_selection	= new JMenuItem("Sélection");
		m_supprimer	= new JMenuItem("Supprimer");
		m_epaisseur	= new JMenuItem("Epaisseur:");
		m_couleurTrait = new JMenuItem("Couleur:");
		
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
		
		// Sous-menu Trait
		m_trait.add(m_epaisseur);
		m_trait.add(m_couleurTrait);
		
		// Constitution de la barre de menu
		m_menuBarre = new JMenuBar();
		m_menuBarre.add(m_fichier);
		m_menuBarre.add(m_edition);		
		m_menuBarre.add(m_trait);

		// ajout de la barre de menu à la Vue
		this.setJMenuBar(m_menuBarre);
	}
	
	/**
	 * Initialisation des composants: panneaux de boutons et le canevas
	 * @param p_conteneur
	 */
	private void initialiserComposants(Container p_conteneur) {
		p_conteneur.setBackground(Color.white);
		
		m_canevas = new Canevas();
		m_canevas.setPreferredSize(new Dimension(1024, 768));
		m_canevas.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		p_conteneur.add(m_canevas, BorderLayout.CENTER);
		
		initialiserPaneauNordBoutonForms(p_conteneur);
		initialiserPaneauOuestBoutonForms(p_conteneur);
	}
	
	/**
	 * Initialisation du panneau de boutons au nord de la fenêtre Vue
	 */
	private void initialiserPaneauNordBoutonForms(Container p_conteneur) {
		
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
		
		p_conteneur.add(panneauNorth, BorderLayout.NORTH);	
	}

	/**
	 * Initialisation du panneau de boutons à l'ouest de la fenêtre Vue
	 */
	private void initialiserPaneauOuestBoutonForms(Container p_conteneur) {
		
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
		btn_LigneDessin = new JButton();		
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
		
		p_conteneur.add(panneauGauche, BorderLayout.WEST);
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

