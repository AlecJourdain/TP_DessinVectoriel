/**
 * 
 */
package ca.csf.dfc.Dessiner;

import java.awt.Color;


/**
 * @author Coralie-Hong Brière
 *
 */
public interface IDessiner {
	void dessinerLigne(int p_x1, int p_y1, int p_x2, int p_y2, Color couleurTrait, float epaisseurTrait);
	void dessinerEllipse(int p_x1, int p_y1, int p_x2, int p_y2,
						 Color couleurTrait, float epaisseurTrait, Color couleurRemplissage);
	void dessinerRectangle(int p_x1, int p_y1, int p_x2, int p_y2,
						   Color couleurTrait, float epaisseurTrait, Color couleurRemplissage);
}
