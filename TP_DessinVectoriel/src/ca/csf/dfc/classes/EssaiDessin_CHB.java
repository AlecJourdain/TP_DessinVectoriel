/**
 * 
 */
package ca.csf.dfc.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Coralie-Hong Brière
 * 
 * Petite classe d'essai...Exercice de dessin tiré d'un livre de la bibliothèque...
 * Pour tracer des lignes, changer de couleur et effacer
 *
 */
class MaFenetre extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 4574237076520078220L;

	/**
	 * pour stocker les différentes couleurs qui seront disponibles pour l'utilisateur
	 */
	public static Color[] couleurs = {Color.yellow, Color.red, Color.blue, Color.green, Color.black, Color.cyan };
	
	private Panneau pan;
	private JButton btn_NouveauDessin, btn_EffacerDessin, btn_Couleur;
	private int numCoul = 0;
	
	/**
	 * Ctor par défaut
	 */
	public MaFenetre() {
		setTitle("Planche à dessin");
		setSize(400, 180);
		Container contenu = getContentPane();
		
		pan = new Panneau();
		pan.addMouseListener(pan);
		contenu.add(pan);
		
		btn_NouveauDessin = new JButton("Tracer");
		contenu.add(btn_NouveauDessin, "North");
		btn_NouveauDessin.addActionListener(this);
		
		btn_EffacerDessin = new JButton("Effacer");
		contenu.add(btn_EffacerDessin, "South");
		btn_EffacerDessin.addActionListener(this);
		
		btn_Couleur = new JButton("");
		contenu.add(btn_Couleur, "West");
		btn_Couleur.addActionListener(this);
		btn_Couleur.setBackground(couleurs[numCoul]);
		pan.setCouleur(couleurs[numCoul]);
	}

	@Override
	public void actionPerformed(ActionEvent p_e) {
		if (p_e.getSource() == btn_Couleur) {
			numCoul++;
			if (numCoul >= couleurs.length) numCoul = 0;
			btn_Couleur.addActionListener(this);
			btn_Couleur.setBackground(couleurs[numCoul]);
			pan.setCouleur(couleurs[numCoul]);
		}
		
		if (p_e.getSource() == btn_NouveauDessin) {
			pan.nouvelleLigne();
		}
		
		if (p_e.getSource() == btn_EffacerDessin) {
			pan.efface();
		}
		
	}
}

class Panneau extends JPanel implements MouseListener {
	
	private static final long serialVersionUID = -5399799654891535775L;
	private boolean enCours = false;
	private Color couleur;
	private int xDebut, yDebut, xFin, yFin;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		enCours = false;
	}
	
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	public void nouvelleLigne() {
		enCours = false;
	}
	
	public void efface() {
		repaint();
	}
	
	public void mouseClicked (MouseEvent e) {
		int xFin = e.getX(); yFin = e.getY();
		if (enCours) {
			Graphics g = getGraphics();
			g.setColor(couleur);
			g.drawLine(xDebut, yDebut, xFin, yFin);
			g.dispose();
		}
		xDebut = xFin;
		yDebut = yFin;
		enCours = true;
	}

	@Override
	public void mouseEntered(MouseEvent p_e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent p_e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent p_e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent p_e) {
		// TODO Auto-generated method stub
		
	}
}

public class EssaiDessin_CHB {
	public static void main (String args[]) {
		MaFenetre fenetreEssai = new MaFenetre();
		fenetreEssai.setVisible(true);
	}
	
}
