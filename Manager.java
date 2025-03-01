public class Manager extends Employee {
    // Singleton Pattern (Override ไม่ให้สร้าง Manager ซ้ำ)
    private static Manager instance;

    // Constructor เป็น private เพื่อป้องกันการสร้างอินสแตนซ์จากภายนอก
    private Manager(String id, String name) {
        super(id, name, RoleType.MANAGER, new ManagerAccess());
    }

    // เมธอด static เพื่อให้เข้าถึงอินสแตนซ์เดียวของคลาส
    public static synchronized Manager getInstance(String id, String name) {
        if (instance == null) {
            instance = new Manager(id, name);
        }
        return instance;
    }
}