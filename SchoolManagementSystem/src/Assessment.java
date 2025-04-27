import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Assessment implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int assessmentCounter = 0;
    private int assessmentID;
    private Date date;
    private String duration;
    private String title;
    private Module module;

    
    public Assessment(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    
    public Assessment(int assessmentID, Date date, String duration, Module module, String title) {
        this.assessmentID = assessmentID;
        this.date = date;
        this.duration = duration;
        this.module = module;
        this.title = title;
        this.assessmentID = assessmentCounter++;
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
    
    // Static methods for managing collections of assessments
    public static void listAllAssessments(ArrayList<Assessment> assessments) {
        System.out.println("=== All Assessments ===");
        for (Assessment a : assessments) {
            System.out.println("Assessment ID: " + a.getAssessmentID());
            System.out.println("Title: " + a.getTitle());
            System.out.println("Date: " + a.getDate());
            System.out.println("Duration: " + a.getDuration());
            System.out.println("Module: " + a.getModule().getModuleName());
            System.out.println("-----------------");
        }
    }
    
    public void addAssessment(ArrayList<Assessment> assessments) {
        assessments.add(this);
    }
    
    public void deleteAssessment(ArrayList<Assessment> assessments) {
        assessments.remove(this);
    }
    
    public void updateAssessment(ArrayList<Assessment> assessments) {
        for (int i = 0; i < assessments.size(); i++) {
            if (assessments.get(i).getAssessmentID() == this.assessmentID) {
                assessments.set(i, this);
                break;
            }
        }
    }
    
    // Helper methods for assessment management
    public void scheduleAssessment(Date newDate) {
        this.date = newDate;
        System.out.println("Assessment scheduled for " + newDate);
    }
    
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("Assessment Report\n");
        report.append("ID: ").append(assessmentID).append("\n");
        report.append("Title: ").append(title).append("\n");
        report.append("Date: ").append(date).append("\n");
        report.append("Duration: ").append(duration).append("\n");
        report.append("Module: ").append(module.getModuleName()).append("\n");
        return report.toString();
    }
}
