package Test.Test;

import java.io.IOException;
import javafx.fxml.FXML;

public class Start_contoller {

    @FXML
    private void switchToAuthentification() throws IOException {
        App.setRoot("Start");
    }
}