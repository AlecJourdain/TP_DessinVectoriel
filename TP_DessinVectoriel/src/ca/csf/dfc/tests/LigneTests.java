package ca.csf.dfc.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.Dessiner.DessinerTest;
import ca.csf.dfc.dessin.Ellipse;
import ca.csf.dfc.dessin.Ligne;

class LigneTests {

	@Test
	void ConstructeurParDefault() {
		Ligne ligne = new Ligne();
		assertEquals(0, ligne.getX1());
		assertEquals(0, ligne.getY1());
		assertEquals(0, ligne.getX2());
		assertEquals(0.0, ligne.getY2());
		assertEquals(0, ligne.getEpaisseurTrait());
		assertEquals("L", ligne.getType());
		assertNull(ligne.getCouleurRemplissage());
		assertNull(ligne.getCouleurTrait());
	}
	
	@Test
	void InitialisationLigne() {
		Ligne ligne = new Ligne();
		ligne.setX1(1);
		ligne.setX2(2);
		ligne.setY1(3);
		ligne.setY2(4);
		ligne.setEpaisseurTrait(3);
		ligne.setCouleurRemplissage(Color.black);
		ligne.setCouleurTrait(Color.black);
		assertEquals(1, ligne.getX1());
		assertEquals(3, ligne.getY1());
		assertEquals(2, ligne.getX2());
		assertEquals(4, ligne.getY2());
		assertEquals(3, ligne.getEpaisseurTrait());
		assertEquals("L", ligne.getType());
		assertEquals(Color.black,ligne.getCouleurRemplissage());
		assertEquals(Color.black,ligne.getCouleurTrait());
	}
	
	@Test
	void contient() {
		Ligne ligne = new Ligne();
		ligne.setX1(100);
		ligne.setY1(100);
		ligne.setX2(200);
		ligne.setY2(200);
		assertTrue(ligne.contientPoint(125, 125));
	}
	
	@Test
	void dessiner() {
		Ligne ligne = new Ligne();
		DessinerTest d2 = new DessinerTest();
		ligne.setX1(1);
		ligne.setX2(2);
		ligne.setY1(3);
		ligne.setY2(4);
		ligne.setEpaisseurTrait(3);
		ligne.setCouleurRemplissage(Color.black);
		ligne.setCouleurTrait(Color.black);
		
		ligne.dessiner(d2);
		
		assertEquals(1, d2.m_nbAppelDessinerLigne2D);
	}

}
