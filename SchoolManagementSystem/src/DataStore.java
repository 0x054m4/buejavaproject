import java.util.ArrayList;

public class DataStore {
    private static final DataStore instance = new DataStore();

    public ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Module> modules = new ArrayList<>();
    public ArrayList<Classroom> classrooms = new ArrayList<>();
    public ArrayList<Enrollment> enrollments = new ArrayList<>();
    public ArrayList<Session> sessions = new ArrayList<>();
    public ArrayList<Payment> payments = new ArrayList<>();
    public ArrayList<Teacher> teachers = new ArrayList<>();

    private DataStore() {} // Private constructor to prevent multiple instances

    public static DataStore getInstance() {
        return instance;
    }
}