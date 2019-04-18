/**
 * 
 */
package ca.csf.dfc.fonctions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import ca.csf.dfc.dessin.Ellipse;
import ca.csf.dfc.dessin.Forme;
import ca.csf.dfc.dessin.Ligne;
import ca.csf.dfc.dessin.Rectangle;

/**
 * @author Coralie-Hong Brière
 *
 */
public class ExporterSVG {
	
	private final static String ELM_SVG = "svg";
	private final static String ATTR_XMLNS = "xmlns";
	private final static String ATTR_VERSION = "version";
	private final static String ATTR_LARGEUR = "width";
	private final static String ATTR_HAUTEUR = "height";
	
	private final static String ELM_TITRE = "titre";
	
	private final static String ELM_DESCRIPTION = "desc";
	
	private final static String ELM_RECTANGLE = "rectangle";
	private final static String ATTR_LARGEURRECT = "largeur";
	private final static String ATTR_HAUTEURRECT = "hauteur";
	private final static String ATTR_X = "x";
	private final static String ATTR_Y = "y";
	private final static String ATTR_COULREMPLISS = "couleur remplissage";
	private final static String ATTR_COULTRAIT = "couleur trait";
	private final static String ATTR_EPAISSTRAIT = "epaisseur trait";
	
	private final static String ELM_LIGNE = "ligne";
	private final static String ATTR_X1 = "x1";
	private final static String ATTR_Y1 = "y1";
	private final static String ATTR_X2 = "x2";
	private final static String ATTR_Y2 = "y2";
	
	private final static String ELM_ELLIPSE = "ellipse";
	private final static String ATTR_CX = "cx";
	private final static String ATTR_CY = "cy";
	private final static String ATTR_RX = "rx";
	private final static String ATTR_RY = "ry";
	
	public static void completerBaliseSVG(XMLStreamWriter p_doc,
										 String p_xmlns,
										 String p_version,
										 String p_largeur,
										 String p_hauteur) throws XMLStreamException{
		p_doc.writeAttribute(ATTR_XMLNS, p_xmlns);
		p_doc.writeAttribute(ATTR_VERSION, p_version);
		p_doc.writeAttribute(ATTR_LARGEUR, p_largeur);
		p_doc.writeAttribute(ATTR_HAUTEUR, p_hauteur);
	}
	
	public static void completerBaliseTitle(XMLStreamWriter p_doc,
											String p_titre) throws XMLStreamException {
		p_doc.writeStartElement(ELM_TITRE);
		p_doc.writeComment(p_titre);
		p_doc.writeEndElement();
	}
	
	public static void completerBaliseDescription(XMLStreamWriter p_doc, ArrayList<Forme> p_listeFormes) throws XMLStreamException {
		StringBuilder sb = new StringBuilder();
		for (Forme f : p_listeFormes) {
			sb.append(f.getClass().getName());
		}
		p_doc.writeStartElement(ELM_DESCRIPTION);
		p_doc.writeComment("Ce dessin est composé de: " + sb);
		p_doc.writeEndElement();
	}
	
	public static void decrireForme(XMLStreamWriter p_doc, ArrayList<Forme> p_listeFormes) throws XMLStreamException {
		for (Forme f : p_listeFormes) {
			if (f instanceof Rectangle) {
				p_doc.writeStartElement(ELM_RECTANGLE);
				p_doc.writeAttribute(ATTR_LARGEURRECT, Integer.toString(f.getX2() - f.getX1()));
				p_doc.writeAttribute(ATTR_HAUTEURRECT, Integer.toString(f.getY2() - f.getY1()));
				p_doc.writeAttribute(ATTR_X, Integer.toString(f.getX1()));
				p_doc.writeAttribute(ATTR_Y, Integer.toString(f.getY1()));
				p_doc.writeAttribute(ATTR_COULREMPLISS, Integer.toString(f.getCouleurRemplissage().getRGB()));
				p_doc.writeAttribute(ATTR_COULTRAIT, Integer.toString(f.getCouleurTrait().getRGB()));
				p_doc.writeAttribute(ATTR_EPAISSTRAIT, Integer.toString(f.getEpaisseurTrait()));
				p_doc.writeEndElement();
			}
			else if (f instanceof Ligne) {
				p_doc.writeStartElement(ELM_LIGNE);
				p_doc.writeAttribute(ATTR_X1, Integer.toString(f.getX1()));
				p_doc.writeAttribute(ATTR_Y1, Integer.toString(f.getY1()));
				p_doc.writeAttribute(ATTR_X2, Integer.toString(f.getX2()));
				p_doc.writeAttribute(ATTR_Y2, Integer.toString(f.getX2()));
				p_doc.writeAttribute(ATTR_COULTRAIT, Integer.toString(f.getCouleurTrait().getRGB()));
				p_doc.writeAttribute(ATTR_EPAISSTRAIT, Integer.toString(f.getEpaisseurTrait()));
				p_doc.writeEndElement();
			}
			else if (f instanceof Ellipse) {
				p_doc.writeStartElement(ELM_ELLIPSE);
				p_doc.writeAttribute(ATTR_CX, Integer.toString(f.getX1() + (f.getX2() - f.getX1())/2));
				p_doc.writeAttribute(ATTR_CY, Integer.toString(f.getY1() + (f.getY2() - f.getY1())/2));
				p_doc.writeAttribute(ATTR_RX, Integer.toString((f.getX2() - f.getX1())/2));
				p_doc.writeAttribute(ATTR_RY, Integer.toString((f.getY2() - f.getY1())/2));
				p_doc.writeAttribute(ATTR_COULREMPLISS, Integer.toString(f.getCouleurRemplissage().getRGB()));
				p_doc.writeAttribute(ATTR_COULTRAIT, Integer.toString(f.getCouleurTrait().getRGB()));
				p_doc.writeAttribute(ATTR_EPAISSTRAIT, Integer.toString(f.getEpaisseurTrait()));
				p_doc.writeEndElement();
			}
		}
	}
	
	public void ecrireFichierSVG(ArrayList<Forme> p_listeFormes) {
		XMLStreamWriter doc = null;
		
		try {
			FileWriter output = new FileWriter(new File("data.svg"));
			
			
			doc = XMLOutputFactory.newInstance().createXMLStreamWriter(output);
			
			doc.writeStartDocument();
			
			doc.writeStartElement(ELM_SVG);
			
			completerBaliseSVG(doc, "http://www.w3.org/2000/svg", "1.1", "300", "200");
			completerBaliseTitle(doc, "Dessin au format SVG");
			completerBaliseDescription(doc, p_listeFormes);
			decrireForme(doc, p_listeFormes);
			
			doc.writeEndElement();
			
			doc.writeEndDocument();
			
		} catch(IOException exp) {
			System.err.println("Erreur d'écriture : " + exp);
			
		} catch(XMLStreamException exp) {
			System.err.println("Erreur dans le XML : " + exp);
			
		} finally {
			if (doc != null) {
				try {
					doc.flush();
					doc.close();
					
				} catch(XMLStreamException exp) {
					System.err.println("Erreur lors de la fermeture" + exp);
					
				} finally {
					doc = null;
				}
			}
		}
	}
	
	
	
	
}
