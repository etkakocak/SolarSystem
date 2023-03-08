package banksystem;

import java.util.Scanner;

/**
 * Java Application.
 */
public class App {
  private Scanner input;

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

        Login login = new Login(name, password);

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
  }



  private void checkBalance() {
    System.out.println("!!!");
  }

  /**
   * The App starting.
   */
  public static void main(String[] args) {
    Scanner consoleInput = new Scanner(System.in, "UTF-8");
    App theApp = new App(consoleInput);
    theApp.start();
    theApp.checkBalance();
    // close the scanner
    consoleInput.close();
  }
}
