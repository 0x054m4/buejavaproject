import java.util.Date;

public class Assessment {
    private int assessmentID;
    private Date date;
    private String duration;
    private Module module;
    private String title;

    public Assessment(int assessmentID){
        this.assessmentID = assessmentID;
    }

    public Assessment(Date date, String duration, Module module, String title) {
        this.date = date;
        this.duration = duration;
        this.module = module;
        this.title = title;
    }

    public int getAssessmentID() {
        return assessmentID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    public String getDuration() {
        return duration;
    }

    public void setModule(Module module) {
        this.module = module;
    }
    
    public Module getModule() {
        return module;
    }  

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
}
