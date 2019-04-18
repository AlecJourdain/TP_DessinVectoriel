package ca.csf.dfc.fonctions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import ca.csf.dfc.dessin.Forme;
import ca.csf.dfc.vueUtilisateur.Canevas;



public class Sauvegarde {
	
	private static final String ELEM_FORME="forme";
	private static final String ELEM_DIMENSIONS="dimensions";
	private static final String ELEM_TABLEAU_FORMES="tableau_formes";
	/* attributs du canevas*/
	private static final String ATTR_HAUTEUR_CANEVAS = "hauteur";
	private static final String ATTR_LARGEUR_CANEVAS = "largeur";
	/*attributs d'une forme*/
	private static final String ATTR_TYPEFORME = "type";
	private static final String ATTR_EPAISSEUR_TRAIT = "epaisseur_trait";
	private static final String ATTR_COULEUR_CONTOUR = "couleur_trait";
	private static final String ATTR_COULEUR_REMPLISSAGE = "couleur_remplissage";
	private static final String ATTR_X1 = "x1";
	private static final String ATTR_X2 = "x2";
	private static final String ATTR_Y1 = "y1";
	private static final String ATTR_Y2 = "y2";
	
	public static void ecrireFormesXML(XMLStreamWriter p_doc, ArrayList<Forme> p_dessin) throws XMLStreamException{
		
		for (Forme p_forme : p_dessin) {
			// <forme ...
			p_doc.writeStartElement(ELEM_FORME);
			
			//... type="..." ...
			p_doc.writeAttribute(ATTR_TYPEFORME, 
					p_forme.getType().toString());
			
			//... epaisseur_trait="..." ...
			p_doc.writeAttribute(ATTR_EPAISSEUR_TRAIT, 
					Float.toString(p_forme.getEpaisseurTrait()));
			
			//... couleur_trait="..." ...
			p_doc.writeAttribute(ATTR_COULEUR_CONTOUR, Integer.toString(p_forme.getCouleurTrait().getRGB()));
					
			
			//... couleur_remplissage="..." ...
			p_doc.writeAttribute(ATTR_COULEUR_REMPLISSAGE,Integer.toString(p_forme.getCouleurRemplissage().getRGB()));
					
			//... x1="..." ...
			p_doc.writeAttribute(ATTR_X1, 
					Integer.toString(p_forme.getX1()));
			
			//... x2="..." ...
			p_doc.writeAttribute(ATTR_X2, 
					Integer.toString(p_forme.getX2()));
			
			//... y1="..." ...
			p_doc.writeAttribute(ATTR_Y1, 
					Integer.toString(p_forme.getY1()));
			
			//... y2="..." ...
			p_doc.writeAttribute(ATTR_Y2, 
					Integer.toString(p_forme.getY2()));
			
			
			// ... />
			p_doc.writeEndElement();
		}
			
			// ... />
			p_doc.writeEndElement();
		}

	

	public void sauvegarderFormesXML(Canevas p_canevas,String p_name){
		
		XMLStreamWriter doc = null;
		
		try {
			FileWriter output = new FileWriter(new File(p_name));

			
			doc = XMLOutputFactory.newInstance().createXMLStreamWriter(output);
					
			
			// <tableau_formes>
			doc.writeStartElement(ELEM_TABLEAU_FORMES);
			int hauteur=p_canevas.getDimensionEspaceTravail().height;
			int largeur=p_canevas.getDimensionEspaceTravail().width;
			
			doc.writeStartElement(ELEM_DIMENSIONS);
			doc.writeAttribute(ATTR_HAUTEUR_CANEVAS,String.valueOf(hauteur));
			doc.writeAttribute(ATTR_LARGEUR_CANEVAS,String.valueOf(largeur));
			doc.writeEndElement();
			ecrireFormesXML(doc, p_canevas.getFormes());

			
			// </tableau_formes>
			//doc.writeEndElement();
			
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
