package moviedata;

import java.util.List;

import models.Movie;

public abstract class MovieData {
    
    public abstract List<Movie> getMovies();

    public abstract Movie getMovies(String title);
}

