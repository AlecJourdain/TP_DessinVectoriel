package ca.csf.dfc.fonctions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import ca.csf.dfc.dessin.Forme;



public class Sauvegarde {
	
	public static void ecrireFormesXML(XMLStreamWriter p_doc, ArrayList<Forme> p_dessin) throws XMLStreamException{
		for (Forme p_forme : p_dessin) {
			// <forme ...
			p_doc.writeStartElement("forme");
			
			//... type="..." ...
			p_doc.writeAttribute("type", 
					p_forme.getType().toString());
			
			//... epaisseur_trait="..." ...
			p_doc.writeAttribute("epaisseur_trait", 
					Float.toString(p_forme.getEpaisseurTrait()));
			
			//... couleur_trait="..." ...
			p_doc.writeAttribute("couleur_trait", 
					p_forme.getCouleurTrait().toString());
			
			//... couleur_remplissage="..." ...
			p_doc.writeAttribute("couleur_remplissage",Integer.toString(p_forme.getCouleurRemplissage().getRGB()));
					
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
			
			
			// ... />
			p_doc.writeEndElement();
		}
			
			// ... />
			p_doc.writeEndElement();
		}



	public void sauvegarderFormesXML(ArrayList<Forme> p_tableauFormes){
		
		XMLStreamWriter doc = null;
		
		try {
			FileWriter output = new FileWriter(new File("data.xml"));

			
			doc = XMLOutputFactory.newInstance().createXMLStreamWriter(output);
					
			// <tableau_formes>
			doc.writeStartElement("tableau_formes");
			
			ecrireFormesXML(doc, p_tableauFormes);

			
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
	
	public void exporterFormesSVG(ArrayList<Forme> p_tableauForme) {
		XMLStreamWriter doc = null;
		
		try {
			FileWriter output = new FileWriter(new File("data.svg"));
			
		}catch(IOException exp) {
			System.err.println("Erreur ecriture :" + exp);
		}
	}

}
