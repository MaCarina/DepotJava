import java.io.IOException;
import javafx.fxml.FXML;

public class Authentification_controller {

    @FXML
    private void switchToStart() throws IOException {
        App.setRoot("Authentification");
    }
}
