package dev.jsonmusk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() {

//        String url = System.getenv("POSTGRES_SQL_DB");
//        String username = System.getenv("DB_USERNAME");
//        String password = System.getenv("PASSWORD");

        // for alec becuase i dont use Environment variables

        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=p3";
        //                                         ^ port  ^database               ^ schema
        //Your Postgres username
        String username = "postgres";
        //your Postgres password
        String password = "password";
        try {
            System.out.println(url);
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
