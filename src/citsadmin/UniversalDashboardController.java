/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package citsadmin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author MD Masum Billah
 */
public class UniversalDashboardController implements Initializable {

    @FXML
    private BorderPane Parent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ApproveNewFacultyOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("AddFaculty.fxml"));
        Parent.setCenter(parent);
    }

    @FXML
    private void ApproveOfferedCourseOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ApproveNewCourseScene.fxml"));
        Parent.setCenter(parent);
    }

    @FXML
    private void ShowFacultyListOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("FacultyList.fxml"));
        Parent.setCenter(parent);
    }

    @FXML
    private void ShowCourseListOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("CourseList.fxml"));
        Parent.setCenter(parent);
    }

    @FXML
    private void ShowOfferCoursToStudentPageOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("OfferCourseForRegistration.fxml"));
        Parent.setCenter(parent);
    }

    @FXML
    private void ShowRegistrationPageOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        Parent.setCenter(parent);
    }
    
}
