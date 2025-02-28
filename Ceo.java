public class Ceo extends Employee {
    public Ceo(String id, String name) {
        super(id, name, "Ceo");
    }

    // Override เมธอด checkAccess
    @Override
    public boolean checkAccess(String area) {
        // Ceo สามารถเข้าถึงได้ทุกพื้นที่ รวมถึงห้องพิเศษ
        boolean isGranted = true;
        if (area.equals("Server Room")) {
            System.out.println("Special access granted for Ceo at " + area);
        }
        logAccess(area, isGranted);  // บันทึกการเข้าถึง
        return isGranted;
    }
}