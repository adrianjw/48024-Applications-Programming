package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import model.Kiosk;

public class ShowAllCustomersController extends Controller<Kiosk> {
    public final Kiosk getKiosk() {
        return model;
    }
    
    @FXML
    private void handleExit(ActionEvent event) {
        stage.close();
    }
}
