package com.game;


import javafx.scene.control.Button;

public class Combo {

    private final Button[] buttons;
    private boolean xWin;
    private boolean oWin;

    private static int xPoint;
    private static int oPoint;

    public static int getXPoint() {
        return xPoint;
    }

    public static int getOPoint() {
        return oPoint;
    }

    public boolean isxWin() {
        return xWin;
    }

    public boolean isoWin() {
        return oWin;
    }

    public Combo(Button... buttons) {
        this.buttons = buttons;
    }

    public boolean isComplete() {

        if (buttons[0].getText().isEmpty())
            return false;

        return buttons[0].getText().equals(buttons[1].getText())
                && buttons[0].getText().equals(buttons[2].getText());

    }

    public void whoWin() {

        if (buttons[0].getText().equals("X")) {
            setWinColor();
            xPoint++;
            xWin = true;



        } else if (buttons[0].getText().equals("O")) {
            setWinColor();
            oPoint++;
            oWin = true;



        }

        xWin = false;
        oWin = false;



    }


    public void setWinColor() {
        for (int i = 0; i < 3; i++) {
            buttons[i].setStyle("-fx-background-color: #00ff00");
        }

    }











}
