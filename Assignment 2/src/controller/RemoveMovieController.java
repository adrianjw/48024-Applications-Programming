package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import model.Kiosk;
import model.Movie;

public class RemoveMovieController extends Controller<Kiosk> {
    @FXML private TableView<Movie> moviesTv;
    @FXML private Button removeMovieBtn;
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private Movie getSelectedMovie() {
        return moviesTv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void initialize() {
        moviesTv.setItems(getKiosk().getCatalogue().getAllMovies());
        moviesTv.getSelectionModel().selectedItemProperty().addListener(
        (o, oldMovie, newMovie) -> removeMovieBtn.setDisable(getSelectedMovie() == null));
    }
    
    @FXML
    private void handleRemoveMovie(ActionEvent event) {
        getKiosk().getCatalogue().removeMovie(getSelectedMovie());
        moviesTv.setItems(getKiosk().getCatalogue().getAllMovies());
    }
    
    @FXML
    private void handleExit(ActionEvent event) {
        stage.close();
    }
}
