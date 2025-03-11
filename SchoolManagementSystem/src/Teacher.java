import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private List<Module> assignedModules; // List of assigned modules

    // Constructor
    public Teacher() {
        this.assignedModules = new ArrayList<>();
    }

    // Setters and Getters
    public void setAssignedModules(List<Module> assignedModules) {
        this.assignedModules = assignedModules;
    }

    public List<Module> getAssignedModules() {
        return assignedModules;
    }

    // Assign a module to the teacher
    public void assignModule(Module module) {
        assignedModules.add(module);
        System.out.println("Module " + module.getModuleID() + " assigned to teacher.");
    }

    // Remove a module assignment
    public void removeModuleAssignment(int moduleID) {
        assignedModules.removeIf(module -> module.getModuleID() == moduleID);
        System.out.println("Module " + moduleID + " removed from teacher's assignments.");
    }

    // Update an assigned module
    public void updateModuleAssignment(int moduleID, int newModuleID) {
        for (Module module : assignedModules) {
            if (module.getModuleID() == moduleID) {
                module.setModuleID(newModuleID);
                System.out.println("Module " + moduleID + " updated to " + newModuleID + ".");
                return;
            }
        }
    }
}