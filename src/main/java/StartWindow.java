
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartWindow implements ActionListener {
    JFrame startFrame;
    JPanel startPanel;
    JTextField Pseudo;
    JLabel PseudoLabel, RequestLabel;
    JButton modify_pseudo;

    public StartWindow() {
        //Create and set up the window.
    	startFrame = new JFrame("Accueil");
    	startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	startFrame.setSize(new Dimension(120, 40));

        //Create and set up the panel.
    	startPanel = new JPanel(new GridLayout(2, 2));

        //Add the widgets.
        addWidgets();

        //Set the default button.
        startFrame.getRootPane().setDefaultButton(modify_pseudo);

        //Add the panel to the window.
        startFrame.getContentPane().add(startPanel, BorderLayout.CENTER);

        //Display the window.
        startFrame.pack();
        startFrame.setVisible(true);
    }

    /**
     * Create and add the widgets.
     */
    private void addWidgets() {
        //Create widgets.
    	RequestLabel= new JLabel("Modifiez votre pseudo ci-dessous:", SwingConstants.LEFT);
        Pseudo = new JTextField(20);
        PseudoLabel = new JLabel("Pseudo", SwingConstants.LEFT);
        modify_pseudo = new JButton("Modifier le pseudo");

        //Listen to events from the Convert button.
        modify_pseudo.addActionListener(this);

        //Add the widgets to the container.
        startPanel.add(RequestLabel);
        startPanel.add(Pseudo);
        startPanel.add(PseudoLabel);
        startPanel.add(modify_pseudo);
        
        //PseudoLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }

    public void actionPerformed(ActionEvent event) {
    	if (!User.PseudoValide(Pseudo)) { 
    		RequestLabel.setText("pseudo non valide");
    	} else {
    		User.setPseudo(Login, Pseudo);
    	}
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    protected static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        StartWindow w = new StartWindow();
    }

    /*public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }*/
}