package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Ghjcnjnfr_11";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed");
        }
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static SessionFactory getFactory() {
        SessionFactory sessionFactory = null;
        try {
            Properties prop = new Properties();
            prop.setProperty("hibernate.connection.url", DB_URL);
            prop.setProperty("hibernate.connection.username", DB_USERNAME);
            prop.setProperty("hibernate.connection.password", DB_PASSWORD);
            prop.setProperty("dialect", "org.hibernate.dialect.MySQL5Dialect");
            sessionFactory = new Configuration()
                    .setProperties(prop)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("Connection failed");
        }
        return sessionFactory;
    }
}
