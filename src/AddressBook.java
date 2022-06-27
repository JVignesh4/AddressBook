import java.util.Scanner;

public class AddressBook {

    Contacts contacts = new Contacts();

    public void addContact(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the First Name :");
        contacts.setFirstName(scanner.nextLine());

        System.out.println("Enter the Last Name :");
        contacts.setLastName(scanner.nextLine());

        System.out.println("Enter the City :");
        contacts.setCity(scanner.nextLine());

        System.out.println("Enter the State :");
        contacts.setState(scanner.nextLine());

        System.out.println("Enter the Phone Number :");
        contacts.setPhNumber(scanner.nextLine());

        System.out.println("Enter the Zip Code :");
        contacts.setZipCode(scanner.nextLine());

        System.out.println("Enter the E-Mail :");
        contacts.seteMail(scanner.nextLine());

        System.out.println(contacts);

    }

}
