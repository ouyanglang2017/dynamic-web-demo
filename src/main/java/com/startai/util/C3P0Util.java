package com.startai.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class C3P0Util {
    public static void getConn(){
        Map<String,String> map = PropertiesUtil.getPro("c3p0.properties");
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass(map.get("jdbcdriver"));
            comboPooledDataSource.setJdbcUrl(map.get("url"));
            comboPooledDataSource.setUser(map.get("username"));
            comboPooledDataSource.setPassword(map.get("password"));
            comboPooledDataSource.setInitialPoolSize(10);
            Connection connection =comboPooledDataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement("select *from user");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
               int id = rs.getInt("id");
               String username = rs.getString("username");
               String password = rs.getString("password");
               System.out.println(id+","+username+","+password);
            }
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
