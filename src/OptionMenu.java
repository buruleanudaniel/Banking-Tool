import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account{
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###, ##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException{
        int x = 1;

        do{
            try{
                data.put(9876543, 9876);
                data.put(8989898, 1890);
                data.put(89878898, 1891);

                System.out.println("Welcome to the ATM project!");

                System.out.print("Enter your customer number: ");
                setCustomerNumber(menuInput.nextInt());
                System.out.print("Enter your pin number: ");
                setPinNumber(menuInput.nextInt());
            }catch(Exception e){
                System.out.println("\n" + "Invalid character(s). Only numbers" + "\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry: data.entrySet()){
                if(entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()){
                    getAccountType();
                }
            }
            System.out.println("\n" + "Wrong customer number or pin number." + "\n");
        }while(x == 1);
    }

    public void getAccountType(){
        System.out.print("Select the account you want to access: ");
        System.out.print("Type 1 - Checking account: ");
        System.out.print("Type 2 - Savings account: ");
        System.out.print("Type 3 - Exit: ");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch(selection){
            case 1:
                System.out.println("Saving account balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingDepositInput();
                break;
            case 3:
                System.out.println("Thank you for using the ATM project!");
                break;
            default:
                System.out.println("\n" + "Invalid selection!" + "\n");
                getAccountType();
        }
    }
}