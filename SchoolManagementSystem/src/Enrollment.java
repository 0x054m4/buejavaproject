import java.util.*;

public class Enrollment{
    private int enrollmentID;
    private int studentID;
    private int moduleID;
    private Status enrollmentStatus;
    public enum Status {
        ACTIVE, CANCELLED;
    }

    //Constructors
    Enrollment(int enrollmentID){
        this.enrollmentID = enrollmentID;
    }

    Enrollment(int studentID, int moduleID, Status enrollmentStatus){
        this.studentID = studentID;
        this.moduleID = moduleID;
        this.enrollmentStatus = enrollmentStatus;
    }

    //Getters and Setters
    public void setEnrollmentID(int enrollmentID){
        this.enrollmentID = enrollmentID;
    }

    public int getEnrollmentID(){
        return enrollmentID;
    }
    
    public void setStudentID(int enrollmentID){
        this.studentID = studentID;
    }

    public int getStudentID(){
        return studentID;
    }

    public void setModuleID(int moduleIDID){
        this.moduleID = moduleID;
    }

    public int getModuleID(){
        return moduleID;
    }

    public void setEnrollmentStatus(Status enrollmentStatus){
        this.enrollmentStatus = enrollmentStatus;
    }

    public int getEnrollmentID(){
        return enrollmentID;
    }

    public void approveEnrollment(){
        
    }
}