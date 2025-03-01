// Decorator Pattern: จำกัดเวลาเข้าออก
public class TimeBasedAccessDecorator implements AccessStrategy {
    private AccessStrategy accessStrategy;

    public TimeBasedAccessDecorator(AccessStrategy accessStrategy) {
        this.accessStrategy = accessStrategy;
    }

    @Override
    public boolean checkAccess(int floor, RoomType room) {
        // ตรวจสอบเวลา (ตัวอย่าง: อนุญาตเฉพาะเวลา 9:00 - 17:00)
        int currentHour = java.time.LocalTime.now().getHour();
        if (currentHour >= 9 && currentHour <= 17) {
            System.out.println("Time-based access granted for floor " + floor +" room "+room);
            return accessStrategy.checkAccess(floor,room);
        } else {
            System.out.println("Access denied for floor " + floor +" room "+room + " (Outside working hours)");
            return false;
        }
    }
}