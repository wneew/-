package com.his.io;

import javax.imageio.IIOException;
import java.io.*;

/**
 * 文件读写对象的工具类
 */
public class FileIO {

    /**
     * 读取文件中对象
     * @param filepath
     * @return
     */
    public static Object readObject(String filepath){
        File file = new File(filepath);
        InputStream is = null;
        ObjectInputStream ois = null;
        Object obj = null;
        try{
            is = new FileInputStream(file);
            ois = new ObjectInputStream(is);
            obj = ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(ois != null){
                    ois.close();
                }
                if(is != null){
                    is.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return obj;
    }

    /**
     * 向文件中写入对象
     * @param filepath
     * @param obj
     */
    public static void writeObject(String filepath,Object obj){
        File file = new File(filepath);
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try{
            os = new FileOutputStream(file);
            oos = new ObjectOutputStream(os);
            oos.writeObject(obj);
            oos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(oos != null){
                    oos.close();
                }
                if(os != null){
                    os.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
