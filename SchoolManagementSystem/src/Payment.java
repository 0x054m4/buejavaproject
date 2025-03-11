public class Payment {
    private int paymentID;
    private float amount;
    private int studentId;
    private String description;
    private String date;

    public Payment(int paymentID) {
        this.paymentID = paymentID;
    }

    public Payment(float amount, int studentId, String description, String date) {
        this.amount = amount;
        this.studentId = studentId;
        this.description = description;
        this.date = date;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
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

    public void setPayeeId(int studentId) {
        this.studentId = studentId;
    }

    public int getPayeeId() {
        return studentId;
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
