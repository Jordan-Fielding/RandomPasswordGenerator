import javafx.application.Application;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.util.Random;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    Scene scene1;
    public static void main(String[] args){ launch(args); }

    @Override
    public void start(Stage stage) throws IOException {


        //First Scene - Label Button1 and Button Action(Generate Random Password)
        Label labelalert = new Label("Generate Random Password");
        labelalert.setStyle("-fx-text-fill: #E8E8E8");
        Button buttonalert = new Button("Generate");


        buttonalert.setOnAction(e -> {
            try {
                AlertBox.display();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        //Scene 1 VBox
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(labelalert, buttonalert);

        scene1 = new Scene(layout1, 500, 500);
        scene1.getStylesheets().add("Theme.css");
        layout1.setAlignment(Pos.CENTER);

        //Set Stage
        stage.setScene(scene1);
        stage.setTitle("Program");
        stage.show();

    }

}
