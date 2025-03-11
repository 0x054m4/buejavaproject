import java.util.*;

public class Session {
    private int sessionID;
    private int moduleID;
    private String sessionName;
    private Date startTime;
    private String endTime;
    private int classroomID;
    private ArrayList<Student> attendees;
    private String status;

    // Constructor with session ID only
    public Session(int sessionID) {
        this.sessionID = sessionID;
        this.attendees = new ArrayList<>();
    }

    // Corrected Constructor
    public Session(int moduleID, String sessionName, Date startTime, String endTime,
            int classroomID, int[] attendees, String status) {
        this.moduleID = moduleID;
        this.sessionName = sessionName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classroomID = classroomID;
        this.status = status;
        this.attendees = new ArrayList<>();

        // Convert int[] to ArrayList<Student>
        for (int studentID : attendees) {
            this.attendees.add(new Student(studentID));
        }
    }

    // Getters and Setters
    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }

    public int getModuleID() {
        return moduleID;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setClassroomID(int classroomID) {
        this.classroomID = classroomID;
    }

    public int getClassroomID() {
        return classroomID;
    }

    public void setAttendees(ArrayList<Student> attendees) {
        this.attendees = new ArrayList<>(attendees); // Copies the list to prevent external modifications
    }

    public ArrayList<Student> getAttendees() {
        return new ArrayList<>(attendees); // Returns a copy to maintain encapsulation
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
