import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับข้อมูลพนักงาน
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        // เลือกบทบาท
        System.out.println("Choose Role:");
        System.out.println("1. Ceo\n2. Manager\n3. General Employee\n4. Intern");
        System.out.print("Enter Role: ");
        int roleChoice = scanner.nextInt();

        Employee employee = null;

        switch (roleChoice) {
            case 1:
                employee = new Ceo(id, name);
                break;
            case 2:
                employee = Manager.getInstance(id, name);
                break;
            case 3:
                employee = new GeneralEmployee(id, name);
                break;
            case 4:
                employee = new Intern(id, name);
                break;
            default:
                System.out.println("Invalid Role!");
                System.exit(0);
        }
        System.out.println("\n✅ Employee: " + employee.getName() + " (" + employee.getRole() + ")\n");

        // ทดสอบการเข้าถึง
        scanner.nextLine();
        System.out.print("Enter Floor (1-10): ");
        int floor = scanner.nextInt();
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
            System.out.println("✅ Access Granted to " +room +" at " +floor);
        } else {
            System.out.println("❌ Access Denied to " +room +" at " +floor);
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        employee.showAccessLogs(); // แสดง Log
        scanner.close();
    }
}