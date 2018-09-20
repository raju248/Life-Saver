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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mahmu
 */
public class SearchBlood implements Initializable {

    @FXML
    private VBox vbox;
    @FXML
    private TableView<Donor> table;
    @FXML
    private TableColumn<Donor, String> NameColumn;
    @FXML
    private TableColumn<Donor, String> GenderColumn;
    @FXML
    private TableColumn<Donor, String> ContactColumn;
    @FXML
    private TableColumn<Donor, String> AddressColumn;
    @FXML
    private ComboBox<String> SelectSearchOption;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
        SelectSearchOption.getItems().addAll(list);

   
        loadDatainTable();

    }

    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException {
        //takes back to the main page of the application
        //loads the mainPage.fxml in to the stage
  
        Stage stage = (Stage) vbox.getScene().getWindow();
        String title = "Life Saver : Search Blood, Donate Blood";
        LoadStages load = new LoadStages(stage, title, "mainPage.fxml");
    }
    
    void loadDatainTable()
    {
        SelectSearchOption.valueProperty().addListener(new ChangeListener<String>() {
            //checks for changes in any comboBox
            //if any change occurs loads data in the table according to the change
            
            String bloodGroup;
            File loadData;
            FileReader readData = null;
            BufferedReader b = null;
            FileReader openUserFile = null;
            BufferedReader readUserFile = null;

            String UserName;
            String UserGender;
            String UserAddress;
            String UserContact;
            String s;

            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                bloodGroup = t1;
                
                //arraylist to store all user of a specific blood group selected from the combo box
                ArrayList<Donor> dataForTable = new ArrayList();
                
                //checks if the data taken from the combobox is empty
                //if not empty then open the file of a specific blood group
                //that holds the user name of same blood group and add the data to the arraylist
                
                if (!bloodGroup.isEmpty()) {
                    try {
                        loadData = new File("Users\\" + bloodGroup + ".txt");

                        if (loadData.exists()) {
                            readData = new FileReader(loadData);
                            b = new BufferedReader(readData);

                            while ((s = b.readLine()) != null) {
                                String s1 = s;

                                openUserFile = new FileReader(new File("Users\\" + s1 + "_name.txt"));
                                readUserFile = new BufferedReader(openUserFile);

                                UserName = readUserFile.readLine();

                                openUserFile.close();
                                readUserFile.close();

                                openUserFile = new FileReader(new File("Users\\" + s1 + "_gender.txt"));
                                readUserFile = new BufferedReader(openUserFile);

                                UserGender = readUserFile.readLine();

                                openUserFile.close();
                                readUserFile.close();

                                openUserFile = new FileReader(new File("Users\\" + s1 + "_address.txt"));
                                readUserFile = new BufferedReader(openUserFile);

                                UserAddress = readUserFile.readLine();

                                openUserFile.close();
                                readUserFile.close();

                                openUserFile = new FileReader(new File("Users\\" + s1 + "_contactNo.txt"));
                                readUserFile = new BufferedReader(openUserFile);

                                UserContact = readUserFile.readLine();

                                openUserFile.close();
                                readUserFile.close();

                                Donor d = new Donor(UserName, UserGender, UserContact, UserAddress);
                                dataForTable.add(d);
                            }

                            readData.close();
                            b.close();
                        }
                    } catch (FileNotFoundException ex) {
                        System.out.println(ex);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }

                ObservableList<Donor> tableData = FXCollections.observableArrayList(dataForTable);

                NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
                GenderColumn.setCellValueFactory(new PropertyValueFactory<>("Gender"));
                AddressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
                ContactColumn.setCellValueFactory(new PropertyValueFactory<>("Contact"));

                table.setItems(tableData);
            }

        });
    }

}
