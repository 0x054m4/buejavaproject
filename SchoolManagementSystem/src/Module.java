import java.util.*;

public class Module {
    private int moduleID;
    private String moduleName;
    private float grade;

    public Module(int moduleID) {
        this.moduleID = moduleID;
    }

    public Module(String moduleName, float grade) {
        this.moduleName = moduleName;
        this.grade = grade;        
    }

    public int getModuleID() {
        return moduleID;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public float getGrade() {
        return grade;
    }
}
