package com.startai.util;

import java.sql.*;

public class JDBCUtil {
    public static void getConn() {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=GMT&useUnicode=true&characterEncoding=utf8", "root", "root");
            statement = conn.createStatement();
            rs = statement.executeQuery("select * from user");
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("id:" + id + "," + "username:" + username + ",password:" + password);
            }
            conn.close();
            statement.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
