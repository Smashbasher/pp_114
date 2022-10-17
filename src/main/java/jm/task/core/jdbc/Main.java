package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {

        UserService service = new UserServiceImpl(new UserDaoHibernateImpl());

        service.createUsersTable();
        service.saveUser("Jason", "Williams", (byte) 46);
        service.saveUser("Stephen", "Curry", (byte) 34);
        service.saveUser("Lebron", "James", (byte) 37);
        service.saveUser("Shaq", "O'Neal", (byte) 50);
        service.getAllUsers();
    }
}
