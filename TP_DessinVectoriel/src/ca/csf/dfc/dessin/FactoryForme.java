/**
 * 
 */
package ca.csf.dfc.dessin;

/**
 * @author Coralie-Hong Brière
 *
		 */
public class FactoryForme {

	public static Forme creationForme(String p_typeForme) {
		if(!(p_typeForme == "R" || p_typeForme == "E" || p_typeForme == "L" )) {
			throw new IllegalArgumentException("Forme non conforme");
		}
		Forme forme = null;
		switch(p_typeForme) {
			case "L":
				forme = new Ligne();
				break;
			case "E":
				forme = new Ellipse();
				break;
			case "R":
				forme = new Rectangle();
				break;
		}
		return forme;
	}
}
