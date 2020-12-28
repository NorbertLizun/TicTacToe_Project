package com.kodilla;


import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ButtonsArea extends VBox {
    Button resetButton = new Button("RESET");

    public ButtonsArea() {
        this.getChildren().add(resetButton);

    }

    public void reset(GridPane gridPane) {

        resetButton.setOnAction(event -> {
            gridPane.add(new PlayableArea(), 1,2);
        });
    }




}
