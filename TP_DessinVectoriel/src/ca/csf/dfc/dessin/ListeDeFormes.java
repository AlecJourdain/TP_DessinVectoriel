/**
 * 
 */
package ca.csf.dfc.dessin;

import java.util.ArrayList;

/**
 * @author Coralie-Hong Brière
 *
 */
public class ListeDeFormes {
	private ArrayList<Forme> listeFormes;
	
	/**
	 * Retourne le listeFormes.
	 * @return le listeFormes
	 */
	public ArrayList<Forme> getListeFormes() {
		return this.listeFormes;
	}

	/**
	 * Pour modifier le listeFormes.
	 * @param p_listeFormes Nouvelle valeur.
	 */
	public void setListeFormes(ArrayList<Forme> p_listeFormes) {
		this.listeFormes = p_listeFormes;
	}

	public ListeDeFormes() {
		listeFormes = new ArrayList<Forme>();
	}
	
	public ListeDeFormes(ArrayList<Forme> p_listeFormes) {
		listeFormes = p_listeFormes;
	}
	
	public void ajouterUneForme(Forme p_forme) {
		listeFormes.add(p_forme);
	}
	
	public void supprimerLesFormes() {
		listeFormes.clear();
	}
}
