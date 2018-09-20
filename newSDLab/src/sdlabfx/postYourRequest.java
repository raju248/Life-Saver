/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdlabfx;

import com.jfoenix.controls.JFXButton;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mahmu
 */
public class postYourRequest implements Initializable {

    @FXML
    private TextField contactNo;
    @FXML
    private ComboBox<String> BloodGroup;
    @FXML
    private TextArea comment;
    @FXML
    private JFXButton post;
    @FXML
    private JFXButton back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
        BloodGroup.getItems().addAll(list);
    }

    @FXML
    private void postButtonAction(ActionEvent event) throws IOException {
        
        String blood;
        String contact;
        String Comment;

        if (BloodGroup.getValue() != null && !contactNo.getText().isEmpty() && !comment.getText().isEmpty()) {
            blood = BloodGroup.getValue() + "\n";
            contact = contactNo.getText() + "\n";
            Comment = comment.getText();

            Comment.replaceAll(System.getProperty("line.separator"), "#");

            String data = blood + contact + Comment;

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Sign UP");
            alert.setHeaderText("Press OK if you want to continue");
            Optional<ButtonType> result = alert.showAndWait();
            
            if (result.get() == ButtonType.OK) {
                String location = "Users\\Requests";
                try {
                    File createUserFile = new File("Users\\Requests\\" + LoginController.StaticUserName + "_request.txt");
                    createAndStore(data, createUserFile);
                } catch (Exception e) {
                    System.out.println(e);
                }

                try {
                    Stage stage = (Stage) back.getScene().getWindow();
                    String title = "Blood Request";
                    LoadStages load = new LoadStages(stage, title, "Blood Request.fxml");
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
            
        }
    }

    @FXML
    private void backButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        String title = "Blood Request";
        LoadStages load = new LoadStages(stage, title, "Blood Request.fxml");
    }

    void createAndStore(String data, File createUserFile) throws IOException {
        //creates a file for user infomation and write the data in file

        createUserFile.createNewFile();
        File dir = new File("Users\\Requests\\");
        dir.mkdirs();

        String ln = System.getProperty("line.separator");
        String as = data.replaceAll("\n", ln);

        FileWriter save = new FileWriter(createUserFile);

        BufferedWriter br = new BufferedWriter(save);

        br.write(as.toString(), 0, as.length());
        //br.write(data);
        br.close();
        save.close();
    }
}
