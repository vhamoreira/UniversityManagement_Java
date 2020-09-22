package projeto_lp_aed2.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainUni extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("uni.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Universidade");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
