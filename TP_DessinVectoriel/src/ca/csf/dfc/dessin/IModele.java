/**
 * 
 */
package ca.csf.dfc.dessin;

import java.awt.Color;

public interface IModele {
	
	
void EspaceTravailDefault();
	
	//pour l'espace Travail
	
	void setColorFondEspaceTravailDefault();
	Color getColorFondEspaceTravailDefault();
	
	Color getColorFondEspaceTravail();
	void setColorFondEspaceTravail(Color p_colorFondEspaceTravail) ;
	
	void setDimensionEspaceTravailDefault();	
	void setDimensionEspaceTravail(double p_Largeur, double p_Hauteur);	
	void setLargeurEspacetravail(int p_Largeur);
	
	double getLargeurEspaceTravail();
	double getHauteurEspaceTravail();
}
