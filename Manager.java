public class Manager extends Employee {
    // Constructor เป็น private เพื่อป้องกันการสร้างอินสแตนซ์จากภายนอก
    public Manager(String id, String name) {
        super(id, name, RoleType.MANAGER, new ManagerAccess());
    }
}