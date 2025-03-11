import java.util.*;

public class Session {
    private int sessionID;
    private int moduleID;
    private String sessionName;
    private Date startTime;
    private String endTime;
    private int classroomID;
    private ArrayList<Student> attendees = new ArrayList<>();
    private String status;

    public Session(int sessionID) {
        this.sessionID = sessionID;
    }

    public Session(int moduleID, String sessionName, Date startTime, String endTime,
                   int classroomID, int[] attendees, String status) {
        this.moduleID = moduleID;
        this.sessionName = sessionName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classroomID = classroomID;
        for (int i = 0; i < attendees.size(); i++) {
            this.attendees.set(i, attendees.get(i));
        }       
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
      this.attendees=attendees;
    }

    public Student[] getAttendees() {
        for (Student attendee : attendees) {
            System.out.println(attendee);
        }
    
        return attendees;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

 
}
