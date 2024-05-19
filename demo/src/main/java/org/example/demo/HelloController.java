package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    public TextField display;

    // переменная для хранения текущего значения
    private double currentValue = 0;

    // переменная для хранения предыдущего значения
    private double previousValue = 0;

    // переменная для хранения текущего оператора
    private char currentOperator = '+';

    @FXML
    protected void onTypeNum(ActionEvent event) {
        Button button = (Button) event.getSource();

        String num = button.getText();

        // добавляем цифру к текущему значению
        currentValue = currentValue * 10 + Double.parseDouble(num);

        // обновляем текст в поле ввода
        display.setText(String.valueOf(currentValue));
    }

    @FXML
    protected void onTypeSymbol(ActionEvent event) {
        Button button = (Button) event.getSource();

        String symbol = button.getText();

        // сохраняем текущее значение в качестве предыдущего значения
        previousValue = currentValue;

        // сбрасываем текущее значение в ноль
        currentValue = 0;

        // обновляем текущий оператор
        currentOperator = symbol.charAt(0);

        // обновляем текст в поле ввода
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
        // вычисляем результат на основе предыдущего значения, текущего оператора и текущего значения
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

        // обновляем текст в поле ввода
        display.setText(String.valueOf(result));

        // сохраняем результат в качестве текущего значения
        currentValue = result;
    }
}
