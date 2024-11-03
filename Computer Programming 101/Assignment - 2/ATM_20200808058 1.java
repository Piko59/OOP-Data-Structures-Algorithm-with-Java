//Tahir Emre Semiz
//28.10.2021

import java.util.Scanner;

public class ATM_20200808058 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your first name >> ");
        String name = scanner.nextLine();
        System.out.print("Please enter your surname >> ");
        String surname = scanner.nextLine();
        double balance;
        do{
            System.out.print("Please enter your starting balance >> ");
            balance = scanner.nextDouble();
            System.out.println();
        }
        while(balance <= 0);
        int selection;
        do {
            System.out.println("Hello " + name + " " + surname.toUpperCase());
            System.out.println("What would you like today?");
            System.out.println("1 for Account Balance");
            System.out.println("2 for Cash Deposit");
            System.out.println("3 for Cash Withdrawal");
            System.out.println("0 to Quit");
            System.out.print("Please enter your selection >> ");
            selection = scanner.nextInt();
            switch (selection){
                case 1:
                    System.out.println("Your balance is "
                            + balance + "\n");
                    break;
                case 2:
                    System.out.print("How much are you depositing? ");
                    double deposit = scanner.nextDouble();
                    if(isDepositValid(deposit)) {
                        System.out.println();
                        balance += deposit;
                    }
                    else
                        System.out.println("ERROR: Invalid deposit" +
                                " amount\n");
                    break;
                case 3:
                    System.out.print("How much are you withdrawing? ");
                    double withdraw = scanner.nextDouble();
                    if(isWithdrawalValid(balance,withdraw)) {
                        System.out.println(moneyGiven(withdraw));
                        balance -= withdraw;
                    }
                    else
                        System.out.println("ERROR: Invalid" +
                                " withdrawal amount\n");
                    break;
                case 0:
                    System.out.println("Thank you for using our ATM." +
                            " Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid choice. Exiting System.\n");
            }
        }
        while (selection >= 1  && selection <= 3);
    }
    public static boolean isDepositValid(double amount){
        if(amount > 0)
            return true;
        else
            return false;
    }
    public static boolean isWithdrawalValid(double balance,double amount){
        if(amount > 0 && (balance - amount) >= 0)
            return true;
        else
            return false;
    }
    public static String moneyGiven(double amount){
        int twoHundred,hundred,fifty,twenty,ten,five,one,zeroFifty
                ,zeroTwentyFive,zeroTen,zeroFive,zeroOne;
        amount*=100;
        twoHundred = (int)amount / 20000;
        amount %= 20000;
        hundred = (int)amount / 10000;
        amount %= 10000;
        fifty = (int)amount / 5000;
        amount %= 5000;
        twenty = (int)amount / 2000;
        amount %= 2000;
        ten = (int)amount / 1000;
        amount %= 1000;
        five = (int)amount / 500;
        amount %= 500;
        one = (int)amount / 100;
        amount %= 100;
        zeroFifty = (int)amount/50;
        amount %= 50;
        zeroTwentyFive = (int)amount/25;
        amount %= 25;
        zeroTen = (int)amount/10;
        amount %= 10;
        zeroFive = (int)amount/5;
        amount %= 5;
        zeroOne = (int)amount/1;
        return twoHundred + " - 200\n" + hundred + " - 100\n" + fifty
                + " - 50\n" + twenty + " - 20\n" + ten + " - 10\n" + five
                + " - 5\n" + one + " - 1\n" + zeroFifty
                + " - 0.50\n" + zeroTwentyFive + " - 0.25\n" + zeroTen
                + " - 0.10\n" + zeroFive + " - 0.05\n" + zeroOne
                + " - 0.01\n";
    }
}
