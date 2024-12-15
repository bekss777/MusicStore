import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicStore musicStore = new MusicStore();
        musicStore.initializeLibrary(); // Добавляем 20 песен в библиотеку

        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в музыкальный магазин!");

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Показать все хиты");
            System.out.println("2. Найти песню");
            System.out.println("3. Создать альбом");
            System.out.println("4. Показать альбомы");
            System.out.println("5. Воспроизвести песню");
            System.out.println("6. Выйти");

            System.out.print("Ваш выбор: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> musicStore.displayHits();
                case "2" -> musicStore.searchSong();
                case "3" -> musicStore.createAlbum();
                case "4" -> musicStore.displayAlbums();
                case "5" -> musicStore.playSong();
                case "6" -> {
                    System.out.println("До свидания!");
                    return;
                }
                default -> System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }
}
