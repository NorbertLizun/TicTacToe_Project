package com.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuScene extends VBox {


    private final Button pvpButton = new Button("Player vs Player");
    private final Button pvbButton = new Button("Player vs Bot");
    private final Button exitButton = new Button("EXIT");
    private final Label title = new Label("Tic Tac Toe");
    private boolean playerVsPlayer;

    public boolean isPlayerVsPlayer() {
        return playerVsPlayer;
    }



    public MenuScene() {

        setLayout();
        this.getChildren().addAll(title, pvpButton, pvbButton, exitButton);
    }

    public void goToPvPScene(Stage stage, Scene scene) {

        pvpButton.setOnAction(event -> {
            playerVsPlayer = true;
            stage.setScene(scene);
        });
    }

    public void goToPvBScene(Stage stage, Scene scene) {

        pvbButton.setOnAction(event -> {
            playerVsPlayer = false;
            stage.setScene(scene);
        });
    }

    public void exit(Stage stage) {

        exitButton.setOnAction(event -> {
            stage.close();
        });
    }

    public void setLayout() {

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(150));
        this.setSpacing(5);

        pvpButton.setMinWidth(170);
        pvbButton.setMinWidth(170);
        exitButton.setMinWidth(170);


        title.setFont(new Font(21));







    }


}
