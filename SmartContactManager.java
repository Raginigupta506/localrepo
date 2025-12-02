import java.util.ArrayList;
import java.util.Scanner;

// Contact class to store contact details
class Contact {
    int id;
    String name;
    String phone;
    String email;

    Contact(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    void displayContact() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("-----------------------------------");
    }
}

// Main class
public class SmartContactManager {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static int nextId = 1;

    // Add new contact
    private static void addContact() {
        System.out.print("Enter Name: ");
        sc.nextLine(); // consume newline
        String name = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        contacts.add(new Contact(nextId++, name, phone, email));
        System.out.println("✅ Contact added successfully!\n");
    }

    // View all contacts
    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.\n");
            return;
        }

        System.out.println("\n----- All Contacts -----");
        for (Contact contact : contacts) {
            contact.displayContact();
        }
    }

    // Search contact by name
    private static void searchContact() {
        sc.nextLine();
        System.out.print("Enter Name to Search: ");
        String name = sc.nextLine();
        boolean found = false;

        for (Contact contact : contacts) {
            if (contact.name.equalsIgnoreCase(name)) {
                contact.displayContact();
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ Contact not found.\n");
        }
    }

    // Delete contact by ID
    private static void deleteContact() {
        System.out.print("Enter Contact ID to Delete: ");
        int id = sc.nextInt();

        for (Contact contact : contacts) {
            if (contact.id == id) {
                contacts.remove(contact);
                System.out.println("🗑 Contact deleted successfully!\n");
                return;
            }
        }

        System.out.println("❌ Contact not found.\n");
    }

    // Main menu
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("===== Smart Contact Manager =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> searchContact();
                case 4 -> deleteContact();
                case 5 -> System.out.println("Exiting... Thank you for using Smart Contact Manager!");
                default -> System.out.println("Invalid choice! Try again.\n");
            }
        } while (choice != 5);

        sc.close();
    }
}
