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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static sdlabfx.LoginController.StaticUserName;

/**
 * FXML Controller class
 *
 * @author mahmu
 */
public class bloodRequest implements Initializable {

    @FXML
    private TableView<Request> requestTable;
    @FXML
    private TableColumn<Request, Donor> requiredBloodColumn;
    @FXML
    private TableColumn<Request, Donor> contactColumn;
    @FXML
    private TableColumn<Request, Donor> commentColumn;

    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadDatainTable();
        
    }

    @FXML
    private void backbuttonaction(ActionEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        String title = "Life Saver : Search Blood, Donate Blood";
        LoadStages load = new LoadStages(stage, title, "mainPage.fxml");
    }

    @FXML
    private void postRequestlLabel(MouseEvent event) throws IOException {
        File r = new File("Users\\Requests\\"+StaticUserName+"_request.txt");
        
        
       if(r.exists()){
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Error");
                   alert.setHeaderText("You already have a pending request.\n"+"You cannot post more than one request");
                   Optional<ButtonType> result = alert.showAndWait();

    }
       else
       {
                   try {
            Stage stage = (Stage) back.getScene().getWindow();
            String title = "Post Your Request";
            LoadStages load = new LoadStages(stage, title, "postYourRequest.fxml");
        } catch (NullPointerException e) {
            System.out.println(e);
        }
       }
 }
    @FXML
    private void deleteRequestLabel(MouseEvent event) {
               File r = new File("Users\\Requests\\"+StaticUserName+"_request.txt");
               
               if(r.exists()){
                   r.delete();
                   
                   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                   alert.setTitle("Success");
                   alert.setHeaderText("Request Deleted");
                   Optional<ButtonType> result = alert.showAndWait();
                   
                   loadDatainTable();
               }
               else
               {
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Error");
                   alert.setHeaderText("You have no request");
                   Optional<ButtonType> result = alert.showAndWait();
               }
    }

    
    void loadDatainTable()
    {
        ArrayList<Request> dataForTable = new ArrayList();
        
        File f = new File("Users\\Requests");

        BufferedReader br;

        String files[] = f.list();

        for (String s : files) {
            System.out.println(s);
            try {
               br = new BufferedReader(new FileReader(new File("Users\\Requests\\" + s)));
               ArrayList<String> allLine = new ArrayList();
               String line;
                
               while ((line = br.readLine()) != null){
                   System.out.println(line);
                   allLine.add(line);
                }
                
                String bg = allLine.get(0);
                String cn = allLine.get(1);
                String cm = allLine.get(2);
                
                Request r = new Request(bg,cn,cm);
                dataForTable.add(r);
                
                br.close();
                
            } catch (FileNotFoundException ex) {

            } catch (IOException ex) {

            }
            
        }
        ObservableList<Request> tableData = FXCollections.observableArrayList(dataForTable);
        requiredBloodColumn.setCellValueFactory(new PropertyValueFactory<>("BloodGroup"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("Comment"));
        
        requestTable.setItems(tableData);
    }
}
