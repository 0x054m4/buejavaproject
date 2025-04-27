import java.util.*;

public class Session {
    private static int sessionCounter = 0;
    private int sessionID;
    private Module module;
    private String sessionName;
    private String startTime;
    private String endTime;
    private Classroom classroom;
    private ArrayList<Student> attendees;
    private String status;
    private ArrayList<Assessment> assessments;

    public Session(int sessionID) {
        this.sessionID = sessionID;
        this.attendees = new ArrayList<>();
        this.assessments = new ArrayList<>();
    }

    public Session(Module module, String sessionName, String startTime, String endTime, Classroom classroom, ArrayList<Student> attendees, String status) {
        this.module = module;
        this.sessionName = sessionName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classroom = classroom;
        this.attendees = attendees != null ? new ArrayList<>(attendees) : new ArrayList<>();
        this.assessments = new ArrayList<>();
        this.status = status;
        this.sessionID = sessionCounter++;
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

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTime() {
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
    public void addSession(ArrayList<Session> session){
        session.add(this);
    }
    public void removeSession(ArrayList<Session> session){
        session.remove(this);
    }
    public void updateSession(ArrayList<Session> session){
        for (int i = 0; i < session.size(); i++) {
            if (session.get(i).getSessionID() == this.sessionID) {
                session.set(i, this);
                break;
            }
        }
    }
    public void setAssessments(ArrayList<Assessment> assessments) {
        this.assessments = new ArrayList<>(assessments);
    }

    public ArrayList<Assessment> getAssessments() {
        return new ArrayList<>(assessments);
    }
    
    public void addAssessment(Assessment assessment) {
        this.assessments.add(assessment);
    }
    
    public void removeAssessment(Assessment assessment) {
        this.assessments.remove(assessment);
    }
    
    public static void listAllSessions(ArrayList<Session> sessions) {
        System.out.println("=== All Sessions ===");
        for (Session s : sessions) {
            System.out.println("Session ID: " + s.getSessionID());
            System.out.println("Session Name: " + s.getSessionName());
            System.out.println("Module: " + s.getModule().getModuleName());
            System.out.println("Classroom: " + s.getClassroom().getRoomName());
            System.out.println("Start Time: " + s.getStartTime());
            System.out.println("End Time: " + s.getEndTime());
            System.out.println("Status: " + s.getStatus());
            System.out.println("Attendees: " + s.getAttendees().size());
            System.out.println("Assessments: " + s.getAssessments().size());
            System.out.println("-----------------");
        }
    }
    
    public void deleteSession(ArrayList<Session> sessions) {
        sessions.remove(this);
    }
}
