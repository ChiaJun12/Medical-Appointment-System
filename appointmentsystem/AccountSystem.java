package appointmentsystem;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface AccountSystem { 
    public void addPatient(int id, String name, String role, String email, String contact) throws FileNotFoundException, IOException;
    public void addDoctor(int id, String name, String role, String email, String password, String contact) throws FileNotFoundException, IOException;
    public void addAdmin(int id, String name, String role, String email, String password, String contact) throws FileNotFoundException, IOException;
    public boolean check_duplicate(String name, String email);
}
