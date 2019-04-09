package ca.csf.dfc.fonctions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;





public abstract class MasterListener implements ActionListener, MouseListener {
	
		Fonctionnalite fonctions = new Fonctionnalite();
		
	
		public void actionPerformed(ActionEvent p_event) {
			AbstractButton abstractBtn = (AbstractButton) p_event.getSource();
			System.out.println(abstractBtn.getModel());
//			switch (abstractBtn.getLabel()) {
//			case 
//			}
		}
		
		
		
		
		
	
		


}
