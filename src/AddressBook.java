import java.util.*;

public class AddressBook {
    static HashMap<String, AddressBook> addressBookMap = new HashMap<>();
    static ArrayList<Contacts> contactList = new ArrayList<Contacts>();
    Contacts contacts;
    static Scanner scanner = new Scanner(System.in);

    public Contacts addContact() {
        System.out.println("Enter the First Name :");
        String fName = scanner.nextLine();

        System.out.println("Enter the Last Name :");
        String lName = scanner.nextLine();

        System.out.println("Enter the City :");
        String city = scanner.nextLine();

        System.out.println("Enter the State :");
        String state = scanner.nextLine();

        System.out.println("Enter the Phone Number :");
        String phName = scanner.nextLine();

        System.out.println("Enter the Zip Code :");
        String zipCode = scanner.nextLine();

        System.out.println("Enter the E-Mail :");
        String EMail = scanner.nextLine();

        contactList.add(new Contacts(fName, lName, city, state, phName, zipCode, EMail));
        return contacts;
    }

    public void showContacts() {
        for (Contacts contacts : contactList) {
            System.out.println("Contacts{" +
                    "firstName='" + contacts.getFirstName() + '\'' +
                    ", lastName='" + contacts.getLastName() + '\'' +
                    ", city='" + contacts.getCity() + '\'' +
                    ", state='" + contacts.getState() + '\'' +
                    ", zipCode='" + contacts.getZipCode() + '\'' +
                    ", phNumber='" + contacts.getPhNumber() + '\'' +
                    ", eMail='" + contacts.getEMail() + '\'' +
                    '}');
        }
        System.out.println(addressBookMap);
    }

    public void editContact() {

        System.out.println("Enter the first name");
        String firstName = scanner.next();
        boolean isAvailable = false;

        for (Contacts contacts : contactList) {
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
                contacts.setEMail(scanner.next());
                break;
            }
        }
        if (!isAvailable) {
            System.out.println("Contact is Not found ");
        }
    }

    public void duplicateEntry() {
        boolean flag = false;
        Contacts personDetails = addContact();
        for (Contacts objPerson : contactList) {
            if (objPerson.getFirstName().equals(personDetails.getFirstName())) {
                flag = true;
            }
        }
        if (!flag) {
            contactList.add(personDetails);
        } else {
            System.out.println("First Name already exist..");
        }
    }

    public void deleteContact() {
        System.out.println("Enter the first name");
        String firstName = scanner.next();

        boolean isAvailable = false;
        for (Contacts contacts : contactList) {
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

    public void addNewAddressBook() {
        System.out.println("Enter the Address Book Name  : ");
        String addressBookName = scanner.next();
        if (addressBookMap.containsKey(addressBookName)) {
            System.out.println("Entered AddressBook is Already Available");
        } else {
            AddressBook addressBook = new AddressBook();
            addressBookMap.put(addressBookName, addressBook);
        }
    }

    public void addressBookMenu() {

        System.out.println("Welcome TO Address Book");
        boolean flag = false;
        int choice;
        do {
            String bookName = "";
            AddressBook addressBook;
            System.out.println("Welcome to Address Book System ");
            choice = inputInteger("1.Add a New Address Book" +
                    "\n 2.Edit Address Book \n 3. Display Address Book \n 4. Search by City \n 5. Search by State " +
                    "\n 6. EXIT");
            switch (choice) {
                case 1:
                    addNewAddressBook();
                    menu();
                    break;
                case 2:
                    if (!addressBookMap.isEmpty()) {
                        displayBooks();
                        bookName = inputString("Enter Address Book Name to Access: ");
                        addressBookMap.get(bookName);
                    } else {
                        System.out.println("No Address Books are present");
                    }
                    break;
                case 3:
                    System.out.println("List Of Available Address Book ");
                    Set keys = addressBookMap.keySet();
                    Iterator i = keys.iterator();
                    while (i.hasNext()) {
                        System.out.println(i.next());
                    }
                    break;
                case 4:
                    searchPersonCity();
                    break;
                case 5:
                    searchPersonState();
                    break;
                case 6:
                    System.out.println("Thanks For Using!");
                    flag = true;
                    break;
            }
        } while (!flag);
    }


    public void menu() {
        System.out.println("Welcome To Address Book Programme");

        boolean flag = false;
        int choice;
        do {
            System.out.println("Kindly Enter choice \n 1. Add new Contact \n 2. Edit Contact details \n 3. Delete" +
                    "\n 4. Display Contacts \n 5. Exit ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact();
                    System.out.println("Contact Added Successfully!!");
                    break;
                case 2:
                    editContact();
                    System.out.println("Contact Edited Successfully!!");
                    break;
                case 3:
                    deleteContact();
                    System.out.println("Contact Deleted Successfully!!");
                    break;
                case 4:
                    showContacts();
                    break;
                case 5:
                    System.out.println("Thanks For Using");
                    flag = true;
                    break;
                default:
                    System.out.println("Please Enter the correct Choice");
            }
        } while (!flag);

    }

    public static void displayBooks() {
        for (String books : addressBookMap.keySet()) {
            System.out.println(books);
        }
    }

    public static int inputInteger(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
    public static String inputString(String message) {
        System.out.println(message);
        return scanner.next().toLowerCase();
    }
    public static void searchPersonCity() {
        System.out.println("Enter City name");
        String city = scanner.next();
        contactList.stream().filter(person -> person.getCity().equalsIgnoreCase(city)).forEach(System.out::println);
    }

    public static void searchPersonState() {
        System.out.println("Enter State name");
        String state = scanner.next();
        contactList.stream().filter(person -> person.getState().equalsIgnoreCase(state)).forEach(System.out::println);
    }

}
