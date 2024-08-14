package services;

import models.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    User getUser(String identifiant, String password) throws SQLException;
    User updateUser(String identifiant, String password)throws SQLException;
    void deleteUser(String identifiant, String password)throws SQLException;
    List<User> listeUtilisateur()throws SQLException;
    void gestionUtilisateurMenu()throws SQLException;
}

