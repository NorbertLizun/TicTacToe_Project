//package com.tictactoe;
//
//public class Combo {
//    private final Tile[] tiles;
//
//
//    // It means that zero or more String objects (or a single array of them)
//    // may be passed as the argument(s) for that method.
//    public Combo(Tile... tiles) {
//        this.tiles = tiles;
//    }
//
//    public boolean isComplete() {
//
//        if (tiles[0].getText().isEmpty())
//            return false;
//
//        return tiles[0].getText().equals(tiles[1].getText())
//                && tiles[0].getText().equals(tiles[2].getText());
//
//    }
//
//    public void whoWin() {
//
//        if (tiles[0].getText().equals("X")) {
//            // Dodaj punkt
//            setWinColor();
//        } else if (tiles[0].getText().equals("O")) {
//            // Dodaj punkt
//            setWinColor();
//        }
//    }
//
//    public void setWinColor() {
//        for (int i = 0; i < 3; i++) {
//            tiles[i].setStyle("-fx-background-color: #00ff00");
//        }
//
//    }
//

//}