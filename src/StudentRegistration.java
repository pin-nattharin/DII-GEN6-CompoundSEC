class StudentRegistration extends Registration {
    private String studentName;
    private String courseName;

    //@Override
    public void displayDetails() {
        System.out.println("Student: " + studentName);
        System.out.println("Course: " + courseName);
    }

    public StudentRegistration(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }
}
