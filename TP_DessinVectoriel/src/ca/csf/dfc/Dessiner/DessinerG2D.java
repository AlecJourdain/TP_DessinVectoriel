/**
 * 
 */
package ca.csf.dfc.Dessiner;



import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * @author Coralie-Hong Brière
 *
 */
public class DessinerG2D implements IDessiner{
	private Graphics2D m_g2D;
	
	public DessinerG2D(Graphics2D p_g) {
		m_g2D = p_g;
	}

	@Override
	public void dessinerLigne(int p_x1, int p_y1, int p_x2, int p_y2, Color couleurTrait, float epaisseurTrait) {
		if (couleurTrait != null) {
			m_g2D.setPaint(couleurTrait);
			m_g2D.setStroke(new BasicStroke(epaisseurTrait));
		}

		m_g2D.draw(new Line2D.Float(p_x1, p_y1, p_x2, p_y2));
	}

	@Override
	public void dessinerEllipse(int p_x1, int p_y1, int p_x2, int p_y2,
								Color couleurTrait, float epaisseurTrait, Color couleurRemplissage) {
		int x = Math.min(p_x1, p_x2);
		int y = Math.min(p_y1, p_y2);
		
		int largeur = Math.abs(p_x1-p_x2);
		int hauteur = Math.abs(p_y1-p_y2);

		if (couleurTrait != null) {
			m_g2D.setPaint(couleurTrait);
			m_g2D.setStroke(new BasicStroke(epaisseurTrait));
		}
		m_g2D.draw(new Ellipse2D.Float(x, y, largeur, hauteur));

		if (couleurRemplissage != null) {
			m_g2D.setPaint(couleurRemplissage);
			m_g2D.fillOval(x, y, largeur, hauteur);
		}
	}

	@Override
	public void dessinerRectangle(int p_x1, int p_y1, int p_x2, int p_y2,
								  Color couleurTrait, float epaisseurTrait, Color couleurRemplissage) {
		int x = Math.min(p_x1, p_x2);
		int y = Math.min(p_y1, p_y2);
		
		int largeur = Math.abs(p_x1-p_x2);
		int hauteur = Math.abs(p_y1-p_y2);

		if (couleurTrait != null) {
			m_g2D.setPaint(couleurTrait);
			m_g2D.setStroke(new BasicStroke(epaisseurTrait));
		}
		m_g2D.draw(new Rectangle2D.Float(x, y, largeur, hauteur));

		if (couleurRemplissage != null) {
			m_g2D.setPaint(couleurRemplissage);
			m_g2D.fillRect(x, y, largeur, hauteur);
		}
	}

}
