package com.kodilla;

public class Combo {
    private final Tile[] tiles;
    private int xPoint;
    private int oPoint;

    public int getxPoint() {
        return xPoint;
    }

    public int getoPoint() {
        return oPoint;
    }

    public Combo(Tile... tiles) {
        this.tiles = tiles;
    }

    public boolean isComplete() {

        if (tiles[0].getText().isEmpty())
            return false;

        return tiles[0].getText().equals(tiles[1].getText())
                && tiles[0].getText().equals(tiles[2].getText());

    }

    public void whoWin() {

        if (tiles[0].getText().equals("X")) {
            setWinColor();
            xPoint++;
        } else if (tiles[0].getText().equals("O")) {
            setWinColor();
            oPoint++;
        }
    }


    public void setWinColor() {
        for (int i = 0; i < 3; i++) {
            tiles[i].setStyle("-fx-background-color: #00ff00");
        }

    }


}
