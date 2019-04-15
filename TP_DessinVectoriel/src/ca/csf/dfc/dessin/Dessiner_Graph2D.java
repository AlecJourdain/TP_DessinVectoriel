package ca.csf.dfc.dessin;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;

import ca.csf.dfc.vueUtilisateur.Canevas;

public class Dessiner_Graph2D implements IDessiner{
	
	Graphics2D m_graphics = null;
	
	Shape m_formeCourante = null;
	
	
	public Dessiner_Graph2D(Graphics p_graph) {
		Graphics2D titGraph = (Graphics2D)p_graph;
		this.m_graphics = titGraph;

		
	}



	@Override
	public void dessinerRectangle(int p_x1, int p_y1, int p_x2, int p_y2, 
			Color p_couleurRemplissage, Color p_couleurTrait, int p_epaisseurTrait) {
		this.m_graphics.setPaint(p_couleurTrait);
		this.m_graphics.setStroke(new BasicStroke(p_epaisseurTrait));
		int x = Math.min(p_x1, p_x2);
		int y = Math.min(p_y1, p_y2);
		int largeur = Math.abs(p_x1-p_x2);
		int hauteur = Math.abs(p_y1-p_y2);
		this.m_formeCourante = new Rectangle2D.Float(x, y, largeur, hauteur);
		this.m_graphics.draw(m_formeCourante);
		this.m_graphics.setPaint(p_couleurRemplissage);
		this.m_graphics.fill(m_formeCourante);
		
		
	}


	@Override
	public void dessinerEllipse(int p_x1, int p_y1, int p_x2, int p_y2,
			Color p_couleurRemplissage, Color p_couleurTrait, int p_epaisseurTrait) {
		this.m_graphics.setPaint(p_couleurTrait);
		this.m_graphics.setStroke(new BasicStroke(p_epaisseurTrait));
		int x = Math.min(p_x1, p_x2);
		int y = Math.min(p_y1, p_y2);
		int largeur = Math.abs(p_x1-p_x2);
		int hauteur = Math.abs(p_y1-p_y2);
		this.m_formeCourante = new Ellipse2D.Float(x, y, largeur, hauteur);
		this.m_graphics.draw(m_formeCourante);
		this.m_graphics.setPaint(p_couleurRemplissage);
		this.m_graphics.fill(m_formeCourante);
		
	}


	@Override
	public void dessinerLigne(int p_x1, int p_y1, int p_x2, int p_y2,
			Color p_couleurRemplissage, Color p_couleurTrait, int p_epaisseurTrait) {
		this.m_graphics.setPaint(p_couleurTrait);
		this.m_graphics.setStroke(new BasicStroke(p_epaisseurTrait));
		this.m_formeCourante = new Line2D.Float(p_x1, p_y1, p_x2, p_y2);
		this.m_graphics.draw(m_formeCourante);
		this.m_graphics.setPaint(p_couleurRemplissage);
		this.m_graphics.fill(m_formeCourante);
		
	}
	
	


	
}
