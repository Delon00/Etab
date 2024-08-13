package dao.impl;

import dao.IUserDao;
import models.User;
import dao.singletonDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {

    private static final String QUERY_GET_USER_BY_IDENTIFIANT_AND_PASSWORD = "SELECT * FROM users WHERE identifiant = ? AND password = ?";
    private static final String QUERY_UPDATE_USER = "UPDATE users SET password = ? WHERE identifiant = ?";
    private static final String QUERY_DELETE_USER = "DELETE FROM users WHERE identifiant = ? AND password = ?";
    private static final String QUERY_GET_ALL_USERS = "SELECT * FROM users";

    @Override
    public User getUser(String identifiant, String password) throws SQLException {
        User user = null;
        try (Connection connection = singletonDatabase.getInstance();
             PreparedStatement statement = connection.prepareStatement(QUERY_GET_USER_BY_IDENTIFIANT_AND_PASSWORD)) {

            statement.setString(1, identifiant);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("identifiant"),
                        resultSet.getString("password"),
                        resultSet.getDate("dateCreation")
                );
            }
        }
        return user;
    }

    @Override
    public User updateUser(String identifiant, String password) throws SQLException {
        try (Connection connection = singletonDatabase.getInstance();
             PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE_USER)) {

            statement.setString(1, password);
            statement.setString(2, identifiant);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                return getUser(identifiant, password);
            }
        }
        return null;
    }

    @Override
    public void deleteUser(String identifiant, String password) throws SQLException {
        try (Connection connection = singletonDatabase.getInstance();
             PreparedStatement statement = connection.prepareStatement(QUERY_DELETE_USER)) {

            statement.setString(1, identifiant);
            statement.setString(2, password);
            statement.executeUpdate();
        }
    }

    @Override
    public List<User> listeUtilisateur() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection connection = singletonDatabase.getInstance();
             PreparedStatement statement = connection.prepareStatement(QUERY_GET_ALL_USERS);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("identifiant"),
                        resultSet.getString("password"),
                        resultSet.getDate("dateCreation")
                );
                users.add(user);
            }
        }
        return users;
    }
}
