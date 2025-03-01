// 🔹 Subclass: General Employee
class GeneralEmployee extends Employee {
    public GeneralEmployee(String id, String name) {
        super(id, name, RoleType.GENERALEMPLOYEE, new GeneralEmployeeAccess());
    }
}