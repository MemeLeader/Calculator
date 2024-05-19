package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    public TextField display;

    private double currentValue = 0;

    private double previousValue = 0;

    private char currentOperator = '+';

    @FXML
    protected void onTypeNum(ActionEvent event) {
        Button button = (Button) event.getSource();

        String num = button.getText();

        currentValue = currentValue * 10 + Double.parseDouble(num);

        display.setText(String.valueOf(currentValue));
    }

    @FXML
    protected void onTypeSymbol(ActionEvent event) {
        Button button = (Button) event.getSource();

        String symbol = button.getText();

        previousValue = currentValue;

        currentValue = 0;

        currentOperator = symbol.charAt(0);

        display.setText("");
    }

    @FXML
    protected void dropLastSymbol(ActionEvent event) {
        String currentText = display.getText();

        if (currentText.length() > 0) {
            String newText = currentText.substring(0, currentText.length() - 1);
            display.setText(newText);
        }
    }

    @FXML
    protected void dropAllSymbol(ActionEvent event) {
        display.setText("");

        currentValue = 0.0;
        previousValue = 0.0;
    }

    @FXML
    protected void onEqualClick() {
        double result = 0.0;
        switch (currentOperator) {
            case '+':
                result = previousValue + currentValue;
                break;
            case '-':
                result = previousValue - currentValue;
                break;
            case '*':
                result = previousValue * currentValue;
                break;
            case '÷':
                result = previousValue / currentValue;
                break;
        }


        display.setText(String.valueOf(result));

        currentValue = result;
    }
}
