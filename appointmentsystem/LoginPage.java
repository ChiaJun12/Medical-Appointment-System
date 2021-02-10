package appointmentsystem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color; 
import java.awt.GridLayout; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginPage extends JFrame implements ActionListener {
    private Button login, registerButton;
    private JTextField userName;
    private JPasswordField passWord;
    protected User selected;
    
    public LoginPage(){
        setSize(400, 400);
        setLocation(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE); 
        setTitle("Login Page");
        
        JLabel title = new JLabel("Login Page", SwingConstants.CENTER);
        title.setOpaque(true);
        title.setBackground(new Color(102, 255, 178));
        title.setBorder(new EmptyBorder(10, 0, 10, 0));
        
        JLabel username = new JLabel("Username:");
        JLabel password = new JLabel("Password:");
        
        userName = new JTextField();
        passWord = new JPasswordField(10);
        
        login = new Button("Login");
        login.setBackground(new Color(51, 255, 153)); 
        
//        JPanel registerPanel = new JPanel(new GridLayout(1, 2));
//        JLabel register = new JLabel("Don't have a account ?");
//        registerButton = new Button("Register");
//        registerPanel.add(register);
//        registerPanel.add(registerButton);
        
        JPanel panel = new JPanel(new GridLayout(6, 2)); 
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.add(username);
        panel.add(userName);
        panel.add(password);
        panel.add(passWord); 
        panel.add(new JLabel());
        panel.add(login);
//        panel.add(new JLabel());
//        panel.add(registerPanel);
        
        add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        
//        registerButton.addActionListener(this);
        login.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){ 
        if(e.getSource() == registerButton){
            setVisible(false); 
            MainSystem.register.setVisible(true);
        }
        else if(e.getSource() == login){ 
            for(int i=0; i<MainSystem.all_user.size(); i++){ 
                selected = MainSystem.all_user.get(i);
                 
                if(selected.login(selected.getName(), selected.getPassword(), userName.getText(), String.valueOf(passWord.getPassword()))){
                    System.out.println(userName.getText() + " : " + String.valueOf(passWord.getPassword()));
                    
                    MainSystem.login_user = selected;
                    System.out.println(selected.toString());
                    
                    userName.setText("");
                    passWord.setText("");
                    MainPage.main_page.setVisible(true);
                    MainSystem.login.setVisible(false);
                }
            }
        }
    }
}
