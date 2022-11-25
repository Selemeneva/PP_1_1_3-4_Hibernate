package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import java.sql.Connection;

public class Main {
    private static final UserService user = new UserServiceImpl();

    public static void main(String[] args) {
        Connection con = Util.getConnection();
        user.createUsersTable();

        user.saveUser("name1", "lastname1", (byte) 10);
        user.saveUser("name2", "lastname2", (byte) 20);
        user.saveUser("name3", "lastname3", (byte) 30);
        user.saveUser("name4", "lastname4", (byte) 40);
        user.cleanUsersTable();
        user.dropUsersTable();
    }
}



