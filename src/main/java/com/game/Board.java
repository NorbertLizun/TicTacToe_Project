package com.game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Board extends GridPane {

    private final Button[] tile = new Button[9];
    private final Button[][] buttons = new Button[3][3];
    private final Logic logic = new Logic();
    private final HBox hBox = new HBox();
    private final Label playerName = new Label();
    private final Label player2Name = new Label();
    private static final Label score = new Label();


    public Board(MenuScene menuScene) {
        createTiles(menuScene);
        addTilesToTheGrid();
        logic.combinations(buttons);
        this.add(hBox(), 1, 3, 2,3);
    }

    public Button[] getTile() {
        return tile;
    }

    public void createTiles(MenuScene menuScene) {

        for (int i = 0; i < 9; i++) {

            tile[i] = new Button();
            tile[i].setMinSize(150,150);

            int tileId = i;

            tile[i].setOnMouseClicked(event -> {logic.moveController(tile[tileId],
                    menuScene.isPlayerVsPlayer(), this);
                    updateScore();
            } );
        }
    }

    public void addTilesToTheGrid() {

        int tileNumber = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                this.add(tile[tileNumber], col, row);
                buttons[col][row] = tile[tileNumber];
                tileNumber++;

            }
        }
    }

    public HBox hBox() {



        playerName.setMinSize(20,20);
        player2Name.setMinSize(20,20);
        score.setMinSize(20,20);

        hBox.getChildren().addAll(playerName, score,  player2Name);
        return hBox;
    }

    public void setPlayerName(String p1Name) {
        playerName.setText(p1Name);
    }

    public void setPlayer2Name(String p2Name) {
        player2Name.setText(p2Name);
    }

    public void updateScore() {
        score.setText(Combo.getXPoint() + " " + Combo.getOPoint());
    }


}
