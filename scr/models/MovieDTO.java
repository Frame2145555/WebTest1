package models;

public class MovieDTO {
    private final String title;
    private final String hexCode;

    public MovieDTO(String title, String hexCode) {
        this.title = title;
        this.hexCode = hexCode;
    }

    public String getTitle() {
        return title;
    }

    public String getHexCode() {
        return hexCode;
    }
}