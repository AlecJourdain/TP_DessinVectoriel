package ca.csf.dfc.vueTest;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.JustOneEnum.TypeAction;
import ca.csf.dfc.dessin.Forme;
import ca.csf.dfc.vueUtilisateur.Canevas;

class CanevasTest {

	Canevas canevas = new Canevas();
	
	
	@Test
	void testSetCanevasParDefaut_Nominal_valeurParDefault() {
		//Arrange

		TypeAction typeActionDefault  = TypeAction.ATTENDRE;
		String typeCourantDefault = "X";
		Forme formeSelectionneeDefault = null;
		int qteFormes = 0;
		
		//Act et assert
		assertEquals(typeActionDefault, canevas.getTypeActionPerformee());
		assertEquals(typeCourantDefault, canevas.getFormeTypeCourant());
		assertEquals(formeSelectionneeDefault, canevas.getFormeSelectionnee());
		assertEquals(qteFormes, canevas.getFormes().size());
	}
	
	@Test
	void testSetEspaceTravailParDefaut() {
		//Arrange		
		int largeurEspaceTravailDefault = 2000;
		int hauteurEspaceTravailDefault = 2000;		
		Dimension dimensionEspaceTravailDefault =  new Dimension(
				largeurEspaceTravailDefault,hauteurEspaceTravailDefault);				
		//Act et assert
		assertEquals(dimensionEspaceTravailDefault, canevas.getSize());
		assertEquals(dimensionEspaceTravailDefault, canevas.getPreferredSize());			
			
	}
	/*@Test
	void testSetFormeTypeCourant() {
		fail("Not yet implemented");
	}

	@Test
	void testSetTypeActionPerformee() {
		fail("Not yet implemented");
	}

	@Test
	void testSetFormeSelectionnee() {
		fail("Not yet implemented");
	}

	@Test
	void testSetDimensionEspaceTravailIntInt() {
		fail("Not yet implemented");
	}

	@Test
	void testSetDimensionEspaceTravailDimension() {
		fail("Not yet implemented");
	}

	

	@Test
	void testSetCouleurRemplisageForm() {
		fail("Not yet implemented");
	}

	@Test
	void testSetCouleurTraitForm() {
		fail("Not yet implemented");
	}

	@Test
	void testSetEpaisseurTraitForm() {
		fail("Not yet implemented");
	}

	@Test
	void testSetCanevasParDefaut() {
		fail("Not yet implemented");
	}

	@Test
	void testSetFormes() {
		fail("Not yet implemented");
	}//*/

}
