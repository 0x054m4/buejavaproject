import java.util.*;
public class App {
    public void addStudent(ArrayList<Student> students) {
        System.out.println("Enter student name: ");
        String name = System.console().readLine();
        System.out.println("Enter student email: ");
        String email = System.console().readLine();
        System.out.println("Enter student annual fee: ");
        float annualFee = Float.parseFloat(System.console().readLine());
        Student newStudent = new Student(name, email, annualFee);
        newStudent.createAccount(students, newStudent);
        System.out.println("Student added successfully!");
    }
    public void updateStudent(ArrayList<Student> students) {
        System.out.println("Enter student ID: ");
        int studentID = Integer.parseInt(System.console().readLine());
        Student updatedStudent = new Student(studentID);
        System.out.println("Enter student name: ");
        String name = System.console().readLine();
        updatedStudent.setName(name);
        System.out.println("Enter student email: ");
        String email = System.console().readLine();
        updatedStudent.setEmail(email);
        System.out.println("Enter student annual fee: ");
        float annualFee = Float.parseFloat(System.console().readLine());
        updatedStudent.setAnnualFee(annualFee);
        updatedStudent.manageAccount(students, updatedStudent);
        System.out.println("Student updated successfully!");
    }
    public void deleteStudent(ArrayList<Student> students) {
        System.out.println("Enter student ID: ");
        int studentID = Integer.parseInt(System.console().readLine());
        Student deletedStudent = new Student(studentID);
        students.remove(deletedStudent);
        System.out.println("Student deleted successfully!");
    }
    public void viewStudentCourses(ArrayList<Enrollment> enrollments) {
        System.out.println("Enter student ID: ");
        int studentID = Integer.parseInt(System.console().readLine());
        for(Enrollment e : enrollments){
            if(e.getStudent().getStudentID() == studentID){
                System.out.println("Student ID: " + e.getStudent().getStudentID());
                System.out.println("Module ID: " + e.getModule().getModuleID());
                System.out.println("Enrollment status: " + e.getEnrollmentStatus());
            }
        }
    }
    public void listAllStudents(ArrayList<Student> students) {
        for(Student s : students){
            System.out.println("Student ID: " + s.getStudentID());
            System.out.println("Student name: " + s.getName());
            System.out.println("Student email: " + s.getEmail());
            System.out.println("Student annual fee: " + s.getAnnualFee());
        }
    }
    public void addModule(ArrayList<Module> modules) {
        System.out.println("Enter module name: ");
        String moduleName = System.console().readLine();
        System.out.println("Enter module max capacity: ");
        int maxCapacity = Integer.parseInt(System.console().readLine());
        Module newModule = new Module(moduleName, maxCapacity);
        newModule.addModule(modules, newModule);
        System.out.println("Module added successfully!");
    }
    public void updateModule(ArrayList<Module> modules) {
        System.out.println("Enter module ID: ");
        int moduleID = Integer.parseInt(System.console().readLine());
        Module updatedModule = new Module(moduleID);
        System.out.println("Enter module name: ");
        String moduleName = System.console().readLine();
        updatedModule.setModuleName(moduleName);
        System.out.println("Enter module max capacity: ");
        int maxCapacity = Integer.parseInt(System.console().readLine());
        updatedModule.setMaxCapacity(maxCapacity);
        updatedModule.updateModule(modules, updatedModule);
        System.out.println("Module updated successfully!");
    }
    public void deleteModule(ArrayList<Module> modules) {
        System.out.println("Enter module ID: ");
        int moduleID = Integer.parseInt(System.console().readLine());
        Module deletedModule = new Module(moduleID);
        modules.remove(deletedModule);
        System.out.println("Module deleted successfully!");
    }
    public void listAllModules(ArrayList<Module> modules) {
        for(Module m : modules){
            System.out.println("Module ID: " + m.getModuleID());
            System.out.println("Module name: " + m.getModuleName());
            System.out.println("Module max capacity: " + m.getMaxCapacity());
        }
    }
    public void addClassroom(ArrayList<Classroom> classrooms) {
        System.out.println("Enter classroom name: ");
        String roomName = System.console().readLine();
        System.out.println("Enter classroom capacity: ");
        int capacity = Integer.parseInt(System.console().readLine());
        Classroom newClassroom = new Classroom(roomName, capacity);
        newClassroom.addClassroom(classrooms, newClassroom);
        System.out.println("Classroom added successfully!");
    }
    public void updateClassroom(ArrayList<Classroom> classrooms) {
        System.out.println("Enter classroom ID: ");
        int classroomID = Integer.parseInt(System.console().readLine());
        Classroom updatedClassroom = new Classroom(classroomID);
        System.out.println("Enter classroom name: ");
        String roomName = System.console().readLine();
        updatedClassroom.setRoomName(roomName);
        System.out.println("Enter classroom capacity: ");
        int capacity = Integer.parseInt(System.console().readLine());
        updatedClassroom.setCapacity(capacity);
        updatedClassroom.updateClassroom(classrooms, updatedClassroom);
        System.out.println("Classroom updated successfully!");
    }
    public void deleteClassroom(ArrayList<Classroom> classrooms) {
        System.out.println("Enter classroom ID: ");
        int classroomID = Integer.parseInt(System.console().readLine());
        Classroom deletedClassroom = new Classroom(classroomID);
        classrooms.remove(deletedClassroom);
        System.out.println("Classroom deleted successfully!");
    }
    
    public static void main(String[] args) throws Exception {
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Module> modules = new ArrayList<Module>();
        ArrayList<Classroom> classrooms = new ArrayList<Classroom>();
        ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
        int option = 0;
        boolean loggedIn = false;
        System.out.println("Welcome to School Management System!");
        if(!loggedIn){
            System.out.println("Please login to continue.");
            int staffID = 0;
            System.out.println("Enter your staff ID: ");
            staffID = Integer.parseInt(System.console().readLine());
            Admin admin = new Admin(staffID);
            loggedIn = admin.login();
            if(loggedIn){
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed. Please try again.");
                main(args);
            }
        }
        while(true){
          
        // ArrayLists (will be replaced by database later)
     
        System.out.println("What would you like to do?");
        System.out.println("1. Manage students");
        System.out.println("2. Manage modules");
        System.out.println("3. Manage classrooms");
        System.out.println("4. Manage enrollments");
        System.out.println("5. Exit");
        option = Integer.parseInt(System.console().readLine());
        App app = new App();
        switch(option){
            case 1:
                System.out.println("1. Add student");
                System.out.println("2. Update student");
                System.out.println("3. Delete student");
                System.out.println("4. View student courses");
                System.out.println("5. List all students");
                System.out.println("6. Back");
                int studentOption = Integer.parseInt(System.console().readLine());
                switch(studentOption){
                    case 1:
                        app.addStudent(students);
                        break;
                    case 2:
                        app.updateStudent(students);
                        break;
                    case 3:
                        app.deleteStudent(students);
                        break;
                    case 4:
                        app.viewStudentCourses(enrollments);
                        break;
                    case 5:
                        app.listAllStudents(students);
                        break;
                    case 6:
                        main(args);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        main(args);
                        break;
                }
                break;
            case 2:
                System.out.println("1. Add module");
                System.out.println("2. Update module"); 
                System.out.println("3. Delete module");
                System.out.println("4. List all modules");
                System.out.println("5. Back");
                int moduleOption = Integer.parseInt(System.console().readLine());
                switch(moduleOption){
                    case 1:
                        app.addModule(modules);
                        break;
                    case 2:
                        app.updateModule(modules);
                        break;
                    case 3:
                        app.deleteModule(modules);
                        break;
                    case 4:
                        app.listAllModules(modules);
                        break;
                    case 5:
                        main(args);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        main(args);
                        break;
                }

            case 3:
                System.out.println("1. Add classroom");
                System.out.println("2. Update classroom");
                System.out.println("3. Delete classroom");
                System.out.println("4. List all classrooms");
                System.out.println("5. Back");
                int classroomOption = Integer.parseInt(System.console().readLine());
            case 4:
                System.out.println("1. Add enrollment");
                System.out.println("2. Update enrollment");
                System.out.println("3. Delete enrollment");
                System.out.println("4. List all enrollments");
                System.out.println("5. Back");
                int enrollmentOption = Integer.parseInt(System.console().readLine());
            case 5:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                main(args);
                break;
        }

    }
}
}