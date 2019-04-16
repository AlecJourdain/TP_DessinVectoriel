/**
 * 
 */
package ca.csf.dfc.fonctions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.stream.*;

import ca.csf.dfc.dessin.FactoryForme;
import ca.csf.dfc.dessin.Forme;
import ca.csf.dfc.vueUtilisateur.Canevas;

/**
 * @author administrateur
 *
 */
public class Charger {

	/* espace de travail, chargement */

	private static final String ATTR_TYPEFORME = "type";

	private static final String ATTR_EPAISSEUR_TRAIT = "epaisseur_trait";
	private static final String ATTR_COULEUR_CONTOUR = "couleur_trait";
	private static final String ATTR_COULEUR_REMPLISSAGE = "couleur_remplissage";
	private static final String ATTR_X1 = "x1";
	private static final String ATTR_X2 = "x2";
	private static final String ATTR_Y1 = "y1";
	private static final String ATTR_Y2 = "y2";

	public void charger(File p_file, Canevas p_canevas) throws XMLStreamException, FileNotFoundException {
		ArrayList<Forme> formes = new ArrayList<>();
		FileReader input = new FileReader(p_file);
		XMLStreamReader doc = XMLInputFactory.newInstance().createXMLStreamReader(input);
		doc.next();
		doc.next();
		while (doc.isStartElement()) {
			formes.add(charger(doc));
			doc.next();
		}
		p_canevas.setFormes(formes);
		p_canevas.repaint();
	}
	
	public Forme charger(XMLStreamReader p_doc) throws XMLStreamException {
		Forme f = null;
		FactoryForme facto = new FactoryForme();
			String typeForme = p_doc.getAttributeValue("", ATTR_TYPEFORME);
			int x1 = Integer.parseInt(p_doc.getAttributeValue("", ATTR_X1));
			int y1 = Integer.parseInt(p_doc.getAttributeValue("", ATTR_Y1));
			int x2 = Integer.parseInt(p_doc.getAttributeValue("", ATTR_X2));
			int y2 = Integer.parseInt(p_doc.getAttributeValue("", ATTR_Y2));
			float epaisseurTrait = Float.parseFloat(p_doc.getAttributeValue("", ATTR_EPAISSEUR_TRAIT));
			int couleurRemplissage = Integer.parseInt(p_doc.getAttributeValue("", ATTR_COULEUR_REMPLISSAGE));
			int couleurTrait = Integer.parseInt(p_doc.getAttributeValue("", ATTR_COULEUR_CONTOUR));

			f = facto.creationForme(typeForme);
			
			f.setX1(x1);
			f.setX2(x2);
			f.setY1(y1);
			f.setY2(y2);
			f.setEpaisseurTrait(epaisseurTrait);
			f.setCouleurRemplissage(couleurRemplissage);
			f.setCouleurTrait(couleurTrait);
			p_doc.next();
		return f;

	}

}
