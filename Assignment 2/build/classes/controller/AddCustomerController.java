package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.Kiosk;

public class AddCustomerController extends Controller<Kiosk> {
    @FXML private TextField idTf;
    @FXML private TextField nameTf;
    @FXML private TextField balanceTf;
    @FXML private Text feedbackTxt;
    @FXML private Button addCustomerBtn;
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private int getID() {
        return Integer.parseInt(idTf.getText());
    }
    
    private String getName() {
        return nameTf.getText();
    }
    
    private int getBalance() {
        return Integer.parseInt(balanceTf.getText());
    }
    
    @FXML private void initialize() {
        idTf.textProperty().addListener((o, oldID, newID) ->
                addCustomerBtn.setDisable(!idTf.getText().matches("[0-9]+")));
    }
    
    @FXML
    private void handleAddCustomer(ActionEvent event) {
        try {
            if (getKiosk().getCustomer(getID()) == null) {
                getKiosk().addCustomer(getID(), getName(), getBalance());
                feedbackTxt.setText("Customer added to Kiosk.");
            }
            else {
                feedbackTxt.setText("Customer ID already exists.");
            }
        }
        catch (Exception e) {
            feedbackTxt.setText("Invalid input.");
        }
    }
    
    @FXML
    private void handleClose(ActionEvent event) {
        stage.close();
    }
}
