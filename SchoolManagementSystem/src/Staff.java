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
    }

    public String getName() {
        return name;
    }

    public void setrole(String role) {
        this.role = role;
    }

    public String getrole() {
        return role;
    }

    }

