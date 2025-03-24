import java.util.*;

public class Session {
    private int sessionID;
    private Module module;
    private String sessionName;
    private Date startTime;
    private String endTime;
    private Classroom classroom;
    private ArrayList<Student> attendees;
    private String status;

    public Session(int sessionID) {
        this.sessionID = sessionID;
        this.attendees = new ArrayList<>();
    }

    public Session(Module module, String sessionName, Date startTime, String endTime,
                   Classroom classroom, ArrayList<Student> attendees, String status) {
        this.module = module;
        this.sessionName = sessionName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classroom = classroom;
        this.attendees = new ArrayList<>(attendees);
<<<<<<< HEAD
        this.status = status;    
=======
        this.status = status;
>>>>>>> b12909ac0c742eb936ad44ea892679e6403537ad
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Module getModule() {
        return module;
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

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setAttendees(ArrayList<Student> attendees) {
        this.attendees = new ArrayList<>(attendees);
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
