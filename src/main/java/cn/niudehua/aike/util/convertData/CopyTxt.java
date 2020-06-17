package cn.niudehua.aike.util.convertData;
/**
 * 转换txt文本的格式,给语言模型训练的语料使用
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CopyTxt {
    public static void rwFile(String outFilePath, String inputFilePath) {
        FileWriter fw = null;
        BufferedReader br = null;
        try {
            fw = new FileWriter(outFilePath, true);
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(inputFilePath), "UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                String useData = line.split("\\t")[1];
                if (useData.length() > 3 && useData.indexOf("guangdong-local") == -1) {
                    System.out.println("文件内容: " + useData);
                    fw.write(useData + "\n");
                }
                fw.flush();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取文件夹下所有文件名
     *
     * @param path
     * @return
     */
    public static String[] getFileName(String path) {
        File file = new File(path);
        String[] fileNames = file.list();
        return fileNames;
    }


    public static void main(String[] args) {
        String[] fileNames = getFileName("\\Users\\Deng\\Desktop\\plain\\trans");
        for (String fileName : fileNames) {
            String inputFilePath = "\\Users\\Deng\\Desktop\\plain\\trans\\" + fileName;
            rwFile("\\Users\\Deng\\Desktop\\data.txt", inputFilePath);
        }
    }
}
