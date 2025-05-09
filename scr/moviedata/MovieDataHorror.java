package moviedata;

import java.util.Arrays;
import java.util.List;

import genres.Horror;
import models.Movie;

public class MovieDataHorror extends MovieData {
        private final List<Movie> movies = Arrays.asList(
            new Movie("The Haunting", new Horror(), "A family moves into a haunted mansion and is tormented by spirits."),
            new Movie("Silent Night", new Horror(), "A group of friends celebrate Christmas, unaware of the lurking danger."),
            new Movie("halloween 1978", new Horror(), "ไมเคิล จับแทง ตูดเป็นรู")
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
