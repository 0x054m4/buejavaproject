import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int studentCounter = 0;
    private int studentID;
    private String name;
    private String email;
    private float annualFee;
    private int year;
    private static final String FILE_PATH = "students.dat";
    
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
    
    public void createAccount(Student newStudent) {
        List<Student> students = getAllStudents();
        students.add(newStudent);
        saveAllStudents(students);
    }
    
    public void manageAccount() {
        List<Student> students = getAllStudents();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID() == this.studentID) {
                students.set(i, this);
                break;
            }
        }
        saveAllStudents(students);
    }
    
    public void viewCourses() {
        List<Enrollment> enrollments = Enrollment.getAllEnrollments();
        System.out.println("Courses for Student ID: " + this.studentID);
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().getStudentID() == this.studentID) {
                System.out.println("- " + enrollment.getModule().getModuleName());
            }
        }
    }
    
    public void deleteAccount() {
        List<Student> students = getAllStudents();
        students.removeIf(s -> s.getStudentID() == this.studentID);
        saveAllStudents(students);
    }

    public static void viewEnrollments(int studentID) {
        List<Enrollment> enrollments = Enrollment.getAllEnrollments();
        System.out.println("=== Enrollments for Student ID: " + studentID + " ===");
        boolean found = false;
        for (Enrollment e : enrollments) {
            if (e.getStudent().getStudentID() == studentID) {
                found = true;
                System.out.println("Module ID: " + e.getModule().getModuleID());
                System.out.println("Module Name: " + e.getModule().getModuleName());
                System.out.println("Enrollment Status: " + e.getEnrollmentStatus());
                System.out.println("Grade: " + e.getGrade());
                System.out.println("-----------------");
            }
        }
        if (!found) {
            System.out.println("No enrollments found for this student.");
        }
    }

    public static void listAllStudents() {
        List<Student> students = getAllStudents();
        System.out.println("=== All Students ===");
        for (Student s : students) {
            System.out.println("Student ID: " + s.getStudentID());
            System.out.println("Name: " + s.getName());
            System.out.println("Email: " + s.getEmail());
            System.out.println("Annual Fee: " + s.getAnnualFee());
            System.out.println("Year: " + s.getYear());
            System.out.println("-----------------");
        }
    }

    public boolean login(){
      return true;
    }
    
    // File operations
    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_PATH);
        
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                students = (List<Student>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading students: " + e.getMessage());
            }
        }
        
        return students;
    }
    
    public static void saveAllStudents(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }
    
    public static Student getStudentById(int studentId) {
        List<Student> students = getAllStudents();
        for (Student student : students) {
            if (student.getStudentID() == studentId) {
                return student;
            }
        }
        return null;
    }
}
