package library;
public class LoginUI extends javax.swing.JFrame {
    private javax.swing.JRadioButton ClerkRadioButton;
    private javax.swing.JRadioButton LibrarianRadioButton;
    private javax.swing.JButton LogInButton;
    private javax.swing.JRadioButton StudentRadioButton;
    private javax.swing.JTextField UserIdTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public LoginUI() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        StudentRadioButton = new javax.swing.JRadioButton();
        ClerkRadioButton = new javax.swing.JRadioButton();
        LibrarianRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        UserIdTextField = new javax.swing.JTextField();
        LogInButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Library Management System");

        jLabel2.setText("Role");

        buttonGroup1.add(StudentRadioButton);
        StudentRadioButton.setText("Student");
        StudentRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(ClerkRadioButton);
        ClerkRadioButton.setText("Clerk");

        buttonGroup1.add(LibrarianRadioButton);
        LibrarianRadioButton.setText("Librarian");

        jLabel3.setText("User Id");

        LogInButton.setText("LogIn");
        LogInButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogInButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UserIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClerkRadioButton)
                            .addComponent(StudentRadioButton)
                            .addComponent(LibrarianRadioButton)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(LogInButton)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(StudentRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClerkRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LibrarianRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(UserIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(LogInButton)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StudentRadioButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
            }
    private void LogInButtonMouseClicked(java.awt.event.MouseEvent evt) {
        int id=Integer.parseInt(UserIdTextField.getText() );
        Library LibObj = new Library ();
        
        dbConnectivity db = new dbConnectivity();
        boolean flag =false;
        if(StudentRadioButton.isSelected())
        {
            
            flag=LibObj.IsBorrowerPresent(id);
        
        }
        
        else if (ClerkRadioButton.isSelected())
        {
        
            flag=LibObj.IsClerkPresent(id);
        }
        else
        {
        
            flag=LibObj.IsLibrarianPresent(id);
        
        }
        if(flag==true && StudentRadioButton.isSelected())
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentMenuUI(id).setVisible(true);
            }
        });
        
        }
        
        if(flag==true && ClerkRadioButton.isSelected())
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClerkMenuUI(id, LibObj).setVisible(true);
            }
            });
        }
        
        if(flag==true && LibrarianRadioButton.isSelected())
        {
             java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibrarianMenu(id , LibObj).setVisible(true);
            }
        });
            
        }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUI().setVisible(true);
            }
        });
    }
}
