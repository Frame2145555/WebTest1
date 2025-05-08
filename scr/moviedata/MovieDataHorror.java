package moviedata;

import java.util.Arrays;
import java.util.List;

import genres.Horror;
import models.Movie;

public class MovieDataHorror extends MovieData {
    @Override
    public List<Movie> getMovies() {
        return Arrays.asList(
            new Movie("The Haunting", new Horror(), "A family moves into a haunted mansion and is tormented by spirits."),
            new Movie("Silent Night", new Horror(), "A group of friends celebrate Christmas, unaware of the lurking danger.")
        );
    }
}
