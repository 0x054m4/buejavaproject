import java.util.ArrayList;

public class Teacher extends Staff {
    private ArrayList<Module> assignedModules;
    public Teacher(int staffId) {
        super(staffId);
        assignedModules = new ArrayList<>();
    }
    public Teacher(String name, String email, String role, StaffStatus status) {
        super(name, email, role, status);
        assignedModules = new ArrayList<>();
    }   
    public void setAssignedModules(ArrayList<Module> assignedModules) {
        this.assignedModules = assignedModules;
    }

    public ArrayList<Module> getAssignedModules() {
        return assignedModules;
    }

    public void assignModule(Module module) {
        assignedModules.add(module);
        System.out.println("Module " + module.getModuleID() + " assigned to teacher.");
    }

    public void removeModuleAssignment(int moduleID) {
        for (Module module : assignedModules) {
            if (module.getModuleID() == moduleID) {
                assignedModules.remove(module);
                break;
            }
        }
        System.out.println("Module " + moduleID + " removed from teacher's assignments.");
    }
    public void updateTeacher(ArrayList<Teacher> teachers) {
        for (Teacher teacher : teachers) {
            if (teacher.getStaffId() == this.getStaffId()) {
                teacher.setName(this.getName());
                teacher.setEmail(this.getEmail());
                teacher.setRole(this.getRole());
                teacher.setStatus(this.getStatus());
                teacher.setAssignedModules(this.getAssignedModules());
                break;
            }
        }
    }
    
    public void addTeacher(ArrayList<Teacher> teachers) {
        teachers.add(this);
    }
    
    public void deleteTeacher(ArrayList<Teacher> teachers) {
        teachers.remove(this);
    }
    
    public static void listAllTeachers(ArrayList<Teacher> teachers) {
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
    public static ArrayList<Teacher> getTeachersByModule(ArrayList<Teacher> teachers, int moduleID) {
        ArrayList<Teacher> moduleTeachers = new ArrayList<>();
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
    public static ArrayList<Teacher> getTeachersByStatus(ArrayList<Teacher> teachers, StaffStatus status) {
        ArrayList<Teacher> filteredTeachers = new ArrayList<>();
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
    public ArrayList<Student> getAllStudents(ArrayList<Enrollment> enrollments) {
        ArrayList<Student> allStudents = new ArrayList<>();
        
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
    public String generateTeacherReport(ArrayList<Enrollment> enrollments) {
        StringBuilder report = new StringBuilder();
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
}