public class Enrollment {
    private int enrollmentID;
    private Student student;
    private Module module;
    private Status enrollmentStatus;

    public Enrollment(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public Enrollment(Student student, Module module, Status enrollmentStatus) {
        this.student = student;
        this.module = module;
        this.enrollmentStatus = enrollmentStatus;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public Student getStudent() {
        return student;
    }
    public void setModule(Module module) {
        this.module = module;
    }
    public Module getModule() {
        return module;
    }

    public void setEnrollmentStatus(Status enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public Status getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setStatus(Status status) {
        this.enrollmentStatus = status;
    }

    public Status getStatus() {
        return enrollmentStatus;
    }
}

enum Status {
    ACTIVE, CANCELED;
}
