//package com.tictactoe;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.layout.GridPane;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//
//public class Main extends Application {
//    Board board = new Board();
//    GridPane gridPane = new GridPane();
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//
//
//        gridPane.add(new Board(), 0, 0);
//        gridPane.add(new Board(), 0,1);
//
//
//        Scene scene = new Scene(gridPane, 700,700, Color.AQUA);
//
//        primaryStage.setTitle("Tic-Tac-Toe");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//}
