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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MD Masum Billah
 */
public class OfferCourseForRegistrationController implements Initializable {

    @FXML
    private TextField EnrolledTextField;
    @FXML
    private TextField FacultyidTextField;
    @FXML
    private ComboBox<Integer> SectionComboBox;
    @FXML
    private ComboBox<String> DaysComboBox;
    @FXML
    private ComboBox<String> SemesterComboBox;
    @FXML
    private ComboBox<String> RoomComboBox;
    @FXML
    private ComboBox<String> TimeComboBox;
    @FXML
    private ComboBox<Integer> CapacityComboBox;
    @FXML
    private TextField CourseIdTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SemesterComboBox.getItems().addAll("Summer","Spring","Autumn");
        SemesterComboBox.setValue("Select a semester");
        
        SectionComboBox.getItems().addAll(1,2,3,4,5,6,7);
        SectionComboBox.setValue(1);
        
        DaysComboBox.getItems().addAll("ST","MW","RA");
        DaysComboBox.setValue("ST");
        
        RoomComboBox.getItems().addAll("BC5001","BC5002","BC5003","BC5004","BC5005","BC5006");
        RoomComboBox.setValue("BC5001");
        
        CapacityComboBox.getItems().addAll(35,40,45,50,55,60);
        CapacityComboBox.setValue(35);
        
        TimeComboBox.getItems().addAll("8:00-9:30",
                "9:40-11:10",
                "11:20-12:50",
                "1:00-2:30",
                "2:40-4:10",
                "4:20-5:50");
        TimeComboBox.setValue("8:00-9:30");
    }    

    @FXML
    private void ApproveCourseforRegistrationPageOnClick(ActionEvent event) {
        File f = null;
        FileOutputStream fos = null;
        //BufferedOutputStream bos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("OfferedCourse.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);
            
            //bos = new BufferedOutputStream(fos);
            //dos = new DataOutputStream(bos);
            dos = new DataOutputStream(fos);
            
            
            dos.writeUTF(CourseIdTextField.getText());
            dos.writeUTF(FacultyidTextField.getText());
            dos.writeInt(SectionComboBox.getValue());
            dos.writeUTF(DaysComboBox.getValue());
            dos.writeUTF(SemesterComboBox.getValue());
            dos.writeUTF(TimeComboBox.getValue());
            dos.writeUTF(EnrolledTextField.getText());
            dos.writeInt(CapacityComboBox.getValue());        
            
            
            

        } catch (IOException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (IOException ex) {
                Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // Set the alert title and header text
        alert.setTitle("Information Dialog");
        alert.setHeaderText("This is an information alert!");

        // Set the alert content text
        alert.setContentText("New Course has been Approved for Student Registration!");

        // Show the alert
        alert.showAndWait();
    }
    
}
