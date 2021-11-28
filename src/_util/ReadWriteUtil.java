package _util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Description: 读写文件工具类
 * @Date: 2021/11/28
 */

public class ReadWriteUtil {
    public static String readFileByLines(String path) {
        StringBuffer sb = new StringBuffer();
        File file = new File(path);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;

            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    System.out.println(e1);
                }
            }
        }
        return sb.toString();
    }

}
