package models;

public class MovieResponse {
    private String title;
    private String description;
    private String hexCode;

    public MovieResponse(String title, String description, String hexCode) {
        this.title = title;
        this.description = description;
        this.hexCode = hexCode;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getHexCode() {
        return hexCode;
    }
}
