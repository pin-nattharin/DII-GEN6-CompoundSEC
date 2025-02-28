public class GeneralEmployee extends Employee {
    public GeneralEmployee(String id, String name) {
        super(id, name, "General Employee");
    }

    // Override เมธอด checkAccess
    @Override
    public boolean checkAccess(String area) {
        // พนักงานทั่วไปสามารถเข้าถึงได้เฉพาะชั้น 1 และห้องทั่วไป
        if (area.equals("Floor 1") || area.equals("Room 101")) {
            System.out.println("Access granted for General Employee at " + area);
            return true;
        } else {
            System.out.println("Access denied for General Employee at " + area);
            return false;
        }
    }
}