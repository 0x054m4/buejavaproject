import java.util.ArrayList;
import java.util.Date;

public class Session {
    private int sessionID;
    private int moduleID;
    private String sessionName;
    private Date startTime;
    private Date endTime;
    private int classroomID;
    private ArrayList<Student> attendees = new ArrayList<>();
    private String status;

    // Constructor with only sessionID
    public Session(int sessionID) {
        this.sessionID = sessionID;
    }

    // Full constructor
    public Session(int moduleID, String sessionName, Date startTime, Date endTime,
                   int classroomID, int[] attendeeIDs, String status) {
        this.moduleID = moduleID;
        this.sessionName = sessionName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classroomID = classroomID;
        this.status = status;
        
        // Convert array of student IDs to Student objects
        for (int id : attendeeIDs) {
            this.attendees.add(new Student(id));
        }
    }

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

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setClassroomID(int classroomID) {
        this.classroomID = classroomID;
    }

    public int getClassroomID() {
        return classroomID;
    }

    public void setAttendees(ArrayList<Student> attendees) {
        this.attendees = new ArrayList<>(attendees); // Ensures immutability
    }

    public ArrayList<Student> getAttendees() {
        return new ArrayList<>(attendees); // Returns a copy to prevent modification outside the class
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
