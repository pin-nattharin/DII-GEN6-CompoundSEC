class VisitorCard extends Card {
    //@Override
    public void accessArea() {
        System.out.println("Accessing: Lobby, Guest Room, Meeting Room (by appointment)");
    }

    //@Override
    public void accessSystem() {
        System.out.println("Limited access to guest-related systems.");
    }
}
