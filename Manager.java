public class Manager extends Employee {
    public Manager(String id, String name) {
        super(id, name, RoleType.MANAGER, new ManagerAccess());
    }
}