// Subclass: Ceo
class Ceo extends Employee {
    // Singleton Pattern (Override ไม่ให้สร้าง Ceo ซ้ำ)
    private static Ceo instance;

    public Ceo(String id, String name) {
        super(id, name, RoleType.CEO, new CeoAccess());
    }

    // เมธอด static เพื่อให้เข้าถึงอินสแตนซ์เดียวของคลาส
    public static synchronized Ceo getInstance(String id, String name) {
        if (instance == null) {
            instance = new Ceo(id, name);
        }
        return instance;
    }
}