import java.io.*;
import java.util.*;

public class Module implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int moduleCounter = 0;
    private int moduleID;
    private String moduleName;
    private int maxCapacity;
    private List<Assessment> assessment;
    private int moduleYear;
    private static final String FILE_PATH = "modules.dat";
    
    public Module(int moduleID) {
        this.moduleID = moduleID;
    }

    public Module(String moduleName, int maxCapacity, List<Assessment> assessment, int moduleYear) {
        this.moduleName = moduleName;
        this.maxCapacity = maxCapacity;
        this.assessment = assessment != null ? assessment : new ArrayList<>();
        this.maxCapacity = maxCapacity;
        this.moduleYear = moduleYear;
        this.moduleID = moduleCounter++;
    }

    public int getModuleID() {
        return moduleID;
    }
    
    public void setModuleYear(int moduleYear) {
        this.moduleYear = moduleYear;
    }
    
    public int getModuleYear() {
        return moduleYear;
    }
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setAssessment(List<Assessment> assessment) {
        this.assessment = assessment;
    }
    
    public List<Assessment> getAssessments() {
        return assessment;
    }

    public void addModule() {
        List<Module> modules = getAllModules();
        modules.add(this);
        saveAllModules(modules);
    }
    
    public void removeModule() {
        List<Module> modules = getAllModules();
        modules.removeIf(m -> m.getModuleID() == this.getModuleID());
        saveAllModules(modules);
    }

    public void updateModule() {
        List<Module> modules = getAllModules();
        for (int i = 0; i < modules.size(); i++) {
            if (modules.get(i).getModuleID() == this.getModuleID()) {
                modules.set(i, this);
                break;
            }
        }
        saveAllModules(modules);
    }

    public static void listAllModules() {
        List<Module> modules = getAllModules();
        System.out.println("=== All Modules ===");
        for (Module m : modules) {
            System.out.println("Module ID: " + m.getModuleID());
            System.out.println("Module Name: " + m.getModuleName());
            System.out.println("Max Capacity: " + m.getMaxCapacity());
            System.out.println("Module Year: " + m.getModuleYear());
            System.out.println("-----------------");
        }
    }
    
    // File operations
    public static List<Module> getAllModules() {
        List<Module> modules = new ArrayList<>();
        File file = new File(FILE_PATH);
        
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                modules = (List<Module>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading modules: " + e.getMessage());
            }
        }
        
        return modules;
    }
    
    public static void saveAllModules(List<Module> modules) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(modules);
        } catch (IOException e) {
            System.out.println("Error saving modules: " + e.getMessage());
        }
    }
    
    public static Module getModuleById(int moduleId) {
        List<Module> modules = getAllModules();
        for (Module module : modules) {
            if (module.getModuleID() == moduleId) {
                return module;
            }
        }
        return null;
    }
}
