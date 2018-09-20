/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdlabfx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import static sdlabfx.LoginController.StaticUserName;
import static sdlabfx.MyAccountController.d;

public class EditMyAccountController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField City;
    @FXML
    private TextField Contact;
    @FXML
    private TextField address;
    @FXML
    private ComboBox<String> gender;
    @FXML
    private ComboBox<String> bloodGroup;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private ToggleGroup group;
    @FXML
    private Button back;
    @FXML
    private TextField email;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
        bloodGroup.getItems().addAll(list);

        ObservableList<String> list1 = FXCollections.observableArrayList();
        list1.addAll("Male", "Female");
        gender.getItems().addAll(list1);

        setDatainTextField();

    }

    void setDatainTextField() {
        name.setText(d.getName());
        City.setText(d.getCity());
        Contact.setText(d.getContact());
        address.setText(d.getAddress());

        String date = d.getBod();

        String c[] = date.split("-");

        dateOfBirth.setValue(LocalDate.of(Integer.parseInt(c[0]), Integer.parseInt(c[1]), Integer.parseInt(c[2])));

        bloodGroup.setValue(d.getBg());
        gender.setValue(d.getGender());
        email.setText(d.getEmail());
    }

    @FXML
    private void backButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        String title = "My Account";
        LoadStages load = new LoadStages(stage, title, "MyAccount.fxml");
    }

    @FXML
    private void saveEditedData(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();

        if (!name.getText().isEmpty() && !email.getText().isEmpty() /*&& !username.getText().isEmpty()
                &&*/ /*!password.getText().isEmpty()*/ && !dateOfBirth.getValue().toString().isEmpty()
                && !address.getText().isEmpty() && !City.getText().isEmpty() && !Contact.getText().isEmpty()
                && bloodGroup.getValue() != null && gender.getValue() != null && !toogleGroupValue.isEmpty()) {
            try {
                String getBloodGroup;
                String getName = name.getText();
                String getEmail = email.getText();
                //String getUsername = username.getText();
                // String getPassword = password.getText();
                String getDOB = dateOfBirth.getValue().toString();
                String getAddress = address.getText();
                String getCity = City.getText();
                String getContact = Contact.getText();
                String getAvailability = toogleGroupValue;
                getBloodGroup = bloodGroup.getValue().toString();
                String getGender;
                getGender = gender.getValue().toString();

                //File dir = new File("Users");
                //dir.mkdirs();
                File createUserFile = new File("Users\\" + StaticUserName + ".txt");

                //a pop window appears and if the user clicks ok 
                //files for user information gets created and information is stored
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm Sign UP");
                alert.setHeaderText("Press OK if you want to continue");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {

                    createUserFile = new File("Users\\" + StaticUserName + "_name.txt");
                    createAndStore(getName, createUserFile);

                    createUserFile = new File("Users\\" + StaticUserName + "_email.txt");
                    createAndStore(getEmail, createUserFile);

                    createUserFile = new File("Users\\" + StaticUserName + "_dateOfBirth.txt");
                    createAndStore(getDOB, createUserFile);

                    createUserFile = new File("Users\\" + StaticUserName + "_address.txt");
                    createAndStore(getAddress, createUserFile);

                    createUserFile = new File("Users\\" + StaticUserName + "_city.txt");
                    createAndStore(getCity, createUserFile);

                    createUserFile = new File("Users\\" + StaticUserName + "_contactNo.txt");
                    createAndStore(getContact, createUserFile);

                    
                    createUserFile = new File("Users\\" + StaticUserName + "_bloodGroup.txt");
                    createAndStore(getBloodGroup, createUserFile);
                    
                    updateCommonBloodGroupFile();

                    createUserFile = new File("Users\\" + StaticUserName + "_gender.txt");
                    createAndStore(getGender, createUserFile);

                    createUserFile = new File("Users\\" + StaticUserName + "_availability.txt");
                    createAndStore(getAvailability, createUserFile);

                    createUserFile = new File("Users\\" + getBloodGroup + ".txt");

                    if (!createUserFile.exists()) {
                        createUserFile.createNewFile();
                    }

                    FileWriter save = new FileWriter(createUserFile, true);
                    save.write(StaticUserName + System.getProperty("line.separator"));
                    save.close();

                    Stage stage = (Stage) back.getScene().getWindow();
                    String title = "My Account";
                    LoadStages load = new LoadStages(stage, title, "MyAccount.fxml");

                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            //a pop up window appears if the user presses the sign up
            //button without completing the form

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incomplete Form");
            alert.setHeaderText("Complete the form to Sign Up");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    void createAndStore(String data, File createUserFile) throws IOException {
        //creates a file for user infomation and write the data in file

        File dir = new File("Users");
        dir.mkdirs();

        FileWriter save = new FileWriter(createUserFile);
        save.write(data);
        save.close();

    }

    void updateCommonBloodGroupFile() throws IOException {
        File inputFile = new File("Users\\"+d.getBg()+".txt");
        File tempFile = new File("Users\\myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = StaticUserName;
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            System.out.println(currentLine);
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if (trimmedLine.equals(lineToRemove)) {
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        inputFile.delete();
        boolean successful = tempFile.renameTo(inputFile);
        System.out.println(successful);
    }

}
