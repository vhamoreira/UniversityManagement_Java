package projeto_lp_aed2.javafx.generic_point;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class MapRendererFXMLController<T extends Point3D> {
    private MapGeneric<T> map = new MapGeneric<T>();
    private static final int radius = 12;
    public ComboBox<String> floorComboBox;
    public Pane graphGroup;


    public MapGeneric<T> getMap() {
        return map;
    }

@FXML
    public void initialize(){
        updateFloorComboBox();
    }

    public void updateFloorComboBox(){
        floorComboBox.getItems().clear();
        floorComboBox.getItems().add("ALL");
        for(Integer floor : map.getDistinctExistingFloors()){
            floorComboBox.getItems().add("" + floor);
        }
    }

    public void updateGraphGroup(ArrayList<T> points) {
        graphGroup.getChildren().clear();
        for (Point3D p : points) {
            Circle c = new Circle(p.getX(), p.getY(), radius);
            c.setFill(Color.GREEN);
            Text text = new Text(p.getName());// + p.getId());
            StackPane stackPane = new StackPane();
            stackPane.setLayoutX(p.getX() - radius);
            stackPane.setLayoutY(p.getY() - radius);
            // Dispor os elementos de trás para a frente
            stackPane.getChildren().addAll(c, text);
            graphGroup.getChildren().add(stackPane);
        }
    }



    public void handleFloorChoiceAction(ActionEvent actionEvent) {
        if(floorComboBox.getValue().compareTo("All") == 0)
            updateGraphGroup(this.map.getPoints());
        else
            updateGraphGroup(this.map.getPointsByFloor(Integer.parseInt(floorComboBox.getValue())));
    }

}
