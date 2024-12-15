public class Song {
    private String title;
    private String artist;
    private String youtubeUrl;

    public Song(String title, String artist, String youtubeUrl) {
        this.title = title;
        this.artist = artist;
        this.youtubeUrl = youtubeUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    @Override
    public String toString() {
        return "'" + title + "' - " + artist;
    }
}
