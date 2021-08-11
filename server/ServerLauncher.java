package server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ServerLauncher extends Application {

    public static void main(String[] args) {
        MyServer server = new MyServer();
        Application.launch(args);
        server.stop();
    }

    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Server.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        Image icon = new Image("server/Server.png");
        stage.getIcons().add(icon);
        stage.setTitle("Server");
        stage.show();
    }

}
