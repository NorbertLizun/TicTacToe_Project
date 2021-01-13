package com.game;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Logic {

    private boolean firstPlayerTurn = true;
    private boolean playable = true;
    private final Random random = new Random();
    private boolean drawComplete = false;
    private final List<Combo> combosList = new ArrayList<>();
    private int number = 4;

    public void xDraw(Button tile) {

        if (tile.getText().equals("")) {
            tile.setText("X");
            firstPlayerTurn = false;
        }
    }

    public void oDraw(Button tile) {

        if (tile.getText().equals("")) {
            tile.setText("O");
            firstPlayerTurn = true;
        }

    }

    public void easyBotDraw(Board board) {



        while (!drawComplete) {

            int randomTile = random.nextInt(9);

            if (board.getTile()[randomTile].getText().equals("")) {
                board.getTile()[randomTile].setText("O");
                firstPlayerTurn = true;
                drawComplete = true;

            }
        }

        drawComplete = false;
    }

    public void hardBotDraw() {

    }

    public void moveController(Button tile,  boolean pvpMode, Board board) {

        if (playable) {

            if (firstPlayerTurn) {

                xDraw(tile);
                checkState();

                if (!pvpMode) {

                        easyBotDraw(board);
                        checkState();

                }

            } else {

                oDraw(tile);
                checkState();
            }
        }

    }

    public void combinations(Button[][] button) {

        for (int i = 0; i < 3; i++)
            combosList.add(new Combo(button[0][i], button[1][i], button[2][i]));

        for (int i = 0; i < 3; i++)
            combosList.add(new Combo(button[i][0], button[i][1], button[i][2]));

            combosList.add(new Combo(button[0][0], button[1][1], button[2][2]));
            combosList.add(new Combo(button[2][0], button[1][1], button[0][2]));
    }

    public void checkState() {

        for (Combo combo : combosList)

            if (combo.isComplete()) {
                combo.whoWin();
                playable = false;
            }
    }

}
