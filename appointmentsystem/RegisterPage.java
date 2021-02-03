package appointmentsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RegisterPage extends JFrame implements ActionListener {
    private Button register, loginButton;
    private JTextField userName, Email, contactField;
    private JPasswordField passWord;
    private static RegisterPage registerpage;
    
    public RegisterPage(){
        setSize(400, 600);
        setLocation(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE); 
        setTitle("Register Page");
        
        JLabel title = new JLabel("Patient Register", SwingConstants.CENTER);
        title.setOpaque(true);
        title.setBackground(new Color(102, 255, 178));
        title.setBorder(new EmptyBorder(10, 0, 10, 0));
        
        JLabel username = new JLabel("Username:");
        JLabel password = new JLabel("Password:");
        JLabel email = new JLabel("Email:"); 
        JLabel contact = new JLabel("Contact:"); 
        
        userName = new JTextField();
        passWord = new JPasswordField(10);
        Email = new JTextField(); 
        contactField = new JTextField();
            
        register = new Button("Register");
        register.setBackground(new Color(51, 255, 153)); 
        
        JPanel loginPanel = new JPanel(new GridLayout(1, 2));
        JLabel toLogin = new JLabel("Already have a account ?");
        loginButton = new Button("Login");
        loginPanel.add(toLogin);
        loginPanel.add(loginButton);
        
        JPanel panel = new JPanel(new GridLayout(12, 2)); 
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.add(username);
        panel.add(userName);
        panel.add(email);
        panel.add(Email);
        panel.add(contact);
        panel.add(contactField);
        panel.add(password);
        panel.add(passWord);  
        panel.add(new JLabel());
        panel.add(register);
        panel.add(new JLabel());
        panel.add(loginPanel);
        
        add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        
        loginButton.addActionListener(this);
        register.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginButton){
            setVisible(false);
            MainSystem.login.setVisible(true);
        }
        else{
            if(userName != null && passWord != null && Email != null && contactField != null){
                Patient new_patient = new Patient(MainSystem.all_patient.size() + 1, userName.getText(), "patient", Email.getText(), String.valueOf(passWord.getPassword()), contactField.getText());
                JOptionPane.showMessageDialog(register, "Patient registered successfully");
                
                try{ 
                    PrintWriter writer = new PrintWriter(new File("patient.txt"));

                    writer.println(new_patient.getId());
                    writer.println(new_patient.getName());
                    writer.println(new_patient.getRole());
                    writer.println(new_patient.getEmail());
                    writer.println(new_patient.getPassword());
                    writer.println(new_patient.getContact());
                    writer.println();
                    writer.close();
                    
                    MainSystem.all_patient.add(new_patient);
                    MainSystem.all_user.add(new_patient);
                }
                catch(FileNotFoundException err){
                    JOptionPane.showMessageDialog(register, "Sorry, the file does not exist");
                }
                
                userName.setText("");
                Email.setText("");
                passWord.setText("");
                contactField.setText("");
                
                RegisterPage.registerpage.setVisible(false);
                MainPage.main_page.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(register, "Please make sure you fill all the infomation and try again");
            }
        }
    } 
}
