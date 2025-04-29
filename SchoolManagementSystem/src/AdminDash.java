import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.text.SimpleDateFormat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Omayr
 */
public class AdminDashboard extends javax.swing.JFrame {

    private CardLayout cardLayout;
    private JPanel contentPanel;
    
    // Data collections
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Module> modules;
    private ArrayList<Classroom> classrooms;
    private ArrayList<Session> sessions;
    private ArrayList<Enrollment> enrollments;
    private ArrayList<Payment> payments;
    
    // Tables for each section
    private JTable studentTable;
    private JTable teacherTable;
    private JTable moduleTable;
    private JTable assessmentTable;
    private JTable paymentTable;
    
    /**
     * Creates new form AdminDashboard
     */
    public AdminDashboard() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // Load all data
        loadAllData();
        
        // Initialize card layout and content panel
        contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);
        
        // Initialize panels for each section
        initStudentsPanel();
        initTeachersPanel();
        initModulesPanel();
        initAssessmentsPanel();
        initPaymentsPanel();
        
        // Add content panel to main frame
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        // Show students panel by default
        cardLayout.show(contentPanel, "students");
        highlightSelectedButton(AdminDshbrdStudentsBtn);
    }
    
    /**
     * Load all data from FileDataStore
     */
    private void loadAllData() {
        // Load data from FileDataStore
        students = FileDataStore.loadStudents();
        modules = FileDataStore.loadModules();
        classrooms = FileDataStore.loadClassrooms();
        teachers = FileDataStore.loadTeachers();
        sessions = FileDataStore.loadSessions(modules, classrooms);
        enrollments = FileDataStore.loadEnrollments(students, modules);
        payments = FileDataStore.loadPayments(students);
    }
    
    private void highlightSelectedButton(javax.swing.JLabel selectedLabel) {
        // Reset all buttons to default
        AdminDshbrdStudentsBtn.setOpaque(false);
        AdminDshbrdTeachersBtn.setOpaque(false);
        AdminDshbrdModulesBtn.setOpaque(false);
        AdminDshbrdAssessmentsBtn.setOpaque(false);
        AdminDshbrdPaymentsBtn.setOpaque(false);
        
        // Highlight selected button
        selectedLabel.setOpaque(true);
        selectedLabel.setBackground(new Color(204, 229, 255));
        
        // Repaint to show changes
        sidebarPanel.repaint();
    }
    
    private void initStudentsPanel() {
        JPanel studentPanel = new JPanel(new BorderLayout());
        
        // Create toolbar with buttons
        JPanel toolbar = new JPanel();
        javax.swing.JButton addStudentBtn = new javax.swing.JButton("Add Student");
        addStudentBtn.setBackground(new Color(51, 153, 255));
        
        javax.swing.JButton updateStudentBtn = new javax.swing.JButton("Update Student");
        updateStudentBtn.setBackground(new Color(51, 153, 255));
        
        javax.swing.JButton deleteStudentBtn = new javax.swing.JButton("Delete Student");
        deleteStudentBtn.setBackground(new Color(51, 153, 255));
        
        toolbar.add(addStudentBtn);
        toolbar.add(updateStudentBtn);
        toolbar.add(deleteStudentBtn);
        
        // Create student table
        studentTable = new JTable();
        studentTable.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Student ID", "Name", "Email", "Year", "Annual Fee"
            }
        ));
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(studentTable);
        javax.swing.JPanel tablePanel = new javax.swing.JPanel(new BorderLayout());
        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Students", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18)));
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        studentPanel.add(toolbar, BorderLayout.NORTH);
        studentPanel.add(tablePanel, BorderLayout.CENTER);
        
        contentPanel.add(studentPanel, "students");
        
        // Add action listeners for the student panel buttons
        setupStudentActionListeners(addStudentBtn, updateStudentBtn, deleteStudentBtn);
    }
    
    private void initTeachersPanel() {
        JPanel teacherPanel = new JPanel(new BorderLayout());
        
        // Create toolbar with buttons
        JPanel toolbar = new JPanel();
        javax.swing.JButton addTeacherBtn = new javax.swing.JButton("Add Teacher");
        addTeacherBtn.setBackground(new Color(51, 153, 255));
        
        javax.swing.JButton updateTeacherBtn = new javax.swing.JButton("Update Teacher");
        updateTeacherBtn.setBackground(new Color(51, 153, 255));
        
        javax.swing.JButton deleteTeacherBtn = new javax.swing.JButton("Delete Teacher");
        deleteTeacherBtn.setBackground(new Color(51, 153, 255));
        
        toolbar.add(addTeacherBtn);
        toolbar.add(updateTeacherBtn);
        toolbar.add(deleteTeacherBtn);
        
        // Create teacher table
        teacherTable = new JTable();
        teacherTable.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Teacher ID", "Name", "Email", "Role"
            }
        ));
        teacherTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(teacherTable);
        javax.swing.JPanel tablePanel = new javax.swing.JPanel(new BorderLayout());
        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Teachers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18)));
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        teacherPanel.add(toolbar, BorderLayout.NORTH);
        teacherPanel.add(tablePanel, BorderLayout.CENTER);
        
        contentPanel.add(teacherPanel, "teachers");
        
        // Add action listeners for the teacher panel buttons
        setupTeacherActionListeners(addTeacherBtn, updateTeacherBtn, deleteTeacherBtn);
    }
    
    private void initModulesPanel() {
        JPanel modulePanel = new JPanel(new BorderLayout());
        
        // Create toolbar with buttons
        JPanel toolbar = new JPanel();
        javax.swing.JButton addModuleBtn = new javax.swing.JButton("Add Module");
        addModuleBtn.setBackground(new Color(51, 153, 255));
        
        javax.swing.JButton updateModuleBtn = new javax.swing.JButton("Update Module");
        updateModuleBtn.setBackground(new Color(51, 153, 255));
        
        javax.swing.JButton deleteModuleBtn = new javax.swing.JButton("Delete Module");
        deleteModuleBtn.setBackground(new Color(51, 153, 255));
        
        toolbar.add(addModuleBtn);
        toolbar.add(updateModuleBtn);
        toolbar.add(deleteModuleBtn);
        
        // Create module table
        moduleTable = new JTable();
        moduleTable.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Module ID", "Name", "Capacity", "Year"
            }
        ));
        moduleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(moduleTable);
        javax.swing.JPanel tablePanel = new javax.swing.JPanel(new BorderLayout());
        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modules", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18)));
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        modulePanel.add(toolbar, BorderLayout.NORTH);
        modulePanel.add(tablePanel, BorderLayout.CENTER);
        
        contentPanel.add(modulePanel, "modules");
        
        // Add action listeners for the module panel buttons
        setupModuleActionListeners(addModuleBtn, updateModuleBtn, deleteModuleBtn);
    }
    
    private void initAssessmentsPanel() {
        JPanel assessmentPanel = new JPanel(new BorderLayout());
        
        // Create toolbar with buttons
        JPanel toolbar = new JPanel();
        javax.swing.JButton addAssessmentBtn = new javax.swing.JButton("Add Assessment");
        addAssessmentBtn.setBackground(new Color(51, 153, 255));
        
        javax.swing.JButton updateAssessmentBtn = new javax.swing.JButton("Update Assessment");
        updateAssessmentBtn.setBackground(new Color(51, 153, 255));
        
        javax.swing.JButton deleteAssessmentBtn = new javax.swing.JButton("Delete Assessment");
        deleteAssessmentBtn.setBackground(new Color(51, 153, 255));
        
        toolbar.add(addAssessmentBtn);
        toolbar.add(updateAssessmentBtn);
        toolbar.add(deleteAssessmentBtn);
        
        // Create assessment table
        assessmentTable = new JTable();
        assessmentTable.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Assessment ID", "Title", "Module", "Date", "Duration"
            }
        ));
        assessmentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(assessmentTable);
        javax.swing.JPanel tablePanel = new javax.swing.JPanel(new BorderLayout());
        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Assessments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18)));
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        assessmentPanel.add(toolbar, BorderLayout.NORTH);
        assessmentPanel.add(tablePanel, BorderLayout.CENTER);
        
        contentPanel.add(assessmentPanel, "assessments");
        
        // Add action listeners for assessment buttons
        setupAssessmentActionListeners(addAssessmentBtn, updateAssessmentBtn, deleteAssessmentBtn);
    }
    
    private void initPaymentsPanel() {
        JPanel paymentPanel = new JPanel(new BorderLayout());
        
        // Create toolbar with buttons
        JPanel toolbar = new JPanel();
        javax.swing.JButton addPaymentBtn = new javax.swing.JButton("Add Payment");
        addPaymentBtn.setBackground(new Color(51, 153, 255));
        
        javax.swing.JButton updatePaymentBtn = new javax.swing.JButton("Update Payment");
        updatePaymentBtn.setBackground(new Color(51, 153, 255));
        
        javax.swing.JButton deletePaymentBtn = new javax.swing.JButton("Delete Payment");
        deletePaymentBtn.setBackground(new Color(51, 153, 255));
        
        toolbar.add(addPaymentBtn);
        toolbar.add(updatePaymentBtn);
        toolbar.add(deletePaymentBtn);
        
        // Create payment table
        paymentTable = new JTable();
        paymentTable.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Payment ID", "Student", "Amount", "Date", "Description"
            }
        ));
        paymentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(paymentTable);
        javax.swing.JPanel tablePanel = new javax.swing.JPanel(new BorderLayout());
        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18)));
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        paymentPanel.add(toolbar, BorderLayout.NORTH);
        paymentPanel.add(tablePanel, BorderLayout.CENTER);
        
        contentPanel.add(paymentPanel, "payments");
        
        // Add action listeners for payment buttons
        setupPaymentActionListeners(addPaymentBtn, updatePaymentBtn, deletePaymentBtn);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        AdminDshbrdLogout = new javax.swing.JButton();
        sidebarPanel = new javax.swing.JPanel();
        AdminDshbrdStudentsBtn = new javax.swing.JLabel();
        AdminDshbrdTeachersBtn = new javax.swing.JLabel();
        AdminDshbrdModulesBtn = new javax.swing.JLabel();
        AdminDshbrdAssessmentsBtn = new javax.swing.JLabel();
        AdminDshbrdPaymentsBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Admin Dashboard");

        // Remove icon reference to avoid NullPointerException
        AdminDshbrdLogout.setText("Logout");
        AdminDshbrdLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminDshbrdLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(AdminDshbrdLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AdminDshbrdLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(42, 42, 42))
        );

        getContentPane().add(jPanel3, BorderLayout.NORTH);

        sidebarPanel.setBackground(new java.awt.Color(204, 204, 204));
        sidebarPanel.setPreferredSize(new Dimension(200, 0));
        sidebarPanel.setLayout(new javax.swing.BoxLayout(sidebarPanel, javax.swing.BoxLayout.Y_AXIS));

        // Remove all icon references from sidebar items
        AdminDshbrdStudentsBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AdminDshbrdStudentsBtn.setText("  Students");
        AdminDshbrdStudentsBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 10, 15, 10));
        AdminDshbrdStudentsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminDshbrdStudentsBtnMouseClicked(evt);
            }
        });
        sidebarPanel.add(AdminDshbrdStudentsBtn);

        AdminDshbrdTeachersBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AdminDshbrdTeachersBtn.setText("  Teachers");
        AdminDshbrdTeachersBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 10, 15, 10));
        AdminDshbrdTeachersBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminDshbrdTeachersBtnMouseClicked(evt);
            }
        });
        sidebarPanel.add(AdminDshbrdTeachersBtn);

        AdminDshbrdModulesBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AdminDshbrdModulesBtn.setText("  Modules");
        AdminDshbrdModulesBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 10, 15, 10));
        AdminDshbrdModulesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminDshbrdModulesBtnMouseClicked(evt);
            }
        });
        sidebarPanel.add(AdminDshbrdModulesBtn);

        AdminDshbrdAssessmentsBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AdminDshbrdAssessmentsBtn.setText("  Assessments");
        AdminDshbrdAssessmentsBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 10, 15, 10));
        AdminDshbrdAssessmentsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminDshbrdAssessmentsBtnMouseClicked(evt);
            }
        });
        sidebarPanel.add(AdminDshbrdAssessmentsBtn);

        AdminDshbrdPaymentsBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AdminDshbrdPaymentsBtn.setText("  Payments");
        AdminDshbrdPaymentsBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 10, 15, 10));
        AdminDshbrdPaymentsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminDshbrdPaymentsBtnMouseClicked(evt);
            }
        });
        sidebarPanel.add(AdminDshbrdPaymentsBtn);

        getContentPane().add(sidebarPanel, BorderLayout.WEST);

        pack();
    }// </editor-fold>                        

    private void AdminDshbrdLogoutActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        this.dispose();
        new StudentLogin().setVisible(true);
    }                                                 

    private void AdminDshbrdStudentsBtnMouseClicked(java.awt.event.MouseEvent evt) {                                                    
        cardLayout.show(contentPanel, "students");
        highlightSelectedButton(AdminDshbrdStudentsBtn);
    }                                                   

    private void AdminDshbrdTeachersBtnMouseClicked(java.awt.event.MouseEvent evt) {                                                    
        cardLayout.show(contentPanel, "teachers");
        highlightSelectedButton(AdminDshbrdTeachersBtn);
    }                                                   

    private void AdminDshbrdModulesBtnMouseClicked(java.awt.event.MouseEvent evt) {                                                   
        cardLayout.show(contentPanel, "modules");
        highlightSelectedButton(AdminDshbrdModulesBtn);
    }                                                  

    private void AdminDshbrdAssessmentsBtnMouseClicked(java.awt.event.MouseEvent evt) {                                                       
        cardLayout.show(contentPanel, "assessments");
        highlightSelectedButton(AdminDshbrdAssessmentsBtn);
    }                                                      

    private void AdminDshbrdPaymentsBtnMouseClicked(java.awt.event.MouseEvent evt) {                                                    
        cardLayout.show(contentPanel, "payments");
        highlightSelectedButton(AdminDshbrdPaymentsBtn);
    }                                                   

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            refreshAllTables();
        }
    }
    
    /**
     * Refresh all tables with current data
     */
    private void refreshAllTables() {
        refreshStudentTable();
        refreshTeacherTable();
        refreshModuleTable();
        refreshAssessmentTable();
        refreshPaymentTable();
    }
    
    /**
     * Refresh the student table with current data
     */
    private void refreshStudentTable() {
        DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
        model.setRowCount(0); // Clear existing data
        
        for (Student student : students) {
            model.addRow(new Object[]{
                student.getStudentID(),
                student.getName(),
                student.getEmail(),
                student.getYear(),
                String.format("$%.2f", student.getAnnualFee())
            });
        }
    }
    
    /**
     * Refresh the teacher table with current data
     */
    private void refreshTeacherTable() {
        DefaultTableModel model = (DefaultTableModel) teacherTable.getModel();
        model.setRowCount(0); // Clear existing data
        
        for (Teacher teacher : teachers) {
            model.addRow(new Object[]{
                teacher.getStaffId(),
                teacher.getName(),
                teacher.getEmail(),
                teacher.getRole()
            });
        }
    }
    
    /**
     * Refresh the module table with current data
     */
    private void refreshModuleTable() {
        DefaultTableModel model = (DefaultTableModel) moduleTable.getModel();
        model.setRowCount(0); // Clear existing data
        
        for (Module module : modules) {
            model.addRow(new Object[]{
                module.getModuleID(),
                module.getModuleName(),
                module.getMaxCapacity(),
                module.getModuleYear()
            });
        }
    }
    
    /**
     * Refresh the assessment table with current data
     */
    private void refreshAssessmentTable() {
        DefaultTableModel model = (DefaultTableModel) assessmentTable.getModel();
        model.setRowCount(0); // Clear existing data
        
        // For each module, get its assessments
        for (Module module : modules) {
            ArrayList<Assessment> assessments = module.getAssessments();
            if (assessments != null) {
                for (Assessment assessment : assessments) {
                    model.addRow(new Object[]{
                        assessment.getAssessmentID(),
                        assessment.getTitle(),
                        module.getModuleName(),
                        new SimpleDateFormat("dd/MM/yyyy").format(assessment.getDate()),
                        assessment.getDuration()
                    });
                }
            }
        }
    }
    
    /**
     * Refresh the payment table with current data
     */
    private void refreshPaymentTable() {
        DefaultTableModel model = (DefaultTableModel) paymentTable.getModel();
        model.setRowCount(0); // Clear existing data
        
        for (Payment payment : payments) {
            model.addRow(new Object[]{
                payment.getPaymentID(),
                payment.getPayeeId().getName(),
                String.format("$%.2f", payment.getAmount()),
                payment.getDate(),
                payment.getDescription()
            });
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel AdminDshbrdAssessmentsBtn;
    private javax.swing.JButton AdminDshbrdLogout;
    private javax.swing.JLabel AdminDshbrdModulesBtn;
    private javax.swing.JLabel AdminDshbrdPaymentsBtn;
    private javax.swing.JLabel AdminDshbrdStudentsBtn;
    private javax.swing.JLabel AdminDshbrdTeachersBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel sidebarPanel;
    // End of variables declaration                   

    /**
     * Setup action listeners for student panel buttons
     */
    private void setupStudentActionListeners(javax.swing.JButton addBtn, javax.swing.JButton updateBtn, javax.swing.JButton deleteBtn) {
        // Add Student button action
        addBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter student name:");
            if (name == null || name.trim().isEmpty()) return;
            
            String email = JOptionPane.showInputDialog(this, "Enter student email:");
            if (email == null || email.trim().isEmpty()) return;
            
            String password = JOptionPane.showInputDialog(this, "Enter student password:");
            if (password == null || password.trim().isEmpty()) return;
            
            String yearStr = JOptionPane.showInputDialog(this, "Enter student year (1-12):");
            if (yearStr == null || yearStr.trim().isEmpty()) return;
            
            String feeStr = JOptionPane.showInputDialog(this, "Enter annual fee:");
            if (feeStr == null || feeStr.trim().isEmpty()) return;
            
            try {
                int year = Integer.parseInt(yearStr);
                float fee = Float.parseFloat(feeStr);
                
                Student newStudent = new Student(name, email, fee, year, password);
                students.add(newStudent);
                FileDataStore.saveStudents(students);
                
                refreshStudentTable();
                JOptionPane.showMessageDialog(this, "Student added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // Update Student button action
        updateBtn.addActionListener(e -> {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a student to update", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int studentId = (Integer) studentTable.getValueAt(selectedRow, 0);
            Student studentToUpdate = null;
            
            for (Student s : students) {
                if (s.getStudentID() == studentId) {
                    studentToUpdate = s;
                    break;
                }
            }
            
            if (studentToUpdate == null) {
                JOptionPane.showMessageDialog(this, "Student not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String name = JOptionPane.showInputDialog(this, "Enter student name:", studentToUpdate.getName());
            if (name == null) return;
            
            String email = JOptionPane.showInputDialog(this, "Enter student email:", studentToUpdate.getEmail());
            if (email == null) return;
            
            String yearStr = JOptionPane.showInputDialog(this, "Enter student year (1-12):", studentToUpdate.getYear());
            if (yearStr == null) return;
            
            String feeStr = JOptionPane.showInputDialog(this, "Enter annual fee:", studentToUpdate.getAnnualFee());
            if (feeStr == null) return;
            
            try {
                int year = Integer.parseInt(yearStr);
                float fee = Float.parseFloat(feeStr);
                
                studentToUpdate.setName(name);
                studentToUpdate.setEmail(email);
                studentToUpdate.setYear(year);
                studentToUpdate.setAnnualFee(fee);
                
                studentToUpdate.manageAccount(students);
                refreshStudentTable();
                JOptionPane.showMessageDialog(this, "Student updated successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // Delete Student button action
        deleteBtn.addActionListener(e -> {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a student to delete", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int studentId = (Integer) studentTable.getValueAt(selectedRow, 0);
            Student studentToDelete = null;
            
            for (Student s : students) {
                if (s.getStudentID() == studentId) {
                    studentToDelete = s;
                    break;
                }
            }
            
            if (studentToDelete == null) {
                JOptionPane.showMessageDialog(this, "Student not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to delete student: " + studentToDelete.getName() + "?",
                "Confirm Deletion", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                studentToDelete.removeAccount(students);
                refreshStudentTable();
                JOptionPane.showMessageDialog(this, "Student deleted successfully!");
            }
        });
    }

    /**
     * Setup action listeners for teacher panel buttons
     */
    private void setupTeacherActionListeners(javax.swing.JButton addBtn, javax.swing.JButton updateBtn, javax.swing.JButton deleteBtn) {
        // Add Teacher button action
        addBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter teacher name:");
            if (name == null || name.trim().isEmpty()) return;
            
            String email = JOptionPane.showInputDialog(this, "Enter teacher email:");
            if (email == null || email.trim().isEmpty()) return;
            
            String password = JOptionPane.showInputDialog(this, "Enter teacher password:");
            if (password == null || password.trim().isEmpty()) return;
            
            String role = JOptionPane.showInputDialog(this, "Enter role (e.g., professor, assistant):");
            if (role == null || role.trim().isEmpty()) return;
            
            // Create new teacher and add to collection
            Teacher newTeacher = new Teacher(name, email, role, StaffStatus.ACTIVE, password);
            teachers.add(newTeacher);
            FileDataStore.saveTeachers(teachers);
            
            refreshTeacherTable();
            JOptionPane.showMessageDialog(this, "Teacher added successfully!");
        });
        
        // Update Teacher button action
        updateBtn.addActionListener(e -> {
            int selectedRow = teacherTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a teacher to update", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int teacherId = (Integer) teacherTable.getValueAt(selectedRow, 0);
            Teacher teacherToUpdate = null;
            
            for (Teacher t : teachers) {
                if (t.getStaffId() == teacherId) {
                    teacherToUpdate = t;
                    break;
                }
            }
            
            if (teacherToUpdate == null) {
                JOptionPane.showMessageDialog(this, "Teacher not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String name = JOptionPane.showInputDialog(this, "Enter teacher name:", teacherToUpdate.getName());
            if (name == null) return;
            
            String email = JOptionPane.showInputDialog(this, "Enter teacher email:", teacherToUpdate.getEmail());
            if (email == null) return;
            
            String role = JOptionPane.showInputDialog(this, "Enter role:", teacherToUpdate.getRole());
            if (role == null) return;
            
            teacherToUpdate.setName(name);
            teacherToUpdate.setEmail(email);
            teacherToUpdate.setRole(role);
            
            teacherToUpdate.updateTeacher(teachers);
            refreshTeacherTable();
            JOptionPane.showMessageDialog(this, "Teacher updated successfully!");
        });
        
        // Delete Teacher button action
        deleteBtn.addActionListener(e -> {
            int selectedRow = teacherTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a teacher to delete", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int teacherId = (Integer) teacherTable.getValueAt(selectedRow, 0);
            Teacher teacherToDelete = null;
            int teacherIndex = -1;
            
            for (int i = 0; i < teachers.size(); i++) {
                if (teachers.get(i).getStaffId() == teacherId) {
                    teacherToDelete = teachers.get(i);
                    teacherIndex = i;
                    break;
                }
            }
            
            if (teacherToDelete == null) {
                JOptionPane.showMessageDialog(this, "Teacher not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to delete teacher: " + teacherToDelete.getName() + "?",
                "Confirm Deletion", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                teachers.remove(teacherIndex);
                FileDataStore.saveTeachers(teachers);
                refreshTeacherTable();
                JOptionPane.showMessageDialog(this, "Teacher deleted successfully!");
            }
        });
    }
    
    /**
     * Setup action listeners for module panel buttons
     */
    private void setupModuleActionListeners(javax.swing.JButton addBtn, javax.swing.JButton updateBtn, javax.swing.JButton deleteBtn) {
        // Add Module button action
        addBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter module name:");
            if (name == null || name.trim().isEmpty()) return;
            
            String capacityStr = JOptionPane.showInputDialog(this, "Enter maximum capacity:");
            if (capacityStr == null || capacityStr.trim().isEmpty()) return;
            
            String yearStr = JOptionPane.showInputDialog(this, "Enter module year:");
            if (yearStr == null || yearStr.trim().isEmpty()) return;
            
            try {
                int capacity = Integer.parseInt(capacityStr);
                int year = Integer.parseInt(yearStr);
                
                Module newModule = new Module(name, capacity, new ArrayList<>(), year);
                newModule.addModule(modules);
                
                refreshModuleTable();
                JOptionPane.showMessageDialog(this, "Module added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // Update Module button action
        updateBtn.addActionListener(e -> {
            int selectedRow = moduleTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a module to update", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int moduleId = (Integer) moduleTable.getValueAt(selectedRow, 0);
            Module moduleToUpdate = null;
            
            for (Module m : modules) {
                if (m.getModuleID() == moduleId) {
                    moduleToUpdate = m;
                    break;
                }
            }
            
            if (moduleToUpdate == null) {
                JOptionPane.showMessageDialog(this, "Module not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String name = JOptionPane.showInputDialog(this, "Enter module name:", moduleToUpdate.getModuleName());
            if (name == null) return;
            
            String capacityStr = JOptionPane.showInputDialog(this, "Enter maximum capacity:", moduleToUpdate.getMaxCapacity());
            if (capacityStr == null) return;
            
            String yearStr = JOptionPane.showInputDialog(this, "Enter module year:", moduleToUpdate.getModuleYear());
            if (yearStr == null) return;
            
            try {
                int capacity = Integer.parseInt(capacityStr);
                int year = Integer.parseInt(yearStr);
                
                moduleToUpdate.setModuleName(name);
                moduleToUpdate.setMaxCapacity(capacity);
                moduleToUpdate.setModuleYear(year);
                
                moduleToUpdate.updateModule(modules, moduleToUpdate);
                refreshModuleTable();
                JOptionPane.showMessageDialog(this, "Module updated successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // Delete Module button action
        deleteBtn.addActionListener(e -> {
            int selectedRow = moduleTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a module to delete", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int moduleId = (Integer) moduleTable.getValueAt(selectedRow, 0);
            Module moduleToDelete = null;
            
            for (Module m : modules) {
                if (m.getModuleID() == moduleId) {
                    moduleToDelete = m;
                    break;
                }
            }
            
            if (moduleToDelete == null) {
                JOptionPane.showMessageDialog(this, "Module not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to delete module: " + moduleToDelete.getModuleName() + "?",
                "Confirm Deletion", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                moduleToDelete.removeModule(modules, moduleToDelete);
                refreshModuleTable();
                JOptionPane.showMessageDialog(this, "Module deleted successfully!");
            }
        });
    }
    
    /**
     * Setup action listeners for assessment panel buttons
     */
    private void setupAssessmentActionListeners(javax.swing.JButton addBtn, javax.swing.JButton updateBtn, javax.swing.JButton deleteBtn) {
        // Add Assessment button action
        addBtn.addActionListener(evt -> {
            // First, get the module for this assessment
            String[] moduleOptions = new String[modules.size()];
            for (int i = 0; i < modules.size(); i++) {
                moduleOptions[i] = modules.get(i).getModuleID() + " - " + modules.get(i).getModuleName();
            }
            
            if (moduleOptions.length == 0) {
                JOptionPane.showMessageDialog(this, "No modules available. Please create a module first.", "No Modules", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String selectedModuleStr = (String) JOptionPane.showInputDialog(this, 
                    "Select a module for this assessment:", 
                    "Module Selection", 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    moduleOptions, 
                    moduleOptions[0]);
            
            if (selectedModuleStr == null) return;
            
            int moduleId = Integer.parseInt(selectedModuleStr.split(" - ")[0]);
            Module selectedModule = null;
            for (Module m : modules) {
                if (m.getModuleID() == moduleId) {
                    selectedModule = m;
                    break;
                }
            }
            
            String title = JOptionPane.showInputDialog(this, "Enter assessment title:");
            if (title == null || title.trim().isEmpty()) return;
            
            String durationStr = JOptionPane.showInputDialog(this, "Enter duration (e.g., 2 hours):");
            if (durationStr == null || durationStr.trim().isEmpty()) return;
            
            // Simple date format - in a real app, would use a date picker
            String dateStr = JOptionPane.showInputDialog(this, "Enter date (dd/MM/yyyy):");
            if (dateStr == null || dateStr.trim().isEmpty()) return;
            
            try {
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
                
                // Create new assessment
                Assessment newAssessment = new Assessment(0, date, durationStr, selectedModule, title);
                
                // Add assessment to the module
                ArrayList<Assessment> assessments = selectedModule.getAssessments();
                if (assessments == null) {
                    assessments = new ArrayList<>();
                }
                assessments.add(newAssessment);
                selectedModule.setAssessment(assessments);
                
                // Save modules to persist assessments
                FileDataStore.saveModules(modules);
                
                refreshAssessmentTable();
                JOptionPane.showMessageDialog(this, "Assessment added successfully!");
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // Update Assessment button action
        updateBtn.addActionListener(evt -> {
            int selectedRow = assessmentTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select an assessment to update", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int assessmentId = (Integer) assessmentTable.getValueAt(selectedRow, 0);
            String moduleNameFromTable = (String) assessmentTable.getValueAt(selectedRow, 2);
            
            // Find the module and assessment
            Module moduleWithAssessment = null;
            Assessment assessmentToUpdate = null;
            
            for (Module m : modules) {
                if (m.getModuleName().equals(moduleNameFromTable)) {
                    moduleWithAssessment = m;
                    ArrayList<Assessment> assessments = m.getAssessments();
                    if (assessments != null) {
                        for (Assessment a : assessments) {
                            if (a.getAssessmentID() == assessmentId) {
                                assessmentToUpdate = a;
                                break;
                            }
                        }
                    }
                    if (assessmentToUpdate != null) break;
                }
            }
            
            if (moduleWithAssessment == null || assessmentToUpdate == null) {
                JOptionPane.showMessageDialog(this, "Assessment not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String title = JOptionPane.showInputDialog(this, "Enter assessment title:", assessmentToUpdate.getTitle());
            if (title == null) return;
            
            String durationStr = JOptionPane.showInputDialog(this, "Enter duration:", assessmentToUpdate.getDuration());
            if (durationStr == null) return;
            
            String dateStr = JOptionPane.showInputDialog(this, "Enter date (dd/MM/yyyy):", 
                    new SimpleDateFormat("dd/MM/yyyy").format(assessmentToUpdate.getDate()));
            if (dateStr == null) return;
            
            try {
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
                
                assessmentToUpdate.setTitle(title);
                assessmentToUpdate.setDuration(durationStr);
                assessmentToUpdate.setDate(date);
                
                // Save modules to persist assessment changes
                FileDataStore.saveModules(modules);
                
                refreshAssessmentTable();
                JOptionPane.showMessageDialog(this, "Assessment updated successfully!");
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // Delete Assessment button action
        deleteBtn.addActionListener(evt -> {
            int selectedRow = assessmentTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select an assessment to delete", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int assessmentId = (Integer) assessmentTable.getValueAt(selectedRow, 0);
            String moduleNameFromTable = (String) assessmentTable.getValueAt(selectedRow, 2);
            String assessmentTitle = (String) assessmentTable.getValueAt(selectedRow, 1);
            
            // Find the module and assessment
            Module moduleWithAssessment = null;
            Assessment assessmentToDelete = null;
            int assessmentIndex = -1;
            
            for (Module m : modules) {
                if (m.getModuleName().equals(moduleNameFromTable)) {
                    moduleWithAssessment = m;
                    ArrayList<Assessment> assessments = m.getAssessments();
                    if (assessments != null) {
                        for (int i = 0; i < assessments.size(); i++) {
                            if (assessments.get(i).getAssessmentID() == assessmentId) {
                                assessmentToDelete = assessments.get(i);
                                assessmentIndex = i;
                                break;
                            }
                        }
                    }
                    if (assessmentToDelete != null) break;
                }
            }
            
            if (moduleWithAssessment == null || assessmentToDelete == null) {
                JOptionPane.showMessageDialog(this, "Assessment not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to delete assessment: " + assessmentTitle + "?",
                "Confirm Deletion", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                // Remove assessment from the module
                moduleWithAssessment.getAssessments().remove(assessmentIndex);
                
                // Save modules to persist assessment changes
                FileDataStore.saveModules(modules);
                
                refreshAssessmentTable();
                JOptionPane.showMessageDialog(this, "Assessment deleted successfully!");
            }
        });
    }
    
    /**
     * Setup action listeners for payment panel buttons
     */
    private void setupPaymentActionListeners(javax.swing.JButton addBtn, javax.swing.JButton updateBtn, javax.swing.JButton deleteBtn) {
        // Add Payment button action
        addBtn.addActionListener(e -> {
            // First, get the student for this payment
            if (students.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No students available. Please add a student first.", "No Students", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String[] studentOptions = new String[students.size()];
            for (int i = 0; i < students.size(); i++) {
                studentOptions[i] = students.get(i).getStudentID() + " - " + students.get(i).getName();
            }
            
            String selectedStudentStr = (String) JOptionPane.showInputDialog(this, 
                    "Select a student for this payment:", 
                    "Student Selection", 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    studentOptions, 
                    studentOptions[0]);
            
            if (selectedStudentStr == null) return;
            
            int studentId = Integer.parseInt(selectedStudentStr.split(" - ")[0]);
            Student selectedStudent = null;
            for (Student s : students) {
                if (s.getStudentID() == studentId) {
                    selectedStudent = s;
                    break;
                }
            }
            
            String amountStr = JOptionPane.showInputDialog(this, "Enter payment amount:");
            if (amountStr == null || amountStr.trim().isEmpty()) return;
            
            String description = JOptionPane.showInputDialog(this, "Enter payment description (e.g., Tuition, Books):");
            if (description == null || description.trim().isEmpty()) return;
            
            // Current date for the payment
            String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            
            try {
                float amount = Float.parseFloat(amountStr);
                
                // Create new payment
                Payment newPayment = new Payment(amount, selectedStudent, description, date);
                payments.add(newPayment);
                
                // Save payments to persist changes
                FileDataStore.savePayments(payments);
                
                refreshPaymentTable();
                JOptionPane.showMessageDialog(this, "Payment added successfully!");
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // Update Payment button action
        updateBtn.addActionListener(e -> {
            int selectedRow = paymentTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a payment to update", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int paymentId = (Integer) paymentTable.getValueAt(selectedRow, 0);
            Payment paymentToUpdate = null;
            
            for (Payment p : payments) {
                if (p.getPaymentID() == paymentId) {
                    paymentToUpdate = p;
                    break;
                }
            }
            
            if (paymentToUpdate == null) {
                JOptionPane.showMessageDialog(this, "Payment not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String amountStr = JOptionPane.showInputDialog(this, "Enter payment amount:", paymentToUpdate.getAmount());
            if (amountStr == null) return;
            
            String description = JOptionPane.showInputDialog(this, "Enter payment description:", paymentToUpdate.getDescription());
            if (description == null) return;
            
            // Date stays the same in this simple implementation
            
            try {
                float amount = Float.parseFloat(amountStr);
                
                paymentToUpdate.setAmount(amount);
                paymentToUpdate.setDescription(description);
                
                // Save payments to persist changes
                FileDataStore.savePayments(payments);
                
                refreshPaymentTable();
                JOptionPane.showMessageDialog(this, "Payment updated successfully!");
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // Delete Payment button action
        deleteBtn.addActionListener(e -> {
            int selectedRow = paymentTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a payment to delete", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int paymentId = (Integer) paymentTable.getValueAt(selectedRow, 0);
            Payment paymentToDelete = null;
            int paymentIndex = -1;
            
            for (int i = 0; i < payments.size(); i++) {
                if (payments.get(i).getPaymentID() == paymentId) {
                    paymentToDelete = payments.get(i);
                    paymentIndex = i;
                    break;
                }
            }
            
            if (paymentToDelete == null) {
                JOptionPane.showMessageDialog(this, "Payment not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to delete payment of $" + String.format("%.2f", paymentToDelete.getAmount()) + " for " + paymentToDelete.getPayeeId().getName() + "?",
                "Confirm Deletion", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                payments.remove(paymentIndex);
                
                // Save payments to persist changes
                FileDataStore.savePayments(payments);
                
                refreshPaymentTable();
                JOptionPane.showMessageDialog(this, "Payment deleted successfully!");
            }
        });
    }
}
