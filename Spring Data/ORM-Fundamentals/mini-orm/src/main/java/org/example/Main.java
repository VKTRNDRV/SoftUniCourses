package org.example;

import com.sun.jdi.connect.Connector;
import entities.Student;
import entities.User;
import orm.EntityManager;
import orm.MyConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException {
        MyConnector.createConnection("root", "novaparola", "soft_uni");
        Connection connection = MyConnector.getConnection();

        EntityManager<User> userManager = new EntityManager<>(connection);
        User user = new User("First", 20, LocalDate.now());
        userManager.persists(user);


    }
}