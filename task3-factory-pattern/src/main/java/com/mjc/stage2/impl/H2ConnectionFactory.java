package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        try {
            // Load properties from the file
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("h2database.properties");
            props.load(fis);
            // Get connection properties
            String url = props.getProperty("db_url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            // Establish the database connection
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // Write your code here!
}

