package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class User {
    static ArrayList<User> user = new ArrayList<>();
    private int id;
    private String identifiant;
    private String password;
    private Date dateCreation;

    public User(int id, String identifiant, String password, Date dateCreation) {
        this.id = id;
        this.identifiant = identifiant;
        this.password = password;
        this.dateCreation = dateCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public static void auth(User user) {
        Scanner sc = new Scanner(System.in);

        String defaultIdentifiant = "admin";
        String defaultPassword = "admin";

        while (true) {
            System.out.println("******************************************************");
            System.out.println("********* BIENVENUE DANS L’APPLICATION ETAB 1 ********");
            System.out.println("******************************************************");
            System.out.println("CONNEXION:");
            System.out.print("Entrez votre identifiant: ");
            String enteredIdentifiant = sc.nextLine();
            System.out.print("Entrez votre mot de passe:");
            String enteredPassword = sc.nextLine();


            if (defaultIdentifiant.equals(enteredIdentifiant) && defaultPassword.equals(enteredPassword)) {
                System.out.println("Connexion réussie !\n");
                //Main.menu();
                return;
            } else {
                System.out.println("Identifiant ou mot de passe incorrect. Veuillez réessayer.");
            }
        }
    }

    public static void userGestion(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("******************************************************");
            System.out.println("                GESTION DES UTILISATEURS              ");
            System.out.println("******************************************************\n");
            System.out.println("MENU:\n");
            System.out.println("1: Ajouter un utilisateur");
            System.out.println("2: Supprimer un utilisateur");
            System.out.println("3: Modifier les informations d’un utilisateur");
            System.out.println("4: Lister les utilisateurs");
            System.out.println("5: Retour");
            System.out.println("0: Accueil");
            System.out.print("Choisissez une option: ");
            int choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    addUser();
                    break;
                case 2:
                    delUser();
                    break;
                case 3:
                    User.userGestion();
                    break;
                case 4:
                    User.userGestion();
                    break;
                case 5:
                    return;
                case 0:
                    //Main.menu();
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    public static void addUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n");

        int nextId = user.size() + 1;

        Date dateCreation = new Date();

        System.out.println("CREATION DE L'UTILISATEUR AVEC L'ID : " + nextId);
        System.out.println("\n");
        System.out.print("Entrez l'identifiant de l'utilisateur: ");
        String identifiant = sc.nextLine();
        System.out.print("Entrez le mot de passe: ");
        String password = sc.nextLine();

        User newUser = new User(
                nextId,
                identifiant,
                password,
                dateCreation
        );

        user.add(newUser);
        System.out.println("Utilisateur ajouté avec succès !");
    }

    public static void delUser(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez l'identifiant de la personne à supprimer: ");
        int identifiant = sc.nextInt();
        sc.nextLine();

        boolean removed = user.removeIf(personne -> personne.getId() == identifiant);

        if (removed) {System.out.println("Personne supprimée avec succès.");}
        else {System.out.println("Aucune personne trouvée avec cet identifiant.");}
    }
}
