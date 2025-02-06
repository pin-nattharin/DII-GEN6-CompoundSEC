public class Main {
    public static void testCard(Card card) {
        //card.accessArea();
        //card.accessSystem();
    }

    public static void main(String[] args) {
        // สร้างตัวแปรประเภทต่างๆ
        Card employee = new EmployeeCard();
        Card manager = new ManagerCard();
        Card admin = new AdminCard();
        Card visitor = new VisitorCard();

        // ทดสอบการใช้งาน
        System.out.println("Employee Card:");
        testCard(employee);

        System.out.println("\nManager Card:");
        testCard(manager);

        System.out.println("\nAdmin Card:");
        testCard(admin);

        System.out.println("\nVisitor Card:");
        testCard(visitor);
    }
}
