
package sdlabfx;


public class Donor {
    private String Name;
    private String Gender;
    private String Contact;
    private String Address;
    
    Donor(String Name, String Gender, String Contact, String Address)
    {
        this.Name = Name;
        this.Gender = Gender;
        this.Address = Address;
        this.Contact = Contact;
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
    
    
}
