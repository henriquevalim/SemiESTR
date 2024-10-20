
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nBem-vindo ao seu Gerenciador de Músicas!");
            System.out.println("1. Próxima música");
            System.out.println("2. Música anterior");
            System.out.println("3. Ordenar playlist");
            System.out.println("4. Tocar música");
            System.out.println("5. Adicionar música");
            System.out.println("6. Remover música");
            System.out.println("7. Listar músicas");
            System.out.println("8. Sair");
            System.out.print("Digite a opção desejada: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (option) {
                case 1:
                    playlist.next();
                    break;
                case 2:
                    playlist.previous();
                    break;
                case 3:
                    // Implementar ordenação
                    System.out.println("Função de ordenação ainda não implementada.");
                    break;
                case 4:
                    playlist.playCurrent();
                    break;
                case 5:
                    System.out.print("Digite o título: ");
                    String title = scanner.nextLine();
                    System.out.print("Digite o artista: ");
                    String artist = scanner.nextLine();
                    System.out.print("Digite o álbum: ");
                    String album = scanner.nextLine();
                    System.out.print("Digite a duração (segundos): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();  // Consumir nova linha

                    System.out.print("Digite 1 para adicionar no início, 2 no fim, ou 3 em uma posição específica: ");
                    int position = scanner.nextInt();
                    scanner.nextLine();  // Consumir nova linha

                    Music newMusic = new Music(title, artist, album, duration);
                    if (position == 1) {
                        playlist.addFirst(newMusic);
                    } else if (position == 2) {
                        playlist.addLast(newMusic);
                    } else {
                        System.out.print("Digite a posição: ");
                        int pos = scanner.nextInt();
                        scanner.nextLine();  // Consumir nova linha
                        playlist.addAt(pos, newMusic);
                    }
                    break;
                case 6:
                    System.out.print("Digite o título da música a ser removida: ");
                    String titleToRemove = scanner.nextLine();
                    playlist.remove(titleToRemove);
                    break;
                case 7:
                    playlist.listAll();
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}
