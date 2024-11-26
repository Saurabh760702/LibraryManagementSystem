import javax.annotation.processing.RoundEnvironment;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Loginlib extends JFrame implements ActionListener {

    JLabel title,title1,title2;
    JTextField usernametextfield;
    JPasswordField passwordField;
    JButton login,cancel,SignUp;

    Loginlib(){
        setLayout(null);
        setSize(1000,1000);
       // Color col=new Color(255,102,102);
       // getContentPane().setBackground(col);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(0,0);
        setVisible(true);



        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Image icon/pink.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,550,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(400,100,600,440);

//
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("Image icon/Libaray.jpg"));
        Image i5=i4.getImage().getScaledInstance(1500,1020,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel labe=new JLabel(i6);
        labe.setBounds(-0,-0,1500,900);





        JLabel head=new JLabel("Library Management System");
        head.setBounds(320,0,1000,80);
        head.setFont(new Font("RALEWAY",Font.BOLD,60));
        head.setForeground(Color.red);

        add(head);


        title = new JLabel("Login Page");
        title.setBounds(630, 120, 300, 50);
        title.setFont(new Font("Osward", Font.BOLD, 38));
        title.setForeground(Color.darkGray);
        add(title);


        title1 = new JLabel("User Name");
        title1.setBounds(480,200,300,20);
        title1.setFont(new Font("RALEWAY", Font.BOLD, 25));
        title1.setForeground(Color.black);
        add(title1);

        usernametextfield=new JTextField(15);
        usernametextfield.setBounds(650,200,300,40);
        usernametextfield.setFont(new Font("Arial",Font.BOLD,20));
        usernametextfield.setBackground(Color.white);
        usernametextfield.setBorder(new LineBorder(Color.black,3));
        add(usernametextfield);


        title2 = new JLabel("Password");
        title2.setBounds(480,280,300,20);
        title2.setFont(new Font("RALEWAY", Font.BOLD, 25));
        title2.setForeground(Color.black);
        add(title2);

        passwordField=new JPasswordField(15);
        passwordField.setBounds(650,280,300,40);
        passwordField.setFont(new Font("Arial",Font.BOLD,25));
        passwordField.setBackground(Color.white);
        passwordField.setBorder(new LineBorder(Color.black,3));
        add(passwordField);


        login=new JButton("SignIn");
        login.setBounds(600,380,150,40);
        login.setFont(new Font("Arial",Font.BOLD,25));
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        add(login);


        cancel=new JButton("Clear");
        cancel.setBounds(800,450,150,40);
        cancel.setFont(new Font("Arial",Font.BOLD,25));
        cancel.setBackground(Color.blue);
        cancel.setForeground(Color.white);
        cancel.setBorder(BorderFactory.createEmptyBorder());
        cancel.addActionListener(this);
        add(cancel);

        SignUp=new JButton("SignUp");
        SignUp.setBounds(800,380,150,40);
        SignUp.setFont(new Font("Arial",Font.BOLD,25));
        SignUp.setBackground(Color.blue);
        SignUp.setForeground(Color.white);
        SignUp.setBorder(BorderFactory.createEmptyBorder());
        SignUp.addActionListener(this);
        add(SignUp);



        add(label);
        add(labe);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            boolean isAuthenticated = false;
            do{
                String Suser=usernametextfield.getText();
                String Spasswords=new String(passwordField.getPassword());
                isAuthenticated=Authenticatedadmin(Suser,Spasswords);

                if (Authenticatedadmin(Suser, Spasswords)) {
                    Main obj=new Main();
                    JOptionPane.showMessageDialog(null,"Login sucess");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Username and password do not match");
                    break;
                }

            }
            while (!isAuthenticated);
        }
        else if(e.getSource()==cancel){
            passwordField.setText("");
            usernametextfield.setText("");
        }else if(e.getSource()==SignUp){
            setVisible(false);
            new Signup().setVisible(true);
        }

    }

    private boolean Authenticatedadmin(String Suser, String Spasswords) {

        try {
            Connect ch=new Connect();
            PreparedStatement ps = ch.co.prepareStatement("select * from login where Suser=? and Spasswords=?");
            ps.setString(1,Suser);
            ps.setString(2,Spasswords);
            ResultSet rs = ps.executeQuery();

            return rs.next();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        new Loginlib().setVisible(true);
    }


}
