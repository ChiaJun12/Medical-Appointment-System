package appointmentsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RegisterPage extends JFrame implements ActionListener, AccountSystem {
    private Button register, loginButton;
    private JTextField userName, Email, Contact;
    private JPasswordField passWord; 
    private JComboBox roles;
    PrintWriter pw;
    
    public RegisterPage(){
        setSize(400, 600);
        setLocation(700, 300);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE); 
        setTitle("Register Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel title = new JLabel("Patient Register", SwingConstants.CENTER);
        title.setOpaque(true);
        title.setBackground(new Color(102, 255, 178));
        title.setBorder(new EmptyBorder(10, 0, 10, 0));
        
        JLabel username = new JLabel("Username:");
        JLabel password = new JLabel("Password:");
        JLabel email = new JLabel("Email:");  
        JLabel role = new JLabel("Role:");  
        JLabel contact = new JLabel("Contact:");
        
        userName = new JTextField();
        passWord = new JPasswordField(10);
        Email = new JTextField();  
        Contact = new JTextField();
        
        String[] r = {"Doctor", "Admin", "Patient"};
        roles = new JComboBox(r);
         
        register = new Button("Register");
        register.setBackground(new Color(51, 255, 153)); 
        
//        JPanel loginPanel = new JPanel(new GridLayout(1, 2));
//        JLabel toLogin = new JLabel("Already have a account ?");
//        loginButton = new Button("Login");
//        loginPanel.add(toLogin);
//        loginPanel.add(loginButton);
        
        JPanel panel = new JPanel(new GridLayout(14, 2)); 
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.add(username);
        panel.add(userName);
        panel.add(role);
        panel.add(roles);
        panel.add(email);
        panel.add(Email);
        panel.add(contact);
        panel.add(Contact); 
        panel.add(password);
        panel.add(passWord);
        panel.add(new JLabel());
        panel.add(register);
//        panel.add(new JLabel());
//        panel.add(loginPanel);
        
        add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        
        roles.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(roles.getSelectedItem().toString().equals("Patient")){
                    password.setVisible(false);
                    passWord.setVisible(false);
                }
                else{
                    password.setVisible(true);
                    passWord.setVisible(true);
                }
            }
        });
        
//        loginButton.addActionListener(this);
        register.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginButton){
            setVisible(false);
            MainSystem.login.setVisible(true);
        }
        else{  
            boolean register_success = false;
            
            if(roles.getSelectedItem().toString().equals("Patient") && check_duplicate(userName.getText(), Email.getText())){
                if(!userName.getText().equals("") && !Email.getText().equals("") && !Contact.getText().equals("")){
                    try {
                        addPatient(MainSystem.all_patient.size()+1, userName.getText(), "patient", Email.getText(), Contact.getText());
                        register_success = true;
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "File Not Found", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else{
                if(!userName.getText().equals("") && !Email.getText().equals("") && !Contact.getText().equals("") && !String.valueOf(passWord.getPassword()).equals("")){
                    try {
                        if(roles.getSelectedItem().toString().equals("Doctor") && check_duplicate(userName.getText(), Email.getText())){
                            addDoctor(MainSystem.all_doctor.size()+1, userName.getText(), "doctor", Email.getText(), String.valueOf(passWord.getPassword()), Contact.getText());
                            register_success = true;
                        }
                        else if(roles.getSelectedItem().toString().equals("Admin") && check_duplicate(userName.getText(), Email.getText())){
                            addAdmin(MainSystem.all_doctor.size()+1, userName.getText(), "Admin", Email.getText(), String.valueOf(passWord.getPassword()), Contact.getText());
                            register_success = true;
                        }
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "File Not Found", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            userName.setText("");
            Email.setText("");
            passWord.setText(""); 
            Contact.setText("");

            if(register_success){
                JOptionPane.showMessageDialog(register, "Registered Successfully");
                MainSystem.register.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Please fill in all the require information", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } 
    
    @Override
    public void addPatient(int id, String name, String role, String email, String contact) throws FileNotFoundException, IOException{
        pw = new PrintWriter(new FileWriter("patient.txt", true));
        
        pw.println(id + "\n" + name + "\n" + role + "\n" + email + "\n" + contact);
        pw.println();
        
        pw.flush();
        pw.close();
    } 
    
    @Override
    public void addDoctor(int id, String name, String role, String email, String password, String contact) throws FileNotFoundException, IOException{
        pw = new PrintWriter(new FileWriter("doctor.txt", true));
        
        pw.println(id + "\n" + name + "\n" + role + "\n" + email + "\n" + password + "\n" + contact);
        pw.println();
        
        pw.flush();
        pw.close();
    }
    
    @Override
    public void addAdmin(int id, String name, String role, String email, String password, String contact) throws FileNotFoundException, IOException{
        pw = new PrintWriter(new FileWriter("admin.txt", true));
        
        pw.println(id + "\n" + name + "\n" + role + "\n" + email + "\n" + password + "\n" + contact);
        pw.println();
        
        pw.flush();
        pw.close();
    }

    @Override
    public boolean check_duplicate(String name, String email) {
        for(int i=0; i<MainSystem.all_user.size(); i++){
            User x = MainSystem.all_user.get(i);
            
            if(x.getName().equals(name) || x.getEmail().equals(email)){
                JOptionPane.showMessageDialog(null, "The name or email has been taken", "Duplication Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } 
        return true;
    }
}
