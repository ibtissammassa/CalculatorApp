package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML protected TextField TextField;
    @FXML protected TextField history;
    protected float N;
    protected float N1;
    protected float N2;
    protected String op = "";
    protected boolean running = true;

    public void Number(ActionEvent event) {
        if(!running){
            Clear();
        }
        String number = ((Button) event.getSource()).getText();
        TextField.setText(TextField.getText() + number);
        try {
            N = Float.parseFloat(TextField.getText());
        } catch (NumberFormatException e) {
            Clear();
        }
        
    }

    public void Operation(ActionEvent event) {
        String operation = ((Button) event.getSource()).getText();
        if (!operation.equals("=")) {
            if (op != "") {
                return;
            } else {
                N1 = N;
                history.setText(history.getText() + N1);
                op = operation;
                TextField.setText(op);
                history.setText(history.getText() + op);
                TextField.setText("");
            }
        } else {
            if (op == "") {
                return;
            } else {
                N2 = N;
                if(running){
                    history.setText(history.getText() + N2);
                    history.setText(history.getText() + "=");
                }
                Calculate(N1, N2, op);
            }
        }

    }

    public void Calculate (float N1, float N2, String op) {
        switch (op) {
            case "+":
                TextField.setText(N1 + N2 + "");
                break;
            case "-":
                TextField.setText(N1 - N2 + "");
                break;
            case "*":
                TextField.setText(N1 * N2 + "");
                break;
            case "/":
                TextField.setText(N1 / N2 + "");
                break;
        }
        op = "";
        running=false;
    }

    public void Clear() {
        TextField.setText("");
        history.setText("");
        op = "";
        N = 0;
        N1 = 0;
        N2 = 0;
        running=true;
    }
}
