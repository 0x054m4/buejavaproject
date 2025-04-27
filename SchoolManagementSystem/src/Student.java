import java.util.ArrayList;
<<<<<<< Updated upstream

=======
import java.util.List;
>>>>>>> Stashed changes

public class Student {
    private int studentID;
    private String name;
    private String email;
    private float annualFee;
<<<<<<< Updated upstream
    private ArrayList<Module> enrolledModule;
    private ArrayList<Assessment> assignedAssessment;
=======
    
>>>>>>> Stashed changes
    public Student(int studentID) {
        this.studentID = studentID;
    }

<<<<<<< Updated upstream
    public Student(String name, String email, float annualFee, ArrayList<Module> enrolledModule, ArrayList<Assessment> assignedAssessment) {
        this.name = name;
        this.email = email;
        this.annualFee = annualFee;
        this.enrolledModule = enrolledModule;
        this.assignedAssessment = assignedAssessment;
=======
    
    public Student(String name, String email, float annualFee) {
        this.name = name;
        this.email = email;
        this.annualFee = annualFee;
>>>>>>> Stashed changes
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
    
    
    public void setAnnualFee(float annualFee) {
        this.annualFee = annualFee;
    }

    public float getAnnualFee() {
        return annualFee;
    }

<<<<<<< Updated upstream
    public void setEnrolledModule(ArrayList<Module> enrolledModule) {
        this.enrolledModule = enrolledModule;
    }

    public ArrayList<Module> getEnrolledModule() {
        return enrolledModule;
    }

    public void setAssignedAssessment(ArrayList<Assessment> assignedAssessment) {
        this.assignedAssessment = assignedAssessment;
    }

    public ArrayList<Assessment> getAssignedAssessment() {
        return assignedAssessment;
    }



=======
    
    public void createAccount(ArrayList<Student> students, Student newStudent) {
        this.studentID = students.size() + 1;
        students.add(newStudent);
    }

    
    public void manageAccount(ArrayList<Student> students, Student updatedStudent) {
        for (Student s : students) {
            if (s.getStudentID() == updatedStudent.getStudentID()) {
                s.setName(updatedStudent.getName());
                s.setEmail(updatedStudent.getEmail());
                s.setAnnualFee(updatedStudent.getAnnualFee());
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
>>>>>>> Stashed changes
}
