public abstract class Employee implements AccessControl {
    // ใช้ Data Hiding โดยกำหนด attributes เป็น private
    private String id;
    private String name;
    private String role;

    // Constructor
    public Employee(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
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

    // เมธอด abstract ที่ต้องถูก override โดยคลาสลูก
    public abstract boolean checkAccess(String area);
}