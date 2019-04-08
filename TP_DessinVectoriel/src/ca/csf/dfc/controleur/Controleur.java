package ca.csf.dfc.controleur;

import ca.csf.dfc.modele.IModele;



public class Controleur {
	

		
		/**
		 * 
		 */
		private IModele m_Model;
		

		/**
		 * @param p_Modele
		 */
		public Controleur( IModele p_Modele) {
			this.m_Model = p_Modele;
		}

		/**
		 * @param p_Largeur
		 * @param p_Hauteur
		 */
		public void FichierNouveau() {
			
			
			this.m_Model.setColorFondEspaceTravailDefault();
			this.m_Model.setColorFondEspaceTravailDefault();
			
			
		}
	
	
}
