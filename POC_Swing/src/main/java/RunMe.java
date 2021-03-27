import javax.swing.SwingUtilities;

public class RunMe {

	public static void main(String[] args) {
				
		// Swing utilise son propre thread de traitement, qu'on appelle l'EDT (Event Dispatch Thread)
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
			    // On crée une nouvelle instance de notre JWindow
			    /* JWindow window = new JWindow();  
				window.setSize(300, 200); //On lui donne une taille pour qu'on puisse la voir
				window.setVisible(true); //On la rend visible */
				
				//On crée une nouvelle instance de notre JDialog
				/* JDialog dialog = new JDialog();
				dialog.setSize(300, 200); //On lui donne une taille
				dialog.setTitle("Première fenêtre"); //On lui donne un titre
				dialog.setVisible(true); //On la rend visible
				dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer */
				
				//On crée une nouvelle instance de notre JDialog
				@SuppressWarnings("unused")
				SimpleFenetre fenetre = new SimpleFenetre();
				
			}
		});
		
	}

}
