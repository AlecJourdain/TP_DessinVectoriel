package ca.csf.dfc.controleur;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import ca.csf.dfc.modele.Dessin;
import ca.csf.dfc.modele.Forme;
import ca.csf.dfc.modele.FormeType;
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
		
		public static void ecrireFormes(XMLStreamWriter p_doc, ArrayList<Forme> p_dessin) throws XMLStreamException{
			for (Forme p_forme : p_dessin) {
				// <forme ...
				p_doc.writeStartElement("forme");
				
				//... type="..." ...
				p_doc.writeAttribute("type", 
						p_forme.getType().toString());
				
				//... epaisseur_trait="..." ...
				p_doc.writeAttribute("epaisseur_trait", 
						Integer.toString(p_forme.getEpaisseurTrait()));
				
				//... couleur_trait="..." ...
				p_doc.writeAttribute("couleur_trait", 
						p_forme.getCouleurTrait().toString());
				
				//... couleur_remplissage="..." ...
				p_doc.writeAttribute("couleur_remplissage", 
						p_forme.getCouleurRemplissage().toString());
				
				//... x1="..." ...
				p_doc.writeAttribute("x1", 
						Integer.toString(p_forme.getX1()));
				
				//... x2="..." ...
				p_doc.writeAttribute("x2", 
						Integer.toString(p_forme.getX2()));
				
				//... y1="..." ...
				p_doc.writeAttribute("y1", 
						Integer.toString(p_forme.getY1()));
				
				//... y2="..." ...
				p_doc.writeAttribute("y2", 
						Integer.toString(p_forme.getY2()));
				
				if(p_forme.getType() == FormeType.RECTANGLE ||
						p_forme.getType() == FormeType.ELLIPSE) {
				//... hauteur="..." ...
				//p_doc.writeAttribute("hauteur", p_forme.getHauteur());
				
				//... largeur="..." ...
				//p_doc.writeAttribute("largeur", p_forme.getLargeur());
				}
				
				// ... />
				p_doc.writeEndElement();
			}
		}
		
		
		public void sauvegarderFormes(ArrayList<Forme> p_dessin){
			
			XMLStreamWriter doc = null;
			
			try {
				FileWriter output = new FileWriter(new File("data.xml"));
				
				doc = XMLOutputFactory.newInstance().createXMLStreamWriter(output);
						
				// <tableau_formes>
				doc.writeStartElement("tableau_formes");
				
				ecrireFormes(doc, p_dessin);

				
				// </tableau_formes>
				doc.writeEndElement();
				
			} catch(IOException exp) {
				System.err.println("Erreur ecriture : " + exp);
				
			} catch(XMLStreamException exp) {
				System.err.println("Erreur dans le XML : " + exp);
			} finally {
				if(doc != null) {
					try {
						doc.flush();
						doc.close();
					} catch(XMLStreamException exp) {
						System.err.println("Erreur lors de la fermeture : " + exp);
					} finally {
						doc = null;
					}
				}
			}
			

		}
		
		
	
	
}
