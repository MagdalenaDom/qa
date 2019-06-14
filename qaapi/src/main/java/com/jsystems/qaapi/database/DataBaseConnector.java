package com.jsystems.qaapi.database;

import com.jsystems.qaapi.configuration.ApiConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {

    private static Connection connection = null;

    public static Connection getConnection(){
        if(connection == null) initConnection();
        return connection;
    }

    private static void initConnection() {
        try {
            Class.forName((ApiConfig.DB_CLASS));
            String url = ApiConfig.DB_URL;
            String user = ApiConfig.DB_USER;
            String pass = ApiConfig.DB_PASSWORD;
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
