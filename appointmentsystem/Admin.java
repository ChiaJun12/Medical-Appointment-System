package appointmentsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter; 
import java.io.FileWriter;
import java.io.IOException; 

public class Admin extends User {
    public Admin(int id, String name, String role, String email, String password, String contact){
        super(id, name, role, email, password, contact);
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
    
    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.role + " " + this.email + " " + this.password;
    } 

}
