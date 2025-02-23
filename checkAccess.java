// Interface สำหรับการตรวจสอบสิทธิ์ (ซ่อนรายละเอียดการทำงานภายใน)
interface AccessChecker {
    boolean checkAccess(String userID, String area);
}
