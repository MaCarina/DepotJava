import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
 
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
     
    // Add a public no-args constructor
    public FxFXMLController() 
    {
    }
     
    @FXML
    private void initialize() 
    {
    }
     
    @FXML
    private void handler() 
    {
        //outputText.setText(inputText.getText());
    }
	
    // à quoi sert cette fonction
    @FXML
    private void switchToStart() throws IOException {
        App.setRoot("Authentification");
    }
}
