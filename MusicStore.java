import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicStore {
    private List<Song> songLibrary = new ArrayList<>();
    private List<Album> albums = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    
    public void initializeLibrary() {
        songLibrary.add(new Song("Blinding Lights", "The Weeknd", "https://youtu.be/fHI8X4OXluQ"));
        songLibrary.add(new Song("Shape of You", "Ed Sheeran", "https://youtu.be/JGwWNGJdvx8"));
        songLibrary.add(new Song("Levitating", "Dua Lipa", "https://youtu.be/TUVcZfQe-Kw"));
        songLibrary.add(new Song("Perfect", "Ed Sheeran", "https://youtu.be/2Vv-BfVoq4g"));
    }

    
    public void displayHits() {
        System.out.println("\nСписок хитов:");
        for (int i = 0; i < songLibrary.size(); i++) {
            System.out.println((i + 1) + ". " + songLibrary.get(i));
        }
    }

    
    public void searchSong() {
        System.out.print("\nВведите название или исполнителя: ");
        String query = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (Song song : songLibrary) {
            if (song.getTitle().toLowerCase().contains(query) || song.getArtist().toLowerCase().contains(query)) {
                System.out.println(song);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Песни не найдены.");
        }
    }

    public void createAlbum() {
        System.out.print("\nВведите название нового альбома: ");
        String albumName = scanner.nextLine();

        Album album = new Album(albumName);
        while (true) {
            System.out.print("Введите номер песни для добавления (или 'stop' для завершения): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("stop")) break;

            try {
                int songIndex = Integer.parseInt(input) - 1;
                if (songIndex >= 0 && songIndex < songLibrary.size()) {
                    album.addSong(songLibrary.get(songIndex));
                    System.out.println("Песня добавлена!");
                } else {
                    System.out.println("Неверный номер.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число.");
            }
        }

        albums.add(album);
        System.out.println("Альбом '" + albumName + "' создан!");
    }

    
    public void displayAlbums() {
        if (albums.isEmpty()) {
            System.out.println("Альбомов пока нет.");
        } else {
            for (Album album : albums) {
                System.out.println(album);
                for (Song song : album.getSongs()) {
                    System.out.println("  - " + song);
                }
            }
        }
    }

    public void playSong() {
        System.out.print("\nВведите номер песни для воспроизведения: ");
        String input = scanner.nextLine();

        try {
            int songIndex = Integer.parseInt(input) - 1;
            if (songIndex >= 0 && songIndex < songLibrary.size()) {
                Song song = songLibrary.get(songIndex);
                System.out.println("Слушайте на YouTube: " + song.getYoutubeUrl());
            } else {
                System.out.println("Неверный номер.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Введите корректное число.");
        }
    }
}
