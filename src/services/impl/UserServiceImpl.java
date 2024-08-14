package services.impl;

import dao.IUserDao;
import dao.impl.UserDaoImpl;
import main.Main;
import models.User;
import services.IUserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao = new UserDaoImpl();

    @Override
    public User getUser(String identifiant, String password) throws SQLException {
        return userDao.getUser(identifiant, password);
    }

    @Override
    public User updateUser(String identifiant, String password) throws SQLException {
        return userDao.updateUser(identifiant, password);
    }

    @Override
    public void deleteUser(String identifiant, String password) throws SQLException {
        userDao.deleteUser(identifiant, password);
    }

    @Override
    public List<User> listeUtilisateur() throws SQLException {
        return userDao.listeUtilisateur();
    }

    @Override
    public void gestionUtilisateurMenu() throws SQLException {
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
                    updateUser();
                    break;
                case 4:
                    listUsers();
                    break;
                case 5:
                    return;
                case 0:
                    Main.menu();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private void addUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez l'identifiant de l'utilisateur: ");
        String identifiant = sc.nextLine();
        System.out.print("Entrez le mot de passe: ");
        String password = sc.nextLine();
        User newUser = new User(0, identifiant, password, new java.util.Date());
        try {
            userDao.addUser(newUser);
            System.out.println("Utilisateur ajouté avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'ajout de l'utilisateur.");
        }
    }

    private void delUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez l'identifiant de l'utilisateur à supprimer: ");
        String identifiant = sc.nextLine();
        System.out.print("Entrez le mot de passe de l'utilisateur à supprimer: ");
        String password = sc.nextLine();

        try {
            User user = userDao.getUser(identifiant, password);
            if (user != null) {
                userDao.deleteUser(identifiant, password);
                System.out.println("Utilisateur supprimé avec succès.");
            } else {
                System.out.println("Identifiant ou mot de passe incorrect. Suppression annulée.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la suppression de l'utilisateur.");
        }
    }



    private void updateUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez l'identifiant de l'utilisateur à modifier: ");
        String identifiant = sc.nextLine();
        System.out.print("Entrez le nouveau mot de passe: ");
        String password = sc.nextLine();
        try {
            User updatedUser = userDao.updateUser(identifiant, password);
            if (updatedUser != null) {
                System.out.println("Utilisateur mis à jour avec succès.");
            } else {
                System.out.println("Erreur lors de la mise à jour de l'utilisateur.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la mise à jour de l'utilisateur.");
        }
    }

    private void listUsers() {
        try {
            List<User> users = listeUtilisateur();
            for (User user : users) {
                System.out.println("ID: " + user.getId() + ", Identifiant: " + user.getIdentifiant());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération des utilisateurs.");
        }
    }
}
