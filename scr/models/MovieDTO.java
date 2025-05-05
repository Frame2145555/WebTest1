package models;

public class MovieDTO {
    private final String title;
    private final String hexCode;
    private final String description;

    public MovieDTO(String title, String hexCode, String description) {
        this.title = title;
        this.hexCode = hexCode;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getHexCode() {
        return hexCode;
    }

    public String getDescription() {
        return description;
    }
}