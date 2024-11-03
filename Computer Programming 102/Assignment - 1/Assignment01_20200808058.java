// Tahir Emre Semiz
// 12.03.2022

import java.util.Random;

public class Assignment01_20200808058 {
    public static void main(String[] args){
    }
}
class Account{
    private String acctNumber;
    private double Balance;
    Account(String acctNumber){
        this.acctNumber = acctNumber;
        this.Balance = 0;
    }
    Account(String acctNumber, double Balance){
        this.acctNumber = acctNumber;
        if(Balance < 0)
            this.Balance = 0;
        else
            this.Balance = Balance;
    }
    public String getAcctNumber(){
        return acctNumber;
    }

    public double getBalance() {
        return Balance;
    }
    public void deposit(double amount){
        if(amount > 0)
            this.Balance += amount;
        else
            this.Balance += 0;
    }
    public void withdrawal(double amount){
        if(amount < 0 || amount > getBalance())
            this.Balance -= 0;
        else
            this.Balance -= amount;
    }
    @Override
    public String toString(){
        return "Account " + this.acctNumber + " has " + this.Balance;
    }
}
class PersonalAccount extends Account{
    private String Name;
    private String Surname;
    private String PIN;
    public PersonalAccount(String acctNumber, String Name, String Surname){
        super(acctNumber);
        this.Name = Name;
        this.Surname = Surname;
        Random random = new Random();
        this.PIN = String.format("%04d", random.nextInt(10000));
    }
    public PersonalAccount(String acctNumber, String Name,
                           String Surname, double Balance){
        super(acctNumber,Balance);
        this.Name = Name;
        this.Surname = Surname;
        Random random = new Random();
        this.PIN = String.format("%04d", random.nextInt(10000));
    }
    public String getName() {
        return Name;
    }
    public String getSurname() {
        return Surname;
    }
    public String getPIN() {
        return PIN;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setSurname(String surname) {
        Surname = surname;
    }
    public void setPIN(String PIN) {
        this.PIN = PIN;
    }
    @Override
    public String toString(){
        return "Account " + getAcctNumber() + " belonging to "
                + getName() + " " + getSurname().toUpperCase() +
                " has " + getBalance();
    }
}
class BusinessAccount extends Account{
    private double interestRate;
    public BusinessAccount(String acctNumber, double interestRate){
        super(acctNumber);
        this.interestRate = interestRate;
    }
    public BusinessAccount(String acctNumber,double Balance,
                           double interestRate){
        super(acctNumber,Balance);
        this.interestRate = interestRate;
    }
    public double getRate() {
        return interestRate;
    }

    public void setRate(double rate) {
        interestRate = rate;
    }
    public double calculateInterest(){
        double a = getBalance();
        return (a * getRate());
    }
}
class Customer{
    private String Name;
    private String Surname;
    private PersonalAccount personalAccount;
    public Customer(String Name, String Surname){
        this.Name = Name;
        this.Surname = Surname;
    }
    public String getName() {
        return Name;
    }
    public String getSurname() {
        return Surname;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setSurname(String surname) {
        Surname = surname;
    }
    public void openAccount(String acctNum){
        this.personalAccount = new PersonalAccount(acctNum,Name,Surname);
    }
    public PersonalAccount getAccount(){
        return this.personalAccount;
    }
    @Override
    public String toString(){
        return Name + " " + Surname.toUpperCase();
    }
}
class Company{
    private String Name;
    private BusinessAccount businessAccount;
    public Company(String Name){
        this.Name = Name;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public void openAccount(String acctNum, double rate){
        this.businessAccount = new BusinessAccount(acctNum,rate);
    }
    public BusinessAccount getAccount(){
        return this.businessAccount;
    }
    @Override
    public String toString(){
        return Name;
    }
}