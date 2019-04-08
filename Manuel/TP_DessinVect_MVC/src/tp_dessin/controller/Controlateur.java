/**
 * 
 */
package tp_dessin.controller;



import tp_dessin.model.ModeleDessinVect;


/**
 * @author ManueLMaldonado
 *
 */
public class Controlateur {
	
	/**
	 * 
	 */
	private ModeleDessinVect m_Model;

	/**
	 * @param p_Modele
	 */
	public Controlateur( ModeleDessinVect p_Modele) {
		this.m_Model = p_Modele;
	}

	/**
	 * @param p_Largeur
	 * @param p_Hauteur
	 */
	public void FichierNouveau() {
		
		//this.m_Model.vider();
		this.m_Model.setDimensionEspaceTravail( 
				ModeleDessinVect.LARGEUR_DEFAULT,  
				ModeleDessinVect.HAUTEUR_DEFAULT);//*/
		//this.m_Model.setArrierePlan(Color.WHITE);
		
		
		
	}
}
