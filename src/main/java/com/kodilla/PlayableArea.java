package com.kodilla;


import javafx.scene.layout.GridPane;

public class PlayableArea extends GridPane {
    private Tile tile;
    private Tile[] testtile = new Tile[10];
    private final Tile[][] tiles = new Tile[3][3];
    private Logic logic = new Logic();



    public PlayableArea() {

        addTilesToTheArea();
        logic.combinations(tiles);

    }

    public void addTilesToTheArea() {
        int testNumber = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                testNumber++;
                tile = new Tile();
                //logic.moveController(tile);
                tiles[col][row] = tile;
                testtile[testNumber] = tile;
                logic.botMoveController(tile, testtile);
                this.add(tile, col, row);
                System.out.println(testtile);
            }
        }

    }


}
