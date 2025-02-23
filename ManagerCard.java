class ManagerCard extends Card {
    public ManagerCard(String name, String id) {
        super(name, id);
    }

    public ManagerCard() {
        
    }

    //@Override
    public void accessArea() {
        System.out.println("Accessing: Meeting Room, Manager's Office, Project Areas");
    }

    //@Override
    public void accessSystem() {
        System.out.println("Access to manager-level systems and project management tools.");
    }
}
