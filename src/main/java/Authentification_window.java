import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Authentification_window implements ActionListener {
    JFrame connexionFrame;
    JPanel connexionPanel;
    JTextField Login;
    JTextField Password;
    JTextField Pseudo;
    JLabel LoginLabel, PasswordLabel, PseudoLabel, RequestLabel;
    JButton connexion;

    public Authentification_window() {
        //Create and set up the window.
    	connexionFrame = new JFrame("Connexion");
    	connexionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	connexionFrame.setSize(new Dimension(120, 40));

        //Create and set up the panel.
    	connexionPanel = new JPanel(new GridLayout(2, 2));

        //Add the widgets.
        addWidgets();

        //Set the default button.
        connexionFrame.getRootPane().setDefaultButton(connexion);

        //Add the panel to the window.
        connexionFrame.getContentPane().add(connexionPanel, BorderLayout.CENTER);

        //Display the window.
        connexionFrame.setVisible(true);
    }

    /**
     * Create and add the widgets.
     */
    private void addWidgets() {
        //Create widgets.
    	RequestLabel= new JLabel("Entrez vos informations ci-dessous:", SwingConstants.LEFT);
        Login = new JTextField(20);
        LoginLabel = new JLabel("Login", SwingConstants.LEFT);
        Password = new JTextField(20);
        PasswordLabel = new JLabel("Password", SwingConstants.LEFT);
        Pseudo = new JTextField(20);
        PseudoLabel = new JLabel("Pseudo", SwingConstants.LEFT);
        connexion = new JButton("Connexion");

        //Listen to events from the Convert button.
        connexion.addActionListener(this);

        //Add the widgets to the container.
        connexionPanel.add(RequestLabel);
        connexionPanel.add(Login);
        connexionPanel.add(Password);
        connexionPanel.add(Pseudo);
        connexionPanel.add(LoginLabel);
        connexionPanel.add(PasswordLabel);
        connexionPanel.add(PseudoLabel);
        connexionPanel.add(connexion);
        
        // LoginLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        // PasswordLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        // PseudoLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }

    public void actionPerformed(ActionEvent event) {
        // pseudo_valide
    	if (!User.PseudoValide(Pseudo)) { 
    		RequestLabel.setText("pseudo non valide");
    	} else if (!User.UserExist(Login)) {
    		User.CreateUser(Login, Password,Pseudo);
    	} else if (User.UserExist(Login) && (!User.VerifPassword(Password))) {
    		RequestLabel.setText("mot de passe erroné");
    	} else {
    		User.setPseudo(Login, Pseudo);
    		StartWindow.createAndShowGUI();		
    	}
    	// user_exits
    	// Password_ok
        PseudoLabel.setText("pseudo valide");
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        Authentification_window AuthWindow = new Authentification_window();
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}