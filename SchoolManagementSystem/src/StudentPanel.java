import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panel for student operations
 */
public class StudentPanel extends JPanel {
    private SchoolManagementGUI mainFrame;
    private DataStore dataStore;
    private Student currentStudent;
    
    // UI Components
    private JLabel welcomeLabel;
    private JTabbedPane tabbedPane;
    
    public StudentPanel(SchoolManagementGUI mainFrame, DataStore dataStore) {
        this.mainFrame = mainFrame;
        this.dataStore = dataStore;
        
        setLayout(new BorderLayout());
        
        // Welcome panel at the top
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        welcomeLabel = new JLabel("Welcome, Student");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(welcomeLabel, BorderLayout.WEST);
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> mainFrame.showLoginPanel());
        topPanel.add(logoutButton, BorderLayout.EAST);
        
        add(topPanel, BorderLayout.NORTH);
        
        // Create tabbed pane for different operations
        tabbedPane = new JTabbedPane();
        
        // Create and add tabs
        tabbedPane.addTab("My Courses", createEnrolledCoursesPanel());
        tabbedPane.addTab("Enroll in Course", createEnrollCoursePanel());
        tabbedPane.addTab("My Payments", createPaymentsPanel());
        
        add(tabbedPane, BorderLayout.CENTER);
    }
    
    /**
     * Set the current student and update UI
     */
    public void setCurrentStudent(Student student) {
        this.currentStudent = student;
        welcomeLabel.setText("Welcome, " + student.getName());
        refreshData();
    }
    
    /**
     * Refresh all data in the panels
     */
    private void refreshData() {
        // Refresh each tab's data
        refreshEnrolledCourses();
        refreshPayments();
    }
    
    /**
     * Create the enrolled courses panel
     */
    private JPanel createEnrolledCoursesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create table for enrolled courses
        String[] columns = {"Enrollment ID", "Module ID", "Module Name", "Status", "Grade"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make the table non-editable
            }
        };
        
        JTable enrollmentsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(enrollmentsTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    /**
     * Refresh enrolled courses data
     */
    private void refreshEnrolledCourses() {
        if (currentStudent == null) return;
        
        // Get the table model
        JScrollPane scrollPane = (JScrollPane) ((JPanel) tabbedPane.getComponentAt(0)).getComponent(0);
        JTable table = (JTable) scrollPane.getViewport().getView();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        // Clear the table
        model.setRowCount(0);
        
        // Populate with enrolled courses
        for (Enrollment e : dataStore.enrollments) {
            if (e.getStudent().getStudentID() == currentStudent.getStudentID()) {
                model.addRow(new Object[]{
                    e.getEnrollmentID(),
                    e.getModule().getModuleID(),
                    e.getModule().getModuleName(),
                    e.getEnrollmentStatus(),
                    e.getGrade()
                });
            }
        }
    }
    
    /**
     * Create panel for enrolling in a course
     */
    private JPanel createEnrollCoursePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create available modules table
        String[] columns = {"Module ID", "Module Name", "Year", "Available Seats"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JTable modulesTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(modulesTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Add enroll button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshAvailableModules());
        
        JButton enrollButton = new JButton("Enroll");
        enrollButton.addActionListener(e -> {
            int selectedRow = modulesTable.getSelectedRow();
            if (selectedRow != -1) {
                int moduleID = (int) modulesTable.getValueAt(selectedRow, 0);
                enrollInModule(moduleID);
            } else {
                JOptionPane.showMessageDialog(this,
                    "Please select a module to enroll in",
                    "Enrollment Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        
        bottomPanel.add(refreshButton);
        bottomPanel.add(enrollButton);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    /**
     * Refresh the available modules list
     */
    private void refreshAvailableModules() {
        if (currentStudent == null) return;
        
        // Get the table model
        JScrollPane scrollPane = (JScrollPane) ((JPanel) tabbedPane.getComponentAt(1)).getComponent(0);
        JTable table = (JTable) scrollPane.getViewport().getView();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        // Clear the table
        model.setRowCount(0);
        
        // Count enrollments for each module
        for (Module m : dataStore.modules) {
            // Check if module is for the student's year
            if (m.getModuleYear() == currentStudent.getYear()) {
                // Count enrolled students
                int enrolledCount = 0;
                boolean alreadyEnrolled = false;
                
                for (Enrollment e : dataStore.enrollments) {
                    if (e.getModule().getModuleID() == m.getModuleID()) {
                        enrolledCount++;
                        
                        if (e.getStudent().getStudentID() == currentStudent.getStudentID()) {
                            alreadyEnrolled = true;
                        }
                    }
                }
                
                // Add to table if not already enrolled and has space
                if (!alreadyEnrolled && enrolledCount < m.getMaxCapacity()) {
                    model.addRow(new Object[]{
                        m.getModuleID(),
                        m.getModuleName(),
                        m.getModuleYear(),
                        m.getMaxCapacity() - enrolledCount
                    });
                }
            }
        }
    }
    
    /**
     * Enroll the current student in a module
     */
    private void enrollInModule(int moduleID) {
        // Find the module
        Module module = null;
        for (Module m : dataStore.modules) {
            if (m.getModuleID() == moduleID) {
                module = m;
                break;
            }
        }
        
        if (module == null) {
            JOptionPane.showMessageDialog(this, 
                "Module not found", 
                "Enrollment Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Create new enrollment
        Status status = Status.ACTIVE;
        Enrollment newEnrollment = new Enrollment(currentStudent, module, status);
        newEnrollment.addEnrollment(dataStore.enrollments);
        
        JOptionPane.showMessageDialog(this, 
            "Successfully enrolled in " + module.getModuleName(), 
            "Enrollment Success",
            JOptionPane.INFORMATION_MESSAGE);
        
        // Refresh data
        refreshData();
        refreshAvailableModules();
    }
    
    /**
     * Create panel for viewing payments
     */
    private JPanel createPaymentsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create payments table
        String[] columns = {"Payment ID", "Amount", "Description", "Date"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JTable paymentsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(paymentsTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    /**
     * Refresh payments data
     */
    private void refreshPayments() {
        if (currentStudent == null) return;
        
        // Get the table model
        JScrollPane scrollPane = (JScrollPane) ((JPanel) tabbedPane.getComponentAt(2)).getComponent(0);
        JTable table = (JTable) scrollPane.getViewport().getView();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        // Clear the table
        model.setRowCount(0);
        
        // Populate with payments
        for (Payment p : dataStore.payments) {
            if (p.getPayeeId().getStudentID() == currentStudent.getStudentID()) {
                model.addRow(new Object[]{
                    p.getPaymentID(),
                    p.getAmount(),
                    p.getDescription(),
                    p.getDate()
                });
            }
        }
    }
}