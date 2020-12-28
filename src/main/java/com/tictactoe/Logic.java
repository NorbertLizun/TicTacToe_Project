//package com.tictactoe;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Logic {
//
//    private boolean FirstPlayerTurn = true;
//    private final List <Combo> combosList = new ArrayList<>();
//    private boolean playable = true;
////    private Player playerX = new PlayerX();
////    private Player playerO = new PlayerO();
//   // private Player computer = new ComputerO();
//    private boolean againstPlayer = false;
//
//
//    public boolean isFirstPlayerTurn() {
//
//        return FirstPlayerTurn;
//    }
//
//    public boolean isPlayable() {
//
//        return playable;
//    }
//
//
//    public void setFirstPlayerTurn(boolean firstPlayerTurn) {
//
//        FirstPlayerTurn = firstPlayerTurn;
//    }
//
//
//
//
//
//
//    //public void combinations(Tile[][] tile) {
//
////        for (int i = 0; i < 3; i++)
////            combosList.add(new Combo(tile[0][i], tile[1][i], tile[2][i]));
////
////
////        for (int i = 0; i < 3; i++)
////            combosList.add(new Combo(tile[i][0], tile[i][1], tile[i][2]));
////
////
////            combosList.add(new Combo(tile[0][0], tile[1][1], tile[2][2]));
////            combosList.add(new Combo(tile[2][0], tile[1][1], tile[0][2]));
////    }
//
//
//    public void checkState() {
//
//        for (Combo combo : combosList)
//
//            if (combo.isComplete()) {
//                combo.whoWin();
//                playable = false;
//
//            }
//
//    }
//
//    public void xMove(Tile tile) {
//
//            if (tile.getText().equals("")) {
//                playerX.draw(tile);
//                setFirstPlayerTurn(false);
//                checkState();
//            }
//    }
//
//    public void oMove(Tile tile) {
//
//            if (tile.getText().equals("")) {
//
//                if (againstPlayer) {
//
//                    playerO.draw(tile);
//
//                } else {
//
//                    computer.draw(tile);
//
//                }
//
//                setFirstPlayerTurn(true);
//                checkState();
//            }
//
//    }
//


//}
