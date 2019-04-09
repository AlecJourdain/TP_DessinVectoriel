package ca.csf.dfc.fonctions;


import ca.csf.dfc.dessin.IModele;



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


		public IModele getModele() {
			return this.m_Model;
		}
		
}