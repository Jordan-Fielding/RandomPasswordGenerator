
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.geometry.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AlertBox {

    public static void display() throws IOException {

        String title = "Password Generator";

//        Random Word Generator
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Jordan.F\\Documents\\JavaProjects\\Random Password Generator\\src\\Dictionary.txt"));
        List<String> lines = new ArrayList<String>();

        String line = reader.readLine();

        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }
        Random r = new Random();
        String randomString = lines.get(r.nextInt(lines.size()));

        Random t = new Random();
        String randomline = lines.get(t.nextInt(lines.size()));

        //Random Number Generator
        int min = 1000;
        int max = 10000;
        int b = (int) (Math.random() * (max - min + 1) + min);


        String RandomPassword = (randomString + randomline + b);

        Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(title);
            window.setMinWidth(250);

        Label label = new Label();
            label.setText(RandomPassword);


        VBox layout = new VBox(10);
            layout.getChildren().addAll(label);
            layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
            window.setScene(scene);
            window.showAndWait();



    }
}
