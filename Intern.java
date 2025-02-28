import java.util.ArrayList;
import java.util.List;

public class Intern implements AccessControl {
    private String id;
    private String name;
    private List<String> accessLogs;  // บันทึกการเข้าถึง

    public Intern(String id, String name) {
        this.id = id;
        this.name = name;
        this.accessLogs = new ArrayList<>();
    }

    // เมธอดแสดงข้อมูลของ Intern
    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Role: Intern");
    }

    // เมธอดบันทึกการเข้าถึง
    public void logAccess(String area, boolean isGranted) {
        String logEntry = "Card ID: " + id + ", Area: " + area + ", Access: " + (isGranted ? "Granted" : "Denied") + ", Time: " + java.time.LocalDateTime.now();
        accessLogs.add(logEntry);
        System.out.println(logEntry);
    }

    @Override
    public boolean checkAccess(String area) {
        // Intern สามารถเข้าถึงได้เฉพาะชั้น 1 และห้องทั่วไป
        boolean isGranted = area.equals("Floor 1") || area.equals("Room 101");
        logAccess(area, isGranted);  // บันทึกการเข้าถึง
        return isGranted;
    }
}