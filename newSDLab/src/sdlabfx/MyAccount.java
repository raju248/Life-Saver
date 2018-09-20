/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdlabfx;

/**
 *
 * @author Istiaque Hashem
 */
public class MyAccount {

    private String Name;
    private String Gender;
    private String Contact;
    private String Address;
    private String email;
    private String city;
    private String bod;
    private String bg;

    private String av;
    
    MyAccount() {

    }

    MyAccount(String Name, String Gender, String Contact, String Address, String city, String bod, String bg, String av, String email) {
        this.Name = Name;
        this.Gender = Gender;
        this.Address = Address;
        this.Contact = Contact;
       
        this.bg = bg;
        this.bod = bod;
        this.city = city;
        this.av = av;
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBod() {
        return bod;
    }

    public void setBod(String bod) {
        this.bod = bod;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getAv() {
        return av;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

}
