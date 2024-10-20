
public class Music {
    private String title;
    private String artist;
    private String album;
    private int duration; // in seconds

    public Music(String title, String artist, String album, int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuration() {
        return duration;
    }

    public String toString() {
        return String.format("Title: %s | Artist: %s | Album: %s | Duration: %d sec", title, artist, album, duration);
    }
}
