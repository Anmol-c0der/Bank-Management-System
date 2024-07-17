package bank_management;

import java.util.Scanner;

public class Bank {
    String bank_name;
    private int holder_id;
    String ifsc_no;
    private int acc_no;
    String branch_name;
    String acc_type;
    private String p_password;
    int amount;

    ATM atm;
    NetBanking netbanking;

    public Bank(String bank_name, int holder_id, String ifsc_no, int acc_no, String branch_name, String acc_type,
                String p_password, int amount) {
        this.bank_name = bank_name;
        this.holder_id = holder_id;
        this.ifsc_no = ifsc_no;
        this.acc_no = acc_no;
        this.branch_name = branch_name;
        this.acc_type = acc_type;
        this.p_password = p_password;
        this.amount = amount;
    }

    ATM apply_ATM_Card(Scanner sc) {
        System.out.print("\nEnter a 4 digit no to secure your card: ");
        int pin = sc.nextInt();
        sc.nextLine();

        DateOfBirth expr = enter_issue_date(sc);

        return new ATM((int) (Math.random() * 100000000), pin, (int) (Math.random() * 1000), expr);
    }

    DateOfBirth enter_issue_date(Scanner sc) {
        System.out.print("\nEnter issue date: ");
        int date = sc.nextInt();

        System.out.print("\nEnter issue month: ");
        int month = sc.nextInt();

        System.out.print("\nEnter issue year: ");
        int year = sc.nextInt();
        sc.nextLine();

        return new DateOfBirth(date, month, year + 3);
    }

    NetBanking enable_NetBanking(Scanner sc, User u) {
        System.out.print("Enter your valid email id: ");
        u.email = sc.nextLine();

        System.out.print("\nSet a user id for net banking: ");
        String id = sc.nextLine();

        System.out.print("\nSet a user password for net banking account: ");
        String password = sc.nextLine();

        System.out.print("\nSet a 6-digit pin code to secure net banking transaction: ");
        int pin = sc.nextInt();
        sc.nextLine();

        return new NetBanking(id, pin, password);
    }

    void show_Profile_Details(Scanner sc, User u) {
        String password;

        do {
            System.out.print("Enter your profile password: ");
            password = sc.nextLine();

            if (password.equals(p_password)) {
                System.out.println("\nThe Account Holder is: " + u.name);
                System.out.println("\nThe Account Holder Id is: " + holder_id);
                System.out.println("\nThe Address details of the Account holder is: \nCountry: " + u.address.country +
                        "\nState: " + u.address.state + "\nCity: " + u.address.city + "\nPin Code: " + u.address.pin);
                System.out.println("\nPhone No: " + u.phn_no);
                System.out.println("\nThe Date of Birth is: " + u.dob.date + "." + u.dob.month + "." + u.dob.year);
                System.out.println("\nThe bank name is: " + bank_name + "(Branch: " + branch_name + ")");
                System.out.println("\nIFSC No: " + ifsc_no);
                System.out.println("\nAccount No: " + acc_no);
                System.out.println("\nAccount Type: " + acc_type);

                if (atm == null)
                    System.out.println("\nATM Facility: unavailable");
                else
                    System.out.println("\nATM Facility: available");

                if (netbanking == null)
                    System.out.println("\nNet Banking Facility: unavailable");
                else
                    System.out.println("\nNet Banking Facility: available");
            } else {
                System.out.println("\nSorry! Wrong password given.");
            }
        } while (!password.equals(p_password));
    }

    void show_ATM_Details(Scanner sc) {
        String password;

        do {
            System.out.print("Enter your profile password: ");
            password = sc.nextLine();

            if (password.equals(p_password)) {
                System.out.println("The ATM card no is: " + atm.card_no);
                System.out.println("The ATM card cvv no is: " + atm.cvv);
                System.out.println("The Expire date of this card is: " + atm.expr.date + "." + atm.expr.month + "." + atm.expr.year);
            } else {
                System.out.println("\nSorry! Wrong password given.");
            }
        } while (!password.equals(p_password));
    }

    void change_Password(Scanner sc) {
        int h_id;
        int account_no;

        do {
            System.out.print("\nEnter Bank Account Holder Id: ");
            h_id = sc.nextInt();

            System.out.print("\nEnter Bank Account no: ");
            account_no = sc.nextInt();
            sc.nextLine();

            if (h_id == holder_id && account_no == acc_no) {
                System.out.println("\nEnter your new password: ");
                p_password = sc.nextLine();
                System.out.println("\nYAY! Password has changed");
            } else {
                System.out.println("Sorry! Wrong details given.");
            }
        } while (h_id != holder_id || account_no != acc_no);
    }

    public String getP_password() {
        return p_password;
    }

    public void setP_password(String p_password) {
        this.p_password = p_password;
    }
}
