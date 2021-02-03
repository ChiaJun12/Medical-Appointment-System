package appointmentsystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter; 
import java.io.FileWriter;
import java.io.IOException;

public class Admin extends User implements ReportSystem {
    public Admin(int id, String name, String role, String email, String password){
        super(id, name, role, email, password);
    }
    
    public void addAdmin() throws FileNotFoundException, IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("admin.txt", true));
    
        writer.println(super.id); 
        writer.println(super.name);
        writer.println(super.role);
        writer.println(super.email);
        writer.println(super.password);
        writer.println();
        
        writer.close();
    }
    
    public void editAdmin(){
        
    }
    
    public void removeAdmin(){
        
    }
    
    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.role + " " + this.email + " " + this.password;
    }

    @Override
    public void displayReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
