
package models;

/**
 *
 * @author Gustavo
 */
public class User {
    
    private String email, pass;
    private char status;

    public User(String email, String pass, char status) {
        this.email = email;
        this.pass = pass;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
    
}
