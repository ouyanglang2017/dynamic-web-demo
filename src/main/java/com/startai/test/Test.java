package com.startai.test;

import com.startai.util.JDBCUtil;
import com.startai.util.PropertiesUtil;

import java.util.Map;

public class Test {
    public static void main(String[]args){
        //JDBCUtil.getConn();
        Map<String, String> map = PropertiesUtil.getPro("c3p0.properties");
        String username = map.get("username");
        System.out.println(username);
    }
}
