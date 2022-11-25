package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDaoJDBCImpl usedDaoJDBCImpl = new UserDaoJDBCImpl();

    public void createUsersTable() {
        usedDaoJDBCImpl.createUsersTable();
    }

    public void dropUsersTable() {
        usedDaoJDBCImpl.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        usedDaoJDBCImpl.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        usedDaoJDBCImpl.removeUserById(id);
    }

    public List<User> getAllUsers() {
       return usedDaoJDBCImpl.getAllUsers();
    }

    public void cleanUsersTable() {
        usedDaoJDBCImpl.cleanUsersTable();
    }
}
