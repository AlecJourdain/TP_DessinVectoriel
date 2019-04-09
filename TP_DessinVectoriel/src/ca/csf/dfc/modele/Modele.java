/**
 * 
 */
package ca.csf.dfc.modele;

import java.awt.Color;


public class Modele implements IModele {

	

	/**
	 * 
	 */
	public static final double LARGEUR_DEFAULT_ESPACE_TRAVAIL = 80.0;

	/**
	 * 
	 */
	public static final double HAUTEUR_DEFAULT_ESPACE_TRAVAIL = 60.0;
	
	/**
	 * 
	 */
	public static final Color COULEUR_DEFAULT_ESPACE_TRAVAIL = Color.WHITE;
	
	/**
	 * 
	 */
	private double m_HauteurEspaceTravail;
	
	/**
	 * 
	 */
	private double m_LargeurEspaceTravail;
	
	/**
	 * 
	 */
	private Color m_colorFondEspaceTravail;
	
	
	
	



	/**
	 * 
	 */
	public Modele() {
		

		EspaceTravailDefault();
	}
	
	/* (non-Javadoc)
	 * @see ca.csf.dfc.modele.IModele#initialisationModele()
	 */
	@Override
	public void EspaceTravailDefault() {
		setDimensionEspaceTravailDefault();
		setColorFondEspaceTravailDefault();
	}
	

	/* (non-Javadoc)
	 * @see ca.csf.dfc.modele.IModele#setDimensionEspaceTravailDefault()
	 */
	@Override
	public void setDimensionEspaceTravailDefault() {
		
		this.setDimensionEspaceTravail(
					HAUTEUR_DEFAULT_ESPACE_TRAVAIL,
					LARGEUR_DEFAULT_ESPACE_TRAVAIL);
	}
	/* (non-Javadoc)
	 * @see tp_dessin.model.IModeleDessinVect#setDimension(double, double)
	 */
	@Override
	public void setDimensionEspaceTravail(double p_Largeur, double p_Hauteur) {		
		this.setHauteurEspaceTravail(p_Hauteur);
		this.setLargeurEspaceTravail(p_Largeur);
			
	}
	
	/**
	 * @return the m_Hauteur
	 */
	public double getHauteurEspaceTravail() {		
		return m_HauteurEspaceTravail;		
	}

	/**
	 * @param m_Hauteur the m_Hauteur to set
	 */
	private void setHauteurEspaceTravail(double p_Hauteur) {
		if ( p_Hauteur < 0) {
			throw new IllegalArgumentException(
					"Dimensions négatives non-supportées");
		}
		this.m_HauteurEspaceTravail = p_Hauteur;
	}

	/**
	 * @return the m_Largeur
	 */
	public double getLargeurEspaceTravail() {
		return m_LargeurEspaceTravail;
	}

	/**
	 * @param m_Largeur the m_Largeur to set
	 */
	private void setLargeurEspaceTravail(double p_Largeur) {
		if (p_Largeur < 0 ) {
			throw new IllegalArgumentException(
					"Dimensions négatives non-supportées");
		}
		this.m_LargeurEspaceTravail = p_Largeur;
	}


	/* (non-Javadoc)
	 * @see ca.csf.dfc.modele.IModele#getLargeur()
	 */
	@Override
	public double getLargeur() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see ca.csf.dfc.modele.IModele#getHauteur()
	 */
	@Override
	public double getHauteur() {
		// TODO Auto-generated method stub
		return 0;
	}
	


	/* (non-Javadoc)
	 * @see ca.csf.dfc.modele.IModele#setColorFondEspaceTravailDefault()
	 */
	@Override
	public void setColorFondEspaceTravailDefault() {
		setColorFondEspaceTravail(COULEUR_DEFAULT_ESPACE_TRAVAIL);		
	}
	
	/* (non-Javadoc)
	 * @see ca.csf.dfc.modele.IModele#getColorFondEspaceTravail()
	 */
	@Override
	public Color getColorFondEspaceTravail() {
		return m_colorFondEspaceTravail;
	}

	/* (non-Javadoc)
	 * @see ca.csf.dfc.modele.IModele#setColorFondEspaceTravail(java.awt.Color)
	 */
	@Override
	public void setColorFondEspaceTravail(Color p_colorFondEspaceTravail) {
		this.m_colorFondEspaceTravail = p_colorFondEspaceTravail;
		
	}
	


}

