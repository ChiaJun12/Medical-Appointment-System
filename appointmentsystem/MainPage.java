package appointmentsystem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color; 
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainPage extends JFrame implements ActionListener {
    protected static MainPage main_page = new MainPage();
    private static Button report, user, appointment, myAccount;
    private static JMenuBar menu;
    private static Button logout;
    private Individual_Profile profile;
    
    public MainPage(){
        // main panel settings
        setSize(400, 400);
        setLocation(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Main Page");
        
        // setup menu bar
        menu = new JMenuBar();
        menu.setBackground(Color.ORANGE);
        setJMenuBar(menu);
        
        // create new panel for buttons
        JPanel center = new JPanel(new FlowLayout()); 
        JPanel bottom = new JPanel(new FlowLayout());
        
        // create labels for buttons
        JLabel show_user = new JLabel(MainSystem.login_user.getRole().toUpperCase() + " : " + MainSystem.login_user.getName()); 
        show_user.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        logout = new Button("Logout"); 
        
        // create menu of menubar
        report = new Button("Report");
        user = new Button("Add User");
        appointment = new Button("Appointment");
        myAccount = new Button("My Account");
        
        bottom.add(show_user);
        bottom.add(logout);
        
        // add menu to menubar depends on role
        if(MainSystem.login_user.getRole().equals("doctor")){ 
            profile = new Individual_Profile();
            menu.add(myAccount);
            menu.add(appointment);
        }
        else if(MainSystem.login_user.getRole().equals("admin")){
            menu.add(user);
            menu.add(report);
            menu.add(appointment);
        }
        
        add(bottom, BorderLayout.SOUTH);
        
        report.addActionListener(this);
        user.addActionListener(this);
        appointment.addActionListener(this);
        myAccount.addActionListener(this);
        logout.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == logout){
            MainSystem.login_user = null;  
            
            main_page.setVisible(false);
            MainSystem.login.setVisible(true);
        }
        else if(e.getSource() == user){
            MainSystem.register.setVisible(true);
        }
        else if(e.getSource() == myAccount){
            profile.setVisible(true);
        }
    }
}
