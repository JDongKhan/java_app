package com.jd.app.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class PathUtils {

    public static volatile String baseDataPath = null;

    public static  String readDataPath(HttpServletRequest request, String fileName) {
        if (baseDataPath == null) {
            synchronized (PathUtils.class) {
                if (baseDataPath == null) {
                    baseDataPath = request.getServletContext().getRealPath("/");
                    String configRealPath = PathUtils.readPropertiesValueForKey(request, "configPath");
                    if (configRealPath != null && configRealPath.length() != 0) {
                        baseDataPath = configRealPath;
                    } else {
                        String parentpath = new File(baseDataPath).getParent();
                        String configPath = parentpath + "/CocoaPods/";
                        File cocoapodsFile = new File(configPath);
                        if (cocoapodsFile.exists()) {
                            baseDataPath = configPath;
                        }
                    }
                }
            }
        }
        String basePath = baseDataPath;
        String filePath = basePath + fileName + ".json";
        return filePath;
    }

    public static String readPropertiesValueForKey(HttpServletRequest request,String key) {
        String basePath = PathUtils.class.getClassLoader().getResource("/").getPath();
        Properties p = readProperties(basePath + "/" + "properties","config");
        return p.getProperty(key,"");
    }

    private static Properties readProperties(String basePath,String name) {
        String path = basePath + "/" + name + ".properties";
        try {
            Properties properties = new Properties();
            // 使用InPutStream流读取properties文件
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            properties.load(bufferedReader);
            return properties;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static String podfileLogPath(HttpServletRequest request) {
        String basePath = request.getServletContext().getRealPath("/");
        String logPath = basePath + "/" + "podfile.log";
        return logPath;
    }
}
