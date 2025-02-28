public class TimeBasedAccessDecorator implements AccessControl {
    private AccessControl accessControl;

    public TimeBasedAccessDecorator(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    @Override
    public boolean checkAccess(String area) {
        // ตรวจสอบเวลา (ตัวอย่าง: อนุญาตเฉพาะเวลา 9:00 - 17:00)
        int currentHour = java.time.LocalTime.now().getHour();
        if (currentHour >= 9 && currentHour <= 17) {
            System.out.println("Time-based access granted for " + area);
            return accessControl.checkAccess(area);
        } else {
            System.out.println("Access denied for " + area + " (Outside working hours)");
            return false;
        }
    }
}