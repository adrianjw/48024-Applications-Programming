package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.*;
import javafx.event.*;
import javafx.stage.*;
import model.Kiosk;

public class CatalogueController extends Controller<Kiosk> {
    public final Kiosk getKiosk() {
        return model;
    }
    
    @FXML
    private void handleViewAllMovies(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ShowAllMovies.fxml", "All Movies", new Stage());
    }
    
    @FXML
    private void handleViewAvailableMovies(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ShowAvailableMovies.fxml", "Available Movies", new Stage());
    }
    
    @FXML
    private void handleViewMoviesByGenre(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ShowMoviesByGenre.fxml", "Movies by Genre", new Stage());
    }
    
    @FXML
    private void handleViewMoviesByYear(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ShowMoviesByYear.fxml", "Movies by Year", new Stage());
    }
    
    @FXML
    private void handleViewRentMovie(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/RentMovie.fxml", "Rent a Movie", new Stage());
    }
    
    @FXML
    private void handleViewReturnMovie(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ReturnMovie.fxml", "Return a Movie", new Stage());
    }
    
    @FXML
    private void handleExit(ActionEvent event) {
        stage.close();
    }
}
