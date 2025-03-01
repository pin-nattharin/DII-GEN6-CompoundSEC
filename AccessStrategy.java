public interface AccessStrategy { // Interface สำหรับ Strategy Pattern
    boolean checkAccess(int floor, RoomType room);
}