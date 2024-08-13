package services.impl;

import models.User;
import services.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements IUserService {



    @Override
    public User getUser(String identifiant, String password) throws SQLException {
        return null;
    }

    @Override
    public User updateUser(String identifiant, String password) {
        return null;
    }

    @Override
    public void deleteUser(String identifiant, String password) {

    }

    @Override
    public List<User> listeUtilisateur() {
        return List.of();
    }
}
