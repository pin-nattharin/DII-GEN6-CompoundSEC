public class Ceo extends Employee {
    // Singleton Pattern
    private static Ceo instance;

    public Ceo(String id, String name) {
        super(id, name, "Ceo");
    }

    // เมธอด static เพื่อให้เข้าถึงอินสแตนซ์เดียวของคลาส
    public static synchronized Ceo getInstance(String id, String name) {
        if (instance == null) {
            instance = new Ceo(id, name);
        }
        return instance;
    }

    // Override เมธอด checkAccess
    @Override
    public boolean checkAccess(String area) {
        // ตรวจสอบความถูกต้องของบัตรก่อนอนุญาตให้เข้าถึง
        if (!isCardValid()) {
            System.out.println("Access denied: Invalid card");
            logAccess(area, false);
            return false;
        }
        // Ceo สามารถเข้าถึงได้ทุกพื้นที่ รวมถึงห้องพิเศษ
        boolean isGranted = true;
        if (area.equals("Server Room")) {
            System.out.println("Special access granted for Ceo at " + area);
        }
        logAccess(area, isGranted);  // บันทึกการเข้าถึง
        return isGranted;
    }
}