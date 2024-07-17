package bank_management;

import java.util.Scanner;

public class LogIn {
    void operation(Bank bank, User user) {
        int i;
        String s;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("\n1. Show Profile Details (press 1) \n2. Check bank Balance (press 2) \n3. ATM card issue (press 3) \n4. Enabling NetBanking (press 4) \n5. Show ATM card details (press 5) \n6. Make payment (press 6) \n7. Change Profile Password (press 7) \nEnter your choice: ");
            i = sc.nextInt();
            sc.nextLine();

            switch (i) {
                case 1:
                    bank.show_Profile_Details(sc, user);
                    break;

                case 2:
                    if (bank.netbanking == null)
                        System.out.println("\nUnavailable to check bank balance. Please enable net banking service for your bank account.");
                    else
                        bank.netbanking.bank_Balance_Check(bank, sc);
                    break;

                case 3:
                    bank.atm = bank.apply_ATM_Card(sc);
                    break;

                case 4:
                    bank.netbanking = bank.enable_NetBanking(sc, user);
                    break;

                case 5:
                    bank.show_ATM_Details(sc);
                    break;

                case 6:
                    new Payment().pay(bank, bank.atm, bank.netbanking, sc);
                    break;

                case 7:
                    bank.change_Password(sc);
                    break;

                default:
                    System.out.println("Sorry! This choice is out of facility.");
                    break;
            }

            System.out.print("Do you want to proceed in Login? (y/n): ");
            s = sc.nextLine();

        } while (s.equalsIgnoreCase("y"));
    }
}
