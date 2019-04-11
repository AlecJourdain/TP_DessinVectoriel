/**
 * 
 */
package ca.csf.dfc.fonctions;

import java.io.File;

import javax.xml.stream.*;
import ca.csf.dfc.dessin.Forme;

/**
 * @author administrateur
 *
 */
public class charger {



	/*espace de travail, chargement*/
	
	private static final String ATTR_TYPEFORME = "type";
	
	private static final String ATTR_EPAISSEUR_TRAIT = "epaisseur_trait";
	//private static final String ATTR_COULEUR_CONTOUR = "contour";
	//private static final String ATTR_COULEUR_REMPLISSAGE = "remplissage";
	private static final String ATTR_X1 = "x1";
	private static final String ATTR_X2 = "x2";
	private static final String ATTR_Y1 = "y1";
	private static final String ATTR_Y2 = "y2";
	
	public Forme charger(File p_file) {
		Forme f = null;
		XMLStreamReader doc = null;
		
		String typeForme=doc.getAttributeValue("", ATTR_TYPEFORME);
		int x1=Integer.parseInt(doc.getAttributeValue("", ATTR_X1));
		int y1=Integer.parseInt(doc.getAttributeValue("", ATTR_Y1));
		int x2=Integer.parseInt(doc.getAttributeValue("", ATTR_X2));
		int y2=Integer.parseInt(doc.getAttributeValue("", ATTR_Y2));
		int epaisseurTrait=Integer.parseInt(doc.getAttributeValue("", ATTR_EPAISSEUR_TRAIT));
	//	int couleurRemplissage;    couleur_remplissage
	//	int couleurTrait;    couleur_trait
		
		f.getType();
		f.setX1(x1);
		f.setX2(x2);
		f.setY1(y1);
		f.setY2(y2);
		f.setEpaisseurTrait(epaisseurTrait);
		
		return f;
		
	}

}
