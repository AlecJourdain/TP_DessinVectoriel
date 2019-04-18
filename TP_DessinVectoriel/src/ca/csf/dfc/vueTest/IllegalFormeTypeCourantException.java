/**
 * 
 */
package ca.csf.dfc.vueTest;

/**
 * @author Coralie-Hong Brière
 *
 */
public class IllegalFormeTypeCourantException extends Exception {
	
	private static final long serialVersionUID = -3592975603698264798L;

	public IllegalFormeTypeCourantException(String p_message) {
		super("Une erreur est survenue: " + p_message);
	}
}
