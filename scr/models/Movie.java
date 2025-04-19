package models;

import genres.Genre;

public class Movie {
    private final String title;
    private final Genre genre;

    public Movie(String title, Genre genre) {
        this.title = title;
        this.genre = genre;
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
}
