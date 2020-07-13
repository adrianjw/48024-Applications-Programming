package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.*;
import javafx.event.*;
import javafx.stage.*;
import model.Kiosk;

public class AdminController extends Controller<Kiosk> {
    public final Kiosk getKiosk() {
        return model;
    }
    
    @FXML
    private void handleViewAllCustomers(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ShowAllCustomers.fxml", "Show All Customers", new Stage());
    }
    
    @FXML
    private void handleViewAllMovies(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ShowAllMovies.fxml", "Show All Movies", new Stage());
    }
    
    @FXML
    private void handleViewAddCustomer(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/AddCustomer.fxml", "Add Customer", new Stage());
    }
    
    @FXML
    private void handleViewAddMovie(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/AddMovie.fxml", "Add Movie", new Stage());
    }
    
    @FXML
    private void handleViewRemoveCustomer(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/RemoveCustomer.fxml", "Remove Customer", new Stage());
    }
    
    @FXML
    private void handleViewRemoveMovie(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/RemoveMovie.fxml", "Remove Movie", new Stage());
    }
    
    @FXML
    private void handleExit(ActionEvent event) {
        stage.close();
    }
}
