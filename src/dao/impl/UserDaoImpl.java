package dao.impl;

import dao.IUserDao;
import models.User;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements IUserDao {

    @Override
    public User getUser(String identifiant, String motDePasse) throws SQLException {
        return null;
    }

    @Override
    public User updateUser(String identifiant, String motDePasse) {
        return null;
    }

    @Override
    public void deleteUser(String identifiant, String motDePasse) {

    }

    @Override
    public List<User> listeUtilisateur() {
        return List.of();

    }
}
