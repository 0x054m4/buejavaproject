import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Staff implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Module> assignedModules;
    private static final String FILE_PATH = "teachers.dat";
    
    public Teacher(int staffId) {
        super(staffId);
        assignedModules = new ArrayList<>();
    }
    
    public Teacher(String name, String email, String role, StaffStatus status) {
        super(name, email, role, status);
        assignedModules = new ArrayList<>();
    }   
    
    public void setAssignedModules(List<Module> assignedModules) {
        this.assignedModules = assignedModules;
    }

    public List<Module> getAssignedModules() {
        return assignedModules;
    }

    public void assignModule(Module module) {
        assignedModules.add(module);
        System.out.println("Module " + module.getModuleID() + " assigned to teacher.");
        saveAllTeachers(getAllTeachers());
    }

    public void removeModuleAssignment(int moduleID) {
        for (Module module : assignedModules) {
            if (module.getModuleID() == moduleID) {
                assignedModules.remove(module);
                break;
            }
        }
        System.out.println("Module " + moduleID + " removed from teacher's assignments.");
        saveAllTeachers(getAllTeachers());
    }
    
    public void updateTeacher() {
        List<Teacher> teachers = getAllTeachers();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getStaffId() == this.getStaffId()) {
                teachers.set(i, this);
                break;
            }
        }
        saveAllTeachers(teachers);
    }
    
    public void addTeacher() {
        List<Teacher> teachers = getAllTeachers();
        teachers.add(this);
        saveAllTeachers(teachers);
    }
    
    public void deleteTeacher() {
        List<Teacher> teachers = getAllTeachers();
        teachers.removeIf(t -> t.getStaffId() == this.getStaffId());
        saveAllTeachers(teachers);
    }
    
    public static void listAllTeachers() {
        List<Teacher> teachers = getAllTeachers();
        System.out.println("=== All Teachers ===");
        for (Teacher t : teachers) {
            System.out.println("Teacher ID: " + t.getStaffId());
            System.out.println("Name: " + t.getName());
            System.out.println("Email: " + t.getEmail());
            System.out.println("Role: " + t.getRole());
            System.out.println("Status: " + t.getStatus());
            System.out.println("Assigned Modules: " + t.getAssignedModules().size());
            System.out.println("-----------------");
        }
    }
    
    // Find teachers by module
    public static List<Teacher> getTeachersByModule(int moduleID) {
        List<Teacher> teachers = getAllTeachers();
        List<Teacher> moduleTeachers = new ArrayList<>();
        for (Teacher t : teachers) {
            for (Module m : t.getAssignedModules()) {
                if (m.getModuleID() == moduleID) {
                    moduleTeachers.add(t);
                    break;
                }
            }
        }
        return moduleTeachers;
    }
    
    // Find teachers by status
    public static List<Teacher> getTeachersByStatus(StaffStatus status) {
        List<Teacher> teachers = getAllTeachers();
        List<Teacher> filteredTeachers = new ArrayList<>();
        for (Teacher t : teachers) {
            if (t.getStatus() == status) {
                filteredTeachers.add(t);
            }
        }
        return filteredTeachers;
    }
    
    // Teacher workload analysis
    public int getWorkload() {
        return assignedModules.size();
    }
    
    // Check if teacher has capacity for more modules
    public boolean hasCapacity(int maxModules) {
        return assignedModules.size() < maxModules;
    }
    
    // View all students across assigned modules
    public List<Student> getAllStudents() {
        List<Student> allStudents = new ArrayList<>();
        List<Enrollment> enrollments = Enrollment.getAllEnrollments();
        
        for (Module module : assignedModules) {
            for (Enrollment e : enrollments) {
                if (e.getModule().getModuleID() == module.getModuleID()) {
                    // Add student if not already in the list
                    boolean found = false;
                    for (Student s : allStudents) {
                        if (s.getStudentID() == e.getStudent().getStudentID()) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        allStudents.add(e.getStudent());
                    }
                }
            }
        }
        
        return allStudents;
    }
    
    // Generate a teacher report
    public String generateTeacherReport() {
        StringBuilder report = new StringBuilder();
        List<Enrollment> enrollments = Enrollment.getAllEnrollments();
        
        report.append("Teacher Report\n");
        report.append("ID: ").append(getStaffId()).append("\n");
        report.append("Name: ").append(getName()).append("\n");
        report.append("Email: ").append(getEmail()).append("\n");
        report.append("Role: ").append(getRole()).append("\n");
        report.append("Status: ").append(getStatus()).append("\n");
        report.append("Workload: ").append(getWorkload()).append(" modules\n\n");
        
        report.append("Assigned Modules:\n");
        for (Module m : assignedModules) {
            report.append("- ").append(m.getModuleName()).append(" (ID: ").append(m.getModuleID()).append(")\n");
            
            // Count enrollments and calculate average grade
            int enrollmentCount = 0;
            float totalGrade = 0;
            
            for (Enrollment e : enrollments) {
                if (e.getModule().getModuleID() == m.getModuleID()) {
                    enrollmentCount++;
                    totalGrade += e.getGrade();
                }
            }
            
            float averageGrade = enrollmentCount > 0 ? totalGrade / enrollmentCount : 0;
            
            report.append("  Enrolled Students: ").append(enrollmentCount).append("\n");
            report.append("  Average Grade: ").append(averageGrade).append("\n");
        }
        
        return report.toString();
    }

    public boolean login() {
        return true; // Placeholder for login logic
    }
    
    // File operations
    public static List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        File file = new File(FILE_PATH);
        
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                teachers = (List<Teacher>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading teachers: " + e.getMessage());
            }
        }
        
        return teachers;
    }
    
    public static void saveAllTeachers(List<Teacher> teachers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(teachers);
        } catch (IOException e) {
            System.out.println("Error saving teachers: " + e.getMessage());
        }
    }
    
    public static Teacher getTeacherById(int teacherId) {
        List<Teacher> teachers = getAllTeachers();
        for (Teacher teacher : teachers) {
            if (teacher.getStaffId() == teacherId) {
                return teacher;
            }
        }
        return null;
    }
}