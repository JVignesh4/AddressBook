import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    ArrayList<Contacts> list = new ArrayList<Contacts>();
    Scanner scanner = new Scanner(System.in);

    public void addContact(){
        Contacts contacts = new Contacts();

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

        list.add(contacts);
        System.out.println(contacts);
    }
    public void showContacts() {
        for (Contacts contacts : list) {
            System.out.println("Contacts{" +
                    "firstName='" + contacts.getFirstName() + '\'' +
                    ", lastName='" + contacts.getLastName() + '\'' +
                    ", city='" + contacts.getCity() + '\'' +
                    ", state='" + contacts.getState() + '\'' +
                    ", zipCode='" + contacts.getZipCode() + '\'' +
                    ", phNumber='" + contacts.getPhNumber()+ '\'' +
                    ", eMail='" + contacts.geteMail() + '\'' +
                    '}');
        }
    }
    public void editContact() {

        System.out.println("Enter the first name");
        String firstName = scanner.next();
        boolean isAvailable = false;

        for (Contacts contacts : list) {
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
                break;
            }
        }if (!isAvailable) {
                System.out.println("Contact is Not found ");
            }
    }
    public void deleteContact(){
        System.out.println("Enter the first name");
        String firstName = scanner.next();

        boolean isAvailable = false;
        for (Contacts contacts : list) {
            if (firstName.equalsIgnoreCase(contacts.getFirstName())) {
                isAvailable = true;
                System.out.println("Contact Deleted ");
                contacts = null;
            }
        }
        if (!isAvailable) {
            System.out.println("Contact Number Not found ");
        }
    }
}
