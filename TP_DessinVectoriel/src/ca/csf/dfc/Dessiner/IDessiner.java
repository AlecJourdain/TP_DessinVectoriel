/**
 * 
 */
package ca.csf.dfc.Dessiner;

import ca.csf.dfc.dessin.Couleur;

/**
 * @author Coralie-Hong Brière
 *
 */
public interface IDessiner {
	void dessinerLigne(int p_x1, int p_y1, int p_x2, int p_y2, Couleur couleurTrait, float epaisseurTrait);
	void dessinerEllipse(int p_x1, int p_y1, int p_x2, int p_y2,
						 Couleur couleurTrait, float epaisseurTrait, Couleur couleurRemplissage);
	void dessinerRectangle(int p_x1, int p_y1, int p_x2, int p_y2,
						   Couleur couleurTrait, float epaisseurTrait, Couleur couleurRemplissage);
}
