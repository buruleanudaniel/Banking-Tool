import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("$#,##0.00");

    // customer number set //

    public int setCustomerNumber(int customerNumber){
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    // get the customer number //

    public int getCustomerNumber(){
        return customerNumber;
    }

    public int getPinNumber(){
        return pinNumber;
    }

    public int setPinNumber(int pinNumber){
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingBalance(){
        return savingBalance;
    }

    // calculate checking account withdrawal //

    public double calcCheckingWithdraw(double amount){
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    // calculate saving account withdrawal //

    public double calcSavingWithdraw(double amount){
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    public double calcSavingDeposit(double amount){
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    public double calcCheckingDeposit(double amount){
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    // customer checking account withdraw input //

    public void getCheckingWithdrawInput(){
        System.out.println("Checking account balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to withdraw from the checking account: ");
        double amount = input.nextDouble();

        if((checkingBalance - amount) >= 0){
            calcCheckingWithdraw(amount);
            System.out.println("New checking account balance: " + moneyFormat.format(calcCheckingWithdraw(amount)));
        }else{
            System.out.println("Balance negative" + "\n");
        }
    }

    public void getSavingDepositInput(){
        System.out.println("Saving account balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to withdraw from the saving account: ");
        double amount = input.nextDouble();

        if((savingBalance - amount) >= 0){
            calcCheckingWithdraw(amount);
            System.out.println("New saving account balance: " + savingBalance + "\n");
        }else{
            System.out.println("Balance negative" + "\n");
        }
    }

    public void getCheckingDepositInput(){
        System.out.println("Checking account balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to deposit from checking account: ");
        double amount = input.nextDouble();

        if((checkingBalance + amount) >= 0){
            calcCheckingDeposit(amount);
            System.out.println("New checking account balance: " + moneyFormat.format(checkingBalance));
        }else{
            System.out.println("Balance negative" + "\n");
        }
    }

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;
}
