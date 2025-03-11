import java.util.*;

public class Module {
    private int moduleID;
    private String moduleName;
    private ArrayList<Student> enrolledStudents;

    // Constructors
    public Module(int moduleID) {
        this.moduleID = moduleID;
        this.enrolledStudents = new ArrayList<>();
    }

    public Module(String moduleName, ArrayList<Student> enrolledStudents) {
        this.moduleName = moduleName;
        this.enrolledStudents = enrolledStudents;
    }

    // Getters and Setters
    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }

    public int getModuleID() {
        return moduleID;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setEnrolledStudents(ArrayList<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    // Methods
    public boolean addStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }

    public boolean removeStudent(int studentID) {
        return enrolledStudents.removeIf(student -> student.getStudentID() == studentID);
    }
}
