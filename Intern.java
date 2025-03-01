// 🔹 Subclass: Intern
class Intern extends Employee {
    public Intern(String id, String name) {
        super(id, name, RoleType.INTERN, new InternAccess());
    }
}