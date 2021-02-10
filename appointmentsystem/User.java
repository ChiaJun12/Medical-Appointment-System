package appointmentsystem;

public class User {
    protected int id;
    protected String name;
    protected String role;
    protected String email;
    protected String password;
    protected String contact;
    
    public User(int id, String name, String role, String email, String password, String contact){
        this.id = id;
        this.name = name;
        this.role = role;
        this.email = email;
        this.password = password;
        this.contact = contact;
    }

    public User(int id, String name, String role, String email){
        this.id = id;
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    } 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
 
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    } 

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean login(String username, String password, String enteredUsername, String enteredPassword){
        return (username.equals(enteredUsername) && password.equals(enteredPassword));
    }
    
    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.role + " " + this.email + " " + this.password;
    }
}
