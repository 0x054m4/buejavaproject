import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;

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
    
    /**
     * Creates new form AdminDashboard
     */
    public AdminDashboard() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
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
        JTable studentTable = new JTable();
        studentTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Name", "Email", "Year", "Annual Fee"
            }
        ));
        
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(studentTable);
        javax.swing.JPanel tablePanel = new javax.swing.JPanel(new BorderLayout());
        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Students", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18)));
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        studentPanel.add(toolbar, BorderLayout.NORTH);
        studentPanel.add(tablePanel, BorderLayout.CENTER);
        
        contentPanel.add(studentPanel, "students");
        
        // Add action listeners
        addStudentBtn.addActionListener(e -> {
            // Add student logic
        });
        
        updateStudentBtn.addActionListener(e -> {
            // Update student logic
        });
        
        deleteStudentBtn.addActionListener(e -> {
            // Delete student logic
        });
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
        JTable teacherTable = new JTable();
        teacherTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Teacher ID", "Name", "Email", "Specialty"
            }
        ));
        
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(teacherTable);
        javax.swing.JPanel tablePanel = new javax.swing.JPanel(new BorderLayout());
        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Teachers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18)));
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        teacherPanel.add(toolbar, BorderLayout.NORTH);
        teacherPanel.add(tablePanel, BorderLayout.CENTER);
        
        contentPanel.add(teacherPanel, "teachers");
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
        JTable moduleTable = new JTable();
        moduleTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Module ID", "Name", "Credits", "Teacher"
            }
        ));
        
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(moduleTable);
        javax.swing.JPanel tablePanel = new javax.swing.JPanel(new BorderLayout());
        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modules", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18)));
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        modulePanel.add(toolbar, BorderLayout.NORTH);
        modulePanel.add(tablePanel, BorderLayout.CENTER);
        
        contentPanel.add(modulePanel, "modules");
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
        JTable assessmentTable = new JTable();
        assessmentTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Assessment ID", "Name", "Module", "Due Date", "Weight"
            }
        ));
        
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(assessmentTable);
        javax.swing.JPanel tablePanel = new javax.swing.JPanel(new BorderLayout());
        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Assessments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18)));
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        assessmentPanel.add(toolbar, BorderLayout.NORTH);
        assessmentPanel.add(tablePanel, BorderLayout.CENTER);
        
        contentPanel.add(assessmentPanel, "assessments");
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
        JTable paymentTable = new JTable();
        paymentTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Payment ID", "Student", "Amount", "Date", "Status"
            }
        ));
        
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(paymentTable);
        javax.swing.JPanel tablePanel = new javax.swing.JPanel(new BorderLayout());
        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18)));
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        paymentPanel.add(toolbar, BorderLayout.NORTH);
        paymentPanel.add(tablePanel, BorderLayout.CENTER);
        
        contentPanel.add(paymentPanel, "payments");
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
}
