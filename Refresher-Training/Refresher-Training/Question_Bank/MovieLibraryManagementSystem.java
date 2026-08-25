// Movie Library Management System
import java.util.*;

class Movie {

    int id;
    String name;

    Movie(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}

class MovieLibrary {

    ArrayList<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(int id) {
        movies.removeIf(movie -> movie.id == id);
    }

    public ArrayList<Movie> getAllMovie() {
        return movies;
    }
}

public class MovieLibraryManagementSystem {

    public static void main(String[] args) {

        MovieLibrary library = new MovieLibrary();

        library.addMovie(new Movie(1, "Avengers"));
        library.addMovie(new Movie(2, "Inception"));
        library.addMovie(new Movie(3, "Interstellar"));

        System.out.println(library.getAllMovie());

        library.removeMovie(2);

        System.out.println(library.getAllMovie());
    }
}