// 🔹 Strategy: Manager เข้าได้เฉพาะ Medium และ Low Floor
class ManagerAccess implements AccessStrategy {
    @Override
    public boolean checkAccess(int floor, RoomType room) {
        FloorLevel level = FloorLevel.getFloorLevel(floor);
        return (level == FloorLevel.LOW || level == FloorLevel.MEDIUM)
                && (room == RoomType.LOBBY || room == RoomType.OFFICE || room == RoomType.SERVER_ROOM);
    }
}