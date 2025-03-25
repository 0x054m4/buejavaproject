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

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

   
    public boolean login() {
        //to be implemented in phase 2
        System.out.println("Logged in succesfully!");
        return true;
    }
}

enum StaffStatus {
    ACTIVE, INACTIVE, SUSPENDED, TERMINATED;
}
