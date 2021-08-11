package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ClientLauncher extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        Image icon = new Image("client/Client.png");
        stage.getIcons().add(icon);
        stage.setTitle("Client");
        stage.show();
    }
}
