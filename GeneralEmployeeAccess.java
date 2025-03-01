// Strategy: พนักงานทั่วไป เข้าได้แค่ Low Floor และเฉพาะ Lobby กับ Office
// Override checkAccess() ในคลาสที่ Implement Interface
class GeneralEmployeeAccess implements AccessStrategy {
    @Override
    public boolean checkAccess(int floor, RoomType room) {
        FloorLevel level = FloorLevel.getFloorLevel(floor);
        return (level == FloorLevel.LOW) && (room == RoomType.LOBBY || room == RoomType.OFFICE);
    }
}