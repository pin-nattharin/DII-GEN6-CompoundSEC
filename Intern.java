public class Intern implements AccessControl {
    private String id;
    private String name;

    public Intern(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean checkAccess(String area) {
        // Intern สามารถเข้าถึงได้เฉพาะชั้น 1 และห้องทั่วไป
        if (area.equals("Floor 1") || area.equals("Room 101")) {
            System.out.println("Access granted for Intern at " + area);
            return true;
        } else {
            System.out.println("Access denied for Intern at " + area);
            return false;
        }
    }
}