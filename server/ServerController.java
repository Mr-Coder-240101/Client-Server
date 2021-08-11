package server;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ServerController {

    @FXML
    Label myLabel;

    @FXML
    public void refresh(MouseEvent event) {
        String labelString = MyServer.getLabelString();
        myLabel.setText(labelString);
    }

}
