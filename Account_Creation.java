package bank_management;

import java.util.Scanner;

public class Account_Creation {
	static Address enter_Address_Details(Scanner sc) {
        System.out.print("\nEnter your state: ");
        String state = sc.nextLine();
        
        System.out.print("\nEnter your city: ");
        String city = sc.nextLine();
        
        System.out.print("\nEnter your pin: ");
        int pin = sc.nextInt();
        sc.nextLine(); 
        
        return new Address(state, city, pin);
    }
    
    static DateOfBirth enter_DOB_Details(Scanner sc) {
        System.out.print("\nEnter your date: ");
        int date = sc.nextInt();
        
        System.out.print("\nEnter your month: ");
        int month = sc.nextInt();
        
        System.out.print("\nEnter your year: ");
        int year = sc.nextInt();
        sc.nextLine();
        
        return new DateOfBirth(date, month, year);
    }
    
    User enter_User_Details(Scanner sc) {
        System.out.print("\nEnter your name: ");
        String name = sc.nextLine();
        
        System.out.print("\nEnter your phone no: ");
        String phn_no = sc.nextLine();
        
        System.out.print("\nEnter your age: ");
        int age = sc.nextInt();
        sc.nextLine();
        
        System.out.print("\nEnter your address: ");
        Address ad = enter_Address_Details(sc);
        
        System.out.print("\nEnter your date of birth: ");
        DateOfBirth dob = enter_DOB_Details(sc);
        
        return new User(name, ad, phn_no, dob, age);
    }
    
    Bank create_Account(Scanner sc) {
        System.out.print("\nAvailable banks are: \n1. SBI Bank(To choose press 1) \n2. PNB Bank(To choose press 2) \n3. Axis Bank(To choose press 3) \n4. Canara Bank(To choose press 4)");
        System.out.print("\nEnter your choice: ");
        int i = sc.nextInt();
        sc.nextLine();
        
        System.out.print("\nEnter your bank branch: ");
        String branch = sc.nextLine();
        
        System.out.print("\nEnter your bank account type: ");
        String acc_type = sc.nextLine();
        
        System.out.print("\nEnter your bank account password: ");
        String password = sc.nextLine();
        
        switch(i) {
            case 1:
                return new SBI_Bank("SBI Bank", (int) (Math.random() * 100000000), "sbin0036789", (int) (Math.random() * 1000000000), branch, acc_type, password, 2000);
                    
            case 2:
                return new PNB_Bank("PNB Bank", (int) (Math.random() * 100000000), "pnbi0036789", (int) (Math.random() * 1000000000), branch, acc_type, password, 500);
                
            case 3:
                return new Axis_Bank("Axis Bank", (int) (Math.random() * 100000000), "axisa0036789", (int) (Math.random() * 1000000000), branch, acc_type, password, 1000);
                
            case 4:
                return new SBI_Bank("Canara Bank", (int) (Math.random() * 100000000), "canarar0036789", (int) (Math.random() * 1000000000), branch, acc_type, password, 500);
                
            default:
                System.out.println("Chosen bank account creation facility is currently unavailable");
                return null;
        }
    }
}
