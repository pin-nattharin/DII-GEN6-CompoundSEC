class EmployeeCard extends Card {
    private String employeeName;
    private String employeeID;

    public EmployeeCard() {
        this.employeeName = "unknow";
        this.employeeID = "xxxxxxx";
    }

    public EmployeeCard(String name, String id) {
        this.employeeName = name;
        this.employeeID = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String name) {
        this.employeeName = name;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String id) {
        this.employeeID = id;
    }

    //@Override
    public void accessArea() {
        System.out.println("Accessing: Office, Computer Room, Restroom, Common Areas");
    }

    //@Override
    public void accessSystem() {
        System.out.println("Access to basic work-related systems.");
    }
}
