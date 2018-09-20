package sdlabfx;

import com.jfoenix.controls.JFXButton;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserType;
import com.teamdev.jxbrowser.chromium.PermissionHandler;
import com.teamdev.jxbrowser.chromium.PermissionRequest;
import com.teamdev.jxbrowser.chromium.PermissionStatus;
import static com.teamdev.jxbrowser.chromium.PermissionStatus.DENIED;
import static com.teamdev.jxbrowser.chromium.PermissionStatus.GRANTED;
import com.teamdev.jxbrowser.chromium.PermissionType;

import com.teamdev.jxbrowser.chromium.javafx.BrowserView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainPageController implements Initializable {

   
    @FXML
    private Button Exit;

    @FXML
    private void SearchBloodButtonAction(ActionEvent event) throws IOException {
        /*this method will be implemented to 
        search blood donor of a specific group
        from the database with help of
        google map api with geolocation*/

        Stage stage = (Stage) Exit.getScene().getWindow();
        String title = "Search Donor";
        LoadStages load = new LoadStages(stage, title, "SearchBloodTable.fxml");

    }

    @FXML
    private void RequestBloodButtonAction(ActionEvent event) throws IOException {
        /*this method will be implemented to request
        for blood and other users will see the request*/
       try{ 
        Stage stage = (Stage) Exit.getScene().getWindow();
        String title = "Blood Request";
        LoadStages load = new LoadStages(stage, title, "Blood Request.fxml");
       }
       catch(IOException e)
       {
           System.out.println(e);
       }
    }

    @FXML
    private void BloodBanksButtonAction(ActionEvent event) throws IOException {
       
        try {
            //Stage stage = new Stage();
            Stage stage = (Stage) Exit.getScene().getWindow();
            stage.hide();
            Stage s = new Stage();
            s.setTitle("Nearby Blood Banks");
            Browser browser = new Browser(BrowserType.LIGHTWEIGHT);
            BrowserView view = new BrowserView(browser);

            browser.setPermissionHandler((PermissionRequest request) -> {
                PermissionType type = request.getPermissionType();
                return type == PermissionType.GEOLOCATION ? GRANTED : DENIED;
            });
            browser.loadURL("C:\\Users\\razu4\\Documents\\NetBeansProjects\\newSDLab\\src\\geolocationWithBloodBank.html");
            BorderPane border = new BorderPane();
            JFXButton back = new JFXButton("RAISED BUTTON");
            border.setPadding(new Insets(10, 20, 10, 20));

            back.setPrefSize(150, 30);
            back.setLayoutX(300);
            back.setLayoutY(430);
            back.setText("Back");

            back.setStyle(".button {\n"
                    + "    -fx-padding: 5 22 5 22;   \n"
                    + "    -fx-border-color: #e2e2e2;\n"
                    + "    -fx-border-width: 2;\n"
                    + "    -fx-background-radius: 0;\n"
                    + "    -fx-background-color:  #011F2A;\n"
                    + "    -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif;\n"
                    + "    -fx-font-size: 11pt;\n"
                    + "    -fx-text-fill: #d8d8d8;\n"
                    + "    -fx-background-insets: 0 0 0 0, 0, 1, 2;\n"
                    + "    -fx-rippler-fill: #00ff00;"            
                    );

            border.setCenter(view);
            border.setBottom(back);
            BorderPane.setAlignment(back, Pos.CENTER);
            BorderPane.setMargin(back, new Insets(10));

            Scene scene = new Scene(border, 900, 600);
            s.setScene(scene);
            s.show();

            s.setOnCloseRequest((WindowEvent t) -> {
                Platform.exit();
                s.close();
                view.getBrowser().dispose();
            });

            back.setOnAction((ActionEvent event1) -> {
                String title = "Life Saver : Search Blood, Donate Blood";
                stage.show();
                s.close();
                view.getBrowser().dispose();
                //LoadStages load = new LoadStages(stage, title, "mainPage.fxml");
            });
        } catch (Exception e) {
            System.out.println();
        }
  
    }

    //takes to the page that shows facts about blood donation when Facts button is clicked
    @FXML
    private void FactsButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) Exit.getScene().getWindow();
        String title = "Blood Donation Facts";
        LoadStages load = new LoadStages(stage, title, "facts.fxml");
    }

    @FXML
    private void MyAccountButtonAction(ActionEvent event) throws IOException {
        /*this method will be to show the user's basic infomation
            users will be able to modify their information as well*/
        Stage stage = (Stage) Exit.getScene().getWindow();
        String title = "My Account";
        LoadStages load = new LoadStages(stage, title, "MyAccount.fxml");
    }

    @FXML
    private void LogOutButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) Exit.getScene().getWindow();
        String title = "Life Saver";
        LoadStages load = new LoadStages(stage, title, "login.fxml");
    }

    //exits from the program 
    @FXML
    private void ExitButtonAction(ActionEvent event) {

        Platform.exit();
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.setOnCloseRequest((WindowEvent t) -> {
            Platform.exit();
            System.out.println("raju");
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
