import java.util.Scanner;

public class MainClass
 {
    public static void main(String[] arg) 
    {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);

        while (true) 
        {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            atm.handleOption(option);
        }
    }
}

class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance) 
    {
        this.balance = initialBalance;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } 
        else 
        {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    public boolean withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
            return true;
        } 
        else if (amount <= 0) 
        {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        } 
        else 
        {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
        return false;
    }
}

class ATM 
{
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) 
    {
        this.userAccount = userAccount;
    }

    public void displayMenu() 
    {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("0. Exit");
    }

    public void handleOption(int option) 
    {
        Scanner scanner = new Scanner(System.in);

        switch (option) 
        {
            case 1:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = scanner.nextDouble();
                userAccount.withdraw(withdrawAmount);
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.println("Current balance: $" + userAccount.getBalance());
                break;
            case 0:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

