package ca.csf.dfc.dessin;

public class Ellipse extends Forme{
	public Ellipse() {
		super();
		this.m_typeForme = "ELLIPSE";
	}
	

	@Override
	public void dessiner(IDessiner p_dessin) {
		p_dessin.dessinerEllipse(this.m_x1, this.m_y1, this.m_x2, this.m_y2, 
				this.m_couleurRemplissage, this.m_couleurTrait, this.m_epaisseurTrait);
	}
	
}
