package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.Kiosk;
import model.Movie;

public class CustomerRecordController extends Controller<Kiosk> {
    @FXML private TextField idTf;
    @FXML private Button selectCustomerBtn;
    @FXML private Text feedbackTxt;
    @FXML private TableView<Movie> rentedMoviesTv;
    @FXML private TableView<Movie> rentHistoryTv;
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private int getID() {
        return Integer.parseInt(idTf.getText());
    }
    
    @FXML private void initialize() {
        idTf.textProperty().addListener((o, oldID, newID) ->
                selectCustomerBtn.setDisable(!idTf.getText().matches("[0-9]+")));
    }
    
    @FXML
    private void handleSelectCustomer(ActionEvent event) {
        try {
            rentedMoviesTv.setItems(getKiosk().getCustomer(getID()).currentlyRented());
            rentHistoryTv.setItems(getKiosk().getCustomer(getID()).rentingHistory());
            feedbackTxt.setText(getKiosk().getCustomer(getID()).toString());
        }
        catch (Exception e) {
            feedbackTxt.setText("Invalid Customer ID.");
        }
    }
    
    @FXML
    private void handleClose(ActionEvent event) {
        stage.close();
    }
}
