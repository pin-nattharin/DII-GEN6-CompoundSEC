// 🔹 Subclass: Ceo
class Ceo extends Employee {
    public Ceo(String id, String name) {
        super(id, name, RoleType.CEO, new CeoAccess());
    }
}