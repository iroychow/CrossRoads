/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.business;

/**
 *
 * @author Ishita
 */
public class User {
    private String username;
    private String email;
    private String password;
    private String address;
    private String state;
    private String city;
    private String zip;
    private String contact;
    private String name;
    
    

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPhone(String phone) {
        this.contact = phone;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }
    
    public void setname(String name) {
        this.name = name;
    }

    public String getname() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return contact;
    }

    public String getAddress() {
        return address;
    }
    
    public void setName(String username) {
        this.username = username;
    }

    public String getName() {
        return username;
    }
     public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long userID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
