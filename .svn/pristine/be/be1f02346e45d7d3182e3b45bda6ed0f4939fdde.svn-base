package com.meal.util;

import android.os.Environment;

import java.io.*;

/**
 * @author xiamingxing
 *
 */
public class FileUtils {

    private static final String SDPATH = Environment.getExternalStorageDirectory() + "/";

    /**
     * @return
     */
    public static String getSDPATH() {

        return SDPATH;

    }

    /**
     * @param fileName
     * @return
     * @throws IOException
     */
    public static File creatSDFile(String fileName) throws IOException {

        File file = new File(SDPATH + fileName);
        file.createNewFile();

        return file;
    }

    /**
     * @param dirName
     * @return
     */
    public static File creatSDDir(String dirName) {

        File dir = new File(SDPATH + dirName);
        dir.mkdirs();

        return dir;

    }

    /**
     * @param fileName
     * @return
     */
    public static boolean isFileExist(String fileName) {

        File file = new File(SDPATH + fileName);

        return file.exists();

    }

    /**
     * @param path
     * @param fileName
     * @param input
     * @return
     */
    public static File write2SDFromInput(String path, String fileName,
                                         InputStream input) {

        File file = null;
        OutputStream output = null;

        try {

            creatSDDir(path);
            file = creatSDFile(path + fileName);
            output = new FileOutputStream(file);
            
            byte buffer[] = new byte[4 * 1024];

            while ((input.read(buffer)) != -1) {

                output.write(buffer);

            }

            output.flush();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                output.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        return file;

    }

}