package ca.csf.dfc.fonction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
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




public abstract class MasterListener implements ActionListener, MouseListener {
	
		
	
		public void actionPerformed(ActionEvent p_event) {
			
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


<<<<<<< Updated upstream:TP_DessinVectoriel/src/ca/csf/dfc/controleur/Controleur.java
		public IModele getModele() {
			return this.m_Model;
		}
=======
public void sauvegarderFormes(ArrayList<Forme> p_dessin){
	
	XMLStreamWriter doc = null;
	
	try {
		FileWriter output = new FileWriter(new File("data.xml"));
>>>>>>> Stashed changes:TP_DessinVectoriel/src/ca/csf/dfc/fonction/MasterListener.java
		
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
