package ca.csf.dfc.dessin;


import ca.csf.dfc.Dessiner.IDessiner;

public class Rectangle extends Forme {
	public Rectangle() {
		super();
		this.m_type = "R";
	}

	@Override
	public void dessiner(IDessiner p_methodeDessin) {
		p_methodeDessin.dessinerRectangle(this.getX1(), this.getY1(), this.getX2(), this.getY2(),
				this.getCouleurTrait(), this.getEpaisseurTrait(), this.getCouleurRemplissage());
	}
}
