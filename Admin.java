public class Admin extends Employee {
    public Admin(String id, String name) {
        super(id, name, "Admin");
    }

    // Override เมธอด checkAccess
    @Override
    public boolean checkAccess(String area) {
        // Admin สามารถเข้าถึงได้ทุกพื้นที่ รวมถึงห้องพิเศษ
        if (area.equals("Server Room")) {
            System.out.println("Access granted for Admin at " + area + " (Special Access)");
        } else {
            System.out.println("Access granted for Admin at " + area);
        }
        return true;
    }
}