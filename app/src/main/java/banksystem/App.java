package banksystem;

import java.util.Scanner;

/**
 * Java Application.
 */
public class App {
  private Scanner input;
  private Login login;
  private Balance balance;

  private App(Scanner scannerInput) {
    this.input = scannerInput;
  }

  /**
   * Prints a greeting message and login system.
   */
  public void start() {
    int remainingAttempts = 3;
    boolean isLoggedIn = false;

    System.out.println("Welcome to your bank!");

    while (!isLoggedIn && remainingAttempts > 0) {
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter your password: ");
        String password = input.nextLine();

        this.login = new Login(name, password);

        if (login.checkCredentials(name, password)) {
            isLoggedIn = true;
        } else {
            remainingAttempts--;
            if (remainingAttempts > 0) {
                System.out.println("Login failed. Please try again.");
                System.out.println("Remaining attempts: " + remainingAttempts);
            } else {
                System.out.println("You have exceeded the maximum number of tries...");
                System.exit(0);
            }
        }
    }

    if (isLoggedIn) {
        System.out.println("Login successful!");
    }

    System.out.println();
  }

  private void checkBalance() {
    System.out.println("Private account of " + login.getUsername() + ":");
    this.balance = new Balance(login);
    System.out.println(balance.getUserbalance() + " DKK");
    System.out.println();
  }

  private void menu() {
    int val = 0;

    while (val != 8) {
      System.out.println("1- Check your balance");
      System.out.println("2- Transfer money");
      System.out.println("3- Pay your bill");
      System.out.println("4- Loan services");
      System.out.println("5- Card services");
      System.out.println("6- Investments");
      System.out.println("7- Customer service");
      System.out.println("8- Log out");
      val = input.nextInt();

      if (val == 1) {
        checkBalance();
      } 

    }
  }

  /**
   * The App starting.
   */
  public static void main(String[] args) {
    Scanner consoleInput = new Scanner(System.in, "UTF-8");
    App theApp = new App(consoleInput);
    theApp.start();
    theApp.menu();
    // close the scanner
    consoleInput.close();
  }
}
