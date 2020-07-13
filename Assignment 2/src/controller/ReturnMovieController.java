package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.Kiosk;
import model.Movie;

public class ReturnMovieController extends Controller<Kiosk> {
    @FXML private TextField idTf;
    @FXML private Button selectCustomerBtn;
    @FXML private TableView<Movie> moviesTv;
    @FXML private Button returnMovieBtn;
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
                (o, oldMovie, newMovie) -> returnMovieBtn.setDisable(getSelectedMovie() == null));
    }
    
    @FXML
    private void handleSelectCustomer(ActionEvent event) {
        try {
            moviesTv.setItems(getKiosk().getCustomer(getID()).currentlyRented());
            feedbackTxt.setText("");
        }
        catch (Exception e) {
            feedbackTxt.setText("Invalid Customer ID.");
        }
    }
    
    @FXML
    private void handleReturnMovie(ActionEvent event) {
        try {
            getKiosk().getCatalogue().returnMovieFromCustomer(
                    getSelectedMovie(), getKiosk().getCustomer(getID()));
            feedbackTxt.setText("Movie Returned.");
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
