public class Classroom {
    private int classroomId;
    private String roomName;
    private int capacity;
    public Classroom(String roomName, int capacity) {
        this.roomName = roomName;
        this.capacity = capacity;
        // This constructor will be used to create a new classroom that's not in the database yet
    }
    public Classroom(int classroomId) {
        this.classroomId = classroomId;
        // This constructor will be used to create a classroom that's already in the database
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
