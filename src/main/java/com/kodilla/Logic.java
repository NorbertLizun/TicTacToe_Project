package com.kodilla;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Logic {
    private  boolean firstPlayerTurn = true;
    private final List<Combo> combosList = new ArrayList<>();
    private boolean playable = true;
    private Random random = new Random();




    public void xMove(Tile tile) {
        if (tile.getText().equals("")) {
            tile.setText("X");
            firstPlayerTurn = false;

        }
    }

    public void oMove(Tile tile) {
        if (tile.getText().equals("")) {
            tile.setText("O");
            firstPlayerTurn = true;
        }
    }

    public void testBotMove(Tile[] tile) {
        int randomTile = random.nextInt(10);
        if (tile[randomTile].getText().equals("")) {
            tile[randomTile].setText("O");
            firstPlayerTurn = true;
        }
    }



    public void moveController(Tile tile) {

        tile.setOnAction((event -> {


            if (playable) {


                if (firstPlayerTurn) {


                    xMove(tile);
                    checkState();

                } else {

                    oMove(tile);
                    checkState();
                }

            }

        }));


    }

    public void botMoveController(Tile tile, Tile[] randomTile) {



        tile.setOnAction((event -> {
            if (playable) {


                if (firstPlayerTurn) {


                    xMove(tile);
                    checkState();

                } else {

                    testBotMove(randomTile);
                    checkState();
                }



            }
        }));






    }


        public void combinations(Tile[][] tile) {

        for (int i = 0; i < 3; i++)
            combosList.add(new Combo(tile[0][i], tile[1][i], tile[2][i]));


        for (int i = 0; i < 3; i++)
            combosList.add(new Combo(tile[i][0], tile[i][1], tile[i][2]));


            combosList.add(new Combo(tile[0][0], tile[1][1], tile[2][2]));
            combosList.add(new Combo(tile[2][0], tile[1][1], tile[0][2]));
    }


    public void checkState() {

        for (Combo combo : combosList)

            if (combo.isComplete()) {
                combo.whoWin();
                playable = false;
            }

    }

}




