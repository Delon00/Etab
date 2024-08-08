import java.util.Scanner;
import java.util.UUID;

public class User {
    private String id;
    private String identifiant;
    private String password;


    public User(String identifiant, String password) {
        this.id = UUID.randomUUID().toString(); // Generate UUID in the constructor
        this.identifiant = identifiant;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", identifiant='" + identifiant + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void auth(User user) {
        Scanner scanner = new Scanner(System.in);

        String defaultIdentifiant = "admin";
        String defaultPassword = "admin";

        while (true) {
            System.out.println("******************************************************");
            System.out.println("********* BIENVENUE DANS L’APPLICATION ETAB 1 ********");
            System.out.println("******************************************************");
            System.out.println("CONNEXION:");
            System.out.print("Entrez votre identifiant: ");
            String enteredIdentifiant = scanner.nextLine();
            System.out.print("Entrez votre mot de passe: ");
            String enteredPassword = scanner.nextLine();


            if (defaultIdentifiant.equals(enteredIdentifiant) && defaultPassword.equals(enteredPassword)) {
                System.out.println("Connexion réussie !");
                scanner.close();
                Main.menu();
                return;
            } else {
                System.out.println("Identifiant ou mot de passe incorrect. Veuillez réessayer.");
            }
        }
    }

    public static void userGestion(){

    }
}
