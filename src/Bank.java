/*
 * File description: Bank Class. Has methods to read account types, print info, and run monthly processes on accounts. Has method to write to and read from source file acocunts.
 * Student Name: Aleksander Naumowicz
 * Student #: 041039693
 * Due Date: April 3
 * Professor Name: James Mwangi
 * Course code: CST 8132
 */
import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

/**
 * The purpose of this class is to hold methods used to operate the banking system.
 * @author Aleksander Naumowicz
 * @version 1.0
 * @since 1.8
 */
public class Bank {


    private String name;

    private ArrayList<Account> accounts = new ArrayList<>();

    /**
     * Overlaoded constructor of bank object
     *
     * @param name        [name of the bank]
     * @param accountSize [initial account size of banking system]
     */
    public Bank(String name, int accountSize) {

        this.name = name;

        accounts = new ArrayList<>(accountSize);


    }

    /**
     * Method to read a banking acount depending on the
     *
     * @param keyboard [Scanner object, passed thru]
     */
    public void readAccounts(Scanner keyboard) {

        /** The inputted account type*/
        int accountType = 0;

        /** The default state of the menu to read the accounts*/
        boolean menuOn = true;


        // Printing account type header
        System.out.printf("Enter details of Account %d\n", this.accounts.size() + 1);
        System.out.printf("===========================\n");


        // While loop for account type menu
        while (menuOn == true) {

            boolean validInteger = true;

            // Printing menu options
            System.out.println("1 - Chequing Account");
            System.out.println("2 - Savings Account");


            // Requesting and storing menu inputs

            while (validInteger) {

                try {

                    System.out.print("Enter Account type: ");
                    accountType = keyboard.nextInt();
                    keyboard.nextLine();
                    validInteger = false;

                } catch (Exception e) {

                    System.out.println("*** Input valid integer number ***");
                    keyboard.nextLine();

                }
            }
            // Switch decision structure for account menu
            switch (accountType) {


                // Menu option 1
                case 1:

                    // Creating a Chequing object within the account array
                    this.accounts.add(new Chequing());

                    // Calling chequing account method to read info
                    this.accounts.get(accounts.size() - 1).readInfo(keyboard);

                    // Setting while loop condition to false
                    menuOn = false;

                    break;


                // Menu option 2
                case 2:

                    // Creating savings object within the account array
                    this.accounts.add(new Savings());

                    // Calling saving account radInfo method from within account array
                    this.accounts.get(accounts.size() - 1).readInfo(keyboard);

                    // Setting while loop condition to false
                    menuOn = false;

                    break;

                // Default case, outputs error message when invalid menu input is recieved
                default:

                    // printing invalid input message
                    System.out.println("**** Enter valid account type ****");
                    break;
            }


        }


    }

    /**
     * Method to run the monthly processes of each bank account type
     */
    public void runMonthlyProcess() {


        // decision structure to see if accounts array is empty
        if (this.accounts.isEmpty() == true) {

            System.out.printf("***** No accounts to process *****\n");


        } else {

            // loop iterates through accounts array and updates it with method call
            for (int i = 0; i < this.accounts.size(); i++) {


                this.accounts.get(i).updateBalance();

            }

        }

    }

    /**
     * Method to print the bank accounts based on thier type
     */
    public void printAccounts() {

        // decision structure to see if accounts array is empty, prints error message if so
        if (this.accounts.isEmpty() == true) {

            System.out.println("***** No accounts to print *****");


        } else {

            // printing account title
            printTitle();

            // loop iterates through accounts array and prints using method
            for (int i = 0; i < this.accounts.size(); i++) {

                this.accounts.get(i).printAccountInfo();

            }


        }


    }

    /**
     * Method to print title of bank system
     */
    public void printTitle() {

        System.out.printf("%45s BANK\n", this.name.toUpperCase(Locale.ROOT));
        System.out.println("=====================================================================================================================");
        System.out.println("Acc Number |                Name |                   Email |                  Phone Number |            Balance ");
        System.out.println("======================================================================================================================");


    }


    /**
     * Method to read accounts from text file.
     * @throws IOException [Thrown when file doesn't exist]
     */
    public void readAccountsFromFile() throws IOException {

        try {

            // Creating file path object
            File file = new File("./src/AccountsSource.txt");

            // Creating reader to scan thru text file
            BufferedReader reader = new BufferedReader(new FileReader(file));

            // String to hold account strings
            String string;

            // While loop, loops thru entire document
            while ((string = reader.readLine()) != null) {

                // String array to hold account details
                String accountsArray[];

                // Creating variables to hold account information
                String firstName;
                String lastName;
                String email;
                int phoneNumber;
                int accountNumber;
                double accountBalance;

                // Checking to see accounts on text file are Chequings or Savings
                if (string.startsWith("C")) {

                    // Filling the array with required info
                    accountsArray = string.split(" ");

                    // Setting variables with relevant info
                    accountNumber = Integer.parseInt(accountsArray[1]);

                    // Setting variables with relevant info
                    firstName = accountsArray[2];

                    // Setting variables with relevant info
                    lastName = accountsArray[3];

                    // Setting variables with relevant info
                    email = accountsArray[4];

                    // Setting variables with relevant info
                    phoneNumber = Integer.parseInt(accountsArray[5]);

                    // Setting variables with relevant info
                    accountBalance = Double.parseDouble(accountsArray[6]);

                    // Creating new chequing object in accounts array
                    this.accounts.add(new Chequing());

                    // Populating chequing object in array with info
                    this.accounts.get(accounts.size() - 1).readAccountInfoFromFile(firstName, lastName, email, phoneNumber, accountNumber, accountBalance);


                } else if (string.startsWith("S")) {

                    // Filling the array with required info
                    accountsArray = string.split(" ");

                    // Setting variables with relevant info
                    accountNumber = Integer.parseInt(accountsArray[1]);

                    // Setting variables with relevant info
                    firstName = accountsArray[2];

                    // Setting variables with relevant info
                    lastName = accountsArray[3];

                    // Setting variables with relevant info
                    email = accountsArray[4];

                    // Setting variables with relevant info
                    phoneNumber = Integer.parseInt(accountsArray[5]);

                    // Setting variables with relevant info
                    accountBalance = Double.parseDouble(accountsArray[6]);

                    // Creating new savings object in accounts array
                    this.accounts.add(new Savings());

                    // Populating savings object in array with info
                    this.accounts.get(accounts.size() - 1).readAccountInfoFromFile(firstName, lastName, email, phoneNumber, accountNumber, accountBalance);


                }


            }


            // Printing command success
            System.out.println("*** Accounts read from file ***");

            // Catching exception
        } catch (FileNotFoundException e) {

            // Outputing error message and closing program
            System.out.println("*** Error! File not found! ***");
            System.exit(1);

        }
    }


    /**
     * Method to write accounts to a text file
     * @throws IOException [Exception thrown if file doens't exist]
     */
    public void writeAccountsToFile() throws IOException {

        // Checking to see if there are accounts to write
        if (this.accounts.isEmpty()) {

            System.out.println("*** No accounts to write ***");

        } else {

            // Try catch statement for nofilefound exception
            try {

                // creating file object with pathway for source file text
                File file = new File("./src/AccountsSource.txt");

                // Creating writer object to write to file
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));


                // For loop thru entire length of array
                for (int i = 0; i < accounts.size(); i++) {

                    // Writing to file, formatted differently depending if chequing object or savings object
                    if (accounts.get(i) instanceof Savings) {

                        writer.write("S" + " " + accounts.get(i).getAccountNumber() + " " + accounts.get(i).getAccountFirstName() + " " + accounts.get(i).getAccountLastName() + " "
                                + accounts.get(i).getAccountEmail() + " " + accounts.get(i).getAccountPhone() + " " + accounts.get(i).getAccountBalance());

                        // FOrmating
                        writer.newLine();


                        // Writing to file, formatted differently depending if chequing object or savings object
                    } else if (accounts.get(i) instanceof Chequing) {

                        writer.write("C" + " " + accounts.get(i).getAccountNumber() + " " + accounts.get(i).getAccountFirstName() + " " + accounts.get(i).getAccountLastName() + " "
                                + accounts.get(i).getAccountEmail() + " " + accounts.get(i).getAccountPhone() + " " + accounts.get(i).getAccountBalance());

                        // Formating
                        writer.newLine();

                    }


                }

                // Printing success
                System.out.println("*** Accounts written to file ***");
                // Closing writer to save file
                writer.close();

                // Catching exception
            } catch (FileNotFoundException e) {


                // Error message and program close
                System.out.println("*** Error! File not found! ***");
                System.exit(1);

            }


        }
    }
}


