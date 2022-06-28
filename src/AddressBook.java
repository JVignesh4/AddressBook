import java.util.Scanner;

public class AddressBook {

    Contacts contacts = new Contacts();
    Scanner scanner = new Scanner(System.in);

    public void addContact(){

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

    public void editContact(){
        System.out.println("Enter the first name");
        String firstName = scanner.next();

        boolean isAvailable = false;
            if (firstName.equalsIgnoreCase(contacts.getFirstName())) {
                isAvailable = true;
                System.out.println("Enter the New First Name");
                contacts.setFirstName(scanner.next());
                System.out.println("Enter the Last Name :");
                contacts.setLastName(scanner.next());
                System.out.println("Enter the City :");
                contacts.setCity(scanner.next());
                System.out.println("Enter the State :");
                contacts.setState(scanner.next());
                System.out.println("Enter the Zip Code :");
                contacts.setZipCode(scanner.next());
                System.out.println("Enter the Phone Number :");
                contacts.setPhNumber(scanner.next());
                System.out.println("Enter the EMail ID :");
                contacts.seteMail(scanner.next());
            }else if (!isAvailable) {
            System.out.println("Contact is Not found ");
        }
        System.out.println(contacts);
    }

    public void deleteContact(){
        System.out.println("Enter the first name");
        String firstName = scanner.next();

        boolean isAvailable = false;
        if (firstName.equalsIgnoreCase(contacts.getFirstName())) {
            isAvailable = true;
            System.out.println("Contact Deleted ");
            contacts = null;
        }
        if (!isAvailable) {
            System.out.println("Contact Number Not found ");
        }
    }
}
