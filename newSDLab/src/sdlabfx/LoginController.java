/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdlabfx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author razu4
 */
public class LoginController implements Initializable {

    static String StaticUserName;
    
    Boolean ready = false;

    @FXML
    private Button login;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Label incorrectUsernamePassword;

    @FXML
    private Label ClickHere;

    @FXML
    private Label incorrectusername;

    
    //takes to the main page (MainPageController.java) of the application after pressing the login button
    
    @FXML
    private void loginButtonAction(ActionEvent event) throws IOException {

        if (!username.getText().isEmpty() && !password.getText().isEmpty()) {
            StaticUserName = username.getText();
            
            
            String StoreUserName = username.getText();
            String StorePassword = password.getText();

            try{
            FileReader readUserName = new FileReader("Users\\"+StoreUserName+".txt");
            FileReader readPassword = new FileReader("Users\\"+StoreUserName + "_password.txt");

            BufferedReader br1 = new BufferedReader(readUserName);

            String S1 = br1.readLine();

            br1 = new BufferedReader(readPassword);

            String S2 = br1.readLine();

            if (S1.equals(StoreUserName) && S2.equals(StorePassword)) {
                Stage stage = (Stage) login.getScene().getWindow();
                String title = "Life Saver : Search Blood, Donate Blood";
                LoadStages load = new LoadStages(stage, title, "mainPage.fxml");    
            }
            else
            {
                incorrectUsernamePassword.setText("Incorrect Username or Password");
            }
            }
            catch(IOException e)
            {
                incorrectUsernamePassword.setText("Incorrect Username or Password");
            }
        }
   
        else
        {
            incorrectUsernamePassword.setText("Incorrect Username or Password");
        }
    }

    
    //takes to sign up (SignUP.java) page for new user when 'Click here' text is clicked
    
    @FXML
    public void ClickHereAction(MouseEvent event) {
        try{
        Stage stage = (Stage) ClickHere.getScene().getWindow();
        String title = "Life Saver : Create New Account";
        LoadStages load = new LoadStages(stage, title, "newScene.fxml");
    }
     catch(Exception e)
     {
         System.out.println(e);
     }
    }

    
    // intializes the textbox of login page when the page is loaded
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //changes the value of Error showing label when the username and password text box is clicked
        
        username.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (newValue) {
                incorrectUsernamePassword.setText("");
            }
        });

        password.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (newValue) {
                incorrectUsernamePassword.setText("");
            }
        });

        username.setText("raju248");
        password.setText("pass2480");

    }

}
