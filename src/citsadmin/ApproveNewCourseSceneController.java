/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package citsadmin;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



/**
 * FXML Controller class
 *
 * @author MD Masum Billah
 */
public class ApproveNewCourseSceneController implements Initializable {

    @FXML
    private TextField CourseIdTextField;
    @FXML
    private TextField TittleTextField;
    @FXML
    private TextField CreditTextField;
    @FXML
    private ComboBox<String> CategoryComboBox;
    @FXML
    private ComboBox<String> TypeComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TypeComboBox.getItems().addAll("Major","Minor","Foundation","Core");
        TypeComboBox.setValue("Major");
        
        CategoryComboBox.getItems().addAll("Lab","Theory");
        CategoryComboBox.setValue("Theory");
    }    

    @FXML
    private void ApproveCourseOnClick(ActionEvent event) {
        File f = null;
        FileOutputStream fos = null;
        //BufferedOutputStream bos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("EmpData.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);
            
            //bos = new BufferedOutputStream(fos);
            //dos = new DataOutputStream(bos);
            dos = new DataOutputStream(fos);
            
            
            dos.writeUTF(CourseIdTextField.getText());
            dos.writeUTF(TittleTextField.getText());
            dos.writeUTF(CreditTextField.getText());
            dos.writeUTF(TypeComboBox.getValue());
            dos.writeUTF(CategoryComboBox.getValue());
            
            
            

        } catch (IOException ex) {
            Logger.getLogger(ApproveNewCourseSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (IOException ex) {
                Logger.getLogger(ApproveNewCourseSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Alert alert = new Alert(AlertType.INFORMATION);
        // Set the alert title and header text
        alert.setTitle("Information Dialog");
        alert.setHeaderText("This is an information alert!");

        // Set the alert content text
        alert.setContentText("New Course has been Approved!");

        // Show the alert
        alert.showAndWait();
        
    }
    
}
