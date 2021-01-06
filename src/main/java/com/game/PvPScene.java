package com.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PvPScene extends VBox  {

    private final VBox vBox = new VBox();
    private final HBox hBox = new HBox();
    private final Label p1Nick = new Label("P1 nickname:");
    private final Label p2Nick = new Label("P2 nickname:");
    private final TextField p1TextField = new TextField();
    private final TextField p2TextField = new TextField();
    private final Button backButton = new Button("Back");
    private final Button playButton = new Button("PLAY");

    public PvPScene() {

        this.getChildren().addAll(vBox(), hBox());
        setLayout();
    }

    public VBox vBox() {

        vBox.getChildren().addAll(p1Nick,p1TextField, p2Nick,p2TextField);
        return vBox;
    }

    public HBox hBox() {

        hBox.getChildren().addAll(backButton, playButton);
        return hBox;
    }

    public void setLayout() {

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(150));

        p1TextField.setMaxWidth(200);
        p2TextField.setMaxWidth(200);

        vBox.setSpacing(5);

        hBox.setSpacing(20);
        hBox.setPadding(new Insets(10));


    }

    public void goToBoardScene(Stage stage, Scene scene, Board board) {

        playButton.setOnAction(event -> {
            stage.setScene(scene);
            board.setPlayerName(p1TextField.getText());
            board.setPlayer2Name(p2TextField.getText());
        });
    }

    public void backToMenu(Stage stage, Scene scene) {

        backButton.setOnAction(event -> {
            stage.setScene(scene);
        });
    }



}
