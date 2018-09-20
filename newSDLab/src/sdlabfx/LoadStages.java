package sdlabfx;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoadStages {

    //loads new fxml file file in the stage
    //resource = path of the fxml file
    
    LoadStages(Stage s, String title,String resource) throws IOException{
               Stage stage = s;
               Parent root = FXMLLoader.load(getClass().getResource(resource));
               Scene scene = new Scene(root);
               stage.setTitle(title);
               stage.setScene(scene);
               stage.centerOnScreen();
               stage.show();
}
}
