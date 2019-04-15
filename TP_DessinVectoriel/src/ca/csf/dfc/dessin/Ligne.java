package ca.csf.dfc.dessin;

public class Ligne extends Forme{
	public Ligne() {
		super();
		this.m_typeForme = "LIGNE";
	}
	
	@Override
	public void dessiner(IDessiner p_dessin) {
		p_dessin.dessinerLigne(this.m_x1, this.m_y1, this.m_x2, this.m_y2, 
				this.m_couleurRemplissage, this.m_couleurTrait, this.m_epaisseurTrait);
	}
}
