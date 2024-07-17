package bank_management;

import java.util.Scanner;

public class ATM {
    int card_no;
    private int pin_no;
    int cvv;
    DateOfBirth expr;

    public ATM(int card_no, int pin_no, int cvv, DateOfBirth expr) {
        this.card_no = card_no;
        this.pin_no = pin_no;
        this.cvv = cvv;
        this.expr = expr;
    }

    void money_Deposit(Bank bank, Scanner sc) {
        int deposit_amount;
        int card;
        int cvv_no;
        int pin;

        do {
            System.out.print("\nEnter your ATM card no: ");
            card = sc.nextInt();

            System.out.print("\nEnter your ATM cvv no: ");
            cvv_no = sc.nextInt();

            if (card == card_no && cvv == cvv_no) {
                System.out.print("\nEnter amount to deposit: ");
                deposit_amount = sc.nextInt();

                do {
                    System.out.print("\nEnter your ATM pin code: ");
                    pin = sc.nextInt();

                    if (pin == pin_no) {
                        bank.amount = bank.amount + deposit_amount;
                        System.out.println(deposit_amount + " rupees credited on your bank balance");
                        System.err.println("The Transaction id is: " + (int) (Math.random() * 100000000));
                    } else {
                        System.out.println("\nSorry! Wrong pin code given.");
                    }
                } while (pin != pin_no);
            } else {
                System.out.println("\nSorry! Wrong card no or cvv no given.");
            }
        } while (card != card_no || cvv != cvv_no);
    }

    void money_Withdrawal(Bank bank, Scanner sc) {
        int withdrawal_amount;
        int card;
        int cvv_no;
        int pin;

        do {
            System.out.print("\nEnter your ATM card no: ");
            card = sc.nextInt();

            System.out.print("\nEnter your ATM cvv no: ");
            cvv_no = sc.nextInt();

            if (card == card_no && cvv == cvv_no) {
                System.out.print("\nEnter amount to withdraw: ");
                withdrawal_amount = sc.nextInt();

                if (bank.amount < withdrawal_amount)
                    System.out.println("Sorry! You do not have enough money to withdraw from your account");
                else {
                    do {
                        System.out.println("\nEnter your ATM pin code: ");
                        pin = sc.nextInt();

                        if (pin == pin_no) {
                            bank.amount = bank.amount - withdrawal_amount;
                            System.out.println(withdrawal_amount + " rupees debited from your bank balance");
                            System.err.println("The Transaction id is: " + (int) (Math.random() * 100000000));
                        } else {
                            System.out.println("\nSorry! Wrong pin code given.");
                        }
                    } while (pin != pin_no);
                }
            } else {
                System.out.println("\nSorry! Wrong card no or cvv no given.");
            }
        } while (card != card_no || cvv != cvv_no);
    }
}