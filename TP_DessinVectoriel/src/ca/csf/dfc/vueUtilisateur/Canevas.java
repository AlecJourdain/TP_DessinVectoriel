/**
 * 
 */
package ca.csf.dfc.vueUtilisateur;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import ca.csf.dfc.dessin.FactoryForme;
import ca.csf.dfc.dessin.Forme;
import ca.csf.dfc.dessin.FormeType;

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
	private int m_LargeurEspaceTravail;
	private int m_HauteurEspaceTravail;
	
	
	
	
	private Color m_couleurTrait = Color.black;
	private Color m_couleurRemplissage = Color.black;
	private int m_epaisseurTrait = 2;
	private FormeType m_formeTypeCourant = FormeType.RECTANGLE;
	private boolean m_estModifie = false;
	ArrayList<Forme> m_formes = new ArrayList<Forme>();
	Point premierPoint, pointFinal;
	
	
	/**
	 * Ctor
	 */
	public Canevas() {
		
		//Pour l'espacetravail
		setDefaultEspaceTravail();

		
		/* un objet d'une classe anonyme dérivée de MouseAdapter est créé et transmis à la méthode addMouseListener
		 * les méthodes mousePressed et mouseReleased sont redéfinies*/
		this.addMouseListener(new MouseAdapter () {
			
			public void mousePressed(MouseEvent e) {
				premierPoint = new Point(e.getX(), e.getY());
				pointFinal = premierPoint;
				repaint();
			}
			
			public void mouseReleased(MouseEvent e) {
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
			}
		});
		
		/* un objet d'une classe anonyme dérivée de MouseMotionAdapter est créé et transmis à la méthode 
		 * addMouseMotionListener la méthode mouseDragged est redéfinie*/
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				pointFinal = new Point(e.getX(), e.getY());
				repaint();
			}
		});
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
	public void setFormeTypeCourant(FormeType p_formeTypeCourant) {
		this.m_formeTypeCourant = p_formeTypeCourant;
	}
	
	public void paintComponent(Graphics g) {
		
		// Classe qui définit les formes à dessiner du côté de Swing
		Graphics2D graphSettings = (Graphics2D)g;
		
		// ...sert à adoucir le rendu des lignes
		graphSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		graphSettings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		
		for (Forme f : m_formes) {
			graphSettings.setPaint(f.getCouleurTrait());
			graphSettings.setStroke(new BasicStroke(f.getEpaisseurTrait()));
			
			Shape s = null;
			
			switch(f.getType()) {
				case LIGNE:
					s = dessinerLigne(f.getX1(), f.getY1(), f.getX2(), f.getY2());
					break;
				case ELLIPSE:
					s = dessinerEllipse(f.getX1(), f.getY1(), f.getX2(), f.getY2());
					break;
				case RECTANGLE:
					s = dessinerRectangle(f.getX1(), f.getY1(), f.getX2(), f.getY2());
					break;
			}
			
			graphSettings.draw(s);
			graphSettings.setPaint(f.getCouleurRemplissage());
			graphSettings.fill(s);
		}
		
		if (premierPoint != null && pointFinal != null) {
			graphSettings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
			graphSettings.setPaint(Color.lightGray);
			Shape uneForme = dessinerRectangle(premierPoint.x, premierPoint.y, pointFinal.x, pointFinal.y);
			graphSettings.draw(uneForme);
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
	
	private Rectangle2D.Float dessinerRectangle(int x1, int y1, int x2, int y2) {
		int x = Math.min(x1, x2);
		int y = Math.min(y1, y2);
		
		int largeur = Math.abs(x1-x2);
		int hauteur = Math.abs(y1-y2);
		
		return new Rectangle2D.Float(x, y, largeur, hauteur);
	}
	
	private Ellipse2D.Float dessinerEllipse(int x1, int y1, int x2, int y2) {
		int x = Math.min(x1, x2);
		int y = Math.min(y1, y2);
		
		int largeur = Math.abs(x1-x2);
		int hauteur = Math.abs(y1-y2);
		
		return new Ellipse2D.Float(x, y, largeur, hauteur);
	}
	
	private Line2D.Float dessinerLigne(int x1, int y1, int x2, int y2) {
		
		return new Line2D.Float(x1, y1, x2, y2);
		
	}
	
	
	
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
	
	

}
