package com.hw;

import javafx.scene.control.Label;


public class bmiResult {


    public String mbiCalculate(double weight, double height){

        double bmi= weight/height;

        if(bmi<18.5){
            return "UNDERWEIGHT";
        }else if(bmi>=18.5 && bmi<=23){
            return "HEALTHY";
        }else if(bmi>23 && bmi<=25){
            return "AT RISK";
        }else if(bmi>25){
            return "OVERHEIGHT";
        }else{
            return "BMI can'not negetive";
        }
    }

}
