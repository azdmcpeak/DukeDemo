package com.example.dukedemo;

import java.io.File;
import java.io.FileWriter;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {


        //text fields regarding PII for the customer for the scene
    @FXML
    private TextField FirstName;
    @FXML
    private TextField LastName;

        //text fields regarding Identifying information for the vehicle for the scene
    @FXML
    private TextField VehYear;
    @FXML
    private TextField VehMake;
    @FXML
    private TextField VehModel;
    @FXML
    private TextField Engine_Displacement;
    @FXML
    private TextField VehColor;
    @FXML
    private TextField VehMilage;
    @FXML
    private TextField VehVin;



        //label on the first scene to show the customer that the file was created
    @FXML
    private Label Filecreated;





    //local variables for the customer
  private String firstname;
  private String lastname;


    //local variables for the vehicles
  private String Year;
  private String Make;
  private String Model;
  private String Color;
  private String Mileage;
  private String Vin;
  private String Displacement;


        //Local variables for the scene
    private Stage stage;
    private Scene scene;
    private Parent root;


        //variables for the scene
        //error above existing customer
    @FXML
    private Label Error;

        //variables for the scene
        //error above the new customer button in scene builder
    @FXML
    private Label Error2;


        //to keep the date for file creation
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        //the actual name of the file that getrs created.
    String date = sdf.format(new Date()) + ".txt";

        //the date used for printing purposes
    String TodayDate = sdf.format(new Date());

        //Customer object
    Customer1 customer = new Customer1("","");
        //Vehicle object
    Vehicle1 vehicle = new Vehicle1("","","","","","");

    public void NewCustomerButton(ActionEvent event) throws IOException {

            //Normalization and sanitization for first name
        this.firstname = Sanitize(Normalizer.normalize(FirstName.getText(), Normalizer.Form.NFKC));


            //Normalization and sanitization for last name
        this.lastname = Sanitize(Normalizer.normalize(LastName.getText(), Normalizer.Form.NFKC));


            //Normalization and sanitization for Year
        this.Year = Sanitize(Normalizer.normalize(VehYear.getText(), Normalizer.Form.NFKC));


            //Normalization and sanitization for Make
        this.Make = Sanitize(Normalizer.normalize(VehMake.getText(), Normalizer.Form.NFKC));


            //Normalization and sanitization for Model
        this.Model = Sanitize(Normalizer.normalize(VehModel.getText(), Normalizer.Form.NFKC));


            //Normalization and sanitization for Color
        this.Color = Sanitize(Normalizer.normalize(VehColor.getText(), Normalizer.Form.NFKC));


            //Normalization and sanitization for Engine Displacement
        this.Displacement = Sanitize(Normalizer.normalize(Engine_Displacement.getText(), Normalizer.Form.NFKC));


            //Normalization and sanitization for Mileage
        this.Mileage = Sanitize(Normalizer.normalize(VehMilage.getText(), Normalizer.Form.NFKC));


            //Normalization and sanitization for Vin
        this.Vin = Sanitize(Normalizer.normalize(VehVin.getText(), Normalizer.Form.NFKC));



            //Creating customer object and printing it for verification
        Customer1 customer = new Customer1(this.firstname, this.lastname);
            //print statement for validation
        System.out.println(customer);

            //Creating vehicle object and printing it for verification to validation
        Vehicle1 vehicle = new Vehicle1(this.Year,this.Make,this.Model, this.Color, this.Mileage, this.Vin);
            //print statement for validation
        System.out.println(vehicle);

            //name variable for use in creating the Parent file for the customer
        String name = firstname + " " + lastname;

        System.out.println("name: " + name);


            //creation of parent file
        //String path = "C:\\Users\\azdmc\\Desktop\\Drizzle\\" + name ;
        String path = "C:\\Users\\dukec\\Desktop\\Customers\\" + name ;

            //directory for where the file to be written
        File directory = new File(path);


            //checking to see if folder already exists
        if(!directory.exists()){
                //makes directory if it doesn't exist.
            if(directory.mkdir()){
                    //changing text above button
                Error2.setText("Folder Created");
                    //printing for verification
                System.out.println("folder created!");
            }
        }
        else {
                //notifying customer the folder already exist.
            Error2.setText("Customer already exists");
                //printing for verification
            System.out.println("Folder already exists.");
        }


        try {
            //writer for file for the specific customer use your own applicable file path

            //BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\azdmc\\Desktop\\Drizzle\\" + name + "\\" + date));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\dukec\\Desktop\\Customers\\" + name + "\\" + date));


            //writing person and vehicle attributes to the file
        writer.write("Today's date: " + TodayDate + "\n"
                + " " + "\n" +
                "Customer name: " + this.firstname + " "  + this.lastname + "\n" +
                " " + "\n" +
                "Vehicle Year: " + this.Year + " || " +
                "Vehicle Make: " + this.Make + " || " +
                "Vehicle Model: " + this.Model + " || " +
                "Engine Displacement: " + this.Displacement + " || " +
                "Vehicle Color: " + this.Color + " || " +
                "Vehicle Mileage: " + this.Mileage + " || " +
                "Vehicle Vin: " + this.Vin + "\n" + "\n");

        writer.close();
        }
        catch (Exception e){
            System.out.println("File not found");
        }
    }




    public void ExistingCustomerButton(ActionEvent event) throws IOException {

            //setting text above Existing customer button to whitespace
        this.Error.setText(" ");

            //Normalization and sanitization for first name
        this.firstname = Sanitize(Normalizer.normalize(FirstName.getText(), Normalizer.Form.NFKC));

            //Normalization and sanitization for last name
        this.lastname = Sanitize(Normalizer.normalize(LastName.getText(), Normalizer.Form.NFKC));

            //creating customer object
        Customer1 customer = new Customer1(this.firstname, this.lastname);
            //print statement for validation
        System.out.println(customer);

            //print break for readability
        System.out.println(" ");

            //Normalization and sanitization for Year
        this.Year = Sanitize(Normalizer.normalize(VehYear.getText(), Normalizer.Form.NFKC));

            //Normalization and sanitization for Make
        this.Make = Sanitize(Normalizer.normalize(VehMake.getText(), Normalizer.Form.NFKC));

            //Normalization and sanitization for Model
        this.Model = Sanitize(Normalizer.normalize(VehModel.getText(), Normalizer.Form.NFKC));

            //Normalization and sanitization for Color
        this.Color = Sanitize(Normalizer.normalize(VehColor.getText(), Normalizer.Form.NFKC));

            //Normalization and sanitization for Engine Displacement
        this.Displacement = Sanitize(Normalizer.normalize(Engine_Displacement.getText(), Normalizer.Form.NFKC));

            //Normalization and sanitization for Mileage
        this.Mileage = Sanitize(Normalizer.normalize(VehMilage.getText(), Normalizer.Form.NFKC));

            //Normalization and sanitization for Vin
        this.Vin = Sanitize(Normalizer.normalize(VehVin.getText(), Normalizer.Form.NFKC));


            //vehicle object creation
        Vehicle1 vehicle = new Vehicle1(this.Year,this.Make,this.Model, this.Color, this.Mileage, this.Vin);
            //print statement for verification
        System.out.println(vehicle);

            //creating variable name for creation of file to write to
        //String name =  FirstName.getText() + " " + LastName.getText();

        //creating variable name for creation of file to write to
        String name =  firstname + " " + lastname;


        try {
            //writer for file for the specific customer use your own applicable file path

        //BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\azdmc\\Desktop\\Drizzle\\" + name + "\\" + date, true));
         BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\dukec\\Desktop\\Customers\\" + name + "\\" + date, true));

                //Customer and Vehicle attribute being written and the format in which it is written.
            writer.write("Today's date: " + TodayDate + "\n"
                    + " " + "\n" +
                    "Customer name: " + this.firstname + " " + this.lastname + "\n" +
                    " " + "\n" +
                    "Vehicle Year: " + this.Year + " || " +
                    "Vehicle Make: " + this.Make + " || " +
                    "Vehicle Model: " + this.Model + " || " +
                    "Engine Displacement: " + this.Displacement + " || " +
                    "Vehicle Color: " + this.Color + " || " +
                    "Vehicle Mileage: " + this.Mileage + " || " +
                    "Vehicle Vin: " + this.Vin + "\n");

                //changing text above the save existing customer button
            Filecreated.setText("Created!");


            writer.close();
        } catch (FileNotFoundException e) {
            this.Error.setText("This customer doesn't exist." + "\n" + "Check spelling or select, new customer.");
        }
    }


    public void SwitchToSecondary(ActionEvent event) throws IOException {

            //loading the second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondaryScene.fxml"));
        root = loader.load();

            //calling scene2controller class
        Scene2Controller scene2controller = loader.getController();

            //calling set f&L name function to bring to the second scene
            //this is used for being able to write the correct file, as the naming scheme for the files uses the customer first and last name
        scene2controller.setthefname(firstname);
        scene2controller.settheLname(lastname);



        //Parent root = FXMLLoader.load(getClass().getResource("SecondaryScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public String Sanitize (String attribute) {
        // Create a final list, to store different black listed patterns.
        // Created as final so other classes cannot instantiate the list to add or delete elements
        final List<Pattern> blacklist = new ArrayList<>(); // IDS01-J
        blacklist.add(Pattern.compile("[!#$%^*&<>]")); // IDS01-J
        blacklist.add(Pattern.compile("(@)\\1+")); // IDS01-J
        blacklist.add(Pattern.compile("(\\.)\\1+")); // IDS01-J

        // for loop to test each blacklisted patter/characters
        for (Pattern pattern : blacklist) { // IDS01-J
            Matcher matcher = pattern.matcher(attribute); // IDS01-J

            // if the loop finds a blacklist, throws an IllegalStateException
            if (matcher.find()) { // IDS01-J
                System.out.println("Invalid user input");
                attribute = "";
                System.out.println("attribute:" + attribute);

            }

        }
        return attribute;

    }




}
