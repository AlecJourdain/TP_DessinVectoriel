/**
 * 
 */
package ca.csf.dfc.vueUtilisateur;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JComponent;
import ca.csf.dfc.dessin.Dessiner_Graph2D;
import ca.csf.dfc.dessin.FactoryForme;
import ca.csf.dfc.dessin.Forme;
import ca.csf.dfc.dessin.IDessiner;

/**
 * @author Coralie-Hong Brière
 * 
 * 
 * Le canevas écoute les clics de souris pour créer les formes de nos dessins
 */
public class Canevas extends JComponent{
	
	private static final long serialVersionUID = -1602873151367941910L;
	
	//Pour l'espace Travail
	public static final int LARGEUR_DEFAULT_ESPACE_TRAVAIL = 2000;
	public static final int HAUTEUR_DEFAULT_ESPACE_TRAVAIL = 2000;
	public static final Color COULEUR_DEFAULT_ESPACE_TRAVAIL = Color.white;
	private Dimension m_DimensionEspaceTravail;
	
	
	private Color m_couleurTrait = Color.black;
	private Color m_couleurRemplissage = Color.black;
	private int m_epaisseurTrait = 2;
	private String m_formeTypeCourant = "RECTANGLE";
	private boolean m_estModifie = false;
	ArrayList<Forme> m_formes = new ArrayList<Forme>();
	Point premierPoint, pointFinal;
	private IDessiner m_modeDessin;
	private ModeAction m_modeAction = ModeAction.Dessiner;
	private Shape m_formeSelectionner = null;
	Cursor curseur;
	private int m_selectionX;
	private int m_selectionY;
	
	
	/**
	 * Ctor
	 */
	public Canevas() {
		/* un objet d'une classe anonyme dérivée de MouseAdapter est créé et transmis à la méthode addMouseListener
		 * les méthodes mousePressed et mouseReleased sont redéfinies*/
		this.addMouseListener(new MouseAdapter () {
			public void mousePressed(MouseEvent e) {

				if( m_modeAction == ModeAction.Dessiner) {
					premierPoint = new Point(e.getX(), e.getY());
					pointFinal = premierPoint;
					repaint();
				}
				else if(m_modeAction == ModeAction.Creer){
					m_selectionX = e.getX();
					m_selectionY = e.getY();
					for (Forme f : m_formes) {
						Shape formeTempo = null;
						if(f.getType() == "RECTANGLE") {
							 formeTempo = new Rectangle2D.Float(f.getX1(), f.getY1(), f.getX2()-f.getX1(), f.getY2()-f.getY1());
						}
						
						if(formeTempo.contains(e.getPoint())){
							m_formeSelectionner = formeTempo;
							premierPoint = new Point(f.getX1(), f.getY1());
							pointFinal = new Point(f.getX2(), f.getY2());
						}
					}
					repaint();
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(m_modeAction == ModeAction.Dessiner) {
					if (premierPoint == null) return; 
					
					if (premierPoint == pointFinal) return; 	// La souris n'a pas bougé
					
					// La forme est créée dès que la souris est relâchée
					Forme f = FactoryForme.creationForme(m_formeTypeCourant);
					
					f.setX1(premierPoint.x);
					f.setY1(premierPoint.y);
					f.setX2(e.getX());
					f.setY2(e.getY());
					f.setCouleurRemplissage(m_couleurRemplissage);
					f.setCouleurTrait(m_couleurTrait);
					f.setEpaisseurTrait(m_epaisseurTrait);
					
					// La forme créée est ajoutée à la liste de formes
					m_formes.add(f);
					
					
					
					// Les points sont remis à null pour la création d'une prochaine forme
					premierPoint = null;
					pointFinal = null;
					
					// Le boolean signale qu'il y a eu une modification
					m_estModifie = true;
					
					repaint();
				} else if(m_modeAction == ModeAction.Creer){
					for (Forme f : m_formes) {
						Shape formeTempo = null;
						if(f.getType() == "RECTANGLE") {
							 formeTempo = new Rectangle2D.Float(f.getX1(), f.getY1(), f.getX2()-f.getX1(), f.getY2()-f.getY1());
						}
						
						if(formeTempo.contains(e.getPoint())){
							m_formeSelectionner = formeTempo;
						}
						
					}
					repaint();
				}

			}
			
			public void mouseClicked(MouseEvent e) {
				for (Forme f : m_formes) {
					Shape formeTempo = null;
					if(f.getType() == "RECTANGLE") {
						 formeTempo = new Rectangle2D.Float(f.getX1(), f.getY1(), f.getX2()-f.getX1(), f.getY2()-f.getY1());
					}
					System.out.println(formeTempo.contains(e.getPoint()));
					if(formeTempo.contains(e.getPoint())){
						m_formeSelectionner = formeTempo;
						premierPoint = new Point(f.getX1(), f.getY1());
						pointFinal = new Point(f.getX2(), f.getY2());
					}
					
				}
				repaint();
			}
		});
		
		/* un objet d'une classe anonyme dérivée de MouseMotionAdapter est créé et transmis à la méthode 
		 * addMouseMotionListener la méthode mouseDragged est redéfinie*/
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				
				if(m_modeAction == ModeAction.Dessiner) {
					pointFinal = new Point(e.getX(), e.getY());
					repaint();
				}
				else if(m_modeAction == ModeAction.Creer) {
					int nouveauX = e.getX() - m_selectionX;
					int nouveauY = e.getY() - m_selectionY;
					for (Forme formeCourante : m_formes) {
						premierPoint = new Point(formeCourante.getX1()+ pointFinal.x - premierPoint.x,
								formeCourante.getY1() + pointFinal.y - premierPoint.y);
						pointFinal = new Point(formeCourante.getX2(), formeCourante.getY2());
						Shape formeTempo = null;
						if(formeCourante.getType() == "RECTANGLE") {
							 formeTempo = new Rectangle2D.Float(formeCourante.getX1(), formeCourante.getY1(),
									 Math.abs(formeCourante.getX2()-formeCourante.getX1()),
									 Math.abs(formeCourante.getY2()-formeCourante.getY1()));
							 
						}
						
						if(formeTempo.contains(e.getPoint())){
							m_formeSelectionner = formeTempo;
							
							
							
							// La forme est créée dès que la souris est relâchée
							Forme nouvelleForme = FactoryForme.creationForme(m_formeTypeCourant);
							nouvelleForme = formeCourante;
							
							nouvelleForme.setX1(nouvelleForme.getX1() + nouveauX);
							nouvelleForme.setY1(nouvelleForme.getY1() + nouveauY);
							nouvelleForme.setX2(nouvelleForme.getX2() + nouveauX);
							nouvelleForme.setY2(nouvelleForme.getY2() + nouveauY);
							m_formes.set(m_formes.indexOf(formeCourante), nouvelleForme);
							m_selectionX += nouveauX;
							m_selectionY+= nouveauY;
							premierPoint = pointFinal;
						}
						
					}
					repaint();
				}
			}
			public void mouseMoved(MouseEvent e) {
				if(m_modeAction == ModeAction.Creer) {
					for (Forme formeCourante : m_formes) {
						Shape formeTempo = null;
						if(formeCourante.getType() == "RECTANGLE") {
							 formeTempo = new Rectangle2D.Float(formeCourante.getX1(), formeCourante.getY1(),
									 Math.abs(formeCourante.getX2()-formeCourante.getX1()),
									 Math.abs(formeCourante.getY2()-formeCourante.getY1()));
						}
						if(formeTempo.contains(e.getPoint())){
							
							curseur = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
							
						} else {
							
							curseur = Cursor.getDefaultCursor();
						}
						repaint();
					}
				}
			}
		});
		
		
	}

	public void setModeAction(ModeAction p_modeAction) {
		this.m_modeAction = p_modeAction;
	}
	
	/**
	 * Retourne le couleurTrait.
	 * @return le couleurTrait
	 */
	public Color getCouleurTrait() {
		return this.m_couleurTrait;
	}

	/**
	 * Pour modifier le couleurTrait.
	 * @param p_couleurTrait Nouvelle valeur.
	 */
	public void setCouleurTrait(Color p_couleurTrait) {
		this.m_couleurTrait = p_couleurTrait;
	}

	/**
	 * Retourne le couleurRemplissage.
	 * @return le couleurRemplissage
	 */
	public Color getCouleurRemplissage() {
		return this.m_couleurRemplissage;
	}

	/**
	 * Pour modifier le couleurRemplissage.
	 * @param p_couleurRemplissage Nouvelle valeur.
	 */
	public void setCouleurRemplissage(Color p_couleurRemplissage) {
		this.m_couleurRemplissage = p_couleurRemplissage;
	}

	/**
	 * Retourne le epaisseurTrait.
	 * @return le epaisseurTrait
	 */
	public int getEpaisseurTrait() {
		return this.m_epaisseurTrait;
	}

	/**
	 * Pour modifier le epaisseurTrait.
	 * @param p_epaisseurTrait Nouvelle valeur.
	 */
	public void setEpaisseurTrait(int p_epaisseurTrait) {
		this.m_epaisseurTrait = p_epaisseurTrait;
	}

	/**
	 * Retourne le estModifie.
	 * @return le estModifie
	 */
	public boolean isEstModifie() {
		return this.m_estModifie;
	}

	/**
	 * Pour modifier le estModifie.
	 * @param p_estModifie Nouvelle valeur.
	 */
	public void setEstModifie(boolean p_estModifie) {
		this.m_estModifie = p_estModifie;
	}

	/**
	 * Pour modifier le formeTypeCourant.
	 * @param p_formeTypeCourant Nouvelle valeur.
	 */
	public void setFormeTypeCourant(String p_formeTypeCourant) {
		this.m_formeTypeCourant = p_formeTypeCourant;
	}
	
	public void paintComponent(Graphics g) {
		
		// Classe qui définit les formes à dessiner du côté de Swing
		Graphics2D graphSettings = (Graphics2D)g;
		
		// Modifie le curseur si jamais nous sommes sur une forme
		
		setCursor(curseur);
		
		
		// ...sert à adoucir le rendu des lignes
		graphSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphSettings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		
		this.m_modeDessin = new Dessiner_Graph2D(graphSettings);
		
		for (Forme f : m_formes) {
			f.dessiner(this.m_modeDessin);
		}
		

	}
	
	public void effacer() {
		this.m_formes.clear();
		this.m_estModifie = false;
		repaint();
	}
	
	public void setFormes(ArrayList<Forme> p_formes) {
		// Supprime toutes les formes dans la liste
		m_formes.clear();
		
		// repeint l'aire de dessin
		repaint();
		
		// utilise la nouvelle liste de formes
		m_formes = null;
		m_formes = p_formes;
		
		m_estModifie = false;
		repaint();
	}
	
	public ArrayList<Forme> getFormes() {
		return this.m_formes;
	}
	


}
