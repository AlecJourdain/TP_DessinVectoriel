/**
 * 
 */
package ca.csf.dfc.vueUtilisateur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.xml.stream.XMLStreamException;

import ca.csf.dfc.JustOneEnum.TypeAction;
import ca.csf.dfc.dessin.Forme;
import ca.csf.dfc.dessin.ListeDeFormes;
import ca.csf.dfc.fonctions.Charger;
import ca.csf.dfc.fonctions.Sauvegarde;



/**
 * @author ManueLMaldonado
 *
 */
public class Vue extends JFrame {
	
	private static final long serialVersionUID = 873083412301053821L;
	
	//Pour le Canevas element principal de la fenetre
	private Canevas m_canevas;
	//Pour XML
	private String nameXML;
	
	
	/**
	 * Ctor
	 */
	public Vue() {
		
		ParametrerVue();
		initialiserPanneauCentre();
		initialiserMenu();		
		initialiserFormeBoutonPanneauNord();
		initialiserFormeBoutonPanneauOuest();		
	}

	
	/**
	 * 
	 */
	private void ParametrerVue() {
		this.setTitle("Dessin Vectoriel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(800, 500));
		this.setLocationRelativeTo(null);		
		this.nameXML = null;
	}
	
	
	/**
	 * Initialisation de la barre de menu
	 */
	private void initialiserMenu() {
				
		// Les sous-menus de la MenuBarre
		JMenu fichier 	= new JMenu("Fichier");
		JMenu edition 	= new JMenu("Edition");
		JMenu espaceTravail		= new JMenu("Espace Travail");		
		
		// Les items de chaque sous-menu		
		JMenuItem nouveau 			= new JMenuItem("Nouveau");
		JMenuItem ouvrir			= new JMenuItem("Ouvrir...");
		JMenuItem enregistrerXML	= new JMenuItem("Enregistrer au format XML...");
		JMenuItem enregistrerSous	= new JMenuItem("Enregistrer sous...");
		JMenuItem exporter 			= new JMenuItem("Exporter au format SVG...");
		JMenuItem quitter 			= new JMenuItem("Quitter");
		
				
		
		//Nouveau dessin
		nouveau.addActionListener(e -> {
			creerJPopupSauvegarderSous();
			this.m_canevas.setEspaceTravailParDefaut();
			this.m_canevas.setCanevasParDefaut();
			this.nameXML = null;
		});
		
		//Ouvrir dessin
		ouvrir.addActionListener(e -> {
			ouvrirDessin();
		});
		
		//enregistrerXML
		enregistrerXML.addActionListener(e -> {
			enregistreDessin();		
		});
		
		//enregistrerSous
		enregistrerSous.addActionListener(e -> {
			souvgarderSous();		
		});
				
		//exporter
		exporter.addActionListener(e -> {
			souvgarderSousSVG();				
		});
		
		//quitter dessin
		quitter.addActionListener(e -> {
			this.setVisible (false);
	    	this.dispose ();		
		});
				
		
		
		// Sous-menu Fichier
		fichier.add(nouveau);
		fichier.add(ouvrir);
		fichier.addSeparator();
		fichier.add(enregistrerXML);
		fichier.add(enregistrerSous);
		fichier.addSeparator();
		fichier.add(exporter);
		fichier.addSeparator();
		fichier.add(quitter);
		
		// Sous-menu Edition
		
		JMenuItem selection			= new JMenuItem("Selection");
		JMenuItem couleurRamplisage = new JMenuItem("Couleur Ramplisage de forme");		
		JMenuItem couleurTrait 		= new JMenuItem("Couleur Trait de forme");
		JMenuItem epaisseurTrait 	= new JMenuItem("Epaisseur Trait de forme");
		JMenuItem line 				= new JMenuItem("Line");
		JMenuItem rectangle 		= new JMenuItem("Rectangle");
		JMenuItem elipse 			= new JMenuItem("Ellipse");
		
		//selection
		selection.addActionListener(e -> {
			m_canevas.setTypeActionPerformee(TypeAction.SELECTIONNER);
			m_canevas.setFormeSelectionnee(null);
			m_canevas.setFormeTypeCourant("X");
		});
		
		//couleurRamplisage
		couleurRamplisage.addActionListener(e -> {
			Color couleurInitiale = this.m_canevas.getCouleurRemplisageForm();
			Color couleur = JColorChooser.showDialog(this, "Choisissez une couleur", couleurInitiale);
				if (couleur != null) {this.m_canevas.setCouleurRemplisageForm(couleur);}
		});
		
		//couleurTrait
		couleurTrait.addActionListener(e -> {
			Color couleurInitiale = this.m_canevas.getCouleurTraitForm();
			Color couleur = JColorChooser.showDialog(this, "Choisissez une couleur", couleurInitiale);
				if (couleur != null) {this.m_canevas.setCouleurTraitForm(couleur);}
		});
				
		//epaisseurTrait
		epaisseurTrait.addActionListener(e -> {
			 new EpaisseurTrait(this.m_canevas);
		});
		
		//line
		line.addActionListener(e -> {
			m_canevas.setTypeActionPerformee(TypeAction.DESSINER);
			m_canevas.setFormeSelectionnee(null);
			m_canevas.setFormeTypeCourant("L");
		});
				
		//rectangle
		rectangle.addActionListener(e -> {
			m_canevas.setTypeActionPerformee(TypeAction.DESSINER);
			m_canevas.setFormeSelectionnee(null);
			m_canevas.setFormeTypeCourant("R");
		});
						
		//elipse
		elipse.addActionListener(e -> {
			m_canevas.setTypeActionPerformee(TypeAction.DESSINER);
			m_canevas.setFormeSelectionnee(null);
			m_canevas.setFormeTypeCourant("E");
		});
		
		// Sous-menu Edition
		edition.add(selection);
		edition.addSeparator();
		edition.add(couleurRamplisage);
		edition.add(couleurTrait);
		edition.add(epaisseurTrait);
		edition.addSeparator();
		edition.add(line);
		edition.add(rectangle);		
		edition.add(elipse);		
		
		//Largeur Espace de travail		
		int largeurInitial = this.m_canevas.getDimensionEspaceTravail().width;
		int hauteurInitial = this.m_canevas.getDimensionEspaceTravail().height;		
		JSpinner spin_LargeurEspaceTravail = new JSpinner(new SpinnerNumberModel(largeurInitial, 100, 10000, 50));
		JPanel panel_LargeurEspacetravail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel_LargeurEspacetravail.add(new JLabel("Largeur: "));
		panel_LargeurEspacetravail.add(spin_LargeurEspaceTravail);	
						
		//Hauteur Espace de travail		
		JSpinner spin_HauteurEspaceTravail = new JSpinner(new SpinnerNumberModel(hauteurInitial, 100, 10000, 50));
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
		espaceTravail.add(panel_LargeurEspacetravail);
		espaceTravail.add(panel_HauteurEspacetravail);
		espaceTravail.addSeparator();
		
		// Constitution de la barre de menu
		
		JMenuBar menuBarre = new JMenuBar();
		menuBarre.add(fichier);
		menuBarre.add(edition);		
		menuBarre.add(espaceTravail);

		// ajout de la barre de menu à la Vue
		this.setJMenuBar(menuBarre);
	}
	

	
	/**
	 * Initialisation du panneau de boutons au nord de la fenêtre Vue
	 */
	private void initialiserFormeBoutonPanneauNord() {
		
		JPanel panneauNord = new JPanel();		
		BoxLayout panneauNordGrid = new BoxLayout(panneauNord, BoxLayout.X_AXIS );
		panneauNord.setLayout(panneauNordGrid);
				
		// btn_NouveauDessin
		JButton btn_NouveauDessin = new JButton();		
		btn_NouveauDessin.setIcon(Vue.chargerIcone("icons8-add-32.png"));	
		btn_NouveauDessin.setToolTipText("Nouveau Dessin");
		btn_NouveauDessin.addActionListener(e -> { 
			creerJPopupSauvegarderSous();
			this.m_canevas.setEspaceTravailParDefaut();
			this.m_canevas.setCanevasParDefaut();
			this.nameXML = null;
		});
		

		// btn_OuvrirDessin
		JButton btn_OpenDessin = new JButton();		
		btn_OpenDessin.setIcon(Vue.chargerIcone("icons8-open-view-32.png"));	
		btn_OpenDessin.setToolTipText("Ouvrir Dessin");
		btn_OpenDessin.addActionListener(e -> {

			ouvrirDessin();			

			/*Charger charger = new Charger();
			JFileChooser chooser = new JFileChooser();
			chooser.setFileFilter(new FileFilter() {
				@Override
				public String getDescription() {
					return String.format("Fichier XML (*.xml)");
				}
				@Override
				public boolean accept(File p_Fichier) {
					return p_Fichier.isDirectory() || p_Fichier.getPath().endsWith(".xml");
				}
			});
			if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				
				try {
					charger.chargerFormes(file, this.m_canevas);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}//*/

		});
		
				
		// btn_EnregistrerDessin
		JButton btn_EnregistrerDessin = new JButton();		
		btn_EnregistrerDessin.setIcon(Vue.chargerIcone("icons8-save-32.png"));	
		btn_EnregistrerDessin.setToolTipText("Enregistrer Dessin");
		btn_EnregistrerDessin.addActionListener(e -> {			
			enregistreDessin();							
		});
		

		// btn_EnregistrerSousDessin
		JButton btn_EnregistrerSousDessin = new JButton();		
		btn_EnregistrerSousDessin.setIcon(Vue.chargerIcone("icons8-save-as-32.png"));	
		btn_EnregistrerSousDessin.setToolTipText("Enregistrer Sous");
		btn_EnregistrerSousDessin.addActionListener(e -> {			
			souvgarderSous();					
		});		

		// btn_ExporterDessin
		JButton btn_ExporterDessin = new JButton();		
		btn_ExporterDessin.setIcon(Vue.chargerIcone("icons8-export-32.png"));	
		btn_ExporterDessin.setToolTipText("Exporter Dessin");
		btn_ExporterDessin.addActionListener(e -> {			
			souvgarderSousSVG();					
		});	
		
		
		//additions boutons sur panneu North
		panneauNord.add(btn_NouveauDessin);
		panneauNord.add(btn_OpenDessin);
		panneauNord.add(btn_EnregistrerDessin);
		panneauNord.add(btn_EnregistrerSousDessin);
		panneauNord.add(btn_ExporterDessin);
		
		
		//Addition sur la fanetre Principal
		this.add(panneauNord, BorderLayout.NORTH);
	}

	/**
	 * Initialisation du panneau de boutons à l'ouest de la fenêtre Vue
	 */
	private void initialiserFormeBoutonPanneauOuest() {
		
		//parametrer panneuGauche
		JPanel panneauGauche = new JPanel();
		BoxLayout panneauOuestGrid = new BoxLayout(panneauGauche, BoxLayout.Y_AXIS );
		panneauGauche.setLayout(panneauOuestGrid);
			
		// creer btn_SelectionDessin
		JButton btn_SelectionDessin = new JButton();		
		btn_SelectionDessin.setIcon(Vue.chargerIcone("icons8-mouse-32.png"));	
		btn_SelectionDessin.setToolTipText("Selection Dessin");
		btn_SelectionDessin.addActionListener(e -> {
			m_canevas.setTypeActionPerformee(TypeAction.SELECTIONNER);
			m_canevas.setFormeSelectionnee(null);
			m_canevas.setFormeTypeCourant("X");
		});		
			
		// creer btn_RemplissageDessin
		JButton btn_CouleurRemplissageDessin = new JButton();		
		btn_CouleurRemplissageDessin.setIcon(Vue.chargerIcone("icons8-paint-palette-32.png"));	
		btn_CouleurRemplissageDessin.setToolTipText("Couleur de remplissage");
		btn_CouleurRemplissageDessin.addActionListener(e -> {
			Color couleurInitiale = this.m_canevas.getCouleurRemplisageForm();
			Color couleur = JColorChooser.showDialog(this, "Choisissez une couleur", couleurInitiale);
						if (couleur != null) {this.m_canevas.setCouleurRemplisageForm(couleur);}
		});	
		
		// creer btn_Couleur Trait Dessin
		JButton btn_CouleurTraitDessin = new JButton();		
		btn_CouleurTraitDessin.setIcon(Vue.chargerIcone("icons8-color-palette-32.png"));	
		btn_CouleurTraitDessin.setToolTipText("Couleur de remplissage");
		btn_CouleurTraitDessin.addActionListener(e -> {
					Color couleurInitiale = this.m_canevas.getCouleurTraitForm();
					Color couleur = JColorChooser.showDialog(this, "Choisissez une couleur", couleurInitiale);
								if (couleur != null) {this.m_canevas.setCouleurTraitForm(couleur);}
		});	
		
		// creer btn_EpaisseurDessin
		JButton btn_EpaisseurDessin = new JButton();		
		btn_EpaisseurDessin.setIcon(Vue.chargerIcone("icons8-merge-vertical-32.png"));	
		btn_EpaisseurDessin.setToolTipText("Epaisseur du trait");
		btn_EpaisseurDessin.addActionListener(e -> {
			 new EpaisseurTrait(this.m_canevas);
		});	
			
		// creer btn_LigneDessin
		JButton btn_LigneDessin= new JButton();		
		btn_LigneDessin.setIcon(Vue.chargerIcone("icons8-line-32.png"));	
		btn_LigneDessin.setToolTipText("Ligne");
		btn_LigneDessin.addActionListener(e -> {
			m_canevas.setTypeActionPerformee(TypeAction.DESSINER);
			m_canevas.setFormeSelectionnee(null);
			m_canevas.setFormeTypeCourant("L");
		});		
					
		// creer btn_RectangleDessin
		JButton btn_RectangleDessin = new JButton();		
		btn_RectangleDessin.setIcon(Vue.chargerIcone("icons8-rectangular-32.png"));	
		btn_RectangleDessin.setToolTipText("Rectangle");
		btn_RectangleDessin.addActionListener(e -> {
			m_canevas.setTypeActionPerformee(TypeAction.DESSINER);
			m_canevas.setFormeSelectionnee(null);
			m_canevas.setFormeTypeCourant("R");
		});		

		// creer btn_EllipseDessin
		JButton btn_EllipseDessin = new JButton();		
		btn_EllipseDessin.setIcon(Vue.chargerIcone("icons8-oval-32.png"));	
		btn_EllipseDessin.setToolTipText("Ellipse");
		btn_EllipseDessin.addActionListener(e -> {
			m_canevas.setTypeActionPerformee(TypeAction.DESSINER);
			m_canevas.setFormeSelectionnee(null);
			m_canevas.setFormeTypeCourant("E");
		});		
		
		//additions boutons sur panneu gauche
		panneauGauche.add(btn_SelectionDessin);
		panneauGauche.add(btn_CouleurRemplissageDessin);
		panneauGauche.add(btn_CouleurTraitDessin);		
		panneauGauche.add(btn_EpaisseurDessin);	
		panneauGauche.add(btn_LigneDessin);
		panneauGauche.add(btn_RectangleDessin);
		panneauGauche.add(btn_EllipseDessin);					
		
		//Addition sur la fenetre Principal
		this.add(panneauGauche, BorderLayout.WEST);
	}
		
		
	
	/**
	 * Centre de la Fenetre 
	 */
	private void initialiserPanneauCentre() {			

		//creation panneau Centre
		JPanel m_panel_Centre = new JPanel(new FlowLayout(FlowLayout.LEFT));
		m_panel_Centre.setOpaque(true);
		m_panel_Centre.setBackground(Color.white);		
		
		//creation canevas
		m_canevas = new Canevas();
		m_panel_Centre.add(m_canevas, FlowLayout.LEFT);
				
		//creation scrollpanel
		JScrollPane jScrollPaneCentre = new JScrollPane();		
		jScrollPaneCentre.setViewportView(m_panel_Centre);		
		jScrollPaneCentre.setVerticalScrollBar(new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 300));
		jScrollPaneCentre.setHorizontalScrollBar(new JScrollBar(JScrollBar.HORIZONTAL, 30, 40, 0, 300));
		
		
		//Ajouter scroll au JFrame
		this.add(jScrollPaneCentre);//*/
		
	}	
	
	
	
	/**
	 * Chargera les icones sur les boutons de l'interface
	 * @param p_Image
	 * @return icone
	 */
	private static ImageIcon chargerIcone(String p_Image) {
		ImageIcon icone = null;        
		String chemin = "./src/res/" + p_Image;
		try {
			icone = new ImageIcon(chemin);
		} catch (NullPointerException e) {
				System.err.println("Image introuvable : " + chemin);
		}
		return icone;
	}
	
	private void souvgarderSous() {
		JFileChooser souvegarderSous = new JFileChooser(
				FileSystemView.getFileSystemView().getHomeDirectory());
		
		souvegarderSous.setDialogTitle("Enregistrer sous");			
		souvegarderSous.setDialogType(JFileChooser.SAVE_DIALOG);			
		souvegarderSous.setSelectedFile(new File("data.xml"));			
		souvegarderSous.setFileFilter(new FileNameExtensionFilter("xml file","xml"));			
		if(souvegarderSous.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
		{				
			this.nameXML = souvegarderSous.getSelectedFile().toString();
			if (!this.nameXML .endsWith(".xml")) this.nameXML += ".xml";
			Sauvegarde sauvegarde = new Sauvegarde();				
			sauvegarde.sauvegarderFormesXML(this.m_canevas,this.nameXML);			   
		 }
		
	}
	
	private void souvgarderSousSVG() {
		JFileChooser souvegarderSous = new JFileChooser(
				FileSystemView.getFileSystemView().getHomeDirectory());
		
		souvegarderSous.setDialogTitle("Enregistrer sous");			
		souvegarderSous.setDialogType(JFileChooser.SAVE_DIALOG);			
		souvegarderSous.setSelectedFile(new File("data.svg"));			
		souvegarderSous.setFileFilter(new FileNameExtensionFilter("svg file","svg"));			
		if(souvegarderSous.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
		{				
			this.nameXML = souvegarderSous.getSelectedFile().toString();
			/*if (!this.nameXML .endsWith(".xml")) this.nameXML += ".xml";
			Sauvegarde sauvegarde = new Sauvegarde();				
			sauvegarde.sauvegarderFormesXML(this.m_canevas,this.nameXML);//*/			   
		 }
		
	}
	
	private void creerJPopupSauvegarderSous() {
		
		int rst = JOptionPane.showConfirmDialog(
				null,
				"Est-ce que vous sauvgardez avant de cr�er un nouveau dessin?",
				"Souvergarder",
				JOptionPane.YES_NO_OPTION);
		
		if (rst == JOptionPane.YES_NO_OPTION) {souvgarderSous();}
	}
	
	private void ouvrirDessin() {
		Charger charger = new Charger();
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return String.format("Fichier XML (*.xml)");
			}
			@Override
			public boolean accept(File p_Fichier) {
				return p_Fichier.isDirectory() || p_Fichier.getPath().endsWith(".xml");
			}
		});
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			this.nameXML = chooser.getSelectedFile().toString();
			
			try {
				charger.charger(file, this.m_canevas);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private void enregistreDessin() {
		if(this.nameXML != null) {
			Sauvegarde sauvegarde = new Sauvegarde();				
			sauvegarde.sauvegarderFormesXML(this.m_canevas,this.nameXML);	
		}
		else 
			souvgarderSous();
	}
}