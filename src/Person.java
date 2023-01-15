/*
 * File description: Person class. Contains various variables and setters/getters for person object.
 * Student Name: Aleksander Naumowicz
 * Student #: 041039693
 * Due Date: April 3
 * Professor Name: James Mwangi
 * Course code: CST 8132
 */

// Importing Scanner class
import java.util.Scanner;


/**
 * The purpose of this class is to read and get person object variables.
 * @author Aleksander Naumowicz
 * @version 1.0
 * @since 1.8
 */
public class Person {

    // Declaring required instance variables
    private String firstName = null;

    private String lastName = null;

    private String email = null;

    private int phoneNumber = 0;




    /**
     * No args constructor of Person object
     */
    public Person(){

        this.firstName = null;

        this.lastName = null;

        this.email = null;

        this.phoneNumber = 0;

    }


    // Overloaded constructor, takes in required parameters

    /**
     * Overloaded constructor of Person object
     * @param firstName [first name of the person]
     * @param lastName [last name of the person]
     * @param email [the person's email]
     * @param phoneNumber [the person's phone number]
     */
    public Person( String firstName, String lastName, String email, int phoneNumber){

        this.firstName = firstName;

        this.lastName = lastName;

        this.email = email;

        this.phoneNumber = phoneNumber;

    }


    /**
     * Method sets the first name of the person object
     * @param keyboard [scanner object, passed thru]
     */
    public void setFirstName(Scanner keyboard){

        this.firstName = keyboard.nextLine();

    }


    /**
     * Method returns first name of person object
     * @return [returns the string firstName]
     */
    public String getFirstName(){

        return this.firstName;

    }


    /**
     * Method sets the last name of the person object
     * @param keyboard [scanner object, passed thru]
     */
    public void setLastName(Scanner keyboard){

        this.lastName = keyboard.nextLine();

    }


    /**
     * Method returns the last name of person object
     * @return [returns the string lastName]
     */
    public String getLastName(){

        return this.lastName;

    }


    /**
     * Method sets the email of the person object
     * @param keybaord [scanner object, passed thru]
     */
    public void setEmail(Scanner keybaord){

        this.email = keybaord.nextLine();

    }


    /**
     * Method returns the email of the person object
     * @return [returns the string email]
     */
    public String getEmail(){

        return this.email;

    }


    /**
     * Method sets the phone number of the person object
     * @param keyboard [scanner object, passed thru]
     */
    public void setPhoneNumber(Scanner keyboard){

        this.phoneNumber = keyboard.nextInt();

    }


    /**
     * Method gets the phone number of the person object
     * @return [returns the int phoneNumber]
     */
    public int getPhoneNumber(){

        return this.phoneNumber;

    }


}

