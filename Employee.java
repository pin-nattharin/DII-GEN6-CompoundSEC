class Employee {
    // ข้อมูลสำคัญจะถูกตั้งเป็น private เพื่อป้องกันการเข้าถึงจากภายนอก
    private String employeeName;
    private String employeeID;

    // Constructor สำหรับการสร้าง Employee ใหม่
    public Employee(String name, String id) {
        this.employeeName = name;
        this.employeeID = id;
    }

    // Getter สำหรับเข้าถึงข้อมูลชื่อพนักงาน
    public String getEmployeeName() {
        return employeeName;
    }

    // Setter สำหรับตั้งค่าชื่อพนักงาน
    public void setEmployeeName(String name) {
        if (name != null && !name.isEmpty()) {
            this.employeeName = name;
        } else {
            System.out.println("Invalid name.");
        }
    }

    // Getter สำหรับเข้าถึงข้อมูลรหัสพนักงาน
    public String getEmployeeID() {
        return employeeID;
    }

    // Setter สำหรับตั้งค่ารหัสพนักงาน
    public void setEmployeeID(String id) {
        if (id != null && !id.isEmpty()) {
            this.employeeID = id;
        } else {
            System.out.println("Invalid ID.");
        }
    }

    // เมธอดที่แสดงข้อมูลของพนักงาน
    public void displayEmployeeInfo() {
        System.out.println("Employee Name: " + getEmployeeName());
        System.out.println("Employee ID: " + getEmployeeID());
    }
}
