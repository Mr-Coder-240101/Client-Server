package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ClientController {

    @FXML
    TextField textField;
    @FXML
    Label label;

    @FXML
    public void connectAndCalculate(ActionEvent event) {
        try {
            try (Socket socket = new Socket("localhost", 9999)) {
                double radius = Double.valueOf(textField.getText());
                
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                printWriter.println(radius);
                
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                double area = Double.valueOf(bufferedReader.readLine());
                
                DecimalFormat df = new DecimalFormat();
                String areaStr = df.format(area);
                
                label.setText(areaStr);
            }

        } catch (IOException e) {
            System.out.println("Some Error is Occured In Client .....");
        }
    }

}
