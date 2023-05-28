package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    private static Connection con = null;
    static
    {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("h2database.properties");
            props.load(fis);
            // Get connection properties
            String url = props.getProperty("db_url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            String jdbc_driver = props.getProperty("jdbc_driver");
            // Establish the database connection
            Class.forName(jdbc_driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
    }
    }

    @Override
    public Connection createConnection() {
        return con;
    }
}

