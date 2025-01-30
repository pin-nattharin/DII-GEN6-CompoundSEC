// คลาสที่สืบทอดจาก Abstract Class Registration
class OnlineRegistration extends Registration {
    private String studentName;
    private String courseName;

    @Override
    public void displayDetails() {
        System.out.println("Online Registration");
        System.out.println("Student: " + studentName);
        System.out.println("Course: " + courseName);
    }

    public OnlineRegistration(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }
}