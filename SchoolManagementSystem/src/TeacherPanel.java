import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Panel for teacher operations
 */
public class TeacherPanel extends JPanel {
    private SchoolManagementGUI mainFrame;
    private DataStore dataStore;
    private Teacher currentTeacher;
    
    // UI Components
    private JLabel welcomeLabel;
    private JTabbedPane tabbedPane;
    
    public TeacherPanel(SchoolManagementGUI mainFrame, DataStore dataStore) {
        this.mainFrame = mainFrame;
        this.dataStore = dataStore;
        
        setLayout(new BorderLayout());
        
        // Welcome panel at the top
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        welcomeLabel = new JLabel("Welcome, Teacher");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(welcomeLabel, BorderLayout.WEST);
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> mainFrame.showLoginPanel());
        topPanel.add(logoutButton, BorderLayout.EAST);
        
        add(topPanel, BorderLayout.NORTH);
        
        // Create tabbed pane for different operations
        tabbedPane = new JTabbedPane();
        
        // Create and add tabs
        tabbedPane.addTab("Student List", createStudentListPanel());
        tabbedPane.addTab("Sessions", createSessionsPanel());
        tabbedPane.addTab("Attendees", createAttendeesPanel());
        
        add(tabbedPane, BorderLayout.CENTER);
    }
    
    /**
     * Set the current teacher and update UI
     */
    public void setCurrentTeacher(Teacher teacher) {
        this.currentTeacher = teacher;
        welcomeLabel.setText("Welcome, " + teacher.getName());
        refreshData();
    }
    
    /**
     * Refresh all data in the panels
     */
    private void refreshData() {
        refreshStudentList();
        refreshSessions();
    }
    
    /**
     * Create the student list panel
     */
    private JPanel createStudentListPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create table for students
        String[] columns = {"Student ID", "Name", "Email", "Year", "Annual Fee"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JTable studentsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentsTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    /**
     * Refresh student list data
     */
    private void refreshStudentList() {
        // Get the table model
        JScrollPane scrollPane = (JScrollPane) ((JPanel) tabbedPane.getComponentAt(0)).getComponent(0);
        JTable table = (JTable) scrollPane.getViewport().getView();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        // Clear the table
        model.setRowCount(0);
        
        // Populate with all students
        for (Student s : dataStore.students) {
            model.addRow(new Object[]{
                s.getStudentID(),
                s.getName(),
                s.getEmail(),
                s.getYear(),
                s.getAnnualFee()
            });
        }
    }
    
    /**
     * Create the sessions panel
     */
    private JPanel createSessionsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Table panel
        JPanel tablePanel = new JPanel(new BorderLayout());
        
        // Create table for sessions
        String[] columns = {"Session ID", "Name", "Module", "Start Time", "End Time", "Classroom", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JTable sessionsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(sessionsTable);
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        // Buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton addButton = new JButton("Add Session");
        addButton.addActionListener(e -> showAddSessionDialog());
        
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshSessions());
        
        buttonsPanel.add(refreshButton);
        buttonsPanel.add(addButton);
        
        // Add both panels
        panel.add(tablePanel, BorderLayout.CENTER);
        panel.add(buttonsPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    /**
     * Show dialog to add a new session
     */
    private void showAddSessionDialog() {
        // Create a modal dialog
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Add New Session", true);
        dialog.setSize(400, 350);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Session name
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Session Name:"), gbc);
        
        gbc.gridx = 1;
        JTextField nameField = new JTextField(15);
        panel.add(nameField, gbc);
        
        // Module selection
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Module:"), gbc);
        
        gbc.gridx = 1;
        JComboBox<String> moduleCombo = new JComboBox<>();
        for (Module m : dataStore.modules) {
            moduleCombo.addItem(m.getModuleID() + " - " + m.getModuleName());
        }
        panel.add(moduleCombo, gbc);
        
        // Classroom selection
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Classroom:"), gbc);
        
        gbc.gridx = 1;
        JComboBox<String> classroomCombo = new JComboBox<>();
        for (Classroom c : dataStore.classrooms) {
            classroomCombo.addItem(c.getClassroomId() + " - " + c.getRoomName());
        }
        panel.add(classroomCombo, gbc);
        
        // Start time
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Start Time:"), gbc);
        
        gbc.gridx = 1;
        JTextField startTimeField = new JTextField(15);
        panel.add(startTimeField, gbc);
        
        // End time
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("End Time:"), gbc);
        
        gbc.gridx = 1;
        JTextField endTimeField = new JTextField(15);
        panel.add(endTimeField, gbc);
        
        // Status
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Status:"), gbc);
        
        gbc.gridx = 1;
        JTextField statusField = new JTextField("Scheduled", 15);
        panel.add(statusField, gbc);
        
        // Buttons
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dialog.dispose());
        
        JButton addButton = new JButton("Add Session");
        addButton.addActionListener(e -> {
            // Validate input
            String sessionName = nameField.getText().trim();
            String startTime = startTimeField.getText().trim();
            String endTime = endTimeField.getText().trim();
            String status = statusField.getText().trim();
            
            if (sessionName.isEmpty() || startTime.isEmpty() || endTime.isEmpty() || status.isEmpty()) {
                JOptionPane.showMessageDialog(dialog,
                    "Please fill in all fields",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Get selected module and classroom
            String moduleSelection = (String) moduleCombo.getSelectedItem();
            String classroomSelection = (String) classroomCombo.getSelectedItem();
            
            int moduleID = Integer.parseInt(moduleSelection.split(" - ")[0]);
            int classroomID = Integer.parseInt(classroomSelection.split(" - ")[0]);
            
            Module module = null;
            Classroom classroom = null;
            
            for (Module m : dataStore.modules) {
                if (m.getModuleID() == moduleID) {
                    module = m;
                    break;
                }
            }
            
            for (Classroom c : dataStore.classrooms) {
                if (c.getClassroomId() == classroomID) {
                    classroom = c;
                    break;
                }
            }
            
            if (module != null && classroom != null) {
                // Create new session
                Session newSession = new Session(module, sessionName, startTime, endTime, classroom, null, status);
                newSession.addSession(dataStore.sessions);
                
                dialog.dispose();
                refreshSessions();
                
                JOptionPane.showMessageDialog(this,
                    "Session added successfully",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        buttonPanel.add(cancelButton);
        buttonPanel.add(addButton);
        
        panel.add(buttonPanel, gbc);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }
    
    /**
     * Refresh sessions data
     */
    private void refreshSessions() {
        // Get the table model
        JScrollPane scrollPane = (JScrollPane) ((JPanel) ((JPanel) tabbedPane.getComponentAt(1)).getComponent(0)).getComponent(0);
        JTable table = (JTable) scrollPane.getViewport().getView();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        // Clear the table
        model.setRowCount(0);
        
        // Populate with sessions
        for (Session s : dataStore.sessions) {
            model.addRow(new Object[]{
                s.getSessionID(),
                s.getSessionName(),
                s.getModule().getModuleName(),
                s.getStartTime(),
                s.getEndTime(),
                s.getClassroom().getRoomName(),
                s.getStatus()
            });
        }
    }
    
    /**
     * Create the attendees panel
     */
    private JPanel createAttendeesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Session selection panel
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        topPanel.add(new JLabel("Select Session:"));
        
        JComboBox<String> sessionCombo = new JComboBox<>();
        refreshSessionComboBox(sessionCombo);
        
        JButton refreshSessionsButton = new JButton("Refresh");
        refreshSessionsButton.addActionListener(e -> refreshSessionComboBox(sessionCombo));
        
        topPanel.add(sessionCombo);
        topPanel.add(refreshSessionsButton);
        
        panel.add(topPanel, BorderLayout.NORTH);
        
        // Attendees table
        String[] columns = {"Student ID", "Name", "Email"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JTable attendeesTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(attendeesTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Bottom panel with add attendee button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton addAttendeeButton = new JButton("Register Attendee");
        addAttendeeButton.addActionListener(e -> {
            if (sessionCombo.getSelectedItem() != null) {
                String sessionSelection = (String) sessionCombo.getSelectedItem();
                int sessionID = Integer.parseInt(sessionSelection.split(" - ")[0]);
                showAddAttendeeDialog(sessionID);
            } else {
                JOptionPane.showMessageDialog(this,
                    "Please select a session first",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JButton viewAttendeesButton = new JButton("View Attendees");
        viewAttendeesButton.addActionListener(e -> {
            if (sessionCombo.getSelectedItem() != null) {
                String sessionSelection = (String) sessionCombo.getSelectedItem();
                int sessionID = Integer.parseInt(sessionSelection.split(" - ")[0]);
                viewAttendees(sessionID, tableModel);
            } else {
                JOptionPane.showMessageDialog(this,
                    "Please select a session first",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        
        bottomPanel.add(viewAttendeesButton);
        bottomPanel.add(addAttendeeButton);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    /**
     * Refresh the session combo box
     */
    private void refreshSessionComboBox(JComboBox<String> comboBox) {
        comboBox.removeAllItems();
        
        for (Session s : dataStore.sessions) {
            comboBox.addItem(s.getSessionID() + " - " + s.getSessionName());
        }
    }
    
    /**
     * View attendees for a session
     */
    private void viewAttendees(int sessionID, DefaultTableModel model) {
        final Session session = dataStore.sessions.stream()
            .filter(s -> s.getSessionID() == sessionID)
            .findFirst()
            .orElse(null);
        
        if (session != null) {
            // Clear the table
            model.setRowCount(0);
            
            // Get attendees
            ArrayList<Student> attendees = session.getAttendees();
            
            if (attendees != null && !attendees.isEmpty()) {
                for (Student s : attendees) {
                    model.addRow(new Object[]{
                        s.getStudentID(),
                        s.getName(),
                        s.getEmail()
                    });
                }
            } else {
                JOptionPane.showMessageDialog(this,
                    "No attendees registered for this session",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    /**
     * Show dialog to add an attendee to a session
     */
    private void showAddAttendeeDialog(int sessionID) {
        // Get the session
        final Session[] sessionHolder = {null};
        for (Session s : dataStore.sessions) {
            if (s.getSessionID() == sessionID) {
                sessionHolder[0] = s;
                break;
            }
        }
        final Session session = sessionHolder[0];
        
        if (session == null) {
            JOptionPane.showMessageDialog(this,
                "Session not found",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Create a modal dialog
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Register Attendee", true);
        dialog.setSize(400, 200);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Session info
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(new JLabel("Session: " + session.getSessionName()), gbc);
        
        // Student selection
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Student:"), gbc);
        
        gbc.gridx = 1;
        JComboBox<String> studentCombo = new JComboBox<>();
        for (Student s : dataStore.students) {
            studentCombo.addItem(s.getStudentID() + " - " + s.getName());
        }
        panel.add(studentCombo, gbc);
        
        // Buttons
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dialog.dispose());
        
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> {
            String studentSelection = (String) studentCombo.getSelectedItem();
            int studentID = Integer.parseInt(studentSelection.split(" - ")[0]);
            
            Student student = null;
            for (Student s : dataStore.students) {
                if (s.getStudentID() == studentID) {
                    student = s;
                    break;
                }
            }
            
            if (student != null) {
                // Get current attendees
                ArrayList<Student> attendees = session.getAttendees();
                if (attendees == null) {
                    attendees = new ArrayList<>();
                }
                
                // Check if already registered
                boolean alreadyRegistered = false;
                for (Student s : attendees) {
                    if (s.getStudentID() == student.getStudentID()) {
                        alreadyRegistered = true;
                        break;
                    }
                }
                
                if (!alreadyRegistered) {
                    attendees.add(student);
                    session.setAttendees(attendees);
                    
                    dialog.dispose();
                    
                    JOptionPane.showMessageDialog(this,
                        "Student registered successfully",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(dialog,
                        "Student already registered for this session",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        buttonPanel.add(cancelButton);
        buttonPanel.add(registerButton);
        
        panel.add(buttonPanel, gbc);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }
}