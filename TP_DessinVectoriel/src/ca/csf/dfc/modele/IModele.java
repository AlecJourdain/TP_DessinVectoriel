/**
 * 
 */
package ca.csf.dfc.modele;

import java.awt.Color;

public interface IModele {
	
	
	/**
	 * Pour modifier les dimension de l'arrière plan.
	 * 
	 * @param p_Largeur la nouvelle largeur.
	 * @param p_Hauteur la nouvelle hauteur.
	 */
	
	void initialisationModele();
	
	//pour l'espace Travail
	
	void setColorFondEspaceTravailDefault();
	
	Color getColorFondEspaceTravail();
	void setColorFondEspaceTravail(Color p_colorFondEspaceTravail) ;
	
	void setDimensionEspaceTravailDefault();	
	void setDimensionEspaceTravail(double p_Largeur, double p_Hauteur);	
	
	double getLargeur();
	double getHauteur();
}
