package services;

import models.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    User getUser(String identifiant, String motDePasse) throws SQLException;
    User updateUser(String identifiant, String motDePasse);
    void deleteUser(String identifiant, String motDePasse);
    List<User> listeUtilisateur();
}
