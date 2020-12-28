package com.kodilla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private final PlayableArea playableArea = new PlayableArea();
    private final ButtonsArea buttonsArea = new ButtonsArea();
    private final GridPane gridPane = new GridPane();
    private final ScoreArea scoreArea = new ScoreArea();



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {



        gridPane.add(playableArea, 1,2);
        gridPane.add(buttonsArea, 0,2);
        gridPane.add(scoreArea, 1,3);
        gridPane.setGridLinesVisible(true);

        buttonsArea.reset(gridPane);




        Scene scene = new Scene(gridPane, 700,700, Color.AQUA);

        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
