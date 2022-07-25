package com.example.dukedemo;
import java.io.FileWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.io.IOException;


public class Scene2Controller extends Controller implements Initializable{

    protected static HashMap<String,Double> PriceAndParts = new HashMap<>();

    //Local variables for the scene
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    Label TheFirstName;
    @FXML
    Label TheLastName;


    @FXML
    private TextField Part1;
    @FXML
    private TextField Part2;
    @FXML
    private TextField Part3;
    @FXML
    private TextField Part4;
    @FXML
    private TextField Part5;
    @FXML
    private TextField Part6;
    @FXML
    private TextField Part7;
    @FXML
    private TextField Part8;
    @FXML



    //parts
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    private String part5;
    private String part6;
    private String part7;
    private String part8;
    //parts



    @FXML
    private TextField Price1;
    @FXML
    private TextField Price2;
    @FXML
    private TextField Price3;
    @FXML
    private TextField Price4;
    @FXML
    private TextField Price5;
    @FXML
    private TextField Price6;
    @FXML
    private TextField Price7;
    @FXML
    private TextField Price8;
    @FXML
    private TextField Mark_up;




    //price
    private double price1;
    private double price2;
    private double price3;
    private double price4;
    private double price5;
    private double price6;
    private double price7;
    private double price8;
    //price

    //labor
    @FXML
    private TextField Labor;

    private float labor1 = 0;
    //labor


    //total
    @FXML
    private Label Total;
    //total


    @FXML
    protected TextArea Descrption_of_Issue;

   static protected String DOI;

    @FXML
    private Label Error1;
    @FXML
    private Label Error2;
    @FXML
    private Label Error3;
    @FXML
    private Label Error4;
    @FXML
    private Label Error5;
    @FXML
    private Label Error6;
    @FXML
    private Label Error7;
    @FXML
    private Label Error8;
    @FXML
    private Label Error9;

    @FXML
    private Label SaveMessage;



    double totalofeverything;

    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    String date = sdf.format(new Date()) + ".txt";




    public void setthefname(String name){
        this.TheFirstName.setText(name);
        System.out.println("Customer: " + customer.toString());
    }

    public void settheLname(String name){
        this.TheLastName.setText(name);
    }



    public void Save2 (ActionEvent event) throws IOException {
        part1 = Part1.getText();
        part2 = Part2.getText();
        part3 = Part3.getText();
        part4 = Part4.getText();
        part5 = Part5.getText();
        part6 = Part6.getText();
        part7 = Part7.getText();
        part8 = Part8.getText();


        String name =  TheFirstName.getText() + " " + TheLastName.getText();

        DOI = Descrption_of_Issue.getText();


        float Mark_Up_Multiplier = 0;

        if(!Mark_up.getText().isBlank()){
            Mark_Up_Multiplier = Float.parseFloat(Mark_up.getText());
        }

        float Mark_Up_Percentage = Mark_Up_Multiplier / 100;
        System.out.println("Mark up Percentage " + Mark_Up_Percentage);

        float price_place_holder;

        try {
            //System.out.println("before parse" + this.price1);
            price_place_holder = Float.parseFloat(Price1.getText()) * (Mark_Up_Percentage);
            this.price1 = Float.parseFloat(Price1.getText()) + price_place_holder;
            System.out.println("after parse " + this.price1);
            Error1.setText("");
        }
        catch (NumberFormatException e) {
            if(Price1.getText().isBlank()){
                this.Error1.setText("");
            }
            else {
                this.Error1.setText("!");
            }
        }

        try
        {
            price_place_holder = Float.parseFloat(Price2.getText()) * Mark_Up_Percentage;
            this.price2 = Float.parseFloat(Price2.getText()) + price_place_holder;
            Error2.setText("");
        }
        catch (NumberFormatException e){
            if(Price2.getText().isBlank()){
                this.Error2.setText("");
            }
            else {
                this.Error2.setText("!");
            }
        }

        try
        {
            price_place_holder = Float.parseFloat(Price3.getText()) * Mark_Up_Percentage;
            this.price3 = Float.parseFloat(Price3.getText()) + price_place_holder;
            Error3.setText("");
        }
        catch (NumberFormatException e){
            if(Price3.getText().isBlank()){
                this.Error3.setText("");
            }
            else {
                this.Error3.setText("!");
            }
        }

        try
        {
            price_place_holder = Float.parseFloat(Price4.getText()) * Mark_Up_Percentage;
            this.price4 = Float.parseFloat(Price4.getText()) + price_place_holder;
            Error4.setText("");
        }
        catch (NumberFormatException e){
            if(Price4.getText().isBlank()){
                this.Error4.setText("");
            }
            else {
                this.Error4.setText("!");
            }
        }

        try
        {
            price_place_holder = Float.parseFloat(Price5.getText()) * Mark_Up_Percentage;
            this.price5 = Float.parseFloat(Price5.getText()) + price_place_holder;
            Error5.setText("");
        }
        catch (NumberFormatException e){
            if(Price5.getText().isBlank()){
                this.Error5.setText("");
            }
            else {
                this.Error5.setText("!");
            }
        }



        try
        {
            price_place_holder = Float.parseFloat(Price6.getText()) * Mark_Up_Percentage;
            this.price6 = Float.parseFloat(Price6.getText()) + price_place_holder;
            Error6.setText("");
        }
        catch (NumberFormatException e) {
            if (Price6.getText().isBlank()) {
                this.Error6.setText("");
            } else {
                this.Error6.setText("!");
            }
        }


        try
        {
            price_place_holder = Float.parseFloat(Price7.getText()) * Mark_Up_Percentage;
            this.price7 = Float.parseFloat(Price7.getText()) + price_place_holder;
            Error7.setText("");
        }
        catch (NumberFormatException e){
            if(Price7.getText().isBlank()){
                this.Error7.setText("");
            }
            else {
                this.Error7.setText("!");
            }

        }

        try
        {
            price_place_holder = Float.parseFloat(Price8.getText()) * Mark_Up_Percentage;
            this.price8 = Float.parseFloat(Price8.getText()) + price_place_holder;
            Error8.setText("");

        }
        catch (NumberFormatException e){
            if(Price8.getText().isBlank()){
                this.Error8.setText("");
            }
            else {
                this.Error8.setText("!");
            }
        }

        try
        {
            this.labor1 = Float.parseFloat(Labor.getText());
            Error9.setText("");
        }
        catch (NumberFormatException e){
            this.Error9.setText("!");
        }

        totalofeverything = price1 + price2 + price3 + price4 + price5 + price6 + price7 + price8 + labor1;
        System.out.println("Total " + totalofeverything);
        Total.setText("Total of Parts and Labor:$"+ totalofeverything);


        //writer for file for the specific customer use your own applicable file path

       BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\azdmc\\Desktop\\Drizzle\\" + name + "\\" + date, true));
       //BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\dukec\\Desktop\\Customers\\" + name + "\\" + date,true));

        writer.write("\n" + "\n" + "Description of Service, parts and cost."
                + "\n" + "---------------------------------------" + "\n");

        writer.write(DOI + "\n" + "\n") ;

        writer.write( "---------------------------------------" + "\n" + "\n");

        if (!Part1.getText().isBlank()){
            writer.write(Part1.getText() + ": $"+ this.price1 + "\n");
        }

        if (!Part2.getText().isBlank()){
            writer.write(Part2.getText()  + ": $"+ this.price2 + "\n");
        }

        if (!Part3.getText().isBlank()){
            writer.write(Part3.getText()  + ": $" + this.price3 +  "\n");
        }
        if (!Part4.getText().isBlank()){
            writer.write(Part4.getText()  + ": $" + this.price4 +  "\n");
        }
        if (!Part5.getText().isBlank()){
            writer.write(Part5.getText()  + ": $" + this.price5 +  "\n");
        }
        if (!Part6.getText().isBlank()){
            writer.write(Part6.getText()  + ": $" + this.price6 +  "\n");
        }
        if (!Part7.getText().isBlank()){
            writer.write(Part7.getText()  + ": $" + this.price7 +  "\n");
        }
        if (!Part8.getText().isBlank()){
            writer.write(Part8.getText()  + ": $" + this.price8 +  "\n");
        }

        writer.write("Labor: $" + Labor.getText() + "\n"+ "\n" +Total.getText() + "\n" + "\n");

        // disclaimer
        writer.write("TERMS: STRICTLY CASH UNLESS ARRANGEMENTS ARE MADE. "+ "\n"+
                "I hereby authorize the repair work hereinafter to be done along with the necessary material" +
                " and agree that you are not responsible for loss or damage to vehicle or articles left in the vehicle" +
                " in case of fire, theft, or any other cause beyond your control or for any delays caused by unavailability " +
                "of parts or delays in  arts shipments by the supplier or transporter. I here by grant you or your employees permission" +
                " to operate the vehicle herein described on streets, highways, or elsewhere for the purpose of testing and/or inspection. " +
                "An express mechanic's lien is hereby acknowledged on above vehicle to secure the amount of repairs there to" + "\n" + "\n" +
                "DISCLAIMER OF WARRANTIES. Any warranties on the products sold hereby are those made by the manufacture. The seller hereby expressly disclaims all warranties either express or implied, including" +
                "any implied warranty of merchantability or fitness for a particular purpose, and the seller neither assumes nor authorizes any other person to assume for it any liability in connection with the sale of said products." +
                " Any limitation contained herein does not apply where prohibited by law." + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" +
                "X Signature ______________________________________________________________________________" + "\n" + "\n");

        SaveMessage.setText("Saved!");


        writer.close();
    }

    public void switchToPrintInvoice(ActionEvent event) throws IOException {

        System.out.println(DOI);

        if(!part1.isEmpty()){
            PriceAndParts.put(part1,price1);
        }

        if(!part2.isEmpty()){
            PriceAndParts.put(part2,price2);
        }

        if(!part3.isEmpty()){
            PriceAndParts.put(part3,price3);
        }

        if(!part4.isEmpty()){
            PriceAndParts.put(part4,price4);
        }

        if(!part5.isEmpty()){
            PriceAndParts.put(part5,price5);
        }

        if(!part6.isEmpty()){
            PriceAndParts.put(part6,price6);
        }

        if(!part6.isEmpty()){
            PriceAndParts.put(part6,price6);
        }

        if(!part7.isEmpty()){
            PriceAndParts.put(part7,price2);
        }

        if(!part8.isEmpty()){
            PriceAndParts.put(part8,price8);
        }

        //main scene to get vehicle characteristics
        //loading the second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PrintScreen.fxml"));
        root = loader.load();

        //calling PrintScreen class
        PrintScreen printScreen = loader.getController();




        //setting name attributes
        printScreen.setName(this.TheFirstName.getText() + " " + this.TheLastName.getText());
        //


        //setting vehicle attributes
        printScreen.setYear(vehicle.getYear());
        printScreen.setMake(vehicle.getMake());
        printScreen.setModel(vehicle.getModel());
        printScreen.setMileage(vehicle.getMileage());
        printScreen.setVin(vehicle.getVin());
        //



        //setting part and price attributes
        //if there is no part, it sets the text to blank text for aesthetics
        if(!part1.equals("")){
            printScreen.setPart1(part1 + " =   " + (price1));
        } else {
            printScreen.setPart1("");
        }

        if(!part2.equals("")){
            printScreen.setPart2(part2 + " =   " + (price2));
        } else {
            printScreen.setPart2("");
        }

        if(!part3.equals("")){
            printScreen.setPart3(part3 + " =   " + (price3));
        }else {
            printScreen.setPart3("");
        }

        if(!part4.equals("")){
            printScreen.setPart4(part4 + " =   " + (price4));
        } else {
            printScreen.setPart4("");
        }

        if(!part5.equals("")){
            printScreen.setPart5(part5 + " =   " + (price5));
        } else {
            printScreen.setPart5("");
        }

        if(!part6.equals("")){
            printScreen.setPart6(part6 + " =   " + (price6));
        }else {
            printScreen.setPart6("");
        }

        if(!part7.equals("")){
            printScreen.setPart7(part7 + " =   " + (price7));
        }else {
            printScreen.setPart7("");
        }

        if(!part8.isBlank()){
            printScreen.setPart8(part8 + " =   " + (price8));
        }else {
            printScreen.setPart8("");
        }
        //


        //set labor
        printScreen.setLabor("Labor: " + (labor1));
        //

        //set total
        printScreen.setTotal("Total: " + (totalofeverything));
        //

        //setting text box for issue description
        printScreen.setDescription_Of_Issue(DOI);
        //



        InvoicePDFCreator invoicePDFCreator = new InvoicePDFCreator();

        invoicePDFCreator.createPDF();


    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
