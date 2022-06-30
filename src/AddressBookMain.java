import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
    static HashMap<String, AddressBook> addressBookMap = new HashMap<>();

    public static void addNewAddressBook() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Address Book Name :");
        String addressBookName = sc.next();
        if (addressBookMap.containsKey(addressBookName)) {
            System.out.println("Entered AddressBook is Already Available");
        } else {
            AddressBook addressBook = new AddressBook();
            addressBookMap.put(addressBookName, addressBook);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome To Address Book Programme");
        AddressBook addressBook = new AddressBook();

        int choice;
        do {
            addNewAddressBook();
            Scanner scan = new Scanner(System.in);
            System.out.println("Kindly Enter choice \n 1. Add new Contact \n 2. Edit Contact details \n 3. Delete" +
                    "\n 4. Exit ");

            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    addressBook.addContact();
                    break;
                case 2:
                    addressBook.editContact();
                    break;
                case 3:
                    addressBook.deleteContact();
                    break;
                case 4:
                    addressBook.showContacts();
                    System.out.println("Thanks For Using");
                    System.exit(3);
                    break;
                default:
                    System.out.println("Please Enter the correct Choice");
            }
        } while (true);

    }
}
