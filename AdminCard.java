class AdminCard extends Card {
    public AdminCard(String name, String id) {
        super(name, id);
    }

    public AdminCard() {
        super();
    }

    //@Override
    public void accessArea() {
        System.out.println("Accessing: All Areas, System Settings, Database Access");
    }

    //@Override
    public void accessSystem() {
        System.out.println("Full access to all systems, including administrative tools.");
    }
}
