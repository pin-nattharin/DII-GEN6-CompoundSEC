package src;

public class Main {
    public static void main(String[] args) {
        // สร้างออบเจ็กต์จาก StudentRegistration
        Registration studentReg = new StudentRegistration("John Doe", "Computer Science");
        studentReg.registerStudent("John Doe", "Computer Science");
        studentReg.displayDetails();

        // สร้างออบเจ็กต์จาก OnlineRegistration
        Registration onlineReg = new OnlineRegistration("Jane Doe", "Data Science");
        onlineReg.registerStudent("Jane Doe", "Data Science");
        onlineReg.displayDetails();
    }
}