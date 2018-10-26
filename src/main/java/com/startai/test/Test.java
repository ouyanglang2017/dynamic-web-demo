package com.startai.test;

import com.startai.util.C3P0Util;
import com.startai.util.JDBCUtil;
import com.startai.util.PropertiesUtil;

import java.util.Map;

public class Test {
    public static void main(String[]args){
        C3P0Util.getConn();
    }
}
