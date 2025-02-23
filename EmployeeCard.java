class EmployeeCard {
    private String cardID;  // บัตร ID (ซ่อนไม่ให้เข้าถึงโดยตรง)
    private String employeeName;
    private String accessLevel; // สิทธิ์การเข้าถึง (Low, Medium, High Floor)
    private boolean isActive;  // สถานะบัตร (Active/Revoked)

    // Constructor
    public EmployeeCard(String cardID, String employeeName, String accessLevel) {
        this.cardID = cardID;
        this.employeeName = employeeName;
        this.accessLevel = accessLevel;
        this.isActive = true; // ค่าเริ่มต้นคือบัตรใช้งานได้
    }

    // Getter เท่านั้น ไม่มี Setter เพื่อป้องกันการเปลี่ยนค่า ID จากภายนอก
    public String getCardID() {
        return cardID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public boolean isActive() {
        return isActive;
    }

    // Setter สำหรับเปลี่ยนสิทธิ์การเข้าถึง
    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    // Method ซ่อนข้อมูลภายในและใช้ฟังก์ชันควบคุมการเปลี่ยนแปลงข้อมูล
    public void deactivateCard() {
        this.isActive = false;  // บัตรถูกเพิกถอน
    }

    public void activateCard() {
        this.isActive = true;  // บัตรถูกเปิดใช้งานอีกครั้ง
    }
}
