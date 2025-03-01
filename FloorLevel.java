enum FloorLevel {
    LOW, MEDIUM, HIGH, NONE;

    // กำหนดว่าชั้นไหนอยู่ในระดับอะไร
    public static FloorLevel getFloorLevel(int floor) {
        if (floor >= 1 && floor <= 3) return LOW;
        if (floor >= 4 && floor <= 6) return MEDIUM;
        if (floor >= 7 && floor <= 10) return HIGH;
        return NONE;
    }
}
