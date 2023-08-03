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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class
 *
 * @author MD Masum Billah
 */
public class AddFacultyController implements Initializable {

    @FXML
    private TextField IdTextField;
    @FXML
    private TextField NameTextField;
    @FXML
    private TextField SalaryTextField;
    @FXML
    private DatePicker DOBirth;
    @FXML
    private DatePicker DOjoining;
    @FXML
    private ComboBox<String> DesignationComboBox;
    @FXML
    private ComboBox<String> DepartmentComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DesignationComboBox.getItems().addAll("Professor","Assistant Professor","HR","Accountant");
        DesignationComboBox.setValue("Professor");
        
        DepartmentComboBox.getItems().addAll("CSE",
                "EEE",
                "Chemical",
                "Mechanical",
                "Civil",
                "Economics");
        DepartmentComboBox.setValue("CSE");
    }    

    @FXML
    private void AddNewFacultyOnClick(ActionEvent event) {
        File f = null;
        FileWriter fw = null;
        FileChooser fc = null;
        try {

            f = new File("EmpText.txt");  
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
            	IdTextField.getText()+","
                +NameTextField.getText()+","	
                +DesignationComboBox.getValue()+","	
                +SalaryTextField.getText()+"\n"	
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
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("This is an Information Alert");
        alert.setContentText("New Faculty has been Added!");
        alert.showAndWait();
        
        
    }
    
}
