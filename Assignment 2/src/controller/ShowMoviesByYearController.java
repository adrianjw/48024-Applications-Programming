package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import model.Kiosk;
import model.Movie;

public class ShowMoviesByYearController  extends Controller<Kiosk> {
    @FXML private ListView<Integer> yearsLv;
    @FXML private TableView<Movie> moviesTv;
    @FXML private Button displayMoviesBtn;
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private int getSelectedYear() {
        return yearsLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void initialize() {
        yearsLv.getSelectionModel().selectedItemProperty().addListener(
        (o, oldYear, newYear) -> displayMoviesBtn.setDisable(getSelectedYear() == 0));
    }
    
    @FXML
    private void handleDisplayMovies(ActionEvent event) {
        moviesTv.setItems(getKiosk().getCatalogue().getMoviesByYear(getSelectedYear()));
    }
    
    @FXML
    private void handleExit(ActionEvent event) {
        stage.close();
    }
}
