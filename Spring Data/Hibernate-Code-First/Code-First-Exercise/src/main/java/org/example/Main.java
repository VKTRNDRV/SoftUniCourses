package org.example;

import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Persistence.createEntityManagerFactory("test")
                .createEntityManager();
    }
}