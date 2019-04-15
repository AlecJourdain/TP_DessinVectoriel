package ca.csf.dfc.dessin;

import java.awt.Color;

public interface IDessiner {
	


	public void dessinerRectangle(int p_x1, int p_y1, int p_x2, int p_y2, 
			Color p_couleurRemplissage, Color p_couleurTrait, int p_epaisseurTrait);
	public void dessinerEllipse(int p_x1, int p_y1, int p_x2, int p_y2,
			Color p_couleurRemplissage, Color p_couleurTrait, int p_epaisseurTrait);
	public void dessinerLigne(int p_x1, int p_y1, int p_x2, int p_y2,
			Color p_couleurRemplissage, Color p_couleurTrait, int p_epaisseurTrait);
}
