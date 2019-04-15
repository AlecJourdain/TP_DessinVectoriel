package ca.csf.dfc.dessin;

import java.awt.Graphics;

import ca.csf.dfc.Dessiner.IDessiner;

public class Ligne extends Forme{
	public Ligne() {
		super();
		this.m_type = 'L';
	}

	@Override
	public void dessiner(IDessiner p_methodeDessin) {
		p_methodeDessin.dessinerLigne(this.getX1(), this.getY1(), this.getX2(), this.getY2(),
				this.getCouleurTrait(), this.getEpaisseurTrait());
	}
	
	/**
	 * Sert à me renvoyer un tableau de paramètres de la droite,
	 * soit sa pente et son ordonnée à l'origine
	 * @return
	 */
	private double[] calculerEquationDroite() {
		double[] parametresDroite = new double[2];
		parametresDroite[0] = (this.m_y2 - this.m_y1) / (this.m_x2 - this.m_x1);
		parametresDroite[1] = this.m_y1 - (parametresDroite[0]* this.m_x1);
		return parametresDroite;
	}
	
	/* (non-Javadoc)
	 * @see ca.csf.dfc.dessin.Forme#contientPoint(int, int)
	 * La ligne redéfinit le contientPoint de Forme en vérifiant que le point donné satisfait l'équation de droite
	 */
	@Override
	public boolean contientPoint(int p_x, int p_y) {
		double[] penteOO = this.calculerEquationDroite();
		if (p_y == (penteOO[0] * p_x) + penteOO[1]) {
			return true;
		}
		else {
			return false;
		}
	}

}
