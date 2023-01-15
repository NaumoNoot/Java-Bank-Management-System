/*
 * File description: Main class of program, holds menu loop for banking system.
 * Student Name: Aleksander Naumowicz
 * Student #: 041039693
 * Due Date: April 3
 * Professor Name: James Mwangi
 * Course code: CST 8132
 */
import java.io.IOException;
import java.util.Scanner;

/**
 * The purpose of this class is to loop thru menu options and read accounts / run monthly processes / print all accounts.
 * @author Aleksander Naumowicz
 * @version 1.0
 * @since 1.8
 */
public class BankTest {


    public static void main(String arg[]) throws IOException {

        boolean validInteger = true;

        /** Scanner variable for main class**/
        Scanner keyboard = new Scanner(System.in);

        /** The name of the bank**/
        String name = null;

        /** The amount of accounts to be stored initially**/
        int numAccounts = 0;


        // Requesting and reading bank name input
        System.out.print("Enter the name of the Bank: ");
        name = keyboard.nextLine();


        // Loop for exception catching
        while (validInteger) {

            // Try statement
            try {

                // Requesting and reading number of accounts
                System.out.print("Enter number of accounts: ");

                // Getting user input
                numAccounts = keyboard.nextInt();

                // Checking for non-negative number
                while (numAccounts <= 0) {

                    // Error message
                    System.out.println("*** Please enter a non-negative / 0 number ***");

                    // Re-asking inputs
                    System.out.print("Number of accounts: ");
                    numAccounts = keyboard.nextInt();

                }

                // Turning off loop once successful
                validInteger = false;

                // Catching input mismatch exception
            } catch (Exception e) {

                // Error message
                System.out.println("*** Input a valid integer number ***");
                keyboard.nextLine();

            }
        }

        // Creating bank object with overloaded constructor, using previous variables to set name and student size
        Bank bank = new Bank(name, numAccounts);

        // Calling menu method
        menu(keyboard, bank);

        // Closing Scanner object
        keyboard.close();

    }


    /**
     * Method to loop thru menu options and call bank methods.
     * @param keyboard [Scanner object, is passed thru to other methods]
     * @param bank [Bank object, holds methods for account transactions / reading / writing]
     * @throws IOException [Exception thrown when file doesn't exist]
     */
    public static void menu(Scanner keyboard, Bank bank) throws IOException {

        boolean menuOn = true;


        int menuChoice = 0;

        // While loop that keeps menu running
        while (menuOn == true){

            boolean inputMismatch = true;


            // Displaying menu options
            System.out.println("1. Read account");
            System.out.println("2. Run monthly process");
            System.out.println("3. Print all accounts");
            System.out.println("4. Read data from file");
            System.out.println("5. Write data to file");
            System.out.println("6. Exit");


            // Requesting and reading user input for menu option


            while (inputMismatch) {

                try {

                    System.out.print("Enter your option: ");
                    menuChoice = keyboard.nextInt();
                    inputMismatch = false;

                } catch (Exception e) {

                    System.out.println("*** Input valid menu command ***");
                    keyboard.nextLine();

                }
            }

            // Switch decision structure, 4 options
            switch(menuChoice){


                // Menu option 1.
                case 1:

                    // Calls method readAccounts from bank object, passes in Scanner
                    bank.readAccounts(keyboard);
                    break;


                // Menu option 2.
                case 2:

                    // Calls method runMonthlyProcess from bank object
                    bank.runMonthlyProcess();
                    break;


                // Menu option 3.
                case 3:

                    // Calls method printAccounts from bank object
                    bank.printAccounts();
                    break;

                    // Menu option 4.
                case 4:

                bank.readAccountsFromFile();
                break;

                // Menu option 5
                case 5:
                bank.writeAccountsToFile();
                break;

                // Menu option 6
                case 6:
                    menuOn = false;

                    System.out.println("Program created by Aleksander Naumowicz");
                    System.out.println("Thank you...");

                    break;


                // Default case option, if user inputs an invalid menu option error message is displayed
                default:

                    // invalid input error message
                    System.out.printf("***** Invalid option. . . Please try again *****\n");
                    break;

            }

        }




    }


    }


