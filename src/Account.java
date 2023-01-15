/*
 * File description: Abstract Account class for banking system. Contains setters / getters and methods to print info
 * Student Name: Aleksander Naumowicz
 * Student #: 041039693
 * Due Date: April 3
 * Professor Name: James Mwangi
 * Course code: CST 8132
 */
import java.util.Scanner;
/**
 * The purpose of this class is to read and get account object variables. Has methods to read and print relevant info
 * @author Aleksander Naumowicz
 * @version 1.0
 * @since 1.8
 */
public abstract class Account {

    private Person accHolder = new Person();

    private int accountNumber;

    private double accountBalance;


    /**
     * Overloaded constructor of account object
     * @param accHolder [the information of the account holder]
     * @param accountNumber [the account number of the account holder]
     * @param accountBalance [balance of the account holder]
     */
    public Account (Person accHolder, int accountNumber, double accountBalance){

        this.accHolder = accHolder;

        this.accountNumber = accountNumber;

        this.accountBalance = accountBalance;


    }

    /**
     * No param constructor of account object
     */
    public Account(){

        this.accHolder = null;

        this.accountNumber = 0;

        this.accountBalance = 0;

    }

    /**
     * Method to read bank account details from individual
     * @param keyboard [scanner object, passed thru]
     */
    public void readInfo(Scanner keyboard){

        // Setting account number
        System.out.print("Enter your account number: ");
        this.accountNumber = keyboard.nextInt();
        keyboard.nextLine();

        // Getting user input
        System.out.print("Enter first name: ");
        String firstName = keyboard.nextLine();

        // Getting user input
        System.out.print("Enter last name: ");
        String lastName = keyboard.nextLine();

        // Getting user input
        System.out.print("Enter email: ");
        String email = keyboard.nextLine();

        // Getting user input
        System.out.print("Enter phone number: ");
        int phoneNumber = keyboard.nextInt();

        // Creating / setting person object accholder with user input
        this.accHolder = new Person(firstName, lastName, email, phoneNumber);

        // Setting account balance
        System.out.print("Enter your account balance: ");
        this.accountBalance = keyboard.nextDouble();;

        // Checking for non-negative balance
        balanceCheck(keyboard);


    }

    /**
     * Method to check if balance is negative
     * @param keyboard [Scanner object, passed thru]
     */
    public void balanceCheck (Scanner keyboard){

         while (this.accountBalance < 0){

            System.out.println("Please input a non-negative balance");
             System.out.printf("Account balance: ");
            this.accountBalance = keyboard.nextDouble();


        }

    }


    /**
     * Method to print relevant account details of account holder
     */
    public void printAccountInfo(){

        System.out.printf("%10d |", this.accountNumber);

        System.out.printf("%20s |", accHolder.getFirstName() + " " + accHolder.getLastName());

        System.out.printf("%24s |", accHolder.getEmail());

        System.out.printf("%30d |", accHolder.getPhoneNumber());

        System.out.printf("%23.2f |\n", this.accountBalance);





    }

    /**
     * abstract method to be implemented in subclass
     */
    abstract void updateBalance();

    /**
     * Method to get the balance of the account holder
     * @return [Returns the account balance]
     */
    public double getAccountBalance(){


        return this.accountBalance;

    }

    /**
     * Method to update the balance of the account holder
     * @param accountBalance [Scanner object, passed thru]
     */
    public void setAccountBalance(double accountBalance){

        this.accountBalance = accountBalance;

    }

    /**
     * Method to create an account object from data read from text file
     * @param firstName [First name of person]
     * @param lastName [Last name of person]
     * @param email [Email of person]
     * @param phoneNumber [Person phone number]
     * @param accountNumber [Person account number]
     * @param accountBalance [Person account balance]
     */
    public void readAccountInfoFromFile(String firstName, String lastName, String email, int phoneNumber, int accountNumber, double accountBalance){


        // Creating and setting person object
        this.accHolder = new Person(firstName, lastName, email, phoneNumber);

        // Setting account number
        this.accountNumber = accountNumber;

        // Setting account balance
        this.accountBalance = accountBalance;



    }

    /**
     * Method to get account holder first name
     * @return [Returns first name]
     */
    public String getAccountFirstName(){

        return accHolder.getFirstName();

    }

    /**
     * Method to get account holder last name
     * @return [returns last name]
     */
    public String getAccountLastName(){

        return accHolder.getLastName();


    }

    /**
     * Method to get account holder email
     * @return [returns email]
     */
    public String getAccountEmail(){

        return accHolder.getEmail();

    }

    /**
     * Method to get account phone number
     * @return [returns phone number]
     */
    public int getAccountPhone(){

        return accHolder.getPhoneNumber();
    }

    /**
     * Method to get account number
     * @return [returns account number]
     */
    public int getAccountNumber(){

        return this.accountNumber;

    }

}
