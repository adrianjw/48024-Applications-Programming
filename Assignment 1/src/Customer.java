import java.util.*;

public class Customer {
    
    private int ID;
    private String name;
    private int balance;
    private List<Movie> currentlyRented;
    private List<Movie> rentingHistory;
    
    public Customer(int ID, String name, int balance) {
        this.ID = ID;
        this.name = name;
        this.balance = balance;
        currentlyRented = new ArrayList<Movie>();
        rentingHistory = new ArrayList<Movie>();
    }
    
    public void viewRecord() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Balance: $" + balance);
        System.out.println("Movies currently rented by " + name + ":");
        listCurrentlyRentedMovies();
        System.out.println(name + "'s renting history:");
        listRentingHistory();
    }
    
    public void showFavouriteMovies() {
        System.out.println(name + "'s favourite movies are:");
        if (!rentingHistory.isEmpty()) {
            /**
             * Part 1: create 2 array lists, remove duplicates, count rental frequency
             * 
             * uniqueRentalHistory list contains the unique movies from the
             * rentingHistory list (i.e. remove duplicates).
             * rentalFreq list contains the frequency of each unique movie in
             * the rentingHistory list.
             */
            ArrayList<Movie> uniqueRentalHistory = new ArrayList<Movie>();
            ArrayList<Integer> rentalFreq = new ArrayList<Integer>();
            for (Movie movie: rentingHistory) {
                if (!uniqueRentalHistory.contains(movie)) {
                    uniqueRentalHistory.add(movie);
                }
            }
            for (Movie movie: uniqueRentalHistory) {
                rentalFreq.add(Collections.frequency(rentingHistory, movie));
            }
            /**
             * Part 2: extract the top 3 frequencies from the rentalFreq list
             * 
             * Selection sort the frequencies in the rentalFreq list and stores the
             * top 3 frequencies into their corresponding variables.
             */
            int highestFreq = 0;
            int secondHighestFreq = 0;
            int thirdHighestFreq = 0;
            for (int i: rentalFreq) {
                if (i >= highestFreq) {
                    thirdHighestFreq = secondHighestFreq;
                    secondHighestFreq = highestFreq;
                    highestFreq = i;
                }
                else if (i >= secondHighestFreq) {
                    thirdHighestFreq = secondHighestFreq;
                    secondHighestFreq = i;
                }
                else if (i >= thirdHighestFreq) {
                    thirdHighestFreq = i;
                }
            }
            /**
             * Part 3: print the appropriate list of movies for the given conditions
             */
            System.out.println(uniqueRentalHistory.get(rentalFreq.indexOf(highestFreq)));
            if (uniqueRentalHistory.size() == 2) {
                if (highestFreq == secondHighestFreq) {
                    System.out.println(uniqueRentalHistory.get(indexOfAll(rentalFreq, highestFreq).get(1)));
                }
                else {
                    System.out.println(uniqueRentalHistory.get(rentalFreq.indexOf(secondHighestFreq)));
                }
            }
            else if (uniqueRentalHistory.size() >= 3) {
                if ((highestFreq == secondHighestFreq) && (highestFreq == thirdHighestFreq)) {
                   System.out.println(uniqueRentalHistory.get(indexOfAll(rentalFreq, highestFreq).get(1)));
                   System.out.println(uniqueRentalHistory.get(indexOfAll(rentalFreq, highestFreq).get(2)));
                }
                else if (highestFreq == secondHighestFreq) {
                    System.out.println(uniqueRentalHistory.get(indexOfAll(rentalFreq, highestFreq).get(1)));
                    System.out.println(uniqueRentalHistory.get(rentalFreq.indexOf(thirdHighestFreq)));
                }
                else if (secondHighestFreq == thirdHighestFreq) {
                    System.out.println(uniqueRentalHistory.get(rentalFreq.indexOf(secondHighestFreq)));
                    System.out.println(uniqueRentalHistory.get(indexOfAll(rentalFreq, secondHighestFreq).get(1)));
                }
                else {
                    System.out.println(uniqueRentalHistory.get(rentalFreq.indexOf(secondHighestFreq)));
                    System.out.println(uniqueRentalHistory.get(rentalFreq.indexOf(thirdHighestFreq)));
                }
            }
        }
    }
    
    public void topUpAccount(int amount) {
        System.out.println(name + "'s balance was: $" + balance);
        balance += amount;
        System.out.println(name + "'s current balance is: $" + balance);
    }
    
    public void listCurrentlyRentedMovies() {
        for (Movie movie: currentlyRented) {
            System.out.println(movie);
        }
    }
    
    public void listRentingHistory() {
        for (Movie movie: rentingHistory) {
            System.out.println(movie);
        }
    }
    
    public void rentMovie(Movie movie, int price) {
        currentlyRented.add(movie);
        rentingHistory.add(movie);
        balance -= price;
    }
    
    public void returnMovie(Movie movie) {
        currentlyRented.remove(movie);
    }
    
    public void returnMoviePrintln() {
        System.out.println(name + " has the following movies:");
        System.out.println("Movies currently rented by " + name + ":");
    }
    
    public boolean hasType(int ID) {
        return this.ID == ID;
    }
    
    public int getBalance() {
        return balance;
    }
    
    @Override
    public String toString() {
        return ID + "\t" + name + "\t$ " + balance;
    }
    
    private ArrayList<Integer> indexOfAll(ArrayList<Integer> rentalFreq, int freq) {
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        for (int i = 0; i < rentalFreq.size(); i++) {
            if (rentalFreq.get(i) == freq) {
                indexList.add(i);
            }
        }
        return indexList;
    }
}
