public class Manager extends Employee {
    // Singleton Pattern
    private static Manager instance;

    // Constructor เป็น private เพื่อป้องกันการสร้างอินสแตนซ์จากภายนอก
    private Manager(String id, String name) {
        super(id, name, "Manager");
    }

    // เมธอด static เพื่อให้เข้าถึงอินสแตนซ์เดียวของคลาส
    public static synchronized Manager getInstance(String id, String name) {
        if (instance == null) {
            instance = new Manager(id, name);
        }
        return instance;
    }

    // Override เมธอด checkAccess
    @Override
    public boolean checkAccess(String area) {
        // ผู้จัดการสามารถเข้าถึงได้ทุกพื้นที่
        logAccess(area, true);  // บันทึกการเข้าถึง
        return true;
    }

    // เมธอดเฉพาะของ Manager
    public void conductMeeting() {
        System.out.println(getName() + " is conducting a meeting.");
    }
}