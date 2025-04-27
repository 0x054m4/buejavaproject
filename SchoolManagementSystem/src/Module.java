import java.lang.reflect.Array;
import java.util.*;

public class Module {
    private int moduleID;
    private String moduleName;

    public Module(int moduleID) {
        this.moduleID = moduleID;
    }

    public Module(String moduleName) {
        this.moduleName = moduleName;
        
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
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



}
