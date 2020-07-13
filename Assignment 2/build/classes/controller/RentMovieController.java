package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.Kiosk;
import model.Movie;

public class RentMovieController extends Controller<Kiosk> {
    @FXML private TextField idTf;
    @FXML private Button selectCustomerBtn;
    @FXML private TableView<Movie> moviesTv;
    @FXML private Button rentMovieBtn;
    @FXML private Text feedbackTxt;
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private int getID() {
        return Integer.parseInt(idTf.getText());
    }
    
    private Movie getSelectedMovie() {
        return moviesTv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void initialize() {
        idTf.textProperty().addListener((o, oldID, newID) ->
                selectCustomerBtn.setDisable(!idTf.getText().matches("[0-9]+")));
        moviesTv.getSelectionModel().selectedItemProperty().addListener(
                (o, oldMovie, newMovie) -> rentMovieBtn.setDisable(getSelectedMovie() == null));
    }
    
    @FXML
    private void handleSelectCustomer(ActionEvent event) {
        if (getKiosk().getCustomer(getID()) != null) {
            moviesTv.setItems(getKiosk().getCatalogue().getAvailableMovies());
            feedbackTxt.setText("");
        }
        else {
            feedbackTxt.setText("Invalid Customer ID.");
        }
    }
    
    @FXML
    private void handleRentMovie(ActionEvent event) {
        try {
            if (getKiosk().getCatalogue().rentMovieToCustomer(
                    getSelectedMovie(), getKiosk().getCustomer(getID()))) {
                feedbackTxt.setText("Movie Rented.");
            }
            else {
                feedbackTxt.setText("Insufficient funds.");
            }
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
