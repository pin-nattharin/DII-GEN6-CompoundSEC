import java.util.ArrayList;
import java.util.List;

public abstract class Employee implements AccessControl {
    // ใช้ Data Hiding โดยกำหนด attributes เป็น private
    private String id;
    private String name;
    private String role;
    private AccessCard accessCard;  // เพิ่ม AccessCard
    private List<String> accessLogs;  // บันทึกการเข้าถึง

    // Constructor
    public Employee(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    // Setter methods (แก้ไขข้อมูลผ่านเมธอด)
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
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
    public void logAccess(String area, boolean isGranted) {
        String logEntry = "Card ID: " + accessCard.getCardId() + ", Employee ID: " + accessCard.getEmployeeId() + ", Area: " + area + ", Access: " + (isGranted ? "Granted" : "Denied") + ", Time: " + java.time.LocalDateTime.now();
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

    // เมธอด abstract ที่ต้องถูก override โดยคลาสลูก
    public abstract boolean checkAccess(String area);
}