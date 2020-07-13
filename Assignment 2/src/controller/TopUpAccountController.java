package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.Kiosk;

public class TopUpAccountController extends Controller<Kiosk> {
    @FXML private Text feedbackTxt;
    @FXML private TextField idTf;
    @FXML private TextField amountTf;
    @FXML private Button topUpBtn;
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private int getID() {
        return Integer.parseInt(idTf.getText());
    }
    
    private int getAmount() {
        return Integer.parseInt(amountTf.getText());
    }
    
    @FXML private void initialize() {
        idTf.textProperty().addListener((o, oldID, newID) ->
                topUpBtn.setDisable(!idTf.getText().matches("[0-9]+")));
    }
    
    @FXML
    private void handleTopUp(ActionEvent event) {
        try {
            getKiosk().topUpAccount(getKiosk().getCustomer(getID()), getAmount());
            feedbackTxt.setText("Transaction Complete.");
        }
        catch (NullPointerException e) {
            feedbackTxt.setText("Invalid Customer ID.");
        }
        catch (NumberFormatException e) {
            feedbackTxt.setText("Invalid Amount.");
        }
    }
    
    @FXML
    private void handleClose(ActionEvent event) {
        stage.close();
    }
}
