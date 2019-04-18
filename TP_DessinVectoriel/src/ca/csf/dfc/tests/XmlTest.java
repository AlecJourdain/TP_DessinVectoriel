package ca.csf.dfc.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.dessin.FactoryForme;
import ca.csf.dfc.dessin.Forme;
import ca.csf.dfc.dessin.Rectangle;
import ca.csf.dfc.fonctions.Charger;
import ca.csf.dfc.fonctions.Sauvegarde;
import ca.csf.dfc.vueUtilisateur.Canevas;

class XmlTest {

	File m_fichier = new File("test.xml");

	@Test
	void testSauvegarde() {

	}

	@Test
	void testChargement() throws FileNotFoundException {
		try {

			FactoryForme facto = new FactoryForme();

			ArrayList<Forme> formes = new ArrayList<>();
			Canevas canevas = new Canevas();
			canevas.setEspaceTravailParDefaut();
			Color gris = new Color(128, 128, 128);
			Color orange = new Color(255, 200, 0);

			Forme f1 = new Rectangle();
			// f1 = facto.creationForme(typeForme);
			f1.setEpaisseurTrait(5);
			f1.setCouleurRemplissage(gris);
			f1.setCouleurTrait(orange);
			f1.setX1(20);
			f1.setX2(40);
			f1.setY1(100);
			f1.setY2(140);

			formes.add(f1);
			canevas.setFormes(formes);
			Sauvegarde s = new Sauvegarde();
			FileReader input = new FileReader(m_fichier);
			s.sauvegarderFormesXML(canevas, "test.xml");
			XMLStreamReader doc = XMLInputFactory.newInstance().createXMLStreamReader(input);

			/*
			 * int hauteur = ; int largeur = Integer.parseInt(doc.getAttributeValue("",
			 * ATTR_LARGEUR_CANEVAS));
			 */
			// int hauteur = Integer.parseInt(doc.getAttributeValue("",
			// ATTR_HAUTEUR_CANEVAS));

			doc.next();
			doc.next();

			assertEquals(Integer.parseInt(doc.getAttributeValue("", "hauteur")), 2000);
			assertEquals(Integer.parseInt(doc.getAttributeValue("", "largeur")), 2000);

			doc.next();
			while(doc.isStartElement())
			{
				assertEquals(doc.getAttributeValue("", "type"), "R");
				assertEquals(Integer.parseInt(doc.getAttributeValue("", "epaisseur_trait")), 5);
				assertEquals(Integer.parseInt(doc.getAttributeValue("", "couleur_trait")), -14336);
				assertEquals(Integer.parseInt(doc.getAttributeValue("", "couleur_remplissage")), -8355712);
				assertEquals(Integer.parseInt(doc.getAttributeValue("", "x1")), 20);
				assertEquals(Integer.parseInt(doc.getAttributeValue("", "x2")), 40);
				assertEquals(Integer.parseInt(doc.getAttributeValue("", "y2")), 140);
				assertEquals(Integer.parseInt(doc.getAttributeValue("", "y1")), 100);
				
				

			}
			

			

		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
