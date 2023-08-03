/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package citsadmin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MD Masum Billah
 */
public class RegistrationController implements Initializable {

    @FXML
    private ComboBox<Integer> SectionComboBox;
    @FXML
    private ComboBox<String> DaysComboBox;
    @FXML
    private ComboBox<String> SemesterComboBox;
    @FXML
    private ComboBox<String> TimeComboBox;
    @FXML
    private TextArea CapacityTextArea;
    @FXML
    private TextArea EnrolledTextArea;
    @FXML
    private TextArea CourseListOutputTextArea;
    @FXML
    private TextArea FacultyListOutputTextArea;
    @FXML
    private TextField CourseIdTextField;
    @FXML
    private TextField FacultyIdTextField;

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
        
        TimeComboBox.getItems().addAll("8:00-9:30",
                "9:40-11:10",
                "11:20-12:50",
                "1:00-2:30",
                "2:40-4:10",
                "4:20-5:50");
        TimeComboBox.setValue("8:00-9:30");
    }    

    @FXML
    private void RegisterOnClick(ActionEvent event) {
        File f = null;
        FileOutputStream fos = null;
        //BufferedOutputStream bos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("RegisteredCourse.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);
            
            //bos = new BufferedOutputStream(fos);
            //dos = new DataOutputStream(bos);
            dos = new DataOutputStream(fos);
            
            
            dos.writeUTF(CourseIdTextField.getText());
            dos.writeUTF(FacultyIdTextField.getText());
            dos.writeInt(SectionComboBox.getValue());
            dos.writeUTF(DaysComboBox.getValue());
            dos.writeUTF(SemesterComboBox.getValue());
            dos.writeUTF(TimeComboBox.getValue());
            
            
            

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
        alert.setContentText("Your Course Registration has been Succeed!");

        // Show the alert
        alert.showAndWait();
    }

    @FXML
    private void ShowCourseListOnClick(ActionEvent event) {
        CourseListOutputTextArea.setText("");
        File f = null;
        FileInputStream fis = null;
        //BufferedInputStream bis = null;
        DataInputStream dis = null;
        String str="";
        try {
            f = new File("EmpData.bin");
            if(!f.exists()){
                CourseListOutputTextArea.setText("Oops! EmpData.bin binary file does not exist...");
            }
            else{
                
                fis = new FileInputStream(f);
                //bis = new BufferedInputStream(fis);
                //dis = new DataInputStream(bis);
                dis = new DataInputStream(fis);
                //String str="";
                while(true){
                    str+= "Course Id:"+dis.readUTF()
                        +"; Title:"+dis.readUTF()
                        +"; No Of Credit:"+dis.readUTF()
                        +"; Course Type:"+dis.readUTF()
                        +"; Course Category: "+dis.readUTF()
                        +"\n";
                    //outputTextArea.setText(str);
                }//while
                //outputTextArea.setText(str);
            }//else
        } catch (IOException ex) {
            CourseListOutputTextArea.setText(str);
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dis != null) dis.close();
            } catch (IOException ex) {
                Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }

    @FXML
    private void ShowFacultyListOnClick(ActionEvent event) {
        //outputTextArea.setText("");
        FacultyListOutputTextArea.clear();
        File f = null;
        //FileReader fw = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("EmpText.txt");
            sc = new Scanner(f);
            if(f.exists()){
                FacultyListOutputTextArea.appendText("Content of Emp.txt:\n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    FacultyListOutputTextArea.appendText(
                            "Id="+tokens[0]
                            +", Name="+tokens[1]
                            +", Designation="+tokens[2]
                            +", Salary="+tokens[3]+"\n"
                    );
                }
            }
            else 
                FacultyListOutputTextArea.setText("oops! Emp.txt does not exist...");
            
        } 
        catch (IOException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }
    }
    
}
