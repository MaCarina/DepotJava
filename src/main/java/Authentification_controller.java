import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
 
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Authentification_controller {
	@FXML
    // The reference of inputText will be injected by the FXML loader
    private TextField login;
	private TextField password;
	private TextField pseudo;
     
    // The reference of outputText will be injected by the FXML loader
	// a faire après, afficher un message sur l'écran d'accueil
    //@FXML
    //private TextArea outputText;
     
    // location and resources will be automatically injected by the FXML loader 
    @FXML
    private URL location;
     
    @FXML
    private ResourceBundle resources;
    
    @FXML
    private Scene Start;
     
    // Add a public no-args constructor
    public void FxFXMLController() 
    {
    }
     
    @FXML
    private void initialize() 
    {
    }
     
    @FXML
    private void handler() throws ClassNotFoundException, SQLException 
    {
    	String pseudo1= pseudo.getText();
    	String login1= login.getText();
    	String password1= password.getText();
    	if (!User.PseudoValide(pseudo1)) {
    		// message d'erreur: pseudo non valide
    	} else {
    		if (User.UserExist(login1, password1)) {
    			if (User.VerifPassword(login1,password1)) {
    				// connexion: passage à la page suivante
    				FXMLLoader loader = new FXMLLoader(getClass().getResource("Start.fxml"));
    		        Stage stage = (Stage) btn.getScene().getWindow();
    		        Start = new Scene((Parent) loader.load());
    		        stage.setScene(Start);
    			}
    			else {
    				// message d'erreur: mot de passe erroné
    			}
    		} else {
    			// création d'un nouveau user
    		}
    	}
        //outputText.setText(inputText.getText());
    }
	
    // à quoi sert cette fonction
    @FXML
    private void switchToStart() throws IOException {
        App.setRoot("Authentification");
    }
}
