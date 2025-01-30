import java.util.*;

public class menu {

    // Main method to run the program
    // Print a message to the console
        System.out.println("Welcome to the menu!");

    // Example menu options
    Scanner scanner = new Scanner(System.in);
    int choice;

        while(true)

    {
        System.out.println("Please select an option:");
        System.out.println("1. Option 1");
        System.out.println("2. Option 2");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");

        choice = scanner.nextInt();

        // Handling user choice
        switch (choice) {
            case 1:
                System.out.println("You selected Option 1");
                break;
            case 2:
                System.out.println("You selected Option 2");
                break;
            case 3:
                System.out.println("Exiting...");
                scanner.close();
                return;  // Exit the program
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
}

