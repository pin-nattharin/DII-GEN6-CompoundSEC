// คลาส Abstract สำหรับการลงทะเบียนเรียน
abstract class Registration {
    // เมธอดที่มีการกำหนดการทำงานบางส่วน (สามารถใช้ได้ทันที)
    public void registerStudent(String studentName, String courseName) {
        System.out.println(studentName + " has successfully registered for " + courseName);
    }

    // เมธอดที่เป็น abstract ที่ต้องถูก implement ในคลาสที่สืบทอด
    public abstract void displayDetails();
}

