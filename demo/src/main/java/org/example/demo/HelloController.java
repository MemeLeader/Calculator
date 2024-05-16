package org.example.demo;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.awt.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class HelloController {
    @FXML
    public TextField display;

    private double num1 = 0;

    private double num2 = 0;

    private int numCount = 0;

    private double answer = 0;
    private String symbol = "";

    @FXML
    protected void onTypeNum(ActionEvent event){

        Button button = (Button) event.getSource();

        String num = button.getText();

        String currentText = display.getText();
        String newText = currentText + num;
        display.setText(newText);

        if (numCount == 0) {
            num1 = Double.parseDouble(newText);
        } else if (numCount == 1) {
            num2 = Double.parseDouble(newText);
        }

        // увеличиваем numCount на 1
        numCount++;
    }
    @FXML
    protected void onTypeSymbol(ActionEvent event) {
        Button button = (Button) event.getSource();

        String symbol = button.getText();

        String currentText = display.getText();
        String newText = currentText + symbol;
        display.setText(newText);



    }
    @FXML
    protected void dropLastSymbol(ActionEvent event) {
        String currentText = display.getText();


        if (currentText.length() > 0) {

            String newText = currentText.substring(0, currentText.length() - 1);

            display.setText(newText);

            if (Character.isDigit(currentText.charAt(currentText.length() - 1))) {
                numCount--;
            }
        }
    }
    @FXML
    protected void dropAllSymbol(ActionEvent event) {
        display.setText("");

        num1 = 0;
        num2 = 0;
        numCount = 0;
    }

    @FXML
    protected void onEqualClick() {
        switch (symbol){
            case "+":
                answer = num1 + num2;
                break;
            case "-":
                answer = num1 - num2;
            case "/":
                answer = num1 / num2;
                break;
            case "*":
                answer = num1 * num2;
                break;
            default:
                display.setText("ERROR");
        }
        display.setText(String.valueOf(answer));

        num1 = 0;
        num2 = 0;
        numCount = 0;
    }
}