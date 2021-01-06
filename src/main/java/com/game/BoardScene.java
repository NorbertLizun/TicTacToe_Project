package com.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class BoardScene extends GridPane {

    private final Button backButton = new Button("<-");
    private final VBox vBox = new VBox();
    public final Button reloadButton = new Button("RELOAD");
    public final Board board;

    public BoardScene(Board board) {
        this.board = board;
        setLayout();
        this.add(board, 1,0);
        this.add(vbox(),4,0);
        this.setGridLinesVisible(true);
    }

    public void reloadBoard(MenuScene menuScene) {

        reloadButton.setOnMouseClicked(event -> this.add(new Board(menuScene), 1,0));
    }

    private void setLayout() {

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
    }

    public void backButton(Stage stage, Scene scene, MenuScene menuScene) {

        backButton.setOnAction(event -> {
            this.add(new Board(menuScene), 1,0);
            stage.setScene(scene);
        });
    }

    public VBox vbox() {

        backButton.setMinSize(30,30);
        vBox.setPadding(new Insets(0,0,20,20));
        vBox.getChildren().addAll(backButton, reloadButton);

        return vBox;
    }





















}
