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
	
	
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private int m_epaisseur;

	public EpaisseurTrait(Canevas p_Canevas){
		//parametre du fenetre
		this.m_epaisseur = p_Canevas.getEpaisseurTraitForm();
	    this.setSize(250,200);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLayout(new GridLayout(4, 1));
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);

	    //Label pour donner l'epaisseur
	    statusLabel = new JLabel("Valeur: " + m_epaisseur,JLabel.CENTER);    
	    statusLabel.setSize(350,100);
	    
	    //Panel pour le slider
	    controlPanel = new JPanel();
	    controlPanel.setLayout(new FlowLayout());
	    JSlider slider = new JSlider(JSlider.HORIZONTAL,0,100,10);
	    controlPanel.add(slider);
	    slider.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	        	 m_epaisseur = ((JSlider) e.getSource()).getValue();
	            statusLabel.setText("Valeur: " + m_epaisseur);
	         }
	     });
	    
	    //bouton pour set eppaisseur trait
	    JButton btn_ok = new JButton("Ok");
	    btn_ok.addActionListener(e -> {
	    	p_Canevas.setEpaisseurTraitForm(m_epaisseur);
	    });	

	    //addition
	    this.add(new JLabel("Epaisseur Trait de Forms",JLabel.CENTER));
	    this.add(controlPanel);//*/
	    this.add(statusLabel);
	    this.add(btn_ok);
	      
	    
	    //showSliderDemo();
	}
   
	/* private void parametrer(){  
      
      
      this.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });  
      
      
              
      
   } 
   private void showSliderDemo(){
      
      JSlider slider = new JSlider(JSlider.HORIZONTAL,0,100,10);
      
      slider.addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent e) {
            statusLabel.setText("Valeur: " + ((JSlider)e.getSource()).getValue());
         }
      });
      controlPanel.add(slider);      
      mainFrame.setVisible(true);     
   } //*/ 
}