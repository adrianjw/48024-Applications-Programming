import java.util.*;

public class Kiosk {
    private Catalogue catalogue;
    private List<Customer> customers;
    
    public Kiosk() {
        catalogue = new Catalogue(this);
        customers = new ArrayList<Customer>();
        customers.add(new Customer(101, "Jaime", 10));
        customers.add(new Customer(102, "Luke", 10));
        customers.add(new Customer(103, "William", 1));
    }
    
    public static void main(String[] args) {
        new Kiosk().use();
    }
    
    public void use() {
        char choice;
        while ((choice = readMainMenuChoice()) != 'X') {
            switch (choice) {
                case '1': exploreCatalogue(); break;
                case '2': viewRecord(); break;
                case '3': showFavouriteMovies(); break;
                case '4': topUpAccount(); break;
                case '5': adminMode(); break;
                default: System.out.println("Please enter a number between"
                        + "1 and 5, or press X to exit."); break;
            }
        }
    }
    
    private void exploreCatalogue() {
        char choice;
        while ((choice = readCatalogueMenuChoice()) != 'R') {
            switch (choice) {
                case '1': displayAllMovies(); break;
                case '2': displayAvailableMovies(); break;
                case '3': displayGenres(); break;
                case '4': displayMoviesByGenre(); break;
                case '5': displayMoviesByYear(); break;
                case '6': rentMovie(); break;
                case '7': returnMovie(); break;
                default: System.out.println("Please enter a number between"
                        + "1 and 7 or press R to return to the previous menu."); break;
            }
        }
    }
    
    private void adminMode() {
        char choice;
        while ((choice = readAdminMenuChoice()) != 'R') {
            switch (choice) {
                case '1': listCustomers(); break;
                case '2': addCustomer(); break;
                case '3': removeCustomer(); break;
                case '4': displayAllMovies(); break;
                case '5': addMovie(); break;
                case '6': removeMovie(); break;
                default: System.out.println("Please enter a number between"
                        + "1 and 6 or press R to return to the previous menu."); break;
            }
        }
    }
    
    private char readMainMenuChoice() {
        System.out.println("Welcome to the Movie Kiosk! Please make a selection from the menu:");
        System.out.println("1. Explore the catalogue.");
        System.out.println("2. View your customer record.");
        System.out.println("3. Show you favourite movies.");
        System.out.println("4. Top up account.");
        System.out.println("5. Enter Admin Mode.");
        System.out.println("X. Exit the system.");
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }
    
    private char readCatalogueMenuChoice() {
        System.out.println("Welcome to the Catalogue! Please make a selection from the menu:");
        System.out.println("1. Display all movies.");
        System.out.println("2. Display all available movies.");
        System.out.println("3. Display all genres.");
        System.out.println("4. Display movies in a genre.");
        System.out.println("5. Display all movies by year.");
        System.out.println("6. Rent a movie.");
        System.out.println("7. Return a movie.");
        System.out.println("R. Return to previous menu.");
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }
            
    private char readAdminMenuChoice() {
        System.out.println("Welcome to the administration menu:");
        System.out.println("1. List all customers.");
        System.out.println("2. Add a customer.");
        System.out.println("3. Remove a customer.");
        System.out.println("4. List all movies.");
        System.out.println("5. Add a movie to the catalogue.");
        System.out.println("6. Remove a movie from the catalogue.");
        System.out.println("R. Return to the previous menu.");
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }
    
    private int readCustomerID() {
        System.out.print("Enter a customer ID: ");
        return In.nextInt();
    }
    
    private int readNewCustomerID() {
        System.out.print("Enter a new ID: ");
        return In.nextInt();
    }
    
    private int readValidCustomerID() {
        System.out.print("Enter a valid customer ID: ");
        return In.nextInt();
    }
    
    private String readCustomerName() {
        System.out.print("Enter the customer's name: ");
        return In.nextLine();
    }
    
    private int readCustomerBalance() {
        System.out.print("Enter the customer's initial balance: ");
        return In.nextInt();
    }
    
    private String readMovieTitle() {
        System.out.print("Enter the title of the movie: ");
        return In.nextLine();
    }
    
    private int readMovieYear() {
        System.out.print("Enter the year: ");
        return In.nextInt();
    }
    
    private String readMovieGenre() {
        System.out.print("Enter the genre: ");
        return In.nextLine();
    }
    
    private String readAMovieGenre() {
        System.out.print("Enter a genre: ");
        return In.nextLine();
    }
    
    private int readMoviePrice() {
        System.out.print("Enter price: ");
        return In.nextInt();
    }
    
    private String readRentMovie() {
        System.out.print("Enter the title of the movie you wish to rent: ");
        return In.nextLine();
    }
    
    private String readReturnMovie() {
        System.out.print("Enter the title of the movie you wish to return: ");
        return In.nextLine();
    }
    
    private int readTopUpAmount() {
        System.out.print("Enter the top-up amount:");
        return In.nextInt();
    }
    
    private void viewRecord() {
        System.out.println();
        Customer customer = customer(readCustomerID());
        if (customer != null) {
            customer.viewRecord();
        }
        else {
            System.out.println("That customer does not exist.");
        }
        System.out.println();
    }
    
    private void showFavouriteMovies() {
        System.out.println();
        Customer customer = customer(readCustomerID());
        if (customer != null) {
            customer.showFavouriteMovies();
        }
        else {
            System.out.println("That customer does not exist.");
        }
        System.out.println();
    }
    
    private void topUpAccount() {
        System.out.println();
        Customer customer = customer(readCustomerID());
        if (customer != null) {
            int amount = readTopUpAmount();
            System.out.println();
            System.out.println("Transaction complete.");
            customer.topUpAccount(amount);
        }
        else {
            System.out.println("That customer does not exist.");
        }
        System.out.println();
    }
    
    private void displayAllMovies() {
        System.out.println();
        System.out.println("The Kiosk has the following movies:");
        catalogue.listAvailableMovies();
        catalogue.listRentedMovies();
        System.out.println();
    }
    
    private void displayAvailableMovies() {
        System.out.println();
        System.out.println("The following movies are available:");
        catalogue.listAvailableMovies();
        System.out.println();
    }
    
    private void displayGenres() {
        System.out.println();
        System.out.println("The Kiosk has movies in the following genres:");
        catalogue.listGenres();
        System.out.println();
    }
    
    private void displayMoviesByGenre() {
        System.out.println();
        String genre = readAMovieGenre();
        System.out.println("The kiosk has the following movies in that genre:");
        catalogue.listMoviesByGenre(genre);
        System.out.println();
    }
    
    private void displayMoviesByYear() {
        System.out.println();
        int year = readMovieYear();
        System.out.println("The kiosk has the following movies by that year:");
        catalogue.listMoviesByYear(year);
        System.out.println();
    }
    
    private void rentMovie() {
        System.out.println();
        Customer customer = customer(readValidCustomerID());
        if (customer != null) {
            Movie movie = catalogue.movie(readRentMovie());
            if (movie != null && catalogue.isMovieAvailable(movie)) {
                int price = movie.getPrice();
                if (customer.getBalance() >= price) {
                    System.out.println("Movie rented.");
                    customer.rentMovie(movie, price);
                    catalogue.rentMovie(movie);
                }
                else {
                    System.out.println("You don't have sufficient funds to rent this movie.");
                }
            }
            else {
                System.out.println("That movie is not available or doesn't exist.");
            }
        }
        else {
            System.out.println("That customer does not exist.");
        }
        System.out.println();
    }
    
    private void returnMovie() {
        System.out.println();
        Customer customer = customer(readValidCustomerID());
        if (customer != null) {
            customer.returnMoviePrintln();
            customer.listCurrentlyRentedMovies();
            Movie movie = catalogue.movie(readReturnMovie());
            if (movie != null) {
                movie.returnMoviePrintln();
                customer.returnMovie(movie);
                catalogue.returnMovie(movie);
            }
            else {
                System.out.println("No such movie found.");
            }
        }
        else {
            System.out.println("That customer does not exist.");
        }
        System.out.println();
    }
    
    private void listCustomers() {
        System.out.println();
        System.out.println("The Kiosk has the following customers:");
        for (Customer customer: customers) {
            System.out.println(customer);
        }
        System.out.println();
    }
    
    private void addCustomer() {
        System.out.println();
        System.out.println("Adding a new customer.");
        customers.add(new Customer(readNewCustomerID(), readCustomerName(), readCustomerBalance()));
        System.out.println("Customer added.");
        System.out.println();
    }
    
    private void removeCustomer() {
        System.out.println();
        System.out.println("Removing a customer.");
        Customer customer = customer(readCustomerID());
        if (customer != null) {
            System.out.println("Customer removed.");
            customers.remove(customer);
        }
        else {
            System.out.println("That customer does not exist.");
        }
        System.out.println();
    }
    
    private void addMovie() {
        System.out.println();
        System.out.println("Adding a new movie.");
        String title = readMovieTitle();
        int year = readMovieYear();
        String genre = readMovieGenre();
        int price = readMoviePrice();
        if (catalogue.hasMovie(title, year, genre)) {
            System.out.println("The movie is already in the catalogue.");
        }
        else {
            catalogue.addMovie(title, year, genre, price);
        }
    }
    
    private void removeMovie() {
        System.out.println();
        System.out.println("Removing a movie.");
        String title = readMovieTitle();
        int year = readMovieYear();
        Movie movie = catalogue.movie2(title, year);
        if (movie != null) {
            System.out.println(movie + " removed from catalogue.");
            catalogue.removeMovie(movie);
        }
        else {
            System.out.println("No such movie found.");
        }
        System.out.println();
    }
    
    private Customer customer(int ID) {
        for (Customer customer: customers) {
            if (customer.hasType(ID)) {
                return customer;
            }
        }
        return null;
    }
}
