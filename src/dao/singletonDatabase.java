package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class singletonDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/etab_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    // Constructeur privé pour empêcher l'instanciation
    private singletonDatabase() {}

    public static Connection getInstance() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connexion à la base de données réussie !");
            } catch (ClassNotFoundException e) {
                System.out.println("Driver MySQL non trouvé.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Erreur de connexion à la base de données.");
                e.printStackTrace();
                throw new SQLException("Erreur de connexion à la base de données", e);
            }
        }
        return connection;
    }

    public static void getConnection() {
    }
}
