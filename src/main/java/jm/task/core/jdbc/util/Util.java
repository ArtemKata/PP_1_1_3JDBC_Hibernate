package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {

    private static final  String URL = "jdbc:mysql://localhost:3306/BD_Users";
    private static final  String USERNAME = "root";
    private static final  String PASSWORD = "artem1111";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Coeдинение получено");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Не удалось установить соединение с базой данных.", e);
        }
            }
        }
