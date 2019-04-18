package ca.csf.dfc.tests;


import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.dessin.Rectangle;

class RectangleTests {

	@Test
	void ConstructeurParDefault() {
		Rectangle rect = new Rectangle();
		assertEquals(0, rect.getX1());
		assertEquals(0, rect.getY1());
		assertEquals(0, rect.getX2());
		assertEquals(0.0, rect.getY2());
		assertEquals(0, rect.getEpaisseurTrait());
		assertEquals("R", rect.getType());
		assertNull(rect.getCouleurRemplissage());
		assertNull(rect.getCouleurTrait());
	}
	
	@Test
	void InitialisationRectangle() {
		Rectangle rect = new Rectangle();
		rect.setX1(1);
		rect.setX2(2);
		rect.setY1(3);
		rect.setY2(4);
		rect.setEpaisseurTrait(3);
		rect.setCouleurRemplissage(Color.black);
		rect.setCouleurTrait(Color.black);
		assertEquals(1, rect.getX1());
		assertEquals(3, rect.getY1());
		assertEquals(2, rect.getX2());
		assertEquals(4, rect.getY2());
		assertEquals(3, rect.getEpaisseurTrait());
		assertEquals("R", rect.getType());
		assertEquals(Color.black,rect.getCouleurRemplissage());
		assertEquals(Color.black,rect.getCouleurTrait());
	}
	
	@Test
	void contient() {
		Rectangle rect = new Rectangle();
		rect.setX1(100);
		rect.setY1(100);
		rect.setX2(200);
		rect.setY2(200);
		assertTrue(rect.contientPoint(125, 125));
	}
	
	@Test
	void dessiner() {
		Rectangle rect = new Rectangle();
		rect.setX1(1);
		rect.setX2(2);
		rect.setY1(3);
		rect.setY2(4);
		rect.setEpaisseurTrait(3);
		rect.setCouleurRemplissage(Color.black);
		rect.setCouleurTrait(Color.black);
	}
	
	
}
