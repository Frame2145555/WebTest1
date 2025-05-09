package moviedata;

import java.util.Arrays;
import java.util.List;

import genres.Romance;
import models.Movie;

public class MovieDataRomance extends MovieData {
        private final List<Movie> movies = Arrays.asList(
            new Movie("Love in Paris", new Romance(), "Two strangers fall in love during a rainy Parisian night."),
            new Movie("Forever Yours", new Romance(), "High school sweethearts reconnect after 10 years apart.")
        );

    @Override
    public List<Movie> getMovies() {
        return movies;
    }

    public Movie getMovies(String title) {
        return movies.stream()
                .filter(m -> m.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }
}