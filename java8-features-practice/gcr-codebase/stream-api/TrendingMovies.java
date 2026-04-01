package streamapi;

import java.util.*;

import java.util.stream.*;

class Movie {
    String name;
    double rating;
    int year;

    Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }
}


public class TrendingMovies {
    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
            new Movie("Movie A", 8.5, 2022),
            new Movie("Movie B", 9.0, 2023),
            new Movie("Movie C", 8.5, 2024),
            new Movie("Movie D", 9.2, 2021),
            new Movie("Movie E", 7.9, 2023),
            new Movie("Movie F", 9.0, 2024)
        );

        movies.stream()
              .filter(m -> m.getRating() >= 8.0)   // optional filter
              .sorted(
                  Comparator.comparing(Movie::getRating).reversed()
                            .thenComparing(Movie::getYear).reversed()
              )
              .limit(5)
              .forEach(m ->
                  System.out.println(m.getName() + " | Rating: "
                          + m.getRating() + " | Year: " + m.getYear())
              );
    }
}
