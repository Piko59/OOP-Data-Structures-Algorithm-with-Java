//Tahir Emre Semiz
//26.12.2021


import java.io.*;
import java.util.Scanner;

public class ATM_20200808058 {
    public static void main(String[] args){
        int lineNumber1 = countAccounts("Assignment4_AccountInfo.txt");
        int lineNumber2 = countAccounts("Assignment4_TransferInfo.txt");

        int[] acctNums = new int[lineNumber1];
        String[] names = new String[lineNumber1];
        String[] surnames = new String[lineNumber1];
        double[] balances = new double[lineNumber1];
        readAccountInfo(acctNums,names,surnames,balances,"Assignment4_AccountInfo.txt");

        String[] codes = new String[lineNumber2];
        int[] moneyFrom = new int[lineNumber2];
        int[] moneyTo = new int[lineNumber2];
        double[] amount = new double[lineNumber2];
        transferInfo(codes,moneyFrom,moneyTo,amount,"Assignment4_TransferInfo.txt");
        try {
            FileWriter fw = new FileWriter("Assignment.log");
            for(int i = 0;i < lineNumber2; i++){
                int sj = transfer(acctNums,balances,moneyFrom[i],moneyTo[i],amount[i]);
                fw.write("Transfer " + codes[i] + " resulted in code " + sj + ": " + bankCodes(sj) + "\n");
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        writeAccountInfo(acctNums,names,surnames,balances,"Assignment4_AccountInfoOut.txt");
    }
    public static int countAccounts(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            int lines = 0;
            while (reader.readLine() != null){
                lines++;
            }
            reader.close();
            return lines;
        }
        catch (IOException e){
            e.printStackTrace();
            return 0;
        }
    }
    public static void readAccountInfo(int[] acctNums,String[] names,String[] surnames,double[] balances,String filename){
        try {
            Scanner scanner = new Scanner (filename);
            int i = 0;
            scanner.next();
            while(scanner.hasNext()){
                acctNums[i] = scanner.nextInt();
                names[i] = scanner.next();
                surnames[i] = scanner.next();
                balances[i] = scanner.nextDouble();
                i++;
            }
            scanner.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static boolean deposit(double[] balances,int index,double amount){
        if(isDepositValid(amount)){
            balances[index] += amount;
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean withdrawal(double[] balances,int index,double amount){
        if(isWithdrawalValid(balances[index], amount)){
            balances[index] -= amount;
            return true;
        }
        else{
            return false;
        }
    }
    public static int transfer(int[] acctNums,double[] balances,int acctNumFrom,int acctNumTo,double amount){
        int indexFrom = findAcct(acctNums,acctNumFrom);
        int indexTo = findAcct(acctNums,acctNumTo);
        boolean a = withdrawal(balances,indexFrom,amount);
        boolean b = deposit(balances,indexTo,amount);
        if(a && !b)
            return 1;
        else if(!a && b)
            return 2;
        else if(a && b)
            return 0;
        else if(!(isWithdrawalValid(balances[indexFrom],amount)))
            return 3;
        else{
            return -1;
        }
    }
    public static void writeAccountInfo(int[] acctNums,String[] names,String[] surnames,double[] balances,String filename){
        try{
            FileWriter fw = new FileWriter(filename);
            for (int i = 0;i < acctNums.length;i++){
                fw.write(acctNums[i] + " " + names[i] + " " + surnames[i] + " " + balances[i] + "\n");
            }
            fw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static int findAcct(int[] acctNums,int acctNum){
        for (int i = 0 ; i <= acctNums.length - 1;i++){
            if (acctNums[i] == acctNum)
                return i;
        }
        return -1;
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
    public static void transferInfo(String[] codes,int[] moneyFrom,int[] moneyTo,double[] amount,String filename){
        try {
            Scanner input = new Scanner(filename);
            int i = 0;
            input.next();
            while(input.hasNext()){
                String code = input.next();
                int from = input.nextInt();
                int to = input.nextInt();
                double balance = input.nextDouble();
                codes[i] = code;
                moneyFrom[i] = from;
                moneyTo[i] = to;
                amount[i] = balance;
                i++;
            }
            input.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String bankCodes(int x){
        if (x == 0)
            return "STX - Transfer Successful";
        else if (x == 1)
            return "TNF - To Account Not Found";
        else if (x == 2)
            return "FNF - From Account Not Found";
        else
            return "NSF - Insufficient Funds";
    }
}
