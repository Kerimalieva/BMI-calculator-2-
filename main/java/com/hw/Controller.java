package com.hw;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Controller implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private ToggleGroup G;

    @FXML
    private Label label;

    @FXML
    private TextField inch;

    @FXML
    private TextField kg;

    @FXML
    private TextField age;

    @FXML
    private TextField foot;

    @FXML
    private RadioButton female;

    @FXML
    private RadioButton male;

    @FXML
    void calculate(ActionEvent event) {
        String Age = age.getText();
        String Foot = foot.getText();
        String Inch = inch.getText();
        String Weight = kg.getText();

        // Добавим проверки на пустые строки
        if (Age.isEmpty() || Foot.isEmpty() || Inch.isEmpty() || Weight.isEmpty()) {
            label.setText("Please fill in all fields.");
            label.setStyle("-fx-background-color: #ff0000;");
            return;
        }

        try {
            double myFoot = Double.parseDouble(Foot);
            double myInch = Double.parseDouble(Inch);
            double myWeight = Double.parseDouble(Weight);

            double myHeight = (myFoot * 12) + myInch;
            myHeight = (myHeight * 0.0254);

            myHeight = myHeight * myHeight;

            bmiResult result = new bmiResult();

            String myResult = result.mbiCalculate(myWeight, myHeight);

            String gender;
            if (male.isSelected()) {
                gender = "male";
            } else if (female.isSelected()) {
                gender = "female";
            } else {
                gender = "unknown";
            }

            label.setText("You are a " + gender + " of " + Age + " years old\n" + myResult);
            label.setStyle("-fx-background-color: #36abff;");
        } catch (NumberFormatException e) {
            label.setText("Please enter valid numeric values.");
            label.setStyle("-fx-background-color: #ff0000;");
        }
    }

    @FXML
    void reset(ActionEvent event) {
        age.clear();
        foot.clear();
        inch.clear();
        kg.clear();
        label.setStyle("-fx-background-color: #ffffff;");
        label.setText("");
        G.selectToggle(null); // Сбрасываем выбор гендера
    }
}
