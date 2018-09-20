/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdlabfx;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mahmu
 */
public class FactsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button back;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException
    {
        Stage stage = (Stage) back.getScene().getWindow();
        String title = "Life Saver : Create New Account";
        LoadStages load = new LoadStages(stage, title, "mainPage.fxml");
    }
   
    
}
