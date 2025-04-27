import java.util.ArrayList;

public class Enrollment implements IEnrollment {
    private static int enrollmentCounter = 0;
    private int enrollmentID;
    private Student student;
    private Module module;
    private Status enrollmentStatus;
    private float grade;

    public Enrollment(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public Enrollment(Student student, Module module, Status enrollmentStatus){
        this.student = student;
        this.module = module;
        this.enrollmentStatus = enrollmentStatus;
        grade = 0.0f;
        this.enrollmentID = enrollmentCounter++;
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
    public void setGrade(float grade) {
        this.grade = grade;
    }
    public float getGrade() {
        return grade;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Module getModule() {
        return module;
    }


    public Status getEnrollmentStatus() {
        return enrollmentStatus;
    }


    public void generateReports(ArrayList<Enrollment> enrollments, Module module) {
        int enrolledStudents = 0;
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getModule().equals(module)) {
                enrolledStudents++;
            }
        }
        System.out.println("Module: " + module.getModuleName());
        System.out.println("Total Enrolled Students: " + enrolledStudents);
        System.out.println("Max Capacity: " + module.getMaxCapacity());
        System.out.println("Status: " + (enrolledStudents >= module.getMaxCapacity() ? "Full" : "Available"));
    }

    
    public void addEnrollment(ArrayList<Enrollment> enrollments) {
        enrollments.add(this);
    }

    
    public void removeEnrollment(ArrayList<Enrollment> enrollments) {
        enrollments.remove(this);
    }

    
    public void updateEnrollment(ArrayList<Enrollment> enrollments) {
        for (int i = 0; i < enrollments.size(); i++) {
            if (enrollments.get(i).getEnrollmentID() == this.enrollmentID) {
                enrollments.set(i, this);
                break;
            }
        }
    }
    
    public void deleteEnrollment(ArrayList<Enrollment> enrollments) {
        enrollments.remove(this);
    }
    
    public static void listAllEnrollments(ArrayList<Enrollment> enrollments) {
        System.out.println("=== All Enrollments ===");
        for (Enrollment e : enrollments) {
            System.out.println("Enrollment ID: " + e.getEnrollmentID());
            System.out.println("Student: " + e.getStudent().getName() + " (ID: " + e.getStudent().getStudentID() + ")");
            System.out.println("Module: " + e.getModule().getModuleName() + " (ID: " + e.getModule().getModuleID() + ")");
            System.out.println("Status: " + e.getEnrollmentStatus());
            System.out.println("Grade: " + e.getGrade());
            System.out.println("-----------------");
        }
    }
    
    // Check if student is eligible for this enrollment
    public boolean isEligibleForEnrollment() {
        // Check if student's year matches module year
        return student.getYear() == module.getModuleYear();
    }
    
    // Get all enrollments for a specific student
    public static ArrayList<Enrollment> getEnrollmentsByStudent(ArrayList<Enrollment> enrollments, int studentID) {
        ArrayList<Enrollment> studentEnrollments = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudent().getStudentID() == studentID) {
                studentEnrollments.add(e);
            }
        }
        return studentEnrollments;
    }
    
    // Get all enrollments for a specific module
    public static ArrayList<Enrollment> getEnrollmentsByModule(ArrayList<Enrollment> enrollments, int moduleID) {
        ArrayList<Enrollment> moduleEnrollments = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getModule().getModuleID() == moduleID) {
                moduleEnrollments.add(e);
            }
        }
        return moduleEnrollments;
    }
    
    // Calculate average grade for a module
    public static float calculateModuleAverage(ArrayList<Enrollment> enrollments, int moduleID) {
        float totalGrade = 0;
        int count = 0;
        
        for (Enrollment e : enrollments) {
            if (e.getModule().getModuleID() == moduleID) {
                totalGrade += e.getGrade();
                count++;
            }
        }
        
        return count > 0 ? totalGrade / count : 0;
    }
    
    // Calculate average grade for a student
    public static float calculateStudentAverage(ArrayList<Enrollment> enrollments, int studentID) {
        float totalGrade = 0;
        int count = 0;
        
        for (Enrollment e : enrollments) {
            if (e.getStudent().getStudentID() == studentID) {
                totalGrade += e.getGrade();
                count++;
            }
        }
        
        return count > 0 ? totalGrade / count : 0;
    }
    
    // Determine if a student is passing a module (assuming 50% is passing)
    public boolean isPassing() {
        return grade >= 50.0f;
    }
    
    // Generate a progress report for a specific enrollment
    public String generateProgressReport() {
        StringBuilder report = new StringBuilder();
        report.append("Enrollment Progress Report\n");
        report.append("Enrollment ID: ").append(enrollmentID).append("\n");
        report.append("Student: ").append(student.getName()).append(" (ID: ").append(student.getStudentID()).append(")\n");
        report.append("Module: ").append(module.getModuleName()).append(" (ID: ").append(module.getModuleID()).append(")\n");
        report.append("Status: ").append(enrollmentStatus).append("\n");
        report.append("Current Grade: ").append(grade).append("\n");
        report.append("Result: ").append(isPassing() ? "Passing" : "Failing").append("\n");
        return report.toString();
    }

    @Override
    public void activate() {
    this.enrollmentStatus = Status.ACTIVE;
    System.out.println("Enrollment activated.");
    }

    @Override
    public void cancel() {
    enrollmentStatus = Status.CANCELLED;
    System.out.println("Enrollment cancelled.");
    }

}

enum Status {
    ACTIVE, CANCELLED;
}
