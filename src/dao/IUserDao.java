package dao;

import models.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    public User getUser(String identifiant, String motDePasse) throws SQLException;
    public User updateUser(String identifiant, String motDePasse);
    public void deleteUser(String identifiant, String motDePasse);
    public List<User> listeUtilisateur();

}
