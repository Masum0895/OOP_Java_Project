/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package citsadmin;

// Hasib Developer

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author MD Masum Billah
 */
public class FacultyListController implements Initializable {

    @FXML
    private TextArea outputTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void ShowFacultyListOncCick(ActionEvent event) {
        //outputTextArea.setText("");
        outputTextArea.clear();
        File f = null;
        //FileReader fw = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("EmpText.txt");
            sc = new Scanner(f);
            if(f.exists()){
                outputTextArea.appendText("Content of Emp.txt:\n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    outputTextArea.appendText(
                            "Id="+tokens[0]
                            +", Name="+tokens[1]
                            +", Designation="+tokens[2]
                            +", Salary="+tokens[3]+"\n"
                    );
                }
            }
            else 
                outputTextArea.setText("oops! Emp.txt does not exist...");
            
        } 
        catch (IOException ex) {
            Logger.getLogger(FacultyListController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }        
    }    
}
