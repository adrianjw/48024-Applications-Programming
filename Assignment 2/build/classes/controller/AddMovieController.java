package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.Kiosk;

public class AddMovieController extends Controller<Kiosk> {
    @FXML private TextField titleTf;
    @FXML private TextField yearTf;
    @FXML private TextField genreTf;
    @FXML private TextField priceTf;
    @FXML private Text feedbackTxt;
    @FXML private Button addMovieBtn;
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private String getTitle() {
        return titleTf.getText();
    }
    
    private int getYear() {
        return Integer.parseInt(yearTf.getText());
    }
    
    private String getGenre() {
        return genreTf.getText();
    }
    
    private int getPrice() {
        return Integer.parseInt(priceTf.getText());
    }
    
    @FXML private void initialize() {
        titleTf.textProperty().addListener((o, oldID, newID) ->
                addMovieBtn.setDisable(getTitle().isEmpty()));
    }
    
    @FXML
    private void handleAddMovie(ActionEvent event) {
        try {
            if (!getKiosk().getCatalogue().hasMovie(getTitle(), getYear())) {
                getKiosk().getCatalogue().addMovie(getTitle(), getYear(), getGenre(), getPrice());
                feedbackTxt.setText("Movie added to Catalogue.");
            }
            else {
                feedbackTxt.setText("Movie already exists.");
            }
        }
        catch (Exception e) {
            feedbackTxt.setText("Invalid input.");
        }
    }
    
    @FXML
    private void handleClose(ActionEvent event) {
        stage.close();
    }
}
