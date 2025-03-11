<<<<<<< HEAD
import java.util.List;

public class Student {
    private int staffID;
    private String name;
    private String email;
    private String role;
    private status StaffStatus;

    // Constructors
    public Staff(int staffID) {
        this.staffID = staffID;
    }

    public Staff(String name, String email, String role , status StaffStatus) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.StaffStatus = StaffStatus;
    }

    // Getters and Setters
    public void setstaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getstaffID() {
        return staffID;
    }

    public void setName(String name) {
        this.name = name;
=======
public class Staff {
    private int staffId;
    private String name;
    private String email;
    private String role;
    private StaffStatus status;

    public Staff(int staffId) {
        this.staffId = staffId;
    }

    public Staff(String name, String email, String role, StaffStatus status) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.status = status;
    }

    public int getStaffID() {
        return staffId;
    }

    public void setStaffID(int staffId) {
        this.staffId = staffId;
>>>>>>> 8e11b52cbbf7d995ecad38cbd05cd8d4f8333119
    }

    public String getName() {
        return name;
    }

<<<<<<< HEAD
    public void setrole(String role) {
        this.role = role;
    }

    public String getrole() {
        return role;
    }

    }

=======
    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public StaffStatus getStatus() {
        return status;
    }

    public void setStatus(StaffStatus status) {
        this.status = status;
    }

    public boolean login(int staffID) {
        System.out.println("Staff " + staffID + " logged in.");
        return true;
    }

    public void logout() {
        System.out.println("Staff " + staffId + " logged out.");
    }
}

enum StaffStatus {
    ACTIVE, INACTIVE, SUSPENDED, TERMINATED;
}
>>>>>>> 8e11b52cbbf7d995ecad38cbd05cd8d4f8333119
