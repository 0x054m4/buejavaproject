import java.util.Date;

public class Assessment {
    private int assessmentID;
    private Date date;
    private String duration;
<<<<<<< Updated upstream
    private Module module;
    private String title;

    public Assessment(int assessmentID){
        this.assessmentID = assessmentID;
    }

    public Assessment(Date date, String duration, Module module, String title) {
=======
    private String title;
    private Module module;

    
    public Assessment(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    
    public Assessment(int assessmentID, Date date, String duration, Module module, String title) {
        this.assessmentID = assessmentID;
>>>>>>> Stashed changes
        this.date = date;
        this.duration = duration;
        this.module = module;
        this.title = title;
    }

<<<<<<< Updated upstream
=======
    
>>>>>>> Stashed changes
    public int getAssessmentID() {
        return assessmentID;
    }

<<<<<<< Updated upstream
=======
    
>>>>>>> Stashed changes
    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

<<<<<<< Updated upstream
    public void setDuration(String duration) {
        this.duration = duration;
    }
    
=======
    
    public void setDuration(String duration) {
        this.duration = duration;
    }

>>>>>>> Stashed changes
    public String getDuration() {
        return duration;
    }

<<<<<<< Updated upstream
    public void setModule(Module module) {
        this.module = module;
    }
    
    public Module getModule() {
        return module;
    }  

    public void setTitle(String title) {
        this.title = title;
    }
    
=======
    
    public void setModule(Module module) {
        this.module = module;
    }

    public Module getModule() {
        return module;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }

>>>>>>> Stashed changes
    public String getTitle() {
        return title;
    }
}
