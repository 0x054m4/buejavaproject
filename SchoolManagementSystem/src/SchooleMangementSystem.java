import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SchooleMangementSystem {
    public void addStudent() {
        System.out.println("Enter student name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter student email: ");
        String email = new Scanner(System.in).nextLine();
        System.out.println("Enter student annual fee: ");
        Scanner sc = new Scanner(System.in);
        float annualFee = sc.nextFloat();
        System.out.println("Enter student year (1-12): ");
        Scanner sc1 = new Scanner(System.in);
        int year = sc1.nextInt();
        Student newStudent = new Student(name, email, annualFee, year);
        newStudent.createAccount(newStudent);
        System.out.println("Student added successfully!");
    }

    public void updateStudent() {
        System.out.println("Enter student ID: ");
        Scanner sc = new Scanner(System.in);
        int studentID = sc.nextInt();
        Student updatedStudent = Student.getStudentById(studentID);
        
        if (updatedStudent == null) {
            System.out.println("Student not found!");
            return;
        }
        System.out.println("Enter student name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter student email: ");
        String email = new Scanner(System.in).nextLine();
        System.out.println("Enter student annual fee: ");
        Scanner sc2 = new Scanner(System.in);
        float annualFee = sc2.nextFloat();
        updatedStudent.setName(name);
        updatedStudent.setEmail(email);
        updatedStudent.setAnnualFee(annualFee);
        updatedStudent.manageAccount();
        System.out.println("Student updated successfully!");
    }

    public void deleteStudent() {
        System.out.println("Enter student ID: ");
        Scanner sc = new Scanner(System.in);                             
        int studentID = sc.nextInt();
        Student student = Student.getStudentById(studentID);
        
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        student.deleteAccount();
        System.out.println("Student deleted successfully!");
    }

    public void viewStudentCourses() {
        System.out.println("Enter student ID: ");
        Scanner sc = new Scanner(System.in);
        int studentID = sc.nextInt();
        Student.viewEnrollments(studentID);
    }

    public void listAllStudents() {
        Student.listAllStudents();
    }

    public void addModule() {
        System.out.println("Enter module name: ");
        String moduleName = new Scanner(System.in).nextLine();
        System.out.println("Enter module max capacity: ");
        Scanner sc = new Scanner(System.in);
        int maxCapacity = sc.nextInt();
        System.out.println("Enter module year (1-12): ");
        Scanner sc1 = new Scanner(System.in);
        int moduleYear = sc1.nextInt();
        Module newModule = new Module(moduleName, maxCapacity, null, moduleYear);
        newModule.addModule();
        System.out.println("Module added successfully!");
    }

    public void updateModule() {
        System.out.println("Enter module ID: ");
        Scanner sc = new Scanner(System.in);
        int moduleID = sc.nextInt();
        Module updatedModule = Module.getModuleById(moduleID);
        
        if (updatedModule == null) {
            System.out.println("Module not found!");
            return;
        }
        
        System.out.println("Enter module name: ");
        String moduleName = new Scanner(System.in).nextLine();
        System.out.println("Enter module max capacity: ");
        Scanner sc1 = new Scanner(System.in);
        int maxCapacity = sc1.nextInt();
        updatedModule.setModuleName(moduleName);
        updatedModule.setMaxCapacity(maxCapacity);
        updatedModule.updateModule();
        System.out.println("Module updated successfully!");
    }

    public void deleteModule() {
        System.out.println("Enter module ID: ");
        Scanner sc1 = new Scanner(System.in);
        int moduleID = sc1.nextInt();
        Module moduleToDelete = Module.getModuleById(moduleID);
        
        if (moduleToDelete == null) {
            System.out.println("Module not found!");
            return;
        }
        
        moduleToDelete.removeModule();
        System.out.println("Module deleted successfully!");
    }

    public void listAllModules() {
        Module.listAllModules();
    }

    public void addClassroom(ArrayList<Classroom> classrooms) {
        System.out.println("Enter classroom name: ");
        String roomName = new Scanner(System.in).nextLine();
        System.out.println("Enter classroom capacity: ");
        Scanner sc=new Scanner(System.in);
        int capacity = sc.nextInt();
        Classroom newClassroom = new Classroom(roomName, capacity);
        newClassroom.addClassroom(classrooms);
        System.out.println("Classroom added successfully!");
    }

    public void updateClassroom(ArrayList<Classroom> classrooms) {
        System.out.println("Enter classroom ID: ");
        Scanner sc=new Scanner(System.in);
        int classroomID = sc.nextInt();
        Classroom updatedClassroom = null;
        for (Classroom c : classrooms) {
            if (c.getClassroomId() == classroomID) {
                updatedClassroom = c;
                break;
            }
        }
        if (updatedClassroom == null) {
            System.out.println("Classroom not found!");
            return;
        }
        System.out.println("Enter classroom name: ");
        String roomName = new Scanner(System.in).nextLine();
        System.out.println("Enter classroom capacity: ");
        Scanner s1c=new Scanner(System.in);
        int capacity = s1c.nextInt();
        updatedClassroom.setRoomName(roomName);
        updatedClassroom.setCapacity(capacity);
        updatedClassroom.updateClassroom(classrooms);
        System.out.println("Classroom updated successfully!");
    }

    public void deleteClassroom(ArrayList<Classroom> classrooms) {
        System.out.println("Enter classroom ID: ");
        Scanner sc=new Scanner(System.in);
        int classroomID = sc.nextInt();
        Classroom classroomToDelete = null;
        for (Classroom c : classrooms) {
            if (c.getClassroomId() == classroomID) {
                classroomToDelete = c;
                break;
            }
        }
        if (classroomToDelete == null) {
            System.out.println("Classroom not found!");
            return;
        }
        Classroom.removeClassroom(classrooms, classroomID);
        System.out.println("Classroom deleted successfully!");
    }

    public void listAllClassrooms(ArrayList<Classroom> classrooms) {
        Classroom.listAllClassrooms(classrooms);
    }

    public void addEnrollment(ArrayList<Enrollment> enrollments, ArrayList<Student> students,
            ArrayList<Module> modules) {
        System.out.println("Enter student ID: ");
        Scanner sc=new Scanner(System.in);
        int studentID = sc.nextInt();
        System.out.println("Enter module ID: ");
        Scanner sc1=new Scanner(System.in);
        int moduleID = sc1.nextInt();
        
        Student student = null;
        Module module = null;
        // Set student and module data from the arraylist
        for (Student s : students) {
            if (s.getStudentID() == studentID) {
                student = s;
                break;
            }
        }

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        for (Module m : modules) {
            if (m.getModuleID() == moduleID) {
                module = m;
            }
        }

        if (module == null) {
            System.out.println("Module not found!");
            return;
        }

        Status status = Status.ACTIVE;
        Enrollment newEnrollment = new Enrollment(student, module, status);
        newEnrollment.addEnrollment(enrollments);
        System.out.println("Enrollment added successfully!");
    }

    public void updateEnrollment(ArrayList<Enrollment> enrollments, ArrayList<Student> students,
            ArrayList<Module> modules) {
        System.out.println("Enter enrollment ID: ");
        Scanner sc=new Scanner(System.in);
        int enrollmentID = sc.nextInt();
        Enrollment enrollmentToUpdate = null;
        for (Enrollment e : enrollments) {
            if (e.getEnrollmentID() == enrollmentID) {
                enrollmentToUpdate = e;
                break;
            }
        }
        if (enrollmentToUpdate == null) {
            System.out.println("Enrollment not found!");
            return;
        }
        
        System.out.println("Enter student ID: ");
        Scanner sc1=new Scanner(System.in);
        int studentID = sc1.nextInt();
        System.out.println("Enter module ID: ");
        Scanner sc2=new Scanner(System.in);
        int moduleID = sc2.nextInt();
        System.out.println("Enter grade: ");
        Scanner sc3=new Scanner(System.in);
        float grade = sc3.nextFloat();
        Student student = null;
        Module module = null;
        // Set student and module data from the arraylist
        for (Student s : students) {
            if (s.getStudentID() == studentID) {
                student = s;
                break;
            }
        }
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        for (Module m : modules) {
            if (m.getModuleID() == moduleID) {
                module = m;
            }
        }
        if (module == null) {
            System.out.println("Module not found!");
            return;
        }
        enrollmentToUpdate.setStudent(student);
        enrollmentToUpdate.setModule(module);
        enrollmentToUpdate.setGrade(grade);
        enrollmentToUpdate.updateEnrollment(enrollments);
        System.out.println("Enrollment updated successfully!");
    }

    public void deleteEnrollment(ArrayList<Enrollment> enrollments) {
        System.out.println("Enter enrollment ID: ");
        Scanner sc=new Scanner(System.in);
        int enrollmentID = sc.nextInt();
        Enrollment enrollmentToDelete = null;
        for (Enrollment e : enrollments) {
            if (e.getEnrollmentID() == enrollmentID) {
                enrollmentToDelete = e;
                break;
            }
        }
        if (enrollmentToDelete == null) {
            System.out.println("Enrollment not found!");
            return;
        }
        enrollmentToDelete.deleteEnrollment(enrollments);
        System.out.println("Enrollment deleted successfully!");
    }

    public void listAllEnrollments(ArrayList<Enrollment> enrollments) {
        Enrollment.listAllEnrollments(enrollments);
    }

    public void addSession(ArrayList<Session> sessions, ArrayList<Module> modules, ArrayList<Classroom> classrooms) {
        // Get module and classroom by ID
        System.out.println("Enter module ID: ");
        Scanner sc = new Scanner(System.in);
        int moduleID = sc.nextInt();
        System.out.println("Enter classroom ID: ");
        Scanner sc1 = new Scanner(System.in);
        int classroomID = sc1.nextInt();
        // Get module and classroom by ID
        Module module = null;
        Classroom classroom = null;
        for (Module m : modules) {
            if (m.getModuleID() == moduleID) {
                module = m;
                break;
            }
        }
        if (module == null) {
            System.out.println("Module not found!");
            return;
        }
        for (Classroom c : classrooms) {
            if (c.getClassroomId() == classroomID) {
                classroom = c;
                break;
            }
        }
        if (classroom == null) {
            System.out.println("Classroom not found!");
            return;
        }
        System.out.println("Enter session name: ");
        String sessionName = new Scanner(System.in).nextLine();
        System.out.println("Enter start time: ");
        String startTime = new Scanner(System.in).nextLine();
        System.out.println("Enter end time: ");
        String endTime = new Scanner(System.in).nextLine();
        System.out.println("Enter session status: ");
        String status = new Scanner(System.in).nextLine();
        Session newSession = new Session(module, sessionName, startTime, endTime, classroom, null, status);
        newSession.addSession(sessions);
        System.out.println("Session added successfully!");
    }

    public void updateSession(ArrayList<Session> sessions, ArrayList<Module> modules, ArrayList<Classroom> classrooms) {
        System.out.println("Enter session ID: ");
        Scanner sc = new Scanner(System.in);
        int sessionID = sc.nextInt();
        Session sessionToUpdate = null;
        for (Session s : sessions) {
            if (s.getSessionID() == sessionID) {
                sessionToUpdate = s;
                break;
            }
        }
        if (sessionToUpdate == null) {
            System.out.println("Session not found!");
            return;
        }
        
        System.out.println("Enter module ID: ");
        Scanner sc1 = new Scanner(System.in);
        int moduleID = sc1.nextInt();
        System.out.println("Enter classroom ID: ");
        Scanner sc2 = new Scanner(System.in);
        int classroomID = sc2.nextInt();
        Module module = null;
        Classroom classroom = null;
        for (Module m : modules) {
            if (m.getModuleID() == moduleID) {
                module = m;
                break;
            }
        }
        if (module == null) {
            System.out.println("Module not found!");
            return;
        }
        for (Classroom c : classrooms) {
            if (c.getClassroomId() == classroomID) {
                classroom = c;
                break;
            }
        }
        if (classroom == null) {
            System.out.println("Classroom not found!");
            return;
        }

        System.out.println("Enter session name: ");
        String sessionName = new Scanner(System.in).nextLine();
        System.out.println("Enter start time: ");
        String startTime = new Scanner(System.in).nextLine();
        System.out.println("Enter end time: ");
        String endTime = new Scanner(System.in).nextLine();
        System.out.println("Enter session status: ");
        String status = new Scanner(System.in).nextLine();
        sessionToUpdate.setSessionName(sessionName);
        sessionToUpdate.setStartTime(startTime);
        sessionToUpdate.setEndTime(endTime);
        sessionToUpdate.setStatus(status);
        sessionToUpdate.setModule(module);
        sessionToUpdate.setClassroom(classroom);
        sessionToUpdate.updateSession(sessions);
        System.out.println("Session updated successfully!");
    }

    public void deleteSession(ArrayList<Session> sessions) {
        System.out.println("Enter session ID: ");
        Scanner sc = new Scanner(System.in);
        int sessionID = sc.nextInt();
        Session sessionToDelete = null;
        for (Session s : sessions) {
            if (s.getSessionID() == sessionID) {
                sessionToDelete = s;
                break;
            }
        }
        if (sessionToDelete == null) {
            System.out.println("Session not found!");
            return;
        }
        sessionToDelete.deleteSession(sessions);
        System.out.println("Session deleted successfully!");
    }

    public void listAllSessions(ArrayList<Session> sessions) {
        Session.listAllSessions(sessions);
    }

    public void addPayment(ArrayList<Payment> payments, ArrayList<Student> students) {
        System.out.println("Enter student ID: ");
        Scanner sc = new Scanner(System.in);
        int studentID = sc.nextInt();
        System.out.println("Enter amount: ");
        Scanner sc1 = new Scanner(System.in);
        float amount = sc1.nextFloat();
        System.out.println("Enter description: ");
        String description = new Scanner(System.in).nextLine();
        System.out.println("Enter date: ");
        String date = new Scanner(System.in).nextLine();
        Student student = null;
        for (Student s : students) {
            if (s.getStudentID() == studentID) {
                student = s;
                break;
            }
        }
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        Payment newPayment = new Payment(amount, student, description, date);
        newPayment.addPayment(payments);
        System.out.println("Payment added successfully!");
    }

    public void updatePayment(ArrayList<Payment> payments) {
        System.out.println("Enter payment ID: ");
        Scanner sc = new Scanner(System.in);
        int paymentID = sc.nextInt();
        Payment paymentToUpdate = null;
        for (Payment p : payments) {
            if (p.getPaymentID() == paymentID) {
                paymentToUpdate = p;
                break;
            }
        }
        if (paymentToUpdate == null) {
            System.out.println("Payment not found!");
            return;
        }
        System.out.println("Enter amount: ");
        Scanner sc1 = new Scanner(System.in);
        float amount = sc1.nextFloat();
        System.out.println("Enter description: ");
        String description = new Scanner(System.in).nextLine();
        System.out.println("Enter date: ");
        String date = new Scanner(System.in).nextLine();
        paymentToUpdate.setAmount(amount);
        paymentToUpdate.setDescription(description);
        paymentToUpdate.setDate(date);
        paymentToUpdate.updatePayment(payments);
        System.out.println("Payment updated successfully!");
    }

    public void deletePayment(ArrayList<Payment> payments) {
        System.out.println("Enter payment ID: ");
        Scanner sc = new Scanner(System.in);
        int paymentID = sc.nextInt();
        Payment paymentToDelete = null;
        for (Payment p : payments) {
            if (p.getPaymentID() == paymentID) {
                paymentToDelete = p;
                break;
            }
        }
        if (paymentToDelete == null) {
            System.out.println("Payment not found!");
            return;
        }
        paymentToDelete.deletePayment(payments);
        System.out.println("Payment deleted successfully!");
    }

    public void listAllPayments(ArrayList<Payment> payments) {
        Payment.listAllPayments(payments);
    }

    public class studentFunction{
        // This will run for studentflow (loggedin) student
        public void enrollToModule(ArrayList<Module> modules, ArrayList<Enrollment> enrollments, Student student) {
            System.out.println("Enter module ID: ");
            int moduleID = Integer.parseInt(System.console().readLine());
            Module module = null;
            for (Module m : modules) {
                if (m.getModuleID() == moduleID) {
                    module = m;
                    break;
                }
            }
            if (module == null) {
                System.out.println("Module not found!");
                return;
            }
            Status status = Status.ACTIVE;
            // Check year   
            if (student.getYear() != module.getModuleYear()) {
                System.out.println("You are not eligible to enroll in this module.");
                return;
            }
            // Check if full
            if (module.getMaxCapacity() <= enrollments.size()) {
                System.out.println("Module is full. Cannot enroll.");
                return;
            }
            // Check if already enrolled
            for (Enrollment e : enrollments) {
                if (e.getStudent().getStudentID() == student.getStudentID() && e.getModule().getModuleID() == module.getModuleID()) {
                    System.out.println("You are already enrolled in this module.");
                    return;
                }
            }


            Enrollment newEnrollment = new Enrollment(student, module, status);
            enrollments.add(newEnrollment);
            System.out.println("Enrolled successfully!");
        }
        public void viewEnrolledCourses(ArrayList<Enrollment> enrollments, Student student) {
            System.out.println("Enrolled courses for student ID: " + student.getStudentID());
            for (Enrollment e : enrollments) {
                if (e.getStudent().getStudentID() == student.getStudentID()) {
                    System.out.println("Module ID: " + e.getModule().getModuleID());
                    System.out.println("Enrollment status: " + e.getEnrollmentStatus());
                }
            }
        }
        public void viewPayments(ArrayList<Payment> payments, Student student) {
            System.out.println("Payments for student ID: " + student.getStudentID());
            for (Payment p : payments) {
                if (p.getPayeeId().getStudentID() == student.getStudentID()) {
                    System.out.println("Payment ID: " + p.getPaymentID());
                    System.out.println("Amount: " + p.getAmount());
                    System.out.println("Description: " + p.getDescription());
                    System.out.println("Date: " + p.getDate());
                }
            }
        }
    }

    public class TeacherFunction{
        
        public void registerAttendee(ArrayList<Session> sessions, ArrayList<Student> students) {
            System.out.println("Enter session ID: ");
            int sessionID = Integer.parseInt(System.console().readLine());
            System.out.println("Enter student ID: ");
            int studentID = Integer.parseInt(System.console().readLine());
            Session session = null;
            Student student = null;
            for (Session s : sessions) {
                if (s.getSessionID() == sessionID) {
                    session = s;
                    break;
                }
            }
            if (session == null) {
                System.out.println("Session not found!");
                return;
            }
            for (Student s : students) {
                if (s.getStudentID() == studentID) {
                    student = s;
                    break;
                }
            }
            if (student == null) {
                System.out.println("Student not found!");
                return;
            }
            ArrayList<Student> attendees = session.getAttendees();
            attendees.add(student); 
            session.setAttendees(attendees);
            System.out.println("Student registered for session successfully!");
        }
        // This will run for teacherflow (loggedin) teacher
        // Add session
        public void addSession(ArrayList<Session> sessions, ArrayList<Module> modules, ArrayList<Classroom> classrooms) {
            // Get module and classroom by ID
            System.out.println("Enter module ID: ");
            int moduleID = Integer.parseInt(System.console().readLine());
            System.out.println("Enter classroom ID: ");
            int classroomID = Integer.parseInt(System.console().readLine());
            // Get module and classroom by ID
            Module module = null;
            Classroom classroom = null;
            for (Module m : modules) {
                if (m.getModuleID() == moduleID) {
                    module = m;
                    break;
                }
            }
            if (module == null) {
                System.out.println("Module not found!");
                return;
            }
            for (Classroom c : classrooms) {
                if (c.getClassroomId() == classroomID) {
                    classroom = c;
                    break;
                }
            }
            if (classroom == null) {
                System.out.println("Classroom not found!");
                return;
            }
            System.out.println("Enter session name: ");
            String sessionName = new Scanner(System.in).nextLine();
            System.out.println("Enter start time: ");
            String startTime = new Scanner(System.in).nextLine();
            System.out.println("Enter end time: ");
            String endTime = new Scanner(System.in).nextLine();
            System.out.println("Enter session status: ");
            String status = new Scanner(System.in).nextLine();
            Session newSession = new Session(module, sessionName, startTime, endTime, classroom, null, status);
            newSession.addSession(sessions);
        }
        // List students
        public void listStudents(ArrayList<Student> students) {
            System.out.println("Students enrolled in the module: ");
            for (Student s : students) {
                System.out.println("Student ID: " + s.getStudentID());
                System.out.println("Student name: " + s.getName());
                System.out.println("Student email: " + s.getEmail());
                System.out.println("Student annual fee: " + s.getAnnualFee());
            }
        }

    }
    public void viewSessionAssessments(ArrayList<Session> sessions) {
        System.out.println("Enter session ID: ");
        Scanner sc = new Scanner(System.in);
        int sessionID = sc.nextInt();
        
        Session session = null;
        for (Session s : sessions) {
            if (s.getSessionID() == sessionID) {
                session = s;
                break;
            }
        }
        
        if (session == null) {
            System.out.println("Session not found!");
            return;
        }
        
        ArrayList<Assessment> assessments = session.getAssessments();
        if (assessments.isEmpty()) {
            System.out.println("No assessments found for this session.");
            return;
        }
        
        System.out.println("=== Assessments for Session: " + session.getSessionName() + " ===");
        for (Assessment a : assessments) {
            System.out.println("Assessment ID: " + a.getAssessmentID());
            System.out.println("Title: " + a.getTitle());
            System.out.println("Date: " + a.getDate());
            System.out.println("Duration: " + a.getDuration());
            System.out.println("Module: " + a.getModule().getModuleName());
            System.out.println("-----------------");
        }
    }
    
    public void addAssessmentToSession(ArrayList<Session> sessions) {
        System.out.println("Enter session ID: ");
        Scanner sc = new Scanner(System.in);
        int sessionID = sc.nextInt();
        
        Session session = null;
        for (Session s : sessions) {
            if (s.getSessionID() == sessionID) {
                session = s;
                break;
            }
        }
        
        if (session == null) {
            System.out.println("Session not found!");
            return;
        }
        
        System.out.println("Enter assessment title: ");
        String title = new Scanner(System.in).nextLine();
        
        System.out.println("Enter assessment duration (in minutes): ");
        String duration = new Scanner(System.in).nextLine();
        
        // Using current date for simplicity
        Date date = new Date();
        
        Module module = session.getModule();
        
        Assessment newAssessment = new Assessment(0, date, duration, module, title);
        session.addAssessment(newAssessment);
        
        System.out.println("Assessment added to session successfully!");
    }

    public static void studentFlow(String[] args) throws Exception {
        System.out.println("Please login to continue.");
        int studentID = 0;
        System.out.println("Enter your student ID: ");
        studentID = new Scanner(System.in).nextInt();
        // Check if student exists
        Student student = Student.getStudentById(studentID);
        
        if (student == null) {
            System.out.println("Student not found!");
            main(args);
            return;
        }
        
        int option = 0;
        while(true) {
            System.out.println("What would you like to do?");
            System.out.println("1. View enrolled-in courses");
            System.out.println("2. Enroll in a course");
            System.out.println("3. View payments");
            System.out.println("4. Logout");
            option = Integer.parseInt(System.console().readLine());
            studentFunction studentFunction = new SchooleMangementSystem().new studentFunction();
            switch (option) {
                case 1:
                    student.viewCourses();
                    break;
                case 2:
                    studentFunction.enrollToModule(student);
                    break;
                case 3:
                    studentFunction.viewPayments(student);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    main(null);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
    public static void staffFlow(String[] args) throws Exception {
        boolean loggedIn = false;
        if (!loggedIn) {
            System.out.println("Please login to continue.");
            int staffID = 0;
            System.out.println("Enter your staff ID: ");
            Scanner sc = new Scanner(System.in);
            staffID = sc.nextInt();
            Admin admin = new Admin(staffID);
            loggedIn = admin.login();
            if (loggedIn) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed. Please try again.");
                staffFlow(args);
            }
        }
        
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Manage students");
            System.out.println("2. Manage modules");
            System.out.println("3. Manage classrooms");
            System.out.println("4. Manage enrollments");
            System.out.println("5. Manage sessions");
            System.out.println("6. Manage payments");
            System.out.println("7. Manage teachers");
            System.out.println("8. Exit");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            SchooleMangementSystem app = new SchooleMangementSystem();
            
            switch (option) {
                case 1 -> {
                    System.out.println("1. Add student");
                    System.out.println("2. Update student");
                    System.out.println("3. Delete student");
                    System.out.println("4. View student courses");
                    System.out.println("5. List all students");
                    System.out.println("6. Back");
                    Scanner sc1 = new Scanner(System.in);
                    int studentOption = sc1.nextInt();
                    switch (studentOption) {
                        case 1 -> app.addStudent();
                        case 2 -> app.updateStudent();
                        case 3 -> app.deleteStudent();
                        case 4 -> app.viewStudentCourses();
                        case 5 -> app.listAllStudents();
                        case 6 -> main(args);
                        default -> {
                            System.out.println("Invalid option. Please try again.");
                            main(args);
                        }
                    }
                }
                case 2 -> {
                    System.out.println("1. Add module");
                    System.out.println("2. Update module");
                    System.out.println("3. Delete module");
                    System.out.println("4. List all modules");
                    System.out.println("5. Back");
                    Scanner sc1 = new Scanner(System.in);
                    int moduleOption = sc1.nextInt();
                    switch (moduleOption) {
                        case 1 -> app.addModule();
                        case 2 -> app.updateModule();
                        case 3 -> app.deleteModule();
                        case 4 -> app.listAllModules();
                        case 5 -> main(args);
                        default -> {
                            System.out.println("Invalid option. Please try again.");
                            main(args);
                        }
                    }
                }
                case 3 -> {
                    System.out.println("1. Add classroom");
                    System.out.println("2. Update classroom");
                    System.out.println("3. Delete classroom");
                    System.out.println("4. List all classrooms");
                    System.out.println("5. Back");
                    Scanner sc2 = new Scanner(System.in);
                    int classroomOption = sc2.nextInt();
                    switch (classroomOption) {
                        case 1 -> app.addClassroom();
                        case 2 -> app.updateClassroom();
                        case 3 -> app.deleteClassroom();
                        case 4 -> app.listAllClassrooms();
                        case 5 -> main(args);
                        default -> {
                            System.out.println("Invalid option. Please try again.");
                            main(args);
                        }
                    }
                }

                case 4 -> {
                    System.out.println("1. Add enrollment");
                    System.out.println("2. Update enrollment");
                    System.out.println("3. Delete enrollment");
                    System.out.println("4. List all enrollments");
                    System.out.println("5. Back");
                    Scanner sc1 = new Scanner(System.in);
                    int enrollmentOption =sc1.nextInt();
                    switch (enrollmentOption) {
                        case 1 -> app.addEnrollment();
                        case 2 -> app.updateEnrollment();
                        case 3 -> app.deleteEnrollment();
                        case 4 -> app.listAllEnrollments();
                        case 5 -> main(args);
                        default -> {
                            System.out.println("Invalid option. Please try again.");
                            main(args);
                        }
                    }
                }

                case 5 -> {
                    System.out.println("1. Add session");
                    System.out.println("2. Update session");
                    System.out.println("3. Delete session");
                    System.out.println("4. List all sessions");
                    System.out.println("5. View session assessments");
                    System.out.println("6. Add assessment to session");
                    System.out.println("7. Back");
                    Scanner sc3 = new Scanner(System.in);
                    int sessionOption = sc3.nextInt();
                    switch (sessionOption) {
                        case 1 -> app.addSession();
                        case 2 -> app.updateSession();
                        case 3 -> app.deleteSession();
                        case 4 -> app.listAllSessions();
                        case 5 -> app.viewSessionAssessments();
                        case 6 -> app.addAssessmentToSession();
                        case 7 -> main(args);
                        default -> {
                            System.out.println("Invalid option. Please try again.");
                            main(args);
                        }
                    }
                }

                case 6 -> {
                    System.out.println("1. Add payment");
                    System.out.println("2. Update payment");
                    System.out.println("3. Delete payment");
                    System.out.println("4. List all payments");
                    System.out.println("5. Back");
                    Scanner sc1 = new Scanner(System.in);
                    int paymentOption = sc1.nextInt();
                    switch (paymentOption) {
                        case 1 -> app.addPayment();
                        case 2 -> app.updatePayment();
                        case 3 -> app.deletePayment();
                        case 4 -> app.listAllPayments();
                        case 5 -> main(args);
                        default -> {
                            System.out.println("Invalid option. Please try again.");
                            main(args);
                        }
                    }
                }

                case 7 -> {
                    System.out.println("1. Add teacher");
                    System.out.println("2. Update teacher");
                    System.out.println("3. Delete teacher");
                    System.out.println("4. List all teachers");
                    System.out.println("5. Back");
                    Scanner sc1 = new Scanner(System.in);
                    int teacherOption = sc1.nextInt();
                    switch (teacherOption) {
                        case 1 -> app.addTeacher();
                        case 2 -> app.updateTeacher();
                        case 3 -> app.deleteTeacher();
                        case 4 -> app.listAllTeachers();
                        case 5 -> main(args);
                        default -> {
                            System.out.println("Invalid option. Please try again.");
                            main(args);
                        }
                    }
                }

                case 8 -> {
                    System.out.println("Exiting...");
                    main(args);
                }
                default -> {
                    System.out.println("Invalid option. Please try again.");
                    main(args);
                }
            }
        }
    }
    public static void teacherFlow(String[] args) throws Exception {
        boolean loggedIn = false;
        if (!loggedIn) {
            System.out.println("Please login to continue.");
            int teacherID = 0;
            System.out.println("Enter your teacher ID: ");
            Scanner sc = new Scanner(System.in);
            teacherID = sc.nextInt();
            Teacher teacher = Teacher.getTeacherById(teacherID);
            
            if (teacher == null) {
                System.out.println("Teacher not found!");
                main(args);
                return;
            }
            
            loggedIn = teacher.login();
            
            if (loggedIn) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed. Please try again.");
                teacherFlow(args);
            }
        }
        
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. List students");
            System.out.println("2. Add session");
            System.out.println("3. Register attendee");
            System.out.println("4. Logout");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            TeacherFunction teacherFunction = new SchooleMangementSystem().new TeacherFunction();
            
            switch (option) {
                case 1:
                    teacherFunction.listStudents();
                    break;
                case 2:
                    teacherFunction.addSession();
                    break;
                case 3:
                    teacherFunction.registerAttendee();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    main(args);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    main(args);
                    break;
            }
        }
    }


        public static void main(String[] args) throws Exception {
            // Initialize all data files when the application starts
            DataInitializer.initializeAllFiles();
            
            System.out.println("Welcome to School Management System!");
            System.out.println("1. Student.");
            System.out.println("2. Admin.");
            System.out.println("3. Teacher.");
            Scanner sc = new Scanner(System.in);
            int userType = sc.nextInt();

            if (userType == 1) {
                studentFlow(args);
            } else if (userType == 2) {
                staffFlow(args);
            } else if (userType == 3) {
                teacherFlow(args);
            } else {
                System.out.println("Invalid option. Please try again.");
                main(args);
            }
        }
    }
