
package sdlabfx;

public class Request {
    private String BloodGroup;
    private String Contact;
    private String Comment;

    /**
     * @return the BloodGroup
     */
    
    Request(String BloodGroup, String Contact, String Comment)
    {
        this.BloodGroup = BloodGroup;
        this.Contact = Contact;
        this.Comment = Comment;
    }
    
    public String getBloodGroup() {
        return BloodGroup;
    }

    /**
     * @param BloodGroup the BloodGroup to set
     */
    public void setBloodGroup(String BloodGroup) {
        this.BloodGroup = BloodGroup;
    }

    /**
     * @return the Contact
     */
    public String getContact() {
        return Contact;
    }

    /**
     * @param Contact the Contact to set
     */
    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    /**
     * @return the Comment
     */
    public String getComment() {
        return Comment;
    }

    /**
     * @param Comment the Comment to set
     */
    public void setComment(String Comment) {
        this.Comment = Comment;
    }
    
}
