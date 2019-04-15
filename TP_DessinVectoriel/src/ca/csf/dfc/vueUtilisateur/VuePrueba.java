package ca.csf.dfc.vueUtilisateur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class VuePrueba extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public VuePrueba() {
		this.setTitle("Dessin Vectoriel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1024, 768));
		this.setLocationRelativeTo(null);
		//this.setLayout(new BorderLayout());
		//this.setVisible(true);	
		//CanevasPrueba m_canevas = new CanevasPrueba();
		//m_canevas.setBackground(Color.BLUE);
		//add(m_canevas, BorderLayout.CENTER);
		JPanel m_panel_Centre = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		//JPanel m_panel_Centre = new JPanel();	
		m_panel_Centre.setOpaque(true);
		m_panel_Centre.setBackground(Color.gray);		
		m_panel_Centre.setBorder(BorderFactory.createTitledBorder("Espace de Travail"));
		
		//creation canevas
		CanevasPrueba m_canevas = new CanevasPrueba();
		//this.m_canevas.setBackground(Color.white);
		m_panel_Centre.add(m_canevas, BorderLayout.CENTER);		
			
		//creation scrollpanel
		JScrollPane jScrollPaneCentre = new JScrollPane();		
		jScrollPaneCentre.setViewportView(m_panel_Centre);
		
		jScrollPaneCentre.setVerticalScrollBar(new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 300));
		jScrollPaneCentre.setHorizontalScrollBar(new JScrollBar(JScrollBar.HORIZONTAL, 30, 40, 0, 300));
		jScrollPaneCentre.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPaneCentre.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		//Add scroll au JFrame
		this.add(jScrollPaneCentre);//*/
	}
	
	

}
