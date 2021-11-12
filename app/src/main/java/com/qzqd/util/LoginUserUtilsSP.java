package com.qzqd.util;

import android.content.Context;
import android.content.SharedPreferences;


import com.orhanobut.logger.Logger;
import com.qzqd.initialization.MyApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhengWenxin
 * on 2020/2/27 17:09
 * Describe:
 * 登录用户将登录信息存到内存和持久化到XML文件中的工具类
 * XML文件存储在data/data/包名/shared_prefs目录下
 *
 */
public class LoginUserUtilsSP {
    private static final String fileName= "data";
    /**
     * 设置sessionID
     * @param context
     * @param token
     * @return
     */
    public static boolean setLoginInfo(Context context, String token, String userName, String userPassword) {
        //一、根据Context获取SharedPreferences对象
        SharedPreferences sp =  context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        /*
         * context.getSharedPreferences("bill",MODE);
         * MODE模式支持以下几种:
         *1、 检查文件是否存在，存在就往文件追加内容，否则就创建新文件。
         *SharedPreferences sharedPreferences=context.getSharedPreferences("bill", MODE_APPEND);
         *2、表示当前文件可以被其他应用读取
         *SharedPreferences sharedPreferences=context.getSharedPreferences("bill", MODE_WORLD_READABLE);
         *3、表示当前文件可以被其他应用写入
         *SharedPreferences sharedPreferences=context.getSharedPreferences("bill", MODE_WORLD_WRITEABLE);
         */
        //二、利用edit()方法获取Editor对象。
        SharedPreferences.Editor editor = sp.edit();
        //三、通过Editor对象存储key-value键值对数据。
//        Set<String> values = new HashSet<String>();
//        editor.putBoolean("boolean", true);//存储Boolean类型
//        editor.putFloat("float", 3);//存储float类型
//        editor.putInt("int", 1);//存储int类型
//        editor.putLong("long", 4);//存储long类型
//        editor.putString("string", "billgu");//存储string类型
//        editor.putStringSet("set", values);//存储set多维数组
        editor.putString("token",token);
        editor.putString("userName",userName);
        String DESPassword =DES.encryptDES(userPassword,ConstantVal.DESKey);
        Logger.i("KEY：加密后的密码=="+DESPassword);
        editor.putString("userPassword",DESPassword);
        editor.putBoolean("boolean",true);//true sessionID有效
        // 四、通过commit()方法提交数据。
        editor.commit();
        return true;
    }

    /**
     * 获取登录token
     * @return
     */
    public static String getToken( ){
        SharedPreferences sp = MyApplication.getAppContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        String token = sp.getString("token",null);
        if (token==null){
            return token="";
        }
        return token;
    }

    /**
     * 获取用户登录信息
     * @param context
     * @return
     */
    public static Map<String, String> getUserInfo(Context context){
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        String sessionID = sp.getString("token",null);
        String userName = sp.getString("userName",null);
        String userPassword = sp.getString("userPassword",null);
        Map<String, String> sessionIDMap = new HashMap<String, String>();
        sessionIDMap.put("token",sessionID);
        sessionIDMap.put("userName",userName);
        if (userPassword!=null){
            String password = DES.decryptDES(userPassword,ConstantVal.DESKey);
            Logger.i("KEY：解密后的密码=="+password);
            sessionIDMap.put("userPassword",password);
        }
        return sessionIDMap;
    }
    /**
     * 设置登录界面复选框状态
     * @param context
     * @param isPassword 是否记住密码
     * @param isLogin 是否自动登录
     * @return
     */
    public static boolean setLoginStatus(Context context, Boolean isPassword, Boolean isLogin) {
        SharedPreferences sp =  context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
//        try {
//            FileOutputStream fos = context.openFileOutput("data",Context.MODE_APPEND);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        SharedPreferences.Editor editor = sp.edit();

        editor.putBoolean("isPassword",isPassword);
        editor.putBoolean("isLogin",isLogin);
        editor.commit();
        return true;
    }

    /**
     * 获取登录复选框状态
     * @param context
     * @return
     */
    public static Map<String, Boolean> getCheckBoxStatus(Context context){
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        Boolean isPassword = sp.getBoolean("isPassword",false);
        Boolean isLogin = sp.getBoolean("isLogin",false);
        Map<String, Boolean> checkBoxStatusMap = new HashMap<String, Boolean>();
        checkBoxStatusMap.put("isPassword",isPassword);
        checkBoxStatusMap.put("isLogin",isLogin);
        return checkBoxStatusMap;
    }

    /**
     * 设置登录服务器IP
     * @param context
     * @param serverIP 服务器IP
     * @return
     */
    public static boolean setServerIP(Context context, String serverIP) {
        SharedPreferences sp =  context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("serverIP",serverIP);
        editor.commit();
        return true;
    }

    /**
     * 获取服务器IP
     * @param context
     * @return
     */
    public static String getServerIP(Context context){
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        String serverIP = sp.getString("serverIP",null);
        return serverIP;
    }


    /**
     * 设置默认打印机
     * @param context
     * @param printerName 选择的打印机名
     * @return
     */
    public static boolean setPrinterName(Context context, String printerName) {
        SharedPreferences sp =  context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("printerName",printerName);
        editor.commit();
        return true;
    }

    /**
     * 获取默认打印机
     * @param context
     * @return
     */
    public static String getPrinterName(Context context){
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        String printerName = sp.getString("printerName",null);
        return printerName;
    }


    /**
     * 设置sessionID
     * @param context
     * @param token
     * @return
     */
    public static boolean setWebInfo(Context context,String webViewUrl,String zoom) {
        //一、根据Context获取SharedPreferences对象
        SharedPreferences sp =  context.getSharedPreferences(fileName, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();
        editor.putString("webViewUrl",webViewUrl);
        editor.putString("zoom",zoom);
        editor.commit();
        return true;
    }

    /**
     * 获取用户登录信息
     * @param context
     * @return
     */
    public static Map<String, String> getWebInfo(Context context){
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        String webViewUrl = sp.getString("webViewUrl",null);
        String zoom = sp.getString("zoom",null);
        Map<String, String> sessionIDMap = new HashMap<String, String>();
        sessionIDMap.put("webViewUrl",webViewUrl);
        sessionIDMap.put("zoom",zoom);
        return sessionIDMap;
    }

}