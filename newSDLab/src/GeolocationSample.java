/*
 * Copyright (c) 2000-2017 TeamDev Ltd. All rights reserved.
 * TeamDev PROPRIETARY and CONFIDENTIAL.
 * Use is subject to license terms.
 */

import static com.teamdev.jxbrowser.chromium.PermissionStatus.DENIED;
import static com.teamdev.jxbrowser.chromium.PermissionStatus.GRANTED;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserPreferences;
import com.teamdev.jxbrowser.chromium.JSValue;
import com.teamdev.jxbrowser.chromium.PermissionHandler;
import com.teamdev.jxbrowser.chromium.PermissionRequest;
import com.teamdev.jxbrowser.chromium.PermissionStatus;
import com.teamdev.jxbrowser.chromium.PermissionType;
import com.teamdev.jxbrowser.chromium.events.FinishLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.LoadAdapter;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * The sample demonstrates how to enable Geolocation API in Chromium engine.
 */
public class GeolocationSample {
    public static void main(String[] args) throws ScriptException, FileNotFoundException {
        BrowserPreferences.setChromiumVariable("GOOGLE_API_KEY", "AIzaSyBk84E22UvDE3FEU8uJaCXeaPq2JDdzuZY");
        BrowserPreferences.setChromiumVariable("GOOGLE_DEFAULT_CLIENT_ID", "308176406924-qod3f16foc3drevmfhgp2q36ot3jq4mn.apps.googleusercontent.com");
        BrowserPreferences.setChromiumVariable("GOOGLE_DEFAULT_CLIENT_SECRET", "9IFccHhzZ-VVwTfnRc6FFeER");

        
        Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(view, BorderLayout.CENTER);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        browser.setPermissionHandler(new PermissionHandler() {
            @Override
            public PermissionStatus onRequestPermission(PermissionRequest request) {
                PermissionType type = request.getPermissionType();
                return type == PermissionType.GEOLOCATION ? GRANTED : DENIED;
            }
        });
        
       /* browser.addLoadListener(new LoadAdapter() {
            @Override
            public void onFinishLoadingFrame(FinishLoadingEvent event) {
                if (event.isMainFrame()) {
                    Browser browser = event.getBrowser();
                    JSValue value = browser.executeJavaScriptAndReturnValue("window");
                    value.asObject().setProperty("Account", new Account());
                }
            }
        });*/
        
        
        //browser.executeJavaScriptAndReturnValue("C:\\Users\\razu4\\Documents\\NetBeansProjects\\geoapi.js");
        
        
        //browser.loadURL("http://html5demos.com/geo");
        
        browser.loadURL("C:\\Users\\mahmu\\Documents\\NetBeansProjects\\sdlabfx\\src\\geolocation.html");
        
    }
    
    /*public static class Account {
        public void save(String firstName, String lastName) throws IOException {
            System.out.println("firstName = " + firstName);
            System.out.println("lastName = " + lastName);
           BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\LatLan.txt"));
                writer.write(firstName);
                writer.newLine();
                writer.write(lastName);
                writer.newLine();
                writer.close();
        }
    }*/
}
