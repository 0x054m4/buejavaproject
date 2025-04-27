import java.io.*;
import java.util.ArrayList;

/**
 * Utility class to initialize the data storage files for the application.
 */
public class DataInitializer {
    
    private static final String STUDENTS_FILE = "students.dat";
    private static final String TEACHERS_FILE = "teachers.dat";
    private static final String MODULES_FILE = "modules.dat";
    private static final String ENROLLMENTS_FILE = "enrollments.dat";
    private static final String CLASSROOMS_FILE = "classrooms.dat";
    private static final String SESSIONS_FILE = "sessions.dat";
    private static final String PAYMENTS_FILE = "payments.dat";
    
    /**
     * Initialize all data files if they don't exist.
     */
    public static void initializeAllFiles() {
        initializeFile(STUDENTS_FILE);
        initializeFile(TEACHERS_FILE);
        initializeFile(MODULES_FILE);
        initializeFile(ENROLLMENTS_FILE);
        initializeFile(CLASSROOMS_FILE);
        initializeFile(SESSIONS_FILE);
        initializeFile(PAYMENTS_FILE);
        System.out.println("All data files initialized successfully.");
    }
    
    /**
     * Initialize a specific data file if it doesn't exist.
     * 
     * @param fileName the name of the file to initialize
     */
    private static void initializeFile(String fileName) {
        File file = new File(fileName);
        
        if (!file.exists()) {
            try {
                // Create an empty ArrayList for the entity
                ArrayList emptyList = new ArrayList<>();
                
                // Write the empty ArrayList to the file
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                    oos.writeObject(emptyList);
                }
                
                System.out.println("Created new data file: " + fileName);
            } catch (IOException e) {
                System.out.println("Error creating data file " + fileName + ": " + e.getMessage());
            }
        } else {
            System.out.println("Data file already exists: " + fileName);
        }
    }
}