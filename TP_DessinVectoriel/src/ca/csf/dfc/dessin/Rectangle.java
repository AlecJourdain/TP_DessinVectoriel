package ca.csf.dfc.dessin;

public class Rectangle extends Forme {
	public Rectangle() {
		super();
		this.m_type = FormeType.RECTANGLE;
	}
	
	@Override
	public void dessiner(IDessiner p_dessin) {
		p_dessin.dessinerRectangle(this.m_x1, this.m_y1, this.m_x2, this.m_y2, 
				this.m_couleurRemplissage, this.m_couleurTrait, this.m_epaisseurTrait);
	}
}
