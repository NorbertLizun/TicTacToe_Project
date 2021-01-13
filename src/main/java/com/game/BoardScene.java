package com.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class BoardScene extends GridPane implements Serializable {

    private final Button backButton = new Button("BACK");
    private final VBox vBox = new VBox();
    public final Button reloadButton = new Button("RELOAD");
    public final Board board;
    public static File rankingFile = new File("Ranking.list");
    public Map<Integer, String> rankingList = new HashMap<>();
    private static final File pvpRanking = new File("pvpRanking.txt");
    private static final File pvbRanking = new File("pvbRanking.txt");
    private MenuScene menuScene = new MenuScene();




    public BoardScene(Board board) {
        this.board = board;
        setLayout();
        this.add(board, 1, 0);
        this.add(vbox(), 4, 0);

    }

    public static File getPvbRanking() {
        return pvbRanking;
    }

    public static File getPvpRanking() {
        return pvpRanking;
    }

    public static File getRankingFile() {
        return rankingFile;
    }

    public Map<Integer, String> getRankingList() {
        return rankingList;
    }

    public void reloadBoard(MenuScene menuScene) {

        reloadButton.setOnMouseClicked(event -> this.add(new Board(menuScene), 1, 0));

    }

    private void setLayout() {

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
    }

    public void backButton(Stage stage, Scene scene, MenuScene menuScene) {

        backButton.setOnAction(event -> {
            this.add(new Board(menuScene), 1, 0);
            stage.setScene(scene);

            if (menuScene.isPlayerVsPlayer()) {

                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(pvpRanking, true));

                    String p1Name = board.getPlayerName();
                    String p2Name = board.getPlayer2Name();
                    int xPoints = Combo.getXPoint();
                    int oPoints = Combo.getOPoint();

                    bw.write(p1Name + " vs " + p2Name + " | " + xPoints + " : " + oPoints + "\n");
                    bw.close();


                } catch (IOException ioe) {

                    System.out.println("Problem z pikiem");
                }

            } else {


                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(pvbRanking, true));

                    String p1Name = board.getPlayerName();
                    String p2Name = "BOT";
                    int xPoints = Combo.getXPoint();
                    int oPoints = Combo.getOPoint();

                    bw.write(p1Name +  " vs " + p2Name + " | " + xPoints + " : " + oPoints + "\n");
                    bw.close();


                } catch (IOException ioe) {

                    System.out.println("Problem z pikiem");
                }

            }

        });
    }


    public VBox vbox() {

        backButton.setMinSize(70, 30);
        reloadButton.setMinSize(70,30);
        vBox.setPadding(new Insets(0, 0, 20, 20));
        vBox.getChildren().addAll(backButton, reloadButton);

        return vBox;
    }
}
