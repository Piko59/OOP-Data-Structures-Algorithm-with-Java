//Tahir Emre Semiz
//04.10.2021

import java.util.Scanner;

public class ATM_20200808058 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the balance: ");
        double balance = scanner.nextDouble();
        System.out.println("What would you like to do today?");
        System.out.println("1 for Balance");
        System.out.println("2 for Deposit");
        System.out.println("3 for Withdrawal");
        System.out.println("0 to Quit");
        System.out.print("Please enter your selection: ");
        int selection = scanner.nextInt();
        if(selection == 0) {
            System.out.println();
        }
        else if(selection == 1) {
            System.out.println("The current balance is " + balance);
            System.out.println("Have a nice day.");
        }
        else if(selection == 2) {
            System.out.print("Please enter the amount to deposit: ");
            double deposit = scanner.nextDouble();
            if (deposit < 0) {
                System.out.println("ERROR: Invalid deposit amount.");
                System.out.println("The current balance is " + balance);
                System.out.println("Have a nice day.");
            }
            else {
                System.out.println("The current balance is " + (balance +
                        deposit));
                System.out.println("Have a nice day.");
            }
        }
        else if(selection == 3) {
            System.out.print("Please enter the amount to withdraw: ");
            double withdraw = scanner.nextDouble();
            if (withdraw < 0 || (balance - withdraw) < 0) {
                System.out.println("ERROR: Invalid withdraw amount.");
                System.out.println("The current balance is " + balance);
                System.out.println("Have a nice day.");
            }
            else {
                System.out.println("The current balance is " + (balance -
                        withdraw));
                System.out.println("Have a nice day.");
            }
        }
        else {
            System.out.println("ERROR: Invalid selection. Exiting" +
                    " system.");
        }
    }
}
