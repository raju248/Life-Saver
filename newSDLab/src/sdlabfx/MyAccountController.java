/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdlabfx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static sdlabfx.LoginController.StaticUserName;

/**
 * FXML Controller class
 *
 * @author Istiaque Hashem
 */
public class MyAccountController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label Name;
    @FXML
    private Label gender;
    @FXML
    private Label contact;
    @FXML
    private Label address;
    @FXML
    private Label bod;
    @FXML
    private Label bg;
    @FXML
    private Label city;
    @FXML
    private Label availability;
    
    
    @FXML
    private Button back;
    @FXML
    private Button edit;

    static MyAccount d = new MyAccount();
    @FXML
    private Label email;
    
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        
    }

    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        String title = "Life Saver : Search Blood, Donate Blood";
        LoadStages load = new LoadStages(stage, title, "mainPage.fxml");
    }

    @FXML
    private void EditMyAccountButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) edit.getScene().getWindow();
        String title = "Edit My Account";
        LoadStages load = new LoadStages(stage, title, "EditMyAccount.fxml");
    }
    
    void loadData(){
        String path = "Users\\";
        File loadData;
        FileReader readData = null;
        BufferedReader b = null;
        FileReader openUserFile = null;
        BufferedReader readUserFile = null;
        String UserName;
        String UserGender;
        String UserAddress;
        String UserContact;
        String Usercity;
        String Userbod;
        String Userbg;
        String UserAvailability;
        String UserEmail;
        try {
            openUserFile = new FileReader(new File(path+StaticUserName+"_name.txt"));
            readUserFile = new BufferedReader(openUserFile);

            UserName = readUserFile.readLine();

            openUserFile.close();
            readUserFile.close();

            openUserFile = new FileReader(new File(path+StaticUserName+"_gender.txt"));
            readUserFile = new BufferedReader(openUserFile);

            UserGender = readUserFile.readLine();

            openUserFile.close();
            readUserFile.close();

            openUserFile = new FileReader(new File(path+StaticUserName+"_contactNo.txt"));
            readUserFile = new BufferedReader(openUserFile);

            UserContact = readUserFile.readLine();

            openUserFile.close();
            readUserFile.close();

            openUserFile = new FileReader(new File(path+StaticUserName+"_city.txt"));
            readUserFile = new BufferedReader(openUserFile);

            Usercity = readUserFile.readLine();

            openUserFile.close();
            readUserFile.close();

            openUserFile = new FileReader(new File(path+StaticUserName+"_address.txt"));
            readUserFile = new BufferedReader(openUserFile);

            UserAddress = readUserFile.readLine();

            openUserFile.close();
            readUserFile.close();


            openUserFile = new FileReader(new File(path+StaticUserName+"_dateOfBirth.txt"));
            readUserFile = new BufferedReader(openUserFile);

            Userbod = readUserFile.readLine();

            openUserFile.close();
            readUserFile.close();

            openUserFile = new FileReader(new File(path+StaticUserName+"_bloodGroup.txt"));
            readUserFile = new BufferedReader(openUserFile);

            Userbg = readUserFile.readLine();

            openUserFile.close();
            readUserFile.close();
            
            openUserFile = new FileReader(new File(path+StaticUserName+"_bloodGroup.txt"));
            readUserFile = new BufferedReader(openUserFile);

            Userbg = readUserFile.readLine();

            openUserFile.close();
            readUserFile.close();
            
            openUserFile = new FileReader(new File(path+StaticUserName+"_availability.txt"));
            readUserFile = new BufferedReader(openUserFile);

            UserAvailability = readUserFile.readLine();

            openUserFile.close();
            readUserFile.close();
            
            
            openUserFile = new FileReader(new File(path+StaticUserName+"_email.txt"));
            readUserFile = new BufferedReader(openUserFile);

            UserEmail = readUserFile.readLine();

            openUserFile.close();
            readUserFile.close();

            d = new MyAccount(UserName, UserGender, UserContact, UserAddress,Usercity, Userbod,  Userbg, UserAvailability, UserEmail);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException e) {
            System.out.println(e);
        }
        Name.setText(d.getName());
        address.setText(d.getAddress());
        contact.setText(d.getContact());
        city.setText(d.getCity());
        bg.setText(d.getBg());
        bod.setText(d.getBod());
        gender.setText(d.getGender());
        availability.setText(d.getAv());
        email.setText(d.getEmail());
    }
}
