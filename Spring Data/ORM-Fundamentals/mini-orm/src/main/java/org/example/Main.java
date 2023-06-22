package org.example;

import entities.User;
import orm.EntityManager;
import orm.MyConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args)
            throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        MyConnector.createConnection("root", "novaparola", "soft_uni");
        Connection connection = MyConnector.getConnection();

        EntityManager<User> userManager = new EntityManager<>(connection);
        User user = new User("First", 20, LocalDate.now());
        userManager.persist(user);

        User found = userManager.findFirst(User.class, "age > 10");

        System.out.println(found);
    }
}