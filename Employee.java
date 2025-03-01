import java.util.ArrayList;
import java.util.List;

public abstract class Employee implements AccessStrategy {
    // ใช้ Data Hiding โดยกำหนด attributes เป็น private
    private String id;
    private String name;
    private RoleType  role;
    protected AccessStrategy accessStrategy;
    private AccessCard accessCard;  // เพิ่ม AccessCard
    private List<String> accessLogs;  // บันทึกการเข้าถึง

    // Constructor
    public Employee(String id, String name, RoleType role, AccessStrategy strategy) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.accessStrategy = strategy;
        this.accessCard = new AccessCard("CARD_" + id, id);  // สร้าง AccessCard ด้วย Multi-Facades ID
        this.accessLogs = new ArrayList<>();
    }

    // Getter methods (เข้าถึงข้อมูลผ่านเมธอด)
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public RoleType  getRole() {
        return role;
    }

    // Setter methods (แก้ไขข้อมูลผ่านเมธอด)
    public void setId(String id) {
        this.id = id;
    }

    // เมธอดทั่วไปที่ใช้ร่วมกัน
    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Role: " + role);
    }

    // เมธอดตรวจสอบความถูกต้องของบัตร
    public boolean isCardValid() {
        return accessCard.isValid();
    }

    // เมธอดบันทึกการเข้าถึง
    public void logAccess(int floor, RoomType room, boolean isGranted) {
        String logEntry = "Card ID: " + accessCard.getCardId() + ", Employee ID: " + accessCard.getEmployeeId() + ", Floor: " + floor +", Room: " +room + ", Access: " + (isGranted ? "Granted" : "Denied") + ", Time: " + java.time.LocalDateTime.now();
        accessLogs.add(logEntry);
        System.out.println(logEntry);
    }

    // เมธอดแสดงบันทึกการเข้าถึง
    public void showAccessLogs() {
        System.out.println("Access logs for " + name + ":");
        for (String log : accessLogs) {
            System.out.println(log);
        }
    }

    public boolean checkAccess(int floor, RoomType room) {
        boolean result = accessStrategy.checkAccess(floor, room);
        logAccess(floor,room, result);
        return result;
    }

    // เมธอด abstract ที่ต้องถูก override โดยคลาสลูก
    //public abstract boolean checkAccess(String area);
}