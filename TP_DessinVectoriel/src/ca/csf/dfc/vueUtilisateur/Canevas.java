/**
 * 
 */
package ca.csf.dfc.vueUtilisateur;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import ca.csf.dfc.Dessiner.DessinerG2D;
import ca.csf.dfc.JustOneEnum.TypeAction;
import ca.csf.dfc.dessin.FactoryForme;
import ca.csf.dfc.dessin.Forme;
//import ca.csf.dfc.dessin.FormeType;
import ca.csf.dfc.dessin.ListeDeFormes;

/**
 * @author Coralie-Hong Brière
 * 
 * 
 * Le canevas écoute les clics de souris pour créer les formes de nos dessins
 */
public class Canevas extends JComponent{
	
	private static final long serialVersionUID = -1602873151367941910L;

	private static Stroke dashedStroke =
			new BasicStroke(
					1.0f,
					BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_MITER,
					10.0f, new float[]{10.0f}, 0.0f);

	private ListeDeFormes m_listeFormesAdessiner;
	
	//Pour l'espace Travail
	public static final int LARGEUR_DEFAULT_ESPACE_TRAVAIL = 2000;
	public static final int HAUTEUR_DEFAULT_ESPACE_TRAVAIL = 2000;
	public static final Color COULEUR_DEFAULT_ESPACE_TRAVAIL = Color.white;
	private Dimension m_DimensionEspaceTravail;

	
	
	//Pour le couleur de remplisage des figures
	public static final Color 	COLOR_DEFAULT_REMPLISAGE = Color.black;
	public static final Color 	COLOR_DEFAULT_TRAIT = Color.black;
	public static final int 	EPPAISSEUR_DEFAULT_REMPLISAGE = 2;
	
	private Color m_couleurTrait = Color.black;
	private Color m_couleurRemplissage = Color.black;
	private int m_epaisseurTrait;
	
	
	private TypeAction m_typeActionPerformee;
	private String m_formeTypeCourant = "X";
	private Forme m_formeSelectionnee = null;
	
	private JPopupMenu menuClicDroitSouris;

	/*
	 * Ctor du menu popup du clic droit de la souris
	 */
	
	
	//	private boolean m_estModifie = false;
	
	Point m_premierPoint, m_pointFinal;			// Points enregistrés lors d'un DESSINER
	int xAvantDpl;
	int yAvantDpl;		// Enregistrent les coordonnées x,y de la position de la souris au départ d'un déplacement

	/**
	 * Ctor
	 */
	public Canevas(ListeDeFormes ldf) {
		
		
		
		m_listeFormesAdessiner = ldf;
		ArrayList<Forme> listeFormes = m_listeFormesAdessiner.getListeFormes();
		
		//Pour l'espacetravail
		setDefaultEspaceTravail();

		
		/* un objet d'une classe anonyme dérivée de MouseAdapter est créé et transmis à la méthode addMouseListener
		 * les méthodes mousePressed et mouseReleased sont redéfinies*/
		this.addMouseListener(new MouseAdapter () {
			public void mousePressed(MouseEvent e) {
				if (m_typeActionPerformee == TypeAction.DESSINER || m_typeActionPerformee == TypeAction.SELECTIONNER) {
					m_premierPoint = new Point(e.getX(), e.getY());
					m_pointFinal = m_premierPoint;
					if (m_typeActionPerformee == TypeAction.SELECTIONNER) {
						
						for (Forme f : listeFormes) {
							if (f.contientPoint(m_premierPoint.x, m_premierPoint.y)) {
								xAvantDpl = e.getX();
								yAvantDpl = e.getY();
								m_formeSelectionnee = f;
								m_premierPoint.x = f.getX1();
								m_premierPoint.y = f.getY1();
								m_pointFinal.x = f.getX2();
								m_pointFinal.y = f.getY2();
								if(SwingUtilities.isRightMouseButton(e)) {
									
									if(menuClicDroitSouris == null) {
										menuClicDroitSouris = new JPopupMenu();
										JMenuItem menuItem = new JMenuItem("Modifier couleur de remplissage");
										menuItem.addActionListener(g -> {
											
											Color couleur = JColorChooser.showDialog(Canevas.this, "Choisissez une couleur", m_couleurRemplissage);
											if (couleur != null) {
												f.setCouleurRemplissage(couleur);
												repaint();
											}
										});
										menuClicDroitSouris.add(menuItem);
										menuItem = new JMenuItem("Modifier couleur du trait");
										menuItem.addActionListener(e_-> {
											Color couleur = JColorChooser.showDialog(Canevas.this, "Choisissez une couleur",m_couleurTrait);
											if (couleur != null) {
												f.setCouleurTrait(couleur);
												repaint();
											}
										});
										menuClicDroitSouris.add(menuItem);
										menuItem = new JMenuItem("Modifier epaisseur du trait");
										menuItem.addActionListener(e_-> {
											String epaisseur;
											epaisseur = JOptionPane.showInputDialog(Canevas.this, "Entrer l'epaisseur desire");
											if (epaisseur != null) {
												f.setEpaisseurTrait(Integer.parseInt(epaisseur));
												repaint();
											}
										});
										menuClicDroitSouris.add(menuItem);
									}
									menuClicDroitSouris.show(e.getComponent(), e.getX(), e.getY());
									menuClicDroitSouris = null;

								}
							}
						}
					}
					repaint();
				}
				
			}

			public void mouseReleased(MouseEvent e) {
				if (m_premierPoint == null) return;
				if (m_premierPoint == m_pointFinal) return; 	// La souris n'a pas bougé
				if (m_typeActionPerformee == TypeAction.DESSINER) {
					// La forme est créée dès que la souris est relâchée
					Forme f = FactoryForme.creationForme(m_formeTypeCourant);
					
					f.setX1(m_premierPoint.x);
					f.setY1(m_premierPoint.y);
					f.setX2(e.getX());
					f.setY2(e.getY());
					f.setCouleurRemplissage(m_couleurRemplissage);
					f.setCouleurTrait(m_couleurTrait);
					f.setEpaisseurTrait(m_epaisseurTrait);
					
//					// La forme créée est ajoutée à la liste de formes
//					m_formes.add(f);
					m_listeFormesAdessiner.ajouterUneForme(f);
					
					// Les points sont remis à null pour la création d'une prochaine forme
					m_premierPoint = null;
					m_pointFinal = null;
					
//					// Le boolean signale qu'il y a eu une modification
//					m_estModifie = true;
					
					repaint();
				}
				if (m_typeActionPerformee == TypeAction.SELECTIONNER) {
//					if (m_formeSelectionnee != null) {
//						m_formeSelectionnee.deplacerDe(x - xAvantDpl, y - yAvantDpl);
//						m_formeSelectionnee = null;
//						
//					}
					for (Forme f : listeFormes) {
						if(f.contientPoint(e.getX(), e.getY())) {
							m_formeSelectionnee = f;
							if(SwingUtilities.isRightMouseButton(e)) {
								
								menuClicDroitSouris.show(e.getComponent(), e.getX(), e.getY());
							}
							
						}
					}
					
					repaint();
				}
				
			}
		});
		
		/* un objet d'une classe anonyme dérivée de MouseMotionAdapter est créé et transmis à la méthode 
		 * addMouseMotionListener la méthode mouseDragged est redéfinie*/
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int nouveauX = e.getX() - xAvantDpl;
				int nouveauY = e.getY() - yAvantDpl;
				if (m_typeActionPerformee == TypeAction.DESSINER || m_typeActionPerformee == TypeAction.SELECTIONNER) {
					m_pointFinal = new Point(e.getX(), e.getY());

					if (m_typeActionPerformee == TypeAction.SELECTIONNER) {
						for (Forme f : listeFormes) {
							if(f.contientPoint(e.getX(), e.getY())) {
								m_formeSelectionnee = f;
								Forme nouvelleForme = FactoryForme.creationForme(m_formeTypeCourant);
								nouvelleForme = f;
								if (e.getX() >= f.getX2()-10 ||  e.getY() >= f.getY2()-10) {
									nouvelleForme.setX2(nouvelleForme.getX2() + nouveauX);
									nouvelleForme.setY2(nouvelleForme.getY2() + nouveauY);
									
								} else {
									nouvelleForme.setX1(nouvelleForme.getX1() + nouveauX);
									nouvelleForme.setY1(nouvelleForme.getY1() + nouveauY);
									nouvelleForme.setX2(nouvelleForme.getX2() + nouveauX);
									nouvelleForme.setY2(nouvelleForme.getY2() + nouveauY);
									
								}
								
								listeFormes.set(listeFormes.indexOf(f), nouvelleForme);
								xAvantDpl += nouveauX;
								yAvantDpl += nouveauY;
								m_premierPoint = m_pointFinal;
							}
						}
//						if (m_formeSelectionnee != null) {
//							m_formeSelectionnee.deplacerDe(m_pointFinal.x - xAvantDpl, m_pointFinal.y - yAvantDpl);
//							xAvantDpl = m_pointFinal.x;
//							yAvantDpl = m_pointFinal.y;
//						}
					}
					repaint();
				}
			}
		});
		
		
	}

//	/**
//	 * Retourne le couleurTrait.
//	 * @return le couleurTrait
//	 */
//	public Color getCouleurTrait() {
//		return this.m_couleurTrait;
//	}
//
//	/**
//	 * Pour modifier le couleurTrait.
//	 * @param p_couleurTrait Nouvelle valeur.
//	 */
//	public void setCouleurTrait(Color p_couleurTrait) {
//		this.m_couleurTrait = p_couleurTrait;
//	}
//
//	/**
//	 * Retourne le couleurRemplissage.
//	 * @return le couleurRemplissage
//	 */
//	public Color getCouleurRemplissage() {
//		return this.m_couleurRemplissage;
//	}
//
//	/**
//	 * Pour modifier le couleurRemplissage.
//	 * @param p_couleurRemplissage Nouvelle valeur.
//	 */
//	public void setCouleurRemplissage(Color p_couleurRemplissage) {
//		this.m_couleurRemplissage = p_couleurRemplissage;
//	}
//
//	/**
//	 * Retourne le epaisseurTrait.
//	 * @return le epaisseurTrait
//	 */
//	public int getEpaisseurTrait() {
//		return this.m_epaisseurTrait;
//	}
//
//	/**
//	 * Pour modifier le epaisseurTrait.
//	 * @param p_epaisseurTrait Nouvelle valeur.
//	 */
//	public void setEpaisseurTrait(int p_epaisseurTrait) {
//		this.m_epaisseurTrait = p_epaisseurTrait;
//	}
//
//	/**
//	 * Retourne le estModifie.
//	 * @return le estModifie
//	 */
//	public boolean isEstModifie() {
//		return this.m_estModifie;
//	}
//
//	/**
//	 * Pour modifier le estModifie.
//	 * @param p_estModifie Nouvelle valeur.
//	 */
//	public void setEstModifie(boolean p_estModifie) {
//		this.m_estModifie = p_estModifie;
//	}

	/**
	 * Pour modifier le formeTypeCourant.
	 * @param p_formeTypeCourant Nouvelle valeur.
	 */
	public void setFormeTypeCourant(String p_formeTypeCourant) {
		this.m_formeTypeCourant = p_formeTypeCourant;
	}
	
	/**
	 * Retourne le typeActionPerformee.
	 * @return le typeActionPerformee
	 */
	public TypeAction getTypeActionPerformee() {
		return this.m_typeActionPerformee;
	}

	/**
	 * Pour modifier le typeActionPerformee.
	 * @param p_typeActionPerformee Nouvelle valeur.
	 */
	public void setTypeActionPerformee(TypeAction p_typeActionPerformee) {
		this.m_typeActionPerformee = p_typeActionPerformee;
	}
	
	/**
	 * Retourne le formeSelectionnee.
	 * @return le formeSelectionnee
	 */
	public Forme getFormeSelectionnee() {
		return this.m_formeSelectionnee;
	}

	/**
	 * Pour modifier le formeSelectionnee.
	 * @param p_formeSelectionnee Nouvelle valeur.
	 */
	public void setFormeSelectionnee(Forme p_formeSelectionnee) {
		this.m_formeSelectionnee = p_formeSelectionnee;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Classes utilisées pour dessiner des formes sur le Canevas
		Graphics2D g2 = (Graphics2D) g;
		DessinerG2D d2 = new DessinerG2D(g2);

		// ...sert à adoucir le rendu des lignes
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Dessine les formes
		m_listeFormesAdessiner.getListeFormes().forEach(f -> f.dessiner(d2));

		

		// Guide pour le dessin lorsque l'utilisateur trace la forme
		if (m_premierPoint != null && m_pointFinal != null && m_typeActionPerformee == TypeAction.DESSINER) {
			afficherGuide(g2, d2);
		}
	}

	private void afficherGuide(Graphics2D g2, DessinerG2D d2) {
		// Configurer le guide
		Forme f = FactoryForme.creationForme(this.m_formeTypeCourant);
		f.setX1(m_premierPoint.x);
		f.setY1(m_premierPoint.y);
		f.setX2(m_pointFinal.x);
		f.setY2(m_pointFinal.y);
		g2.setPaint(Color.darkGray);
		g2.setStroke(dashedStroke);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));

		// Dessiner guide
		f.dessiner(d2);
	}
	
//	public void effacer() {
//		this.m_formes.clear();
//		this.m_estModifie = false;
//		repaint();
//	}
//	
//	public void setFormes(ArrayList<Forme> p_formes) {
//		// Supprime toutes les formes dans la liste
//		m_formes.clear();
//		
//		// repeint l'aire de dessin
//		repaint();
//		
//		// utilise la nouvelle liste de formes
//		m_formes = null;
//		m_formes = p_formes;
//		
//		m_estModifie = false;
//		repaint();
//	}
//	
//	public ArrayList<Forme> getFormes() {
//		return this.m_formes;
//	}
	
	
	//Pour le space travail
	public void setDimensionEspaceTravail(int p_Largeur, int p_Hauteur) {		
		this.setDimensionEspaceTravail(new Dimension(p_Largeur , p_Hauteur));
	}
	
	public void setDimensionEspaceTravail(Dimension p_DimensionEspaceTravail) {		
		this.m_DimensionEspaceTravail = p_DimensionEspaceTravail;
		this.setPreferredSize(this.m_DimensionEspaceTravail);
		this.setSize(this.m_DimensionEspaceTravail);
	}
	
	public void setDefaultEspaceTravail() {	
		this.m_DimensionEspaceTravail = new Dimension(LARGEUR_DEFAULT_ESPACE_TRAVAIL, HAUTEUR_DEFAULT_ESPACE_TRAVAIL);
		this.setPreferredSize(this.m_DimensionEspaceTravail);		
		this.setBorder(	BorderFactory.createLineBorder(Color.gray,1));	

		
		
		
	}
	
	public Dimension getDimensionEspaceTravail() {
		return this.m_DimensionEspaceTravail;
	} 
	
	public int getLargeurEspaceTravail() {
		return this.m_DimensionEspaceTravail.width;
	}
	
	//Pour le couleur de remplisage des forms
	public void setCouleurRemplisageForm(Color p_couleur) {
		this.m_couleurRemplissage = p_couleur;
	}
	public Color getCouleurRemplisageForm() {
		return this.m_couleurRemplissage;
	}
	
	//Pour le couleur de trait des forms
	public void setCouleurTraitForm(Color p_couleur) {
		this.m_couleurTrait = p_couleur;
	}
	public Color getCouleurTraitForm() {
		return this.m_couleurTrait;
	}
	
	//Pour l'epaisseur de trait des forms
	public void setEpaisseurTraitForm(int p_eppaisseur) {
		this.m_epaisseurTrait = p_eppaisseur;
	}
		public int getEpaisseurTraitForm() {
			return this.m_epaisseurTrait;
		}



}
