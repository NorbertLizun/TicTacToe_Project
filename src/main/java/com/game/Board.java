package com.game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.io.Serializable;

public class Board extends GridPane implements Serializable {

    private final Button[] tile = new Button[9];
    private final Button[][] buttons = new Button[3][3];
    private final Logic logic = new Logic();
    private final Label playerName = new Label();
    private final Label player2Name = new Label();
    private static final Label score = new Label();


    public Board(MenuScene menuScene) {
        createTiles(menuScene);
        addTilesToTheGrid();
        logic.combinations(buttons);
        this.add(playerName, 0, 3);
        this.add(player2Name, 2, 3);
        this.add(score,1,3);
    }

    public Button[] getTile() {
        return tile;
    }

    public void setPlayerName(String p1Name) {
        playerName.setText(p1Name);
    }

    public void setPlayer2Name(String p2Name) {
        player2Name.setText(p2Name);
    }

    public String getPlayerName() {
        return playerName.getText();
    }

    public String getPlayer2Name() {
        return player2Name.getText();
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

    public void updateScore() {
        score.setText(Combo.getXPoint() + " " + Combo.getOPoint());
    }


}
