package ca.csf.dfc.dessin;



import ca.csf.dfc.Dessiner.IDessiner;

public class Ellipse extends Forme{
	public Ellipse() {
		super();
		this.m_type = "E";
	}

	@Override
	public void dessiner(IDessiner p_methodeDessin) {
		p_methodeDessin.dessinerEllipse(this.getX1(), this.getY1(), this.getX2(), this.getY2(),
				this.getCouleurTrait(), this.getEpaisseurTrait(), this.getCouleurRemplissage());
	}
	
//	@Override
//	public boolean contientPoint(int p_x, int p_y) {
//		int largeur = Math.abs(this.m_x1 - this.m_x2);
//		int hauteur = Math.abs(this.m_y1 - this.m_y2);
//		
//		double rayonX = largeur/2.0;			// Rayon horizontal de l'ellipse
//		double rayonY = hauteur/2.0;			// Rayon vertical de l'ellipse
//		double centreX = this.m_x1 + rayonX;	// Coordonnée X du centre de l'ellipse
//		double centreY = this.m_y1 + rayonY;	// Coordonnée Y du centre de l'ellipse
//		
//		if ( (rayonY * (this.m_x1-centreX))*(rayonY*(this.m_x1-centreY)) + (rayonX*(this.m_y1-centreY))*
//				(rayonX*(this.m_y1-centreY)) <= rayonX * rayonX * rayonY * rayonY) {
//			return true;
//		} else {
//			return false;
//		}
//	}

}
