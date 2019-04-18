package ca.csf.dfc.vueTest;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import ca.csf.dfc.JustOneEnum.TypeAction;
import ca.csf.dfc.dessin.FactoryForme;
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
	@Test
	void testSetFormeTypeCourant_Nominal() {
		// Arrange
		String formeTypeCourantRectangle = "R";
		String formeTypeCourantLigne = "L";
		String formeTypeCourantEllipse = "E";
		String formeTypeCourantAttendre = "X";
		// Act et Assert
		try {
			canevas.setFormeTypeCourant(formeTypeCourantRectangle);
		} catch (IllegalFormeTypeCourantException e) {
			
			e.printStackTrace();
		}
		assertEquals(formeTypeCourantRectangle, canevas.getFormeTypeCourant());
		
		try {
			canevas.setFormeTypeCourant(formeTypeCourantLigne);
		} catch (IllegalFormeTypeCourantException e) {
			
			e.printStackTrace();
		}
		assertEquals(formeTypeCourantLigne, canevas.getFormeTypeCourant());
		
		try {
			canevas.setFormeTypeCourant(formeTypeCourantEllipse);
		} catch (IllegalFormeTypeCourantException e) {
			
			e.printStackTrace();
		}
		assertEquals(formeTypeCourantEllipse, canevas.getFormeTypeCourant());
		
		try {
			canevas.setFormeTypeCourant(formeTypeCourantAttendre);
		} catch (IllegalFormeTypeCourantException e) {
			
			e.printStackTrace();
		}
		assertEquals(formeTypeCourantAttendre, canevas.getFormeTypeCourant());
	}
	
	@Test
	void testSetFormeTypeCourant_Exception() {
		
		assertThrows(IllegalFormeTypeCourantException.class,
				() -> {String formeTypeCourantErreur = "W";
						canevas.setFormeTypeCourant(formeTypeCourantErreur);},
				"");
	}

	@Test
	void testSetTypeActionPerformee_NOMINAL() {
		// Arrange
		canevas.setTypeActionPerformee(TypeAction.ATTENDRE);
		// Act et Assert
		assertEquals(TypeAction.ATTENDRE, canevas.getTypeActionPerformee());
	}

	@Test
	void testSetFormeSelectionnee_NOMINAL() {
		// Arrange
		Forme petiteForme = FactoryForme.creationForme("L");
		canevas.setFormeSelectionnee(petiteForme);
		// Act et Assert
		assertEquals(petiteForme, canevas.getFormeSelectionnee());
		
	}

	@Test
	void testSetDimensionEspaceTravailIntInt_nominal() {
		canevas.setDimensionEspaceTravail(300, 150);
		assertEquals(new Dimension(300, 150), canevas.getDimensionEspaceTravail());
	}

	@Test
	void testSetDimensionEspaceTravailDimension() {
		canevas.setDimensionEspaceTravail(new Dimension(300, 150));
		assertEquals(new Dimension(300, 150), canevas.getDimensionEspaceTravail());
	}

	

	@Test
	void testSetCouleurRemplisageForm() {
		canevas.setCouleurRemplisageForm(Color.cyan);
		assertEquals(Color.cyan, canevas.getCouleurRemplisageForm());
	}

	@Test
	void testSetCouleurTraitForm() {
		canevas.setCouleurTraitForm(Color.green);
		assertEquals(Color.green, canevas.getCouleurTraitForm());
	}

	@Test
	void testSetEpaisseurTraitForm() {
		canevas.setEpaisseurTraitForm(2);
		assertEquals(2, canevas.getEpaisseurTraitForm());
	}

	

	@Test
	void testSetFormes() {
		// Arrange
		ArrayList<Forme> petiteListe = new ArrayList<Forme>();
		petiteListe.add(FactoryForme.creationForme("L"));
		petiteListe.add(FactoryForme.creationForme("R"));
		petiteListe.add(FactoryForme.creationForme("E"));
		// Act
		canevas.setFormes(petiteListe);
		// Assert
		assertEquals(petiteListe.get(0), canevas.getFormes().get(0));
		assertEquals(petiteListe.get(1), canevas.getFormes().get(1));
		assertEquals(petiteListe.get(2), canevas.getFormes().get(2));
		
		assertEquals(3, canevas.getFormes().size());
	}//*/

}
