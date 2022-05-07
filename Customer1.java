package com.example.dukedemo;

public class Customer1 {

    private String FirstName;
    private String LastName;



    public Customer1(){
    }

    public Customer1(String firstname, String lastname){
        this.FirstName = firstname;
        this.LastName = lastname;

    }





    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getLastName() {
        return LastName;
    }






    public String toString(){
        return "First Name: " + this.FirstName + "\n" + "Last Name: " + this.LastName + "\n";

    }
}