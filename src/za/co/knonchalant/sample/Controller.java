package za.co.knonchalant.sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import za.co.knonchalant.builder.JavaFXComponent;
import za.co.knonchalant.builder.TaggedParameters;
import za.co.knonchalant.sample.pojo.SampleClass;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private GridPane mainPane;

    public void setup(Window window) {
    TaggedParameters taggedParameters = new TaggedParameters();
    List<String> range = new ArrayList<>();
    range.add("Ay");
    range.add("Bee");
    range.add("See");
    taggedParameters.addTag("range", range);
    Pane build = JavaFXComponent.build(new SampleClass(), taggedParameters, window);

    Button button = new Button("Read in");
    button.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            SampleClass sample = JavaFXComponent.read(mainPane, SampleClass.class);
            System.out.println(sample.getTextString());
        }
    });

    mainPane.getChildren().addAll(build, button);
    }
}
