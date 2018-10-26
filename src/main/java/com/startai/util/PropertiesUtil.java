package com.startai.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {
    public static Map<String, String> getPro(String path) {
        Map<String, String> map = new HashMap<String, String>();
        Properties prop = new Properties();
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(path);
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Enumeration<?> enumeration = prop.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = (String) enumeration.nextElement();
            System.out.println(key);
            String value = prop.getProperty(key);
            System.out.println(value);
            map.put(key,value);
        }
        return map;
    }
}

