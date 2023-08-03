/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package citsadmin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;


/**
 * FXML Controller class
 *
 * @author MD Masum Billah
 */
public class LogInPageSceneController implements Initializable {

    @FXML
    private TextField IdTextField;
    @FXML
    private PasswordField PpassField;
    @FXML
    private Button LogButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LogButtonOnClick(ActionEvent event) throws Exception {
        File f = null;
        FileWriter fw = null;
        FileChooser fc = null;
        try {

            f = new File("UserDatabase.txt");  
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
            	IdTextField.getText()+","
                +PpassField.getText()+",\n"	
            );
            fw.close();           
            
        } catch (IOException ex) {
            Logger.getLogger(AddFacultyController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
                
            } catch (IOException ex) {
                Logger.getLogger(AddFacultyController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("This is an Information Alert");
        alert.setContentText("LogIn Successful");
        alert.showAndWait();
    }
    
}
