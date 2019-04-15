package ca.csf.dfc.vueUtilisateur;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class EpaisseurTrait extends JFrame{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	Canevas m_Canevas;
	private int m_epaisseur;

	public EpaisseurTrait(Canevas p_Canevas){
		
		//parametre du fenetre
		this.m_Canevas = p_Canevas;
		this.m_epaisseur = m_Canevas.getEpaisseurTraitForm();
	    this.setSize(250,220);
	    this.setUndecorated(true);//effacer le bord
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLayout(new GridLayout(4, 1));
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);

	    //Label pour donner l'epaisseur
	    JLabel statusLabel = new JLabel("Valeur: " + m_epaisseur,JLabel.CENTER);    
	    statusLabel.setSize(350,100);
	    
	    //Panel pour le slider
	    JPanel controlPanel = new JPanel();
	    controlPanel.setLayout(new FlowLayout());
	    JSlider slider = new JSlider(JSlider.HORIZONTAL,0,20,1);
	    slider.setSnapToTicks(true);	   
	    slider.setMinorTickSpacing(1);  
	    slider.setMajorTickSpacing(5); 
	    slider.setPaintTicks(true);  
	    slider.setPaintLabels(true); 
	    controlPanel.add(slider);
	    slider.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	        	 m_epaisseur = ((JSlider) e.getSource()).getValue();
	            statusLabel.setText("Valeur: " + m_epaisseur);
	            
	         }
	     });
	    
	    //bouton pour set eppaisseur trait	    
	    JButton btn_ok = new JButton("Ok");
	    btn_ok.setLayout(new FlowLayout());
	    btn_ok.setSize(new Dimension(50,50));
	    btn_ok.addActionListener(e -> {
	    	m_Canevas.setEpaisseurTraitForm(m_epaisseur);
	    	
	    	this.setVisible (false);
	    	this.dispose ();
	    });	
	    JPanel pannelBouton = new JPanel();		
		pannelBouton.add(btn_ok,BorderLayout.CENTER);

	    //addition
	    this.add(new JLabel("Epaisseur Trait de Forms",JLabel.CENTER));
	    this.add(controlPanel);//*/
	    this.add(statusLabel);	    
	    this.add(pannelBouton,BorderLayout.CENTER);
	} 	 
}