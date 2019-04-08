/**
 * 
 */
package tp_dessin.model;

/**
 * @author ManueLMaldonado
 *
 */
public interface IModeleDessinVect {
	
	
	/**
	 * Pour modifier les dimension de l'arrière plan.
	 * 
	 * @param p_Largeur la nouvelle largeur.
	 * @param p_Hauteur la nouvelle hauteur.
	 */
	void setDimensionEspaceTravail(double p_Largeur, double p_Hauteur);	
	double getLargeur();
	double getHauteur();
}
