package ca.csf.dfc.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.Dessiner.DessinerTest;
import ca.csf.dfc.dessin.*;

class EllipseTests {

	@Test
	void ConstructeurParDefault() {
		Ellipse ellipse = new Ellipse();
		assertEquals(0, ellipse.getX1());
		assertEquals(0, ellipse.getY1());
		assertEquals(0, ellipse.getX2());
		assertEquals(0.0, ellipse.getY2());
		assertEquals(0, ellipse.getEpaisseurTrait());
		assertEquals("E", ellipse.getType());
		assertNull(ellipse.getCouleurRemplissage());
		assertNull(ellipse.getCouleurTrait());
	}
	
	@Test
	void InitialisationEllipse() {
		Ellipse ellipse = new Ellipse();
		ellipse.setX1(1);
		ellipse.setX2(2);
		ellipse.setY1(3);
		ellipse.setY2(4);
		ellipse.setEpaisseurTrait(3);
		ellipse.setCouleurRemplissage(Color.black);
		ellipse.setCouleurTrait(Color.black);
		assertEquals(1, ellipse.getX1());
		assertEquals(3, ellipse.getY1());
		assertEquals(2, ellipse.getX2());
		assertEquals(4, ellipse.getY2());
		assertEquals(3, ellipse.getEpaisseurTrait());
		assertEquals("E", ellipse.getType());
		assertEquals(Color.black,ellipse.getCouleurRemplissage());
		assertEquals(Color.black,ellipse.getCouleurTrait());
	}
	
	@Test
	void contient() {
		Ellipse ellipse = new Ellipse();
		ellipse.setX1(100);
		ellipse.setY1(100);
		ellipse.setX2(200);
		ellipse.setY2(200);
		assertTrue(ellipse.contientPoint(125, 125));
	}
	
	@Test
	void dessiner() {
		Ellipse ellipse = new Ellipse();
		DessinerTest d2 = new DessinerTest();
		ellipse.setX1(1);
		ellipse.setX2(2);
		ellipse.setY1(3);
		ellipse.setY2(4);
		ellipse.setEpaisseurTrait(3);
		ellipse.setCouleurRemplissage(Color.black);
		ellipse.setCouleurTrait(Color.black);
		
		ellipse.dessiner(d2);
		
		assertEquals(1, d2.m_nbAppelDessinerEllipse2D);
	}

}
