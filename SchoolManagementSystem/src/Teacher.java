import java.util.ArrayList;

public class Teacher extends Staff {
   
    private ArrayList<Module> assignedModules; 

    public Teacher(int staffId) {
        super(staffId);
    }

    public void setAssignedModules(ArrayList<Module> assignedModules) {
        this.assignedModules = assignedModules;
    }

    public ArrayList<Module> getAssignedModules() {
        return assignedModules;
    }

    public void assignModule(Module module) {
        assignedModules.add(module);
        System.out.println("Module " + module.getModuleID() + " assigned to teacher.");
    }

    public void removeModuleAssignment(int moduleID) {
        for (Module module : assignedModules) {
            if (module.getModuleID() == moduleID) {
               assignedModules.remove(module);
                System.out.println("Module " + moduleID + " removed");
            }
        }
        System.out.println("Module " + moduleID + " removed from teacher's assignments.");
    }

    // public void updateModuleAssignment(int moduleID, int newModuleID) {
    //     for (Module module : assignedModules) {
    //         if (module.getModuleID() == moduleID) {
    //             module.setModuleID(newModuleID);
    //             System.out.println("Module " + moduleID + " updated to " + newModuleID + ".");
    //         }
    //     }
    // }
}