package com.example.dukedemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class PrintScreen extends Vehicle {

        //customer info
    @FXML
    private Label Name;
        //vehicle info
    @FXML
    private Label CarYear;
    @FXML
    private Label CarMake;
    @FXML
    private Label CarModel;
    @FXML
    private Label CarMileage;
    @FXML
    private Label CarVin;

        //parts info
    @FXML
    private Label Part1;
    @FXML
    private Label Part2;
    @FXML
    private Label Part3;
    @FXML
    private Label Part4;
    @FXML
    private Label Part5;
    @FXML
    private Label Part6;
    @FXML
    private Label Part7;
    @FXML
    private Label Part8;

    @FXML
    private Label Labor;

    //Descriptive text of main issues or talking points
    @FXML
    private TextArea description_Of_Issue;

    @FXML
    private Label Total;


    public void setName(String name) {
        Name.setText(name);
    }

    public void setTotal(String total) {
        Total.setText(total);
    }

    public void setYear(String year) {
        CarYear.setText(year);
    }

    public void setMake(String make) {
        CarMake.setText(make);
    }

    public void setModel(String model) {
        CarModel.setText(model);
    }

    public void setMileage(String mileage) {
        CarMileage.setText(mileage);
    }

    public void setVin(String vin) {
        CarVin.setText(vin);
    }

    public void setPart1(String part1) {
        Part1.setText(part1);
    }

    public void setPart2(String part2) {
        Part2.setText(part2);
    }

    public void setPart3(String part3) {
        Part3.setText(part3);
    }

    public void setPart4(String part4) {
        Part4.setText(part4);
    }

    public void setPart5(String part5) {
        Part5.setText(part5);
    }

    public void setPart6(String part6) {
        Part6.setText(part6);
    }

    public void setPart7(String part7) {
        Part7.setText(part7);
    }

    public void setPart8(String part8) {
        Part8.setText(part8);
    }

    public void setLabor(String labor) {
        Labor.setText(labor);
    }

   public void setDescription_Of_Issue(String Descrtip){
        description_Of_Issue.setText(Descrtip);
   }


}
