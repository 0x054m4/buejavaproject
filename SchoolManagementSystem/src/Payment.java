public class Payment {
    private int paymentID;
    private float amount;
    private Student student;
    private String description;
    private String date;

    public Payment(int paymentID) {
        this.paymentID = paymentID;
    }

    public Payment(float amount, Student student, String description, String date) {
        this.amount = amount;
        this.student = student;
        this.description = description;
        this.date = date;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public void setPayeeId(Student student) {
        this.student = student;
    }

    public Student getPayeeId() {
        return student;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public boolean saveToDB() {
        return true;
    }

    public boolean updateOnDB() {
        return true;
    }

    public boolean fetchFromDB() {
        return true;
    }

    public boolean deleteFromDB() {
        return true;
    }

    public boolean addPayment(float amount) {
        this.amount += amount;
        return true;
    }

    public String generateReceipt() {
        return "Receipt for Payment ID: " + paymentID + "\nAmount: " + amount + "\nDate: " + date;
    }
}
