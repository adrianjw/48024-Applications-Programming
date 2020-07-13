package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.*;
import javafx.event.*;
import javafx.stage.*;
import model.Kiosk;

public class KioskController extends Controller<Kiosk> {
    public final Kiosk getKiosk() {
        return model;
    }
    
    @FXML
    private void handleViewAdminMenu(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/Admin.fxml", "Administration Menu", new Stage());
    }
    
    @FXML
    private void handleViewCatalogueMenu(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/Catalogue.fxml", "Catalogue", new Stage());
    }
    
    @FXML
    private void handleViewCustomerRecord(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/CustomerRecord.fxml", "Patron Record", new Stage());
    }
    
    @FXML
    private void handleViewTopUpAccount(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/TopUpAccount.fxml", "Account Top-up", new Stage());
    }
    
    @FXML
    private void handleViewFavMovies(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/FavouriteMovies.fxml", "Favourites", new Stage());
    }
    
    @FXML
    private void handleQuit(ActionEvent event) {
        stage.close();
    }
}
