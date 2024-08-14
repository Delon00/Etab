package services.impl;

import dao.IUserDao;
import dao.impl.UserDaoImpl;
import models.User;
import services.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao;

    public UserServiceImpl(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(String identifiant, String motDePasse) throws SQLException {
        return userDao.getUser(identifiant, motDePasse);
    }

    @Override
    public User updateUser(String identifiant, String motDePasse) throws SQLException {
        return userDao.updateUser(identifiant, motDePasse);
    }

    @Override
    public void deleteUser(String identifiant, String motDePasse) throws SQLException {
        userDao.deleteUser(identifiant, motDePasse);
    }

    @Override
    public List<User> listeUtilisateur() throws SQLException {
        return userDao.listeUtilisateur();
    }
}
