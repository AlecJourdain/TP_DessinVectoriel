/**
 * 
 */
package ca.csf.dfc.vueUtilisateur;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
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
	
	private Color m_couleurTrait = Color.black;
	private Color m_couleurRemplissage = Color.black;
	private int m_epaisseurTrait = 2;
	private String m_formeTypeCourant = "RECTANGLE";
	private boolean m_estModifie = false;
	ArrayList<Forme> m_formes = new ArrayList<Forme>();
	Point premierPoint, pointFinal;
	private IDessiner m_modeDessin;
	
	
	/**
	 * Ctor
	 */
	public Canevas() {
		
		
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
	public void setFormeTypeCourant(String p_formeTypeCourant) {
		this.m_formeTypeCourant = p_formeTypeCourant;
	}
	
	public void paintComponent(Graphics g) {
		
		// Classe qui définit les formes à dessiner du côté de Swing
		Graphics2D graphSettings = (Graphics2D)g;
		
		// ...sert à adoucir le rendu des lignes
		graphSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphSettings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		
		this.m_modeDessin = new Dessiner_Graph2D(graphSettings);
		
		for (Forme f : m_formes) {
			f.dessiner(this.m_modeDessin);
		}
		
//		if (premierPoint != null && pointFinal != null) {
//			graphSettings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
//			graphSettings.setPaint(Color.lightGray);
//			Shape uneForme = dessinerRectangle(premierPoint.x, premierPoint.y, pointFinal.x, pointFinal.y);
//			graphSettings.draw(uneForme);
//		}
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
