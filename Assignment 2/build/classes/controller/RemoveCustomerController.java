package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import model.Kiosk;
import model.Customer;

public class RemoveCustomerController extends Controller<Kiosk> {
    @FXML private TableView<Customer> customersTv;
    @FXML private Button removeCustomerBtn;
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private Customer getSelectedCustomer() {
        return customersTv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void initialize() {
        customersTv.getSelectionModel().selectedItemProperty().addListener(
        (o, oldCustomer, newCustomer) -> removeCustomerBtn.setDisable(getSelectedCustomer() == null));
    }
    
    @FXML
    private void handleRemoveCustomer(ActionEvent event) {
        getKiosk().removeCustomer(getSelectedCustomer());
    }
    
    @FXML
    private void handleExit(ActionEvent event) {
        stage.close();
    }
}
