public class Main {
    public static void main(String[] args) {
        // สร้างอ็อบเจ็กต์ของคลาสต่าง ๆ
        Employee emp1 = new GeneralEmployee("E001", "John Doe");
        Employee emp2 = Manager.getInstance("M001", "Jane Smith");
        Employee emp3 = new Ceo("C001", "Alice Johnson");
        Intern intern = new Intern("I001", "Bob Brown");

        // ใช้ Upcasting เพื่อจัดการพนักงานประเภทต่าง ๆ เป็นประเภทเดียวกัน
        Employee[] employees = { emp1, emp2, emp3 };

        // ตรวจสอบสิทธิ์การเข้าถึง
        for (Employee emp : employees) {
            emp.displayInfo();
            emp.checkAccess("Floor 1");
            emp.checkAccess("Server Room");
            System.out.println("----------------------------------------------------------------------------------------");
        }

        // แสดงข้อมูลของ Intern และตรวจสอบสิทธิ์การเข้าถึง
        intern.displayInfo();
        intern.checkAccess("Floor 1");
        System.out.println("----------------------------------------------------------------------------------------");

        // ใช้ Decorator Pattern เพื่อเพิ่มเงื่อนไขการจำกัดเวลา
        AccessControl timeBasedAccess = new TimeBasedAccessDecorator(intern);
        timeBasedAccess.checkAccess("Floor 1");

        // เรียกใช้เมธอดเฉพาะของ Manager
        if (emp2 instanceof Manager) {
            Manager manager = (Manager) emp2;  // Downcasting
            manager.conductMeeting();
        }

        for (Employee emp : employees) {
            System.out.println("----------------------------------------------------------------------------------------");
            emp.showAccessLogs();
        }
    }
}