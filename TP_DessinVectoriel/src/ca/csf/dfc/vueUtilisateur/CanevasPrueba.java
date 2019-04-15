package ca.csf.dfc.vueUtilisateur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

import ca.csf.dfc.dessin.Forme;
import ca.csf.dfc.dessin.FormeType;

public class CanevasPrueba extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Color m_couleurTrait = Color.black;
	private Color m_couleurRemplissage = Color.black;
	private int m_epaisseurTrait = 2;
	private FormeType m_formeTypeCourant = FormeType.RECTANGLE;
	private boolean m_estModifie = false;
	ArrayList<Forme> m_formes = new ArrayList<Forme>();
	Point premierPoint, pointFinal;
	
	/**
	 * Ctor
	 */
	public CanevasPrueba() {
		this.setBorder(	BorderFactory.createLineBorder(Color.black,2));		
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(1000,800));
		
	}
}
