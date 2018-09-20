package sdlabfx;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class SignUP implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private DatePicker dob;
    @FXML
    private TextField address;
    @FXML
    private TextField contact;
    @FXML
    private ComboBox bgroup1;
    @FXML
    private TextField city;
    @FXML
    private ComboBox gender;
    @FXML
    private Button signUp;
    @FXML
    private ToggleGroup group1;
    @FXML
    private Label namErrorLabel;
    @FXML
    private Label emailErrorLabel;
    @FXML
    private Label userNameErrorLabel;
    @FXML
    private Label passwordErrorLevel;
    @FXML
    private Label dobErrorLabel;
    @FXML
    private Label contactErrorLabel;

    
    Boolean done = false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
        bgroup1.getItems().addAll(list);
        bgroup1.setPromptText("Select Your Blood Group");

        ObservableList<String> list1 = FXCollections.observableArrayList();
        list1.addAll("Male", "Female");
        gender.getItems().addAll(list1);
        gender.setPromptText("Select Your Gender");

        dob.setValue(LocalDate.of(1980, 1, 1));
        
        checkName();
        checkEmail();
    }

    @FXML
    private Button back;

    //goes back to the login page when back button is clicked
    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) signUp.getScene().getWindow();
        String title = "Life Saver : Create New Account";
        LoadStages load = new LoadStages(stage, title, "login.fxml");
    }

    //creates file for new user when the sign up button is pressed
    @FXML
    private void SignUpAction(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) group1.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();

        if (!name.getText().isEmpty() && !email.getText().isEmpty() && !username.getText().isEmpty()
                && !password.getText().isEmpty() && !dob.getValue().toString().isEmpty()
                && !address.getText().isEmpty() && !city.getText().isEmpty() && !contact.getText().isEmpty()
                && bgroup1.getValue() != null && gender.getValue() != null && !toogleGroupValue.isEmpty() && done) {
            try {
                String getBloodGroup;
                String getName = name.getText();
                String getEmail = email.getText();
                String getUsername = username.getText();
                String getPassword = password.getText();
                String getDOB = dob.getValue().toString();
                String getAddress = address.getText();
                String getCity = city.getText();
                String getContact = contact.getText();
                String getAvailability = toogleGroupValue;
                getBloodGroup = bgroup1.getValue().toString();
                String getGender;
                getGender = gender.getValue().toString();

                //File dir = new File("Users");
                //dir.mkdirs();
                File createUserFile = new File("Users\\" + getUsername + ".txt");

                if (!createUserFile.exists()) {
                    //a pop window appears and if the user clicks ok 
                    //files for user information gets created and information is stored

                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Confirm Sign UP");
                    alert.setHeaderText("Press OK if you want to continue");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {

                        createAndStore(getUsername, createUserFile);

                        createUserFile = new File("Users\\" + getUsername + "_password.txt");
                        createAndStore(getPassword, createUserFile);

                        createUserFile = new File("Users\\" + getUsername + "_name.txt");
                        createAndStore(getName, createUserFile);

                        createUserFile = new File("Users\\" + getUsername + "_email.txt");
                        createAndStore(getEmail, createUserFile);

                        createUserFile = new File("Users\\" + getUsername + "_dateOfBirth.txt");
                        createAndStore(getDOB, createUserFile);

                        createUserFile = new File("Users\\" + getUsername + "_address.txt");
                        createAndStore(getAddress, createUserFile);

                        createUserFile = new File("Users\\" + getUsername + "_city.txt");
                        createAndStore(getCity, createUserFile);

                        createUserFile = new File("Users\\" + getUsername + "_contactNo.txt");
                        createAndStore(getContact, createUserFile);

                        createUserFile = new File("Users\\" + getUsername + "_bloodGroup.txt");
                        createAndStore(getBloodGroup, createUserFile);

                        createUserFile = new File("Users\\" + getUsername + "_gender.txt");
                        createAndStore(getGender, createUserFile);

                        createUserFile = new File("Users\\" + getUsername + "_availability.txt");
                        createAndStore(getAvailability, createUserFile);

                        createUserFile = new File("Users\\" + getBloodGroup + ".txt");

                        if (!createUserFile.exists()) {
                            createUserFile.createNewFile();
                        }

                        FileWriter save = new FileWriter(createUserFile, true);
                        save.write(getUsername + System.getProperty("line.separator"));
                        save.close();

                        Stage stage = (Stage) signUp.getScene().getWindow();
                        String title = "Life Saver";
                        LoadStages load = new LoadStages(stage, title, "login.fxml");
                    } else {
                        return;
                    }
                } else {
                    //a pop up windows appears if user name already exists
                    //and waits until the ok button is clicked
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText("User name " + getUsername + " already exists");
                    alert.setTitle("Error");
                    alert.showAndWait();
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            //a pop up window appears if the user presses the sign up
            //button without completing the form

            Alert alert = new Alert(AlertType.ERROR);
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
    
    
    void checkName()
    {
        name.textProperty().addListener((observable, oldValue, newValue) -> {
            String PATTERN = "[a-zA-Z. ]{0,100}$";    //Writing pattern and array size//
            Pattern patt = Pattern.compile(PATTERN);
            Matcher match = patt.matcher(newValue);
            if (!match.matches()) {
                namErrorLabel.setText("Please enter name correctly.");
                done = false;
            } else {
                namErrorLabel.setText(null);
                done = true;
            }
        }
        );
    }
    
    void checkEmail()
    {
        email.textProperty().addListener((observable, oldValue, newValue) -> {
            String PATTERN = "[a-zA-Z@.0-9 ]{0,100}$";    //Writing pattern and array size//
            Pattern patt = Pattern.compile(PATTERN);
            Matcher match = patt.matcher(newValue);
            if (!match.matches()) {
                emailErrorLabel.setText("Please enter a valid Email");
                done = false;
            } else {
                emailErrorLabel.setText(null);
                done = true;
            }
        }
        );
    }
}
