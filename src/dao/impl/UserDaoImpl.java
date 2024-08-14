package dao.impl;

import dao.IUserDao;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    private Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User getUser(String identifiant, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE identifiant = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, identifiant);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getInt("id"),
                            resultSet.getString("identifiant"),
                            resultSet.getString("password"),
                            resultSet.getDate("dateCreation")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public User updateUser(String identifiant, String password) throws SQLException {
        String query = "UPDATE users SET password = ? WHERE identifiant = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
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
        String query = "DELETE FROM users WHERE identifiant = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, identifiant);
            statement.setString(2, password);
            statement.executeUpdate();
        }
    }

    @Override
    public List<User> listeUtilisateur() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

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
