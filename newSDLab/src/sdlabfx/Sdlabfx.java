package sdlabfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Sdlabfx extends Application {
    static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
      
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        scene = new Scene(root);
        
        stage.setTitle("Life Saver");
        stage.setScene(scene);
        stage.show();
        
       
        
    }


    /*public static void main(String[] args) {

        launch(args);

    }*/


}

