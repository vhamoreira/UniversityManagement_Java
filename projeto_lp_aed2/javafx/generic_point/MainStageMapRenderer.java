package projeto_lp_aed2.javafx.generic_point;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainStageMapRenderer extends Application {

    private static final float FLOOR_HEIGHT = 75.0f;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("map_points_layout.fxml"));
        Parent root = loader.load();
        MapRendererFXMLController<Point3D> controller = loader.getController();


        /*

        0 /20 - entrada
        1 - hall 1
        2 - hall 2
        3 - hall 3
        4/5 - wc1 / wc2
        6/7/8/9 - 101, 102, 103, 104
        10/11/12/13 - 201, 202, 203, 204
        14/15/16/17 - 301, 302, 303, 304
        18/19 - escada 1/2

         */
        // PISO 0
        controller.getMap().addPoint(new Entrada(25.0f, FLOOR_HEIGHT * 1.5f, 0, "Entrada Principal", 0));
        controller.getMap().addPoint(new Corredor(250.0f, FLOOR_HEIGHT * 1.5f, 0, "Hall 0",1));
        controller.getMap().addPoint(new Escada(400.0f, FLOOR_HEIGHT * 1.5f, 0, "Escada 0",18));
        controller.getMap().addPoint(new WC(150.0f, FLOOR_HEIGHT * 1, 0, "WC 0.1f", "F", 4));

        controller.getMap().addPoint(new SalaCoordenadas(200.0f, FLOOR_HEIGHT * 1, 0, "Sala 0.1", 6));
        controller.getMap().addPoint(new SalaCoordenadas(250.0f, FLOOR_HEIGHT * 1, 0, "Sala 0.2", 7));
        controller.getMap().addPoint(new SalaCoordenadas(300.0f, FLOOR_HEIGHT * 1, 0, "Sala 0.3", 8));
        controller.getMap().addPoint(new SalaCoordenadas(350.0f, FLOOR_HEIGHT * 1, 0, "Sala 0.4", 9));
        // PISO 1
        controller.getMap().addPoint(new Escada(400.0f, FLOOR_HEIGHT * 2.5f, 1, "Escada 0",18));
        controller.getMap().addPoint(new Corredor(250.0f, FLOOR_HEIGHT * 2.5f, 1, "Hall 1",2));
        controller.getMap().addPoint(new Escada(25.0f, FLOOR_HEIGHT * 2.5f, 1, "Escada 1",19));
        controller.getMap().addPoint(new WC(150.0f, FLOOR_HEIGHT * 2, 1, "WC 1.1f", "M", 5));

        controller.getMap().addPoint(new SalaCoordenadas(200.0f, FLOOR_HEIGHT * 2, 1, "Sala 1.1", 10));
        controller.getMap().addPoint(new SalaCoordenadas(250.0f, FLOOR_HEIGHT * 2, 1, "Sala 1.2", 11));
        controller.getMap().addPoint(new SalaCoordenadas(300.0f, FLOOR_HEIGHT * 2, 1, "Sala 1.3", 12));
        controller.getMap().addPoint(new SalaCoordenadas(350.0f, FLOOR_HEIGHT * 2, 1, "Sala 1.4", 13));

        // PISO 2
        controller.getMap().addPoint(new Escada(25.0f, FLOOR_HEIGHT * 3.5f, 2, "Escada 1",19));
        controller.getMap().addPoint(new Corredor(250.0f, FLOOR_HEIGHT * 3.5f, 2, "Hall 3",3));
        controller.getMap().addPoint(new Entrada(400.0f, FLOOR_HEIGHT * 3.5f, 2, "saida Secundaria", 20));

        controller.getMap().addPoint(new SalaCoordenadas(200.0f, FLOOR_HEIGHT * 3, 2, "Sala 2.1", 14));
        controller.getMap().addPoint(new SalaCoordenadas(250.0f, FLOOR_HEIGHT * 3, 2, "Sala 2.2", 15));
        controller.getMap().addPoint(new SalaCoordenadas(300.0f, FLOOR_HEIGHT * 3, 2, "Sala 2.3", 16));
        controller.getMap().addPoint(new SalaCoordenadas(350.0f, FLOOR_HEIGHT * 3, 2, "Sala 2.4", 17));

        controller.updateFloorComboBox();
        controller.updateGraphGroup(controller.getMap().getPoints());

        Scene scene = new Scene(root);
        primaryStage.setTitle("MapGeneric - Points");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
