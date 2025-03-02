// Strategy: Ceo เข้าได้ทุกชั้นและทุกห้อง
class CeoAccess implements AccessStrategy {
    @Override
    public boolean checkAccess(int floor, RoomType room) {
        return true; // เข้าได้ทุกที่
    }
}