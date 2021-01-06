package com.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PvBScene extends VBox {

    private final VBox vBox = new VBox();
    private final HBox hBox = new HBox();
    private final HBox hBox2 = new HBox();

    private final Label p1Nick = new Label("Your nickname:");
    private final TextField playerTextField = new TextField();
    private final Label difficultyLevel = new Label("Difficulty Level");
    private final ChoiceBox<String> difficultyLevelList = new ChoiceBox<>();
    private final Button backButton = new Button("Back");
    private final Button playButton = new Button("PLAY");

    public PvBScene() {

        this.getChildren().addAll(vBox(), hBox(), hBox2());
        setLayout();
    }

    public VBox vBox() {

        vBox.getChildren().addAll(p1Nick, playerTextField);
        return vBox;
    }

    public HBox hBox() {

        hBox.getChildren().addAll(difficultyLevel, difficultyLevelList);
        return hBox;
    }

    public HBox hBox2() {

        hBox2.getChildren().addAll(backButton, playButton);
        return hBox2;
    }

    public void setLayout() {

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(150));

        playerTextField.setMaxWidth(200);

        vBox.setSpacing(5);

        hBox.setSpacing(20);
        hBox.setPadding(new Insets(10));

        hBox2.setSpacing(20);
        hBox2.setPadding(new Insets(10));


    }

    public void goToBoardScene(Stage stage, Scene scene, Board board) {

        playButton.setOnAction(event -> {
            stage.setScene(scene);
            board.setPlayerName(playerTextField.getText());
            board.setPlayer2Name("BOT");

        });
    }

    public void backToMenu(Stage stage, Scene scene) {

        backButton.setOnAction(event -> {
            stage.setScene(scene);
        });
    }






}
