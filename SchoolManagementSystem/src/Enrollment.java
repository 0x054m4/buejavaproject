public class Enrollment {
    private int enrollmentID;
    private int studentID;
    private int moduleID;
    private Status enrollmentStatus;

    public Enrollment(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public Enrollment(int studentID, int moduleID, Status enrollmentStatus) {
        this.studentID = studentID;
        this.moduleID = moduleID;
        this.enrollmentStatus = enrollmentStatus;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }

    public int getModuleID() {
        return moduleID;
    }

    public void setEnrollmentStatus(Status enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public Status getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setActive() {
        enrollmentStatus = Status.ACTIVE;
    }

    public void setCancelled() {
        enrollmentStatus = Status.CANCELED;
    }

    public boolean isActive() {
        return enrollmentStatus == Status.ACTIVE;
    }

    public Status status() {
        return enrollmentStatus;
    }
}

enum Status {
    ACTIVE, CANCELED;
}
