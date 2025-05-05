package moviedata;

import java.util.Arrays;
import java.util.List;

import genres.Action;
import models.Movie;

public class MovieDataAction extends MovieData {
    @Override
    public List<Movie> getMovies() {
        return Arrays.asList(
            new Movie("Final Strike", new Action(), "An elite agent must stop a global terrorist threat."),
            new Movie("Road Fury", new Action(), "A renegade driver takes on the underworld in a high-speed war.")
        );
    }
}
