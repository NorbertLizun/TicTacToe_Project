//package com.tictactoe;
//
//import javafx.scene.control.Button;
//
//
//public class Tile extends Button {
//
//    public Tile(Logic logic, Player playerX, Player playerO) {
//
//        this.setMinSize(200, 200);
//
//        this.setOnAction((event -> {
//
//            if (logic.isPlayable()) {
//
//                if (logic.isFirstPlayerTurn()) {
//
//                    if (this.getText().equals("")) {
//                        playerX.draw(this);
//                        logic.setFirstPlayerTurn(false);
//                        logic.checkState();
//                    }
//
//                } else {
//
//                    if (this.getText().equals("")) {
//                        playerO.draw(this);
//                        logic.setFirstPlayerTurn(true);
//                        logic.checkState();
//                    }
//                }
//            }
//
//        }));
//    }
//
//}
