package appointmentsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter; 
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Individual_Profile extends JFrame implements ActionListener { 
    private Button Name, Email, Password, Contact, confirm, edit;
    private JTextField nameField, emailField, contactField;
    private JPasswordField passwordField;
    private Boolean editable = false;
    
    public Individual_Profile(){ 
        setSize(400, 400);
        setLocation(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE); 
        setTitle("Change Profile");
        
        JLabel title = new JLabel("Patient Register", SwingConstants.CENTER);
        title.setOpaque(true);
        title.setBackground(new Color(102, 255, 178));
        title.setBorder(new EmptyBorder(10, 0, 10, 0));
        
        JPanel main = new JPanel(new GridLayout(8, 2));
        main.setBorder(new EmptyBorder(10, 15, 10, 15));
        
        JLabel old_username = new JLabel("Username:");
        nameField = new JTextField();
        nameField.setText(MainSystem.login_user.getName());
        
        JLabel old_password = new JLabel("Password:");
        passwordField = new JPasswordField(10);
        passwordField.setText(String.valueOf(MainSystem.login_user.getPassword()));
        
        JLabel old_email = new JLabel("Email:");  
        emailField = new JTextField();  
        emailField.setText(MainSystem.login_user.getEmail());
        
        JLabel old_contact = new JLabel("Contact:");
        contactField = new JTextField();
        contactField.setText(MainSystem.login_user.getContact());
        
        nameField.setEditable(false);
        passwordField.setEditable(false);
        emailField.setEditable(false);
        contactField.setEditable(false);
        
        main.add(old_username);
        main.add(nameField);
        main.add(old_password);
        main.add(passwordField);
        main.add(old_email);
        main.add(emailField);
        main.add(old_contact);
        main.add(contactField);
         
        edit = new Button("Edit");
        confirm = new Button("Confirm");
        
        add(edit, BorderLayout.NORTH); 
        add(main, BorderLayout.CENTER); 
        add(confirm, BorderLayout.SOUTH);
        
        edit.addActionListener((ActionEvent e) -> {
            editable = !editable;
            
            if(editable){
                nameField.setEditable(true);
                passwordField.setEditable(true);
                emailField.setEditable(true);
                contactField.setEditable(true);
            }
            else{
                nameField.setEditable(false);
                passwordField.setEditable(false);
                emailField.setEditable(false);
                contactField.setEditable(false);
            }
        });
        
        confirm.addActionListener(this); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        try {
//            PrintWriter pw = new PrintWriter(new FileWriter("doctor.txt"));
//             
//            pw.close();
//            
//            if(e.getSource() == confirm){
//                for(int i=0; i<MainSystem.all_user.size(); i++){
//                    System.out.println(MainSystem.all_user.get(i).toString());
//                }
//            }
//        } 
//        catch (IOException ex) {
//            JOptionPane.showMessageDialog(confirm, "File Not Found", "FileNotFound", JOptionPane.ERROR_MESSAGE);
//        }
    }
}
