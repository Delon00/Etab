import java.util.Scanner;

public class Prof {
    static Scanner scanner = new Scanner(System.in);

    public static void menuProf() {
        while (true) {
            System.out.println("1: Ajouter un professeur");
            System.out.println("2: Modifier les informations de l'élève");
            System.out.println("3: Gérer les notes");
            System.out.println("4: Liste des élèves");
            System.out.println("5: Quitter");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    addProf();
                    break;
                case 2:
                    addProf();
                    break;
                case 3:
                    addProf();
                    break;
                case 4:
                    Student.listStudents();
                    break;
                case 5:
                    Main.quit();
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    public static void addProf(){

    }
}
