package com.jd.app.utils;


import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

public class JsonUtils {

    // 方法二
    public static JSONObject readJsonObject(HttpServletRequest request) {
        try {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String str = "";
            String wholeStr = "";
            while((str = reader.readLine()) != null){//一行一行的读取body体里面的内容；
                wholeStr += str;
            }
            return (JSONObject) JSONObject.toJSON(wholeStr);//转化成json对象
        } catch (Exception e) {
        }
        return null;
    }

    public static JSONObject readJSONObjectFromFile(HttpServletRequest request) {
        String fileName = request.getParameter("fileName");
        String filePath = PathUtils.readDataPath(request,fileName);
        return readJsonFromPath(filePath);
    }

    public static String readFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("文件[" + path +"]不存在！");
            return null;
        }
        BufferedReader reader = null;
        String laststr = "";
        try {
            // System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号

                laststr = laststr + tempString;
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return laststr;
    }

    // 读文件，返回字符串
    public static JSONObject readJsonFromPath(String path) {
        String laststr = JsonUtils.readFile(path);
        return (JSONObject) JSONObject.toJSON(laststr);
    }


    // 把json格式的字符串写到文件
    public static boolean writeFile(String filePath, String sets) {
        if (sets == null) {
            return false;
        }
        FileWriter fw;
        try {
            fw = new FileWriter(filePath);
            PrintWriter out = new PrintWriter(fw);
            out.write(sets);
            out.println();
            fw.close();
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static int getSafeInt(JSONObject object,String key) {
        if (object == null)
            return 0;
        return object.getInteger(key);
    }

    public static String getSafeString(JSONObject object,String key) {
        if (object == null)
            return "";
        return object.getString(key);
    }


}