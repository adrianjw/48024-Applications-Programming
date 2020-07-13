import java.util.*;

public class Catalogue {
    private Kiosk kiosk;
    private List<Movie> moviesAvailable;
    private List<Movie> moviesRented;
    private List<Genre> genres;
    
    public Catalogue(Kiosk kiosk) {
        this.kiosk = kiosk;
        Genre sciFi = new Genre("SciFi");
        Genre drama = new Genre("Drama");
        Genre crime = new Genre("Crime");
        moviesAvailable = new ArrayList<Movie>();
        moviesAvailable.add(new Movie("Matrix", 1999, sciFi, 3));
        moviesAvailable.add(new Movie("Jurassic Park", 1993, sciFi, 4));
        moviesAvailable.add(new Movie("Terminator 2", 1991, sciFi, 3));
        moviesAvailable.add(new Movie("Titanic", 1997, drama, 4));
        moviesAvailable.add(new Movie("The Silence of the Lambs", 1991, crime, 3));
        moviesRented = new ArrayList<Movie>();
        genres = new ArrayList<Genre>();
        genres.add(sciFi);
        genres.add(drama);
        genres.add(crime);
    }
    
    public void listAvailableMovies() {
        for (Movie movie: moviesAvailable) {
            System.out.println(movie);
        }
    }
        
    public void listRentedMovies() {
        for (Movie movie: moviesRented) {
            System.out.println(movie);
        }
    }
    
    public void listMoviesByGenre(String genre) {
        for (Movie movie: moviesAvailable) {
            if (movie.hasGenre(genre(genre))) {
                System.out.println(movie);
            }
        }
        for (Movie movie: moviesRented) {
            if (movie.hasGenre(genre(genre))) {
                System.out.println(movie);
            }
        }
    }
    
    public void listMoviesByYear(int year) {
        for (Movie movie: moviesAvailable) {
            if (movie.hasYear(year)) {
                System.out.println(movie);
            }
        }
        for (Movie movie: moviesRented) {
            if (movie.hasYear(year)) {
               System.out.println(movie);
            }
        }
    }
    
    public void listGenres() {
        for (Genre genre: genres) {
            System.out.println(genre);
        }
    }
    
    public void rentMovie(Movie movie) {
        moviesAvailable.remove(movie);
        moviesRented.add(movie);
    }
    
    public void returnMovie (Movie movie) {
        moviesAvailable.add(movie);
        moviesRented.remove(movie);
    }
    
    public void addMovie(String title, int year, String genre, int price) {
        moviesAvailable.add(new Movie(title, year, genre(genre), price));
    }
    
    public void removeMovie(Movie movie) {
        moviesAvailable.remove(movie);
        moviesRented.remove(movie);
    }
    
    public Movie movie(String title) {
        for (Movie movie: moviesAvailable) {
            if (movie.hasType(title)) {
                return movie;
            }
        }
        for (Movie movie: moviesRented) {
            if (movie.hasType(title)) {
                return movie;
            }
        }
        return null;
    }
    
    public Movie movie2(String title, int year) {
        for (Movie movie: moviesAvailable) {
            if (movie.hasType(title) && movie.hasYear(year)) {
                return movie;
            }
        }
        for (Movie movie: moviesRented) {
            if (movie.hasType(title) && movie.hasYear(year)) {
                return movie;
            }
        }
        return null;
    }
    
    public Genre genre(String name) {
        for (Genre genre: genres) {
            if (genre.hasType(name)) {
                return genre;
            }
        }
        return null;
    }
    
    public boolean hasMovie(String title, int year, String genre) {
        for (Movie movie: moviesAvailable) {
            if (movie.hasType(title) && movie.hasYear(year) && movie.hasGenre(genre(genre))) {
                return true;
            }
        }
        for (Movie movie: moviesRented) {
            if (movie.hasType(title) && movie.hasYear(year) && movie.hasGenre(genre(genre))) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isMovieAvailable(Movie movie) {
        return moviesAvailable.contains(movie);
    }
}
