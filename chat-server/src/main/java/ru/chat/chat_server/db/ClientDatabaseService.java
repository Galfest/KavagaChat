package ru.chat.chat_server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDatabaseService {
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String CONNECTION = "asd";
    public static final String GET_USERNAME = "select username from clients where login = ? and password = ?";

    PreparedStatement getClintStatement;
    PreparedStatement changeNickStatement;
    private static ClientDatabaseService instance;
    private static Connection connection;


    public static void connect() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(CONNECTION);
        System.out.println("Connected to db!");
    }

    public static void disconnect(){
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
