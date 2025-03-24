
    public class Admin extends Staff {

    public Admin(int staffId) {
        super(staffId);  
    }

    public int[] viewStatistics() {
        
        
        int[] statistics = {500, 350, 20};
        return statistics;
    }

    
    public void generateReports() {
        
        // Will save a .csv file with the reports
        System.out.println("Reports generated successfully!");
    }

}
