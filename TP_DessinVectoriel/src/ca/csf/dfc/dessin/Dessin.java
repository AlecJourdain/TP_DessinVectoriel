/**
 * 
 */
package ca.csf.dfc.dessin;

import java.util.ArrayList;

/**
 * @author Coralie-Hong Brière
 *
 */
public class Dessin {
	
	private ArrayList<Forme> m_formes;
	
	public Dessin() {
		this.m_formes = new ArrayList<Forme>();
	}
	
	public Dessin(ArrayList<Forme> p_formes) {
		this.m_formes = p_formes;
	}
	
	public ArrayList<Forme> getFormes() {
		return this.m_formes;
	}
}
