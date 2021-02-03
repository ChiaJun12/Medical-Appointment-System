package appointmentsystem;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class AppointmentPage extends JFrame implements ActionListener {
    public AppointmentPage(){
        setLayout(new FlowLayout());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
