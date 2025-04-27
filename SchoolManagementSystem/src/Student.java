import java.util.ArrayList;

public class Student {
    private static int studentCounter = 0;
    private int studentID;
    private String name;
    private String email;
    private float annualFee;
    private int year;
    
    public Student(int studentID) {
        this.studentID = studentID;
    }
    
    public Student(String name, String email, float annualFee, int year) {
        this.name = name;
        this.email = email;
        this.annualFee = annualFee;
        this.year = year;
        this.studentID = studentCounter++;
    }

    public int getStudentID() {
        return studentID;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getYear() {
        return year;
    }
    
    
    public void setAnnualFee(float annualFee) {
        this.annualFee = annualFee;
    }

    public float getAnnualFee() {
        return annualFee;
    }

    
    public void createAccount(ArrayList<Student> students, Student newStudent) {
        students.add(newStudent);
    }

    
    public void manageAccount(ArrayList<Student> students) {
        for (Student s : students) {
            if(s.getStudentID() == this.studentID) {
                students.remove(s);
                students.add(this);
            }
        }
    }

    
    public void viewCourses(ArrayList<Enrollment> enrollments) {
        System.out.println("Courses for Student ID: " + this.studentID);
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().getStudentID() == this.studentID) {
                System.out.println("- " + enrollment.getModule().getModuleName());
            }
        }
    }
    public void removeAccount(ArrayList<Student> students) {
        for (Student s : students) {
            if(s.getStudentID() == this.studentID) {
                students.remove(s);
            }
        }
    }

    public boolean login(){
      return true;
    }
}
