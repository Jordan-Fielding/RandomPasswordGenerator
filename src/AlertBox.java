
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
import java.net.*;
import java.io.*;



public class AlertBox {

    public static void display() throws IOException {

        String title = "Password Generator";

//        Random Word Generator
        URL url = new URL("https://raw.githubusercontent.com/Jordan-Fielding/RandomPasswordGenerator/7bb9b0b5a83c3e63e314dc06caded1f42a47d91f/src/Dictionary.txt?token=GHSAT0AAAAAABVY4H5U73MV5TR64NM4WIRGYVP2ZVA");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
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
        label.setStyle("-fx-text-fill: #E8E8E8");
            label.setText(RandomPassword);


        VBox layout = new VBox(10);
            layout.getChildren().addAll(label);
            layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("Theme.css");
            window.setScene(scene);
            window.showAndWait();



    }
}
