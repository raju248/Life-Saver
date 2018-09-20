package sdlabfx;

/*
 * Copyright (c) 2000-2017 TeamDev Ltd. All rights reserved.
 * TeamDev PROPRIETARY and CONFIDENTIAL.
 * Use is subject to license terms.
 */

import com.teamdev.jxbrowser.chromium.BrowserPreferences;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Demonstrates how to switch between full screen mode and window mode.
 */
public class MainClassofProject extends Application {

    static Stage stage = new Stage();

    public static void main(String[] args) {
        
        BrowserPreferences.setChromiumVariable("GOOGLE_API_KEY", "AIzaSyBk84E22UvDE3FEU8uJaCXeaPq2JDdzuZY");
        BrowserPreferences.setChromiumVariable("GOOGLE_DEFAULT_CLIENT_ID", "308176406924-qod3f16foc3drevmfhgp2q36ot3jq4mn.apps.googleusercontent.com");
        BrowserPreferences.setChromiumVariable("GOOGLE_DEFAULT_CLIENT_SECRET", "9IFccHhzZ-VVwTfnRc6FFeER");

        launch(args);
    }

    /* @Override
    public void init() throws Exception {
        // On Mac OS X Chromium engine must be initialized in non-UI thread.
        if (Environment.isMac()) {
            BrowserCore.initialize();
        }
    }*/
    @Override
    public void start(Stage pstage) throws IOException {

        Scene scene;
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        scene = new Scene(root);

        pstage.setTitle("Life Saver");
        pstage.setScene(scene);
        pstage.show();

    }
}
