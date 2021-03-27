import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleFenetre extends JFrame{
	
	private static final long serialVersionUID = -7265519229087354267L;

	private JPanel pan = new JPanel();
		
	private JButton bouton = new JButton("Go");

	private JButton bouton2 = new JButton("Stop");
	  
	public SimpleFenetre(){
		super();
		setTitle("Ma première fenêtre"); // On donne un titre à l'application
		setSize(320,240); // On donne une taille à notre fenêtre
		setLocationRelativeTo(null); // On centre la fenêtre sur l'écran
		setResizable(false); // On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // On dit à l'application de se fermer lors du clic sur la croix    

	    pan.add(bouton); //Ajout du bouton à notre content pan
		pan.add(bouton2);
		
		bouton.addActionListener(new BoutonListener()); 
		
		bouton2.addActionListener(new Bouton2Listener());
		    
		bouton2.setEnabled(false);
		 
	    this.setContentPane(pan); // On prévient notre JFrame que notre JPanel sera son content pane               

		 //On définit le layout à utiliser sur le content pane
	    // this.setLayout(new BorderLayout());
	    
	    //On ajoute le bouton au content pane de la JFrame
	    //Au centre
	/*    this.getContentPane().add(new JButton("CENTER"), BorderLayout.CENTER);
	    //Au nord
	    this.getContentPane().add(new JButton("NORTH"), BorderLayout.NORTH);
	    //Au sud
	    this.getContentPane().add(new JButton("SOUTH"), BorderLayout.SOUTH);
	    //À l'ouest
	    this.getContentPane().add(new JButton("WEST"), BorderLayout.WEST);
	    //À l'est
	    this.getContentPane().add(new JButton("EAST"), BorderLayout.EAST);
	  */
		
	    this.setVisible(true);
	}
	
	class BoutonListener implements ActionListener{
		    public void actionPerformed(ActionEvent arg0) {
		      bouton.setEnabled(false);
		      bouton2.setEnabled(true);
		    }
	 }

		  class Bouton2Listener implements ActionListener{
		     public void actionPerformed(ActionEvent arg0) {
		      bouton.setEnabled(true);
		      bouton2.setEnabled(false);
		    }
		  }     
}
