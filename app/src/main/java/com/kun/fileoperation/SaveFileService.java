package com.kun.fileoperation;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Crazy-kun on 2017/7/4.
 */

public class SaveFileService {

    //将数据保存在指定文件中
    private static String FILE_NAME = "info.txt";

    /**
     * 保存用户名和密码于文件中
     *
     * @param context
     * @param username
     * @param pwd
     * @return
     */
    public static boolean saveFile(Context context, String username, String pwd) {

        //context.getFilesDir()返回的路径为 /data/data/当前包名/files
        File file = new File(context.getFilesDir(), FILE_NAME);

        try {
            FileWriter fileWriter=new FileWriter(file);
            fileWriter.write(username+":"+pwd);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 删除数据文件
     * @param context
     * @return
     */
    public static boolean deleteFile(Context context){

        File file=new File(context.getFilesDir(),FILE_NAME);

        return file.delete();

    }

    /**
     * 返回保存的用户名和密码
     * @param context
     * @return
     */
    public static String findUser(Context context){
        File file=new File(context.getFilesDir(),FILE_NAME);

        if (!file.exists()){
            return null;
        }
        String result=null;
        try {
            BufferedReader br=new BufferedReader(new FileReader(file));
            result=br.readLine();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
