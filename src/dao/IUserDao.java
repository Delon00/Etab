package dao;

import models.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    public User getUser(String identifiant, String password) throws SQLException;
    public User updateUser(String identifiant, String password) throws SQLException;
    public void deleteUser(String identifiant, String password) throws SQLException;
    public List<User> listeUtilisateur()throws SQLException;
    void addUser(User newUser)throws SQLException;
}
