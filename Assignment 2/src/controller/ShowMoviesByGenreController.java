package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import model.Kiosk;
import model.Genre;
import model.Movie;

public class ShowMoviesByGenreController extends Controller<Kiosk> {
    @FXML private ListView<Genre> genresLv;
    @FXML private TableView<Movie> moviesTv;
    @FXML private Button displayMoviesBtn;
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private Genre getSelectedGenre() {
        return genresLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void initialize() {
        genresLv.getSelectionModel().selectedItemProperty().addListener(
        (o, oldGenre, newGenre) -> displayMoviesBtn.setDisable(getSelectedGenre() == null));
    }
    
    @FXML
    private void handleDisplayMovies(ActionEvent event) {
        moviesTv.setItems(getKiosk().getCatalogue().getMoviesInGenre(getSelectedGenre()));
    }
    
    @FXML
    private void handleExit(ActionEvent event) {
        stage.close();
    }
}
