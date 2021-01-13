package com.game;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class RankingScene extends GridPane {

    private Button pvpRankingButton = new Button("PVP Ranking");
    private Button pvbRankingButton = new Button("PVB Ranking");
    private Button backButton = new Button("Back");
    private MenuScene menuScene = new MenuScene();
    private Board board = new Board(menuScene);
    private BoardScene boardScene = new BoardScene(board);
    private Map<Integer, String> list = boardScene.getRankingList();
    private Text rankingText = new Text("PVP");
    private List <String> pvpRankingList = new ArrayList<>();
    private List <String> pvbRankingList = new ArrayList<>();
    private String bigString = "";



    public RankingScene() {
        this.add(pvpRankingButton, 1,0);
        this.add(pvbRankingButton, 2,0);
        this.add(backButton,3,0);
        this.add(rankingText,1,2, 5,5);
        pvpRanking();
        showPvbRanking();
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
                    bigString +=  pvbRankingList.get(i) + "\n";
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
