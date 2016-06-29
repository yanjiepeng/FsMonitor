package com.zk.utils;

import android.util.Log;

import com.zk.tag.DataTag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/6/27.
 */
public class Util {


    //
    private static final String REMOTE_IP = DataTag.REMOTE_IP;
    private static final String URL = "jdbc:mysql://"
            + REMOTE_IP
            + ":3306/nc?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = DataTag.USER;
    private static final String PASSWORD = DataTag.PASSWORD ;
    public static Connection conn;

    // 获得连接
    private static Connection openConnection(String url, String user,
                                             String password) {
        Connection conn = null;
        try {
            final String DRIVER_NAME = "com.mysql.jdbc.Driver";
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                DataTag.MYSQL_CONNECT_FLAG = true;
            Log.i("SQLog", "connect success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
            conn = null;
        }
        return conn;
    }



    /*
     * 登录判定

    public static UserBean login(String user) {

        UserBean c_User = null;
        if (conn == null) {
            return null;
        }
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select * from staff where Staff_ID = '" + user + "'";

        try {
            stmt = conn.createStatement();
            if (stmt != null) {
                rs = stmt.executeQuery(sql);
                while (rs.next()) {

                    c_User = new UserBean(rs.getString(1), rs.getString(3),
                            rs.getString(2));
                }
                return c_User;
            } else {
                return null;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return c_User;

    }
    */
    //
    public static void onConn() {
        conn = openConnection(URL, USER, PASSWORD);
        Log.i("tag", 1 + "");
    }

}
