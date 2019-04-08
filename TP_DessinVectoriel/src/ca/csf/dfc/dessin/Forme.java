package ca.csf.dfc.dessin;

import java.awt.Color;

/**
 * @author Coralie-Hong Brière
 *
 */
public abstract class Forme {
	protected FormeType m_type;
	protected int m_x1;
	protected int m_x2;
	protected int m_y1;
	protected int m_y2;
	protected Color m_couleurTrait;
	protected Color m_couleurRemplissage;
	protected int m_epaisseurTrait;
	
	public Forme() {};
	
	/**
	 * Retourne le x1
	 * @return le x1
	 */
	public int getX1() {
		return this.m_x1;
	}
	/**
	 * Pour modifier le x1
	 * @param p_x1 Nouvelle valeur
	 */
	public void setX1(int p_x1) {
		this.m_x1 = p_x1;
	}
	/**
	 * Retourne le x2
	 * @return le x2
	 */
	public int getX2() {
		return this.m_x2;
	}
	/**
	 * Pour modifier le x2
	 * @param p_x2 Nouvelle valeur
	 */
	public void setX2(int p_x2) {
		this.m_x2 = p_x2;
	}
	/**
	 * Retourne le y1
	 * @return le y1
	 */
	public int getY1() {
		return this.m_y1;
	}
	/**
	 * Pour modifier le y1
	 * @param p_y1 Nouvelle valeur
	 */
	public void setY1(int p_y1) {
		this.m_y1 = p_y1;
	}
	/**
	 * Retourne le y2
	 * @return le y2
	 */
	public int getY2() {
		return this.m_y2;
	}
	/**
	 * Pour modifier le y2
	 * @param p_y2 Nouvelle valeur
	 */
	public void setY2(int p_y2) {
		this.m_y2 = p_y2;
	}

	/**
	 * Retourne le couleurTrait
	 * @return le couleurTrait
	 */
	public Color getCouleurTrait() {
		return this.m_couleurTrait;
	}

	/**
	 * Pour modifier le couleurTrait
	 * @param p_couleurTrait Nouvelle valeur
	 */
	public void setCouleurTrait(Color p_couleurTrait) {
		this.m_couleurTrait = p_couleurTrait;
	}

	/**
	 * Retourne le couleurRemplissage
	 * @return le couleurRemplissage
	 */
	public Color getCouleurRemplissage() {
		return this.m_couleurRemplissage;
	}

	/**
	 * Pour modifier le couleurRemplissage
	 * @param p_couleurRemplissage Nouvelle valeur
	 */
	public void setCouleurRemplissage(Color p_couleurRemplissage) {
		this.m_couleurRemplissage = p_couleurRemplissage;
	}

	/**
	 * Retourne le epaisseurTrait
	 * @return le epaisseurTrait
	 */
	public int getEpaisseurTrait() {
		return this.m_epaisseurTrait;
	}

	/**
	 * Pour modifier le epaisseurTrait
	 * @param p_epaisseurTrait Nouvelle valeur
	 */
	public void setEpaisseurTrait(int p_epaisseurTrait) {
		this.m_epaisseurTrait = p_epaisseurTrait;
	}

	/**
	 * Retourne le type
	 * @return le type
	 */
	public FormeType getType() {
		return this.m_type;
	}
	
}
