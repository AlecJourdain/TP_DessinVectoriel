/**
 * 
 */
package ca.csf.dfc.modele;

import java.awt.Color;

/**
 * @author ManueLMaldonado
 *
 */
public class ModeleDessinVect implements IModele {

	

	public static final double LARGEUR_DEFAULT = 80.0;

	public static final double HAUTEUR_DEFAULT = 60.0;
	
	public static final Color COULEUR_DEFAULT = Color.WHITE;
	
	private double m_Hauteur;
	
	private double m_Largeur;
	
	
	
	public ModeleDessinVect() {
		this(LARGEUR_DEFAULT, HAUTEUR_DEFAULT);
	}

	public ModeleDessinVect(double p_Largeur, double p_Hauteur) {
		
		this.setDimensionEspaceTravail(p_Largeur, p_Hauteur);
	}

	/* (non-Javadoc)
	 * @see tp_dessin.model.IModeleDessinVect#setDimension(double, double)
	 */
	@Override
	public void setDimensionEspaceTravail(double p_Largeur, double p_Hauteur) {		
		this.setHauteur(p_Hauteur);
		this.setLargeur(p_Largeur);		
	}
	
	/**
	 * @return the m_Hauteur
	 */
	public double getHauteur() {
		
		return m_Hauteur;
		
	}

	/**
	 * @param m_Hauteur the m_Hauteur to set
	 */
	private void setHauteur(double p_Hauteur) {
		if ( p_Hauteur < 0) {
			throw new IllegalArgumentException(
					"Dimensions négatives non-supportées");
		}
		this.m_Hauteur = p_Hauteur;
	}

	/**
	 * @return the m_Largeur
	 */
	public double getLargeur() {
		return m_Largeur;
	}

	/**
	 * @param m_Largeur the m_Largeur to set
	 */
	private void setLargeur(double p_Largeur) {
		if (p_Largeur < 0 ) {
			throw new IllegalArgumentException(
					"Dimensions négatives non-supportées");
		}
		this.m_Largeur = p_Largeur;
	}

}

