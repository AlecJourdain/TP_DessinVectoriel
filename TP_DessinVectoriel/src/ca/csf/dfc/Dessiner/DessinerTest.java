package ca.csf.dfc.Dessiner;

import java.awt.Color;

public class DessinerTest implements IDessiner {
	public int m_nbAppelDessinerRectangle2D;
	public int m_nbAppelDessinerEllipse2D;
	public int m_nbAppelDessinerLigne2D;
	
	@Override
	public void dessinerLigne(int p_x1, int p_y1, int p_x2, int p_y2, Color couleurTrait, float epaisseurTrait) {
		this.m_nbAppelDessinerLigne2D += 1;
		
	}
	@Override
	public void dessinerEllipse(int p_x1, int p_y1, int p_x2, int p_y2,
						 Color couleurTrait, float epaisseurTrait, Color couleurRemplissage) {
		this.m_nbAppelDessinerEllipse2D += 1;
	}
	@Override
	public void dessinerRectangle(int p_x1, int p_y1, int p_x2, int p_y2,
						   Color couleurTrait, float epaisseurTrait, Color couleurRemplissage){
		this.m_nbAppelDessinerRectangle2D += 1;
	}
	
	
}
