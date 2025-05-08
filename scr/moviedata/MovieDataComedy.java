package moviedata;

import java.util.Arrays;
import java.util.List;

import genres.Comedy;
import models.Movie;

public class MovieDataComedy extends MovieData {
    @Override
    public List<Movie> getMovies() {
        return Arrays.asList(
            new Movie("Laugh Out Loud", new Comedy(), "A stand-up comedian accidentally becomes a politician."),
            new Movie("Banana Trouble", new Comedy(), "Two clumsy friends go on a banana farm adventure.")
        );
    }
}
