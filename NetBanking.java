package bank_management;

import java.util.Scanner;

public class NetBanking {
    String user_id;
    private int pin_code;
    private String password;

    public NetBanking(String user_id, int pin_code, String password) {
        this.user_id = user_id;
        this.pin_code = pin_code;
        this.password = password;
    }

    void bank_Balance_Check(Bank bank, Scanner sc) {
        String id;
        String passcode;

        do {
            System.out.print("\nEnter your user id: ");
            id = sc.nextLine();

            System.out.print("\nEnter your user password: ");
            passcode = sc.nextLine();

            if (id.equals(user_id) && passcode.equals(password)) {
                System.out.println("The Bank Balance is: " + bank.amount);
            } else {
                System.out.println("Sorry! Wrong User Id or Password Given.");
            }
        } while (!id.equals(user_id) || !passcode.equals(password));
    }

    void fund_Transfer(Bank bank, Scanner sc) {
        String id;
        String passcode;
        int pin;
        int transfer_amount;

        do {
            System.out.print("\nEnter your user id: ");
            id = sc.nextLine();

            System.out.print("\nEnter your user password: ");
            passcode = sc.nextLine();

            if (id.equals(user_id) && passcode.equals(password)) {
                System.out.print("\nEnter amount to transfer: ");
                transfer_amount = sc.nextInt();
                sc.nextLine();

                if (bank.amount < transfer_amount) {
                    System.out.println("Sorry! You do not have enough money to transfer from your account");
                } else {
                    do {
                        System.out.print("\nEnter your net banking pin code: ");
                        pin = sc.nextInt();
                        sc.nextLine();

                        if (pin == pin_code) {
                            bank.amount = bank.amount - transfer_amount;
                            System.out.println(transfer_amount + " rupees debited from your bank balance");
                            System.err.println("The Transaction id is: " + (int) (Math.random() * 100000000));
                        } else {
                            System.out.println("\nSorry! Wrong pin code given.");
                        }
                    } while (pin != pin_code);
                }
            } else {
                System.out.println("Sorry! Wrong User Id or Password Given.");
            }
        } while (!id.equals(user_id) || !passcode.equals(password));
    }
}
