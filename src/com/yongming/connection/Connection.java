package com.yongming.connection;

import java.sql.DriverManager;

/**
 * Created by jiangyongming on 4/5/16.
 */
public class Connection {
    public java.sql.Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/poetry?useUnicode=true&characterEncoding=utf-8";
            String user = "root";
            String password = "";
            java.sql.Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
