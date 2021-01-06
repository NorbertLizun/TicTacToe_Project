package com.game;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    MenuScene menuScene = new MenuScene();
    PvPScene pvpScene = new PvPScene();
    PvBScene pvbScene = new PvBScene();
    Board board = new Board(menuScene);
    BoardScene boardScene = new BoardScene(board);


    Scene menuWindow = new Scene(menuScene,500,500);
    Scene pvpWindow = new Scene(pvpScene, 500, 500);
    Scene pvbWindow = new Scene(pvbScene, 500,500);
    Scene boardWindow = new Scene(boardScene, 500,500);


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;

        menuScene.goToPvPScene(window, pvpWindow);
        menuScene.goToPvBScene(window, pvbWindow);
        menuScene.exit(window);


        pvpScene.backToMenu(window, menuWindow);
        pvpScene.goToBoardScene(window, boardWindow , board);


        pvbScene.backToMenu(window, menuWindow);
        pvbScene.goToBoardScene(window, boardWindow, board);


        boardScene.backButton(window, menuWindow, menuScene);
        boardScene.reloadBoard(menuScene);


        window.setScene(menuWindow);
        window.setTitle("TicTacToe Game");
        window.show();

    }
}
