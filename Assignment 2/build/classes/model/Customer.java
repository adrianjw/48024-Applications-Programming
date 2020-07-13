package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customer {
    
    private int ID;
    private String name;
    private int balance;
    private ObservableList<Movie> currentlyRented;
    private ObservableList<Movie> rentingHistory;
    
    public Customer(int ID, String name, int balance) {
        this.ID = ID;
        this.name = name;
        this.balance = balance;
        this.currentlyRented = FXCollections.observableArrayList();
        this.rentingHistory = FXCollections.observableArrayList();
    }
    
    public ObservableList<Movie> favouriteMovies() {
        ObservableList<Movie> favourites = FXCollections.observableArrayList();
        if (!rentingHistory.isEmpty()) {
            int[] favouriteCount = new int[rentingHistory.size()];
            for (Movie m : rentingHistory) {
                favouriteCount[rentingHistory.indexOf(m)]++;
            }
            
            int first = max(favouriteCount);
            if (first > -1) {
                favourites.add(this.rentingHistory.get(first));
                favouriteCount[first] = 0;
            }
            
            int second = max(favouriteCount);
            if (second > -1) {
                favourites.add(this.rentingHistory.get(second));
                favouriteCount[second] = 0;
            }
            
            int third = max(favouriteCount);
            if (third > -1) {
                favourites.add(this.rentingHistory.get(third));
            }
        }
        return favourites;
    }
    
    private int max(int[] a) {
        int max = Integer.MIN_VALUE;
        int maxPosition = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 && a[i] > max) {
                max = a[i];
                maxPosition = i;
            }
        }
        return maxPosition;
    }
    
    public void rentMovie(Movie movie) {
        currentlyRented.add(movie);
        rentingHistory.add(movie);
    }
    
    public void returnMovie(Movie movie) {
        if (currentlyRented.contains(movie)) {
            currentlyRented.remove(movie);
        }
    }
    
    public void topUpAccount(int amount) {
        this.balance += amount;
    }
        
    public void deductAmount(int amount) {
        this.balance -= amount;
    }
    
    public boolean hasMovie(Movie movie) {
        return currentlyRented.contains(movie);
    }
    
    public boolean hasMovie(String title) {
        for (Movie m : this.currentlyRented) {
            if (m.titleMatches(title)) {
                return true;
            }
        }
        return false;
    }
    
    public int getId() {
        return this.ID;
    }
    
    public String getName() {
        return this.name;
    }
        
    public int getBalance() {
        return this.balance;
    }
    
    public ObservableList<Movie> currentlyRented() {
        return this.currentlyRented;
    }
    
    public ObservableList<Movie> rentingHistory() {
        return this.rentingHistory;
    }
    
    @Override
    public String toString() {
        return ID + "\t" + name + "\t$ "+ balance;
    }
}
