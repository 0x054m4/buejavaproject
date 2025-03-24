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

    public Session(int sessionID) {
        this.sessionID = sessionID;
        this.attendees = new ArrayList<>();
    }

    public Session(int moduleID, String sessionName, Date startTime, String endTime,
                   int classroomID, ArrayList<Student> attendees, String status) {
        this.moduleID = moduleID;
        this.sessionName = sessionName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classroomID = classroomID;
        this.attendees = new ArrayList<>(attendees);
        this.status = status;    
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
        this.attendees =attendees;
    }

    public ArrayList<Student> getAttendees() {
        return new ArrayList<>(attendees); 
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
