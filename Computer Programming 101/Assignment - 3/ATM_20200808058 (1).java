//Tahir Emre Semiz
//28.11.2021


import java.util.Scanner;

public class ATM_20200808058 {
    public static void main(String[] args){

    }
    public static void atm(String[] names,String[] surnames,
                           double[] balances,int index,Scanner input){
        String[] a = {"Account Balance","Deposit","Withdrawal",
                "Change Name"};
        boolean x = true;
        while (x){
            System.out.println("Hello "
                    + names[index].substring(0,1).toUpperCase()
                    +  names[index].substring(1)
                    + " " + surnames[index].toUpperCase());
            System.out.println("What would you like today?");
            int choice = menuDisplay(a,input);
            switch (choice){
                case 1:
                    System.out.println("Your balance is "
                            + balances[index] + "\n");
                    break;
                case 2:
                    System.out.print("How much are you depositing? ");
                    double deposit = input.nextDouble();
                    if(isDepositValid(deposit)) {
                        System.out.println();
                        balances[index] += deposit;
                    }
                    else
                        System.out.println("ERROR: Invalid deposit" +
                                " amount\n");
                    break;
                case 3:
                    System.out.print("How much are you withdrawing? ");
                    double withdraw = input.nextDouble();
                    if(isWithdrawalValid(balances[index],withdraw)) {
                        System.out.println(moneyGiven(withdraw));
                        balances[index] -= withdraw;
                    }
                    else
                        System.out.println("ERROR: Invalid" +
                                " withdrawal amount\n");
                    break;
                case 4:
                    System.out.print("Please enter your name >> ");
                    String newName = input.next();
                    names[index] = newName;
                    System.out.print("Please enter your surname >> ");
                    String newSurname = input.next();
                    surnames[index] = newSurname;
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Thank you for using our ATM." +
                            " Have a nice day!");
                    x = false;
                    break;
                default:
                    System.out.println("Invalid choice. Exiting System.\n");
                    x = false;
            }
        }
    }
    public static int menuDisplay(String[] items,Scanner input){
        for(int i = 0 ; i <= items.length - 1; i++){
            System.out.println((i + 1) + " - " + items[i]);
        }
        System.out.println("0 to Quit");
        System.out.print("Please enter your selection >> ");
        return input.nextInt();
    }
    public static int findAcct(int[] acctNums,int acctNum){
        for (int i = 0 ; i <= acctNums.length - 1;i++){
            if (acctNums[i] == acctNum)
                return i;
        }
        return -1;
    }
    public static void bankLogin(int[] acctNums,String[] acctNames,
                                 String[] acctSurnames,String[] acctPINs,
                                 double[] acctBalances){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your account number >> ");
        int a = scanner.nextInt();
        System.out.print("Please enter your account PIN >> ");
        String b = scanner.next();
        System.out.println();
        int index = findAcct(acctNums,a);
        if(index == -1)
            System.out.println("ERROR: Account/PIN combination not found.");
        else if(!acctPINs[index].equals(b))
            System.out.println("ERROR: Account/PIN combination not found.");
        else{
            atm(acctNames,acctSurnames,acctBalances,index,scanner);
        }
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
