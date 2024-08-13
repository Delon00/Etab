
import dao.singletonDatabase;
import models.Prof;
import models.Student;
import models.User;

import java.util.Date;
import java.util.Scanner;

/**
 * La classe principale de l'application ETAB.
 *
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static long startTime;

    /**
     * Méthode principale de l'application.
     * Initialise l'application avec un utilisateur par défaut et lance le menu principal.
     *
     * @param args Les arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Date dateCreation = new Date(2024 - 1900, 7, 11);
        User user = new User(1, "admin", "admin", dateCreation);
        User.auth(user);
    }

    /**
     * Affiche le menu principal et gère les différentes options sélectionnées par l'utilisateur.
     * Permet la gestion des élèves, des professeurs, et des utilisateurs.
     */
    public static void menu() {
        singletonDatabase.getConnection();
        while (true) {
            System.out.println("******************************************************");
            System.out.println("******** BIENVENUE DANS L’APPLICATION ETAB 1.2 *******");
            System.out.println("******************************************************\n");
            System.out.println("MENU:\n");
            System.out.println("1: Gestion des élèves");
            System.out.println("2: Gestion des professeurs");
            System.out.println("3: Gestion des utilisateurs");
            System.out.println("0: Quitter");
            System.out.print("Choisissez une option: ");
            int choix = sc.nextInt();
            sc.nextLine();

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

    /**
     * Quitte l'application en affichant le temps total d'utilisation.
     * Le temps d'utilisation est calculé à partir de l'heure de début de l'exécution.
     */
    public static void quit() {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        long seconds = (duration / 1000) % 60;
        long minutes = (duration / (1000 * 60)) % 60;
        long hours = (duration / (1000 * 60 * 60)) % 24;
        System.out.println("Merci d'avoir utilisé l'application ETAB. Au revoir!");
        System.out.println("Temps d'utilisation: " + hours + " heures, " + minutes + " minutes, " + seconds + " secondes.");
    }
}
