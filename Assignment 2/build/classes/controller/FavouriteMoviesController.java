package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.Kiosk;
import model.Movie;

public class FavouriteMoviesController extends Controller<Kiosk> {
    @FXML private TextField idTf;
    @FXML private Button selectCustomerBtn;
    @FXML private Text feedbackTxt;
    @FXML private TableView<Movie> favMovieTv;
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private int getID() {
        return Integer.parseInt(idTf.getText());
    }
    
    @FXML private void initialize() {
        idTf.textProperty().addListener((o, oldID, newID) ->
                selectCustomerBtn.setDisable(!idTf.getText().matches("[0-9]+")));
    }
    
    @FXML
    private void handleSelectCustomer(ActionEvent event) {
        try {
            favMovieTv.setItems(getKiosk().getCustomer(getID()).favouriteMovies());
            feedbackTxt.setText("");
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
