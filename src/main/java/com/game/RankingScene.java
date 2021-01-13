package com.game;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class RankingScene extends GridPane {

    private final Button pvpRankingButton = new Button("PVP Ranking");
    private final Button pvbRankingButton = new Button("PVB Ranking");
    private final Button backButton = new Button("Back");
    private final MenuScene menuScene = new MenuScene();
    private final Board board = new Board(menuScene);
    private final BoardScene boardScene = new BoardScene(board);
    private final VBox vBoxButton = new VBox();
    private final VBox vBoxRanking = new VBox();
    private final Map<Integer, String> list = boardScene.getRankingList();
    private final Text rankingText = new Text("PVP");
    private final List <String> pvpRankingList = new ArrayList<>();
    private final List <String> pvbRankingList = new ArrayList<>();
    private String bigString = "";


    public RankingScene() {

        this.add(vBoxRanking(), 1,1,2,10);
        this.add(vBoxButton(), 3,1,2,10);
        pvpRanking();
        showPvbRanking();
    }

    public VBox vBoxButton() {
        vBoxButton.getChildren().addAll(pvpRankingButton, pvbRankingButton, backButton);

        return  vBoxButton;
    }

    public VBox vBoxRanking() {
        vBoxRanking.getChildren().add(rankingText);
        vBoxRanking.setMinWidth(200);
        vBoxRanking.setBackground(new Background(new BackgroundFill(Color.BISQUE, null, null)));


        return vBoxRanking;
    }

    public void backButton(Stage stage, Scene scene) {
        backButton.setOnAction(event -> {
            stage.setScene(scene);
            rankingText.setText("");
        });
    }

    public void pvpRanking() {

        pvpRankingButton.setOnAction(event -> {


            bigString = "";
            pvbRankingButton.setDisable(false);
            rankingText.setText("");

            try {
                BufferedReader br = new BufferedReader(new FileReader(BoardScene.getPvpRanking()));
                String line;
                while ((line = br.readLine()) != null) {
                    pvpRankingList.add(line);
                }

                for (int i = 0; i < pvpRankingList.size(); i++) {
                    bigString += pvpRankingList.get(i) + "\n";
                }
                rankingText.setText(bigString);

                for (int i = 0; i < pvpRankingList.size(); i++) {
                    pvpRankingList.remove(i);
                }

            } catch (IOException e) {
                System.out.println("Problem z plikiem");
            }


            pvpRankingButton.setDisable(true);


        });

    }

    public void showPvbRanking() {

        pvbRankingButton.setOnAction(event -> {

            bigString = "";
            pvpRankingButton.setDisable(false);
            rankingText.setText("");

            try {
                BufferedReader br = new BufferedReader(new FileReader(BoardScene.getPvbRanking()));
                String line;
                while ((line = br.readLine()) != null) {
                    pvbRankingList.add(line);
                }

                for (int i = 0; i < pvbRankingList.size(); i++) {
                    bigString += pvbRankingList.get(i) + "\n";
                }
                rankingText.setText(bigString);

                for (int i = 0; i < pvbRankingList.size(); i++) {
                    pvbRankingList.remove(i);
                }

            } catch (IOException e) {
                System.out.println("Problem z plikiem");
            }


            pvbRankingButton.setDisable(true);
        });

    }
}
