import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;


public class Main extends Application {

    Scene scene1;
    public static void main(String[] args){ launch(args); }

    @Override
    public void start(Stage stage) throws IOException {


        //First Scene - Label Button1 and Button Action(Generate Random Password)
        Label labelalert = new Label("Generate Random Password");
        labelalert.setStyle("-fx-text-fill: #E8E8E8");

        //Scene1 Button
        Button buttonalert = new Button("Generate");
        buttonalert.setOnAction(e -> {
            try {
                AlertBox.display();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        //Creating a rotate transition for Button
        RotateTransition rotateTransition = new RotateTransition();
        //Setting the duration for the transition
        rotateTransition.setDuration(Duration.millis(200));
        //Setting the node for the transition
        rotateTransition.setNode(buttonalert);
        //Setting the angle of the rotation
        rotateTransition.setByAngle(15);
        //Setting the cycle count for the transition
        rotateTransition.setCycleCount(4000);
        //Setting auto reverse value to false
        rotateTransition.setAutoReverse(true);
        //Playing the animation
        rotateTransition.play();




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
