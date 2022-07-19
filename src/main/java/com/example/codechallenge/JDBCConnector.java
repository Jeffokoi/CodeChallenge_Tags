package com.example.codechallenge;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {


//    private static final String JDBC_LOADER = "com.mysql.jdbc.Driver";
//    private static final String URL = "jdbc:mysql://localhost:3306/thewealt_wealthmarketdb";
//    private static final String LOGIN = "root";
//    private static final String PASSWORD = "root";


        //for the write app.
//    private static final String JDBC_LOADER = "com.mysql.jdbc.Driver";
//    private static final String URL = "jdbc:mysql://localhost:3306/thewealt_wealthmarketdb";
//    private static final String LOGIN = "thewealt_WMUser1";
//    private static final String PASSWORD = "@thewealthmarket123";


        ////
        private static final String JDBC_LOADER = "com.mysql.jdbc.Driver";
        private static final String URL = "jdbc:mysql://localhost:3306/thewealt_wealthmarketdb?characterEncoding=latin1";
        private static final String LOGIN = "root";
        private static final String PASSWORD = "Favour2021";
        //
        private Connection connection;

        public JDBCConnector() throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
            Class.forName(JDBC_LOADER);
            this.connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        }

        public Connection getConnection() throws SQLException {
            return this.connection;
        }
    }

