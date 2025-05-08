package models;

import genres.Genre;

public class Movie {
    private final String title;
    private final Genre genre;
    private final String description;

    public Movie(String title, Genre genre, String description) {
        this.title = title;
        this.genre = genre;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getHexCode() {
        return genre.getHexColor();
    }

    public String getDescription() {
        return description;
    }
}
