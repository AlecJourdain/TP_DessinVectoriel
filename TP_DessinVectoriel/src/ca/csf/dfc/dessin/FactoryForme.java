/**
 * 
 */
package ca.csf.dfc.dessin;

/**
 * @author Coralie-Hong Brière
 *
 */
public class FactoryForme {
	
	public static Forme creationForme(FormeType p_typeForme) {
		Forme forme = null;
		switch(p_typeForme) {
			case LIGNE:
				forme = new Ligne();
				break;
			case ELLIPSE:
				forme = new Ellipse();
				break;
			case RECTANGLE:
				forme = new Rectangle();
				break;
		}
		return forme;
	}
}
