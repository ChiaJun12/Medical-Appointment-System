package appointmentsystem;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList; 

public class MainSystem {
//    call login page and register page
    public static LoginPage login = new LoginPage(); 
    public static RegisterPage register = new RegisterPage();
    public static User login_user; 
    
    // create array to store different types of user
    public static ArrayList<Admin> all_admin = new ArrayList<>();
    public static ArrayList<Patient> all_patient = new ArrayList<>();
    public static ArrayList<Doctor> all_doctor = new ArrayList<>();
    public static ArrayList<User> all_user = new ArrayList<>();
    
    public static void main(String[] args) throws FileNotFoundException, IOException { 
        // load and scan files
        Scanner adminFile  = new Scanner(new File("admin.txt"));
        Scanner patientFile = new Scanner(new File("patient.txt"));
        Scanner doctorFile = new Scanner(new File("doctor.txt"));
        Scanner appointmentFile = new Scanner(new File("appointment.txt"));
        PrintWriter pw = new PrintWriter("admin.txt");
        
        if(!adminFile.hasNextLine()){
            Admin first_admin = new Admin(1, "Chia Jun", "admin", "chiajun@gmail.com", "12345", "0123483743");
            all_user.add(first_admin);
            all_admin.add(first_admin);
            
            pw.println(first_admin.getId());
            pw.println(first_admin.getName());
            pw.println(first_admin.getRole());
            pw.println(first_admin.getEmail());
            pw.println(first_admin.getPassword());
            pw.println(first_admin.getContact());
            
            pw.flush();
            pw.close(); 
        }
        
        // store all admin object into admin's arrayList
        while(adminFile.hasNextLine()){
            int id = Integer.parseInt(adminFile.nextLine());
            String name = adminFile.nextLine();
            String role = adminFile.nextLine();
            String email = adminFile.nextLine();
            String password = adminFile.nextLine();
            String contact = adminFile.nextLine();
            adminFile.nextLine();
            
            Admin new_admin = new Admin(id, name, role, email, password, contact); 
            all_admin.add(new_admin);
            all_user.add(new_admin); 
        }
        
        // store all patient object into patient's arrayList
        while(patientFile.hasNextLine()){
            int id = Integer.parseInt(patientFile.nextLine());
            String name = patientFile.nextLine();
            String role = patientFile.nextLine();
            String email = patientFile.nextLine(); 
            String contact = patientFile.nextLine();
            patientFile.nextLine();
            
            Patient new_patient = new Patient(id, name, role, email, contact);
            all_patient.add(new_patient);
            all_user.add(new_patient);
        }
        
        // store all doctor object into doctor's arrayList 
        while(doctorFile.hasNextLine()){
            int id = Integer.parseInt(doctorFile.nextLine());
            String name = doctorFile.nextLine();
            String role = doctorFile.nextLine();
            String email = doctorFile.nextLine();
            String password = doctorFile.nextLine();
            String contact = doctorFile.nextLine();
            doctorFile.nextLine();
            
            Doctor new_doctor = new Doctor(id, name, role, email, password, contact);
            all_doctor.add(new_doctor);
            all_user.add(new_doctor);
        } 
    }
}
