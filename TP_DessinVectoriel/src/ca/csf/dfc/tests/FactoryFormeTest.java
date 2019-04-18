package ca.csf.dfc.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.dessin.FactoryForme;

class FactoryFormeTest {

	@Test
	void creationRectable() {
		FactoryForme factory = new FactoryForme();
		assertEquals("R", factory.creationForme("R").getType());
	}
	
	@Test
	void creationLigne() {
		FactoryForme factory = new FactoryForme();
		assertEquals("L", factory.creationForme("L").getType());
	}

	@Test
	void creationEllipse() {
		FactoryForme factory = new FactoryForme();
		assertEquals("E", factory.creationForme("E").getType());
	}


}
