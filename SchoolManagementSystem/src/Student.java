import java.util.ArrayList;


public class Student {
    private int studentID;
    private String name;
    private String email;
    private float annualFee;
    private ArrayList<Module> enrolledModule;
    private ArrayList<Assessment> assignedAssessment;
   
    public Student(int studentID) {
        this.studentID = studentID;
    }

    public Student(String name, String email, float annualFee, ArrayList<Module> enrolledModule, ArrayList<Assessment> assignedAssessment) {
        this.name = name;
        this.email = email;
        this.annualFee = annualFee;
        this.enrolledModule = enrolledModule;
        this.assignedAssessment = assignedAssessment;
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

    public void manageAccount(int studentID, Student newDetails) {
        if (this.studentID == studentID) {
            this.name = newDetails.getName();
            this.email = newDetails.getEmail();
            this.annualFee = newDetails.getAnnualFee();
            this.enrolledModule = newDetails.getEnrolledModule();
            this.assignedAssessment = newDetails.getAssignedAssessment();
        }
    }
}
