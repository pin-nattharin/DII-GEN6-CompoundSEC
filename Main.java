import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับข้อมูลพนักงาน
        //System.out.print("Enter Employee ID: ");
        //String id = scanner.nextLine();
        //System.out.print("Enter Employee Name: ");
        //String name = scanner.nextLine();

        Employee employee1 = Ceo.getInstance("C001","Bob");
        Employee employee2 = new Manager("M001","Kim");
        Employee employee3 = new GeneralEmployee("G001","James");
        Employee employee4 = new Intern("I001","Kate");

        // สร้าง CardManager
        CardManager cardManager = CardManager.getInstance();

        // สร้างบัตรและเพิ่มลงใน CardManager
        cardManager.addCard(employee1.getId(), employee1.getName(), employee1.getRole());
        cardManager.addCard(employee2.getId(), employee2.getName(), employee2.getRole());
        cardManager.addCard(employee3.getId(), employee3.getName(), employee3.getRole());
        cardManager.addCard(employee4.getId(), employee4.getName(), employee4.getRole());

        Employee employee = null;

        // เลือกบทบาท
        System.out.println("Choose Role:");
        System.out.println("1. Ceo\n2. Manager\n3. General Employee\n4. Intern");
        System.out.print("Enter Role: ");
        int roleChoice = scanner.nextInt();

        switch (roleChoice) {
            case 1:
                employee = employee1;
                break;
            case 2:
                employee = employee2;
                break;
            case 3:
                employee = employee3;
                break;
            case 4:
                employee = employee4;
                break;
            default:
                System.out.println("Invalid Role!");
                System.exit(0);
        }
        System.out.println("\n✅ Employee: " + employee.getName() + " (" + employee.getRole() + ")\n");

        // ทดสอบการเข้าถึง
        scanner.nextLine();
        String level = "";
        System.out.print("Enter Floor (1-10): ");
        int floor = scanner.nextInt();

        if(floor >= 1 && floor <= 3) {
            level = "Low";
        } else if (floor >= 4 && floor <= 6) {
            level = "Medium";
        } else if (floor >= 7 && floor <= 10) {
            level = "High";
        }

        // แสดงตัวเลือกห้อง
        System.out.println("Available Rooms: LOBBY, OFFICE, SERVER_ROOM, VIP_ROOM");
        System.out.print("Enter Room Name: ");
        String roomInput = scanner.next().toUpperCase();

        // ตรวจสอบห้องที่ผู้ใช้กรอก
        RoomType room;
        try {
            room = RoomType.valueOf(roomInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Room Type!");
            return;
        }

        if (employee.checkAccess(floor, room)) {
            System.out.println("✅ Access Granted to " + room + " at floor " + floor +" ("+level+")");
        } else {
            System.out.println("❌ Access Denied to " + room + " at floor " + floor +" ("+level+")");
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        employee.showAccessLogs(); // แสดง Log
        //scanner.close();

        while (true) {
            System.out.println("\n1. Add Card\n2. Modify Card Permission\n3. Revoke Card\n4. Check Access\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 5) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter Card ID: ");
                    String newCardID = scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Role (CEO, MANAGER, GENERAL_EMPLOYEE, INTERN): ");
                    RoleType newRole = RoleType.valueOf(scanner.nextLine().toUpperCase());
                    cardManager.addCard(newCardID, name, newRole);
                    break;
                case 2:
                    System.out.print("Enter Card ID to Modify: ");
                    String modCardID = scanner.nextLine();
                    System.out.print("Enter New Role: ");
                    RoleType modRole = RoleType.valueOf(scanner.nextLine().toUpperCase());
                    cardManager.modifyCard(modCardID, modRole);
                    break;
                case 3:
                    System.out.print("Enter Card ID to Revoke: ");
                    String revCardID = scanner.nextLine();
                    cardManager.revokeCard(revCardID);
                    break;
                case 4:
                    System.out.print("Enter Card ID: ");
                    String checkCardID = scanner.nextLine();
                    AccessCard card = cardManager.getCard(checkCardID);
                    if (card != null) {
                        System.out.println("✅ Card Found: " + card.getCardID() + " with Role: " + card.getRole());
                    } else {
                        System.out.println("❌ Card Not Found!");
                    }
                    break;
                default:
                    System.out.println("❌ Invalid Option!");
            }
        }
    }
}
