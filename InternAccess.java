// Strategy: Intern เข้าได้เฉพาะ Lobby และ Office ที่ Low Floor เท่านั้น
class InternAccess implements AccessStrategy {
    @Override
    public boolean checkAccess(int floor, RoomType room) {
        FloorLevel level = FloorLevel.getFloorLevel(floor);
        return (level == FloorLevel.LOW) && (room == RoomType.LOBBY);
    }
}