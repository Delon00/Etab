import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static long startTime;

    public static void main(String[] args) {
        startTime = System.currentTimeMillis();
        User user = new User("admin", "admin");
        User.auth(user);
    }

    public static void menu() {
        while (true) {
            System.out.println("******************************************************");
            System.out.println("********* BIENVENUE DANS L’APPLICATION ETAB 1 ********");
            System.out.println("******************************************************");
            System.out.println("MENU:");
            System.out.println("1: Gestion des élèves");
            System.out.println("2: Gestion des professeurs");
            System.out.println("3: Gestion des utilisateurs");
            System.out.println("0: Quitter");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    Student.menuStudent();
                    break;
                case 2:
                    Prof.menuProf();
                    break;
                case 3:
                    User.userGestion();
                    break;
                case 0:
                    quit();
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    public static void quit() {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        long seconds = (duration / 1000) % 60;
        long minutes = (duration / (1000 * 60)) % 60;
        long hours = (duration / (1000 * 60 * 60)) % 24;
        System.out.println("Merci d'avoir utilisé l'application ETAB. Au revoir!");
        System.out.println("Temps d'utilisation: " + hours + " heures, " + minutes + " minutes, " + seconds + " secondes.");
        scanner.close();
    }
}
