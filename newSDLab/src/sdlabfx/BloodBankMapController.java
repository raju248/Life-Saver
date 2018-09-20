/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdlabfx;

import com.teamdev.jxbrowser.chromium.javafx.BrowserView;
import com.jfoenix.controls.JFXButton;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.PermissionHandler;
import com.teamdev.jxbrowser.chromium.PermissionRequest;
import com.teamdev.jxbrowser.chromium.PermissionStatus;
import static com.teamdev.jxbrowser.chromium.PermissionStatus.DENIED;
import static com.teamdev.jxbrowser.chromium.PermissionStatus.GRANTED;
import com.teamdev.jxbrowser.chromium.PermissionType;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class BloodBankMapController implements Initializable {

    @FXML
    BorderPane border;
    

    @FXML
    private JFXButton back;
    
    Scene scene;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
             
        //nothing();
        
    }

    void nothing() {
        Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);

        browser.setPermissionHandler(new PermissionHandler() {
            @Override
            public PermissionStatus onRequestPermission(PermissionRequest request) {
                PermissionType type = request.getPermissionType();
                return type == PermissionType.GEOLOCATION ? GRANTED : DENIED;
            }
        });
        browser.loadURL("C:\\Users\\mahmu\\Documents\\NetBeansProjects\\sdlabfx\\geolocation.html");

        border = new BorderPane();
        border.setCenter(view);
        
        scene = border.getScene();

        
        //stage.setScene(scene);
        //stage.show();
    }
    

}
