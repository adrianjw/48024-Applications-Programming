public class Movie {
    
    private String title;
    private int year;
    private Genre genre;
    private int price;
    
    public Movie(String title, int year, Genre genre, int price) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.price = price;
    }
    
    public void returnMoviePrintln() {
        System.out.println(title + " has been returned.");
    }
    
    public boolean hasType(String title) {
        return this.title.equals(title);
    }
    
    public boolean hasGenre(Genre genre) {
        return this.genre == genre;
    }
    
    public boolean hasYear(int year) {
        return this.year == year;
    }
    
    public int getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return year + "\t" + title + "\t" + genre + "\t$" + price;
    }
}
