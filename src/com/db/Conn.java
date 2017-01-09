package com.db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Conn {
    public static String DBDRIVER = "";
    public static String DBURL = "";
    public static String DBUSER = "";
    public static String DBPASSWORD = "";
    public static final String JDBC_FILE = "jdbc";
    static Connection con = null;
    static Logger log = Logger.getLogger(Conn.class);
    static ResultSet rs = null;
    static ResourceBundle rsb = ResourceBundle.getBundle(JDBC_FILE);

    static {
        DBDRIVER = rsb.getString("DBDRIVER");
        DBURL = rsb.getString("DBURL");
        DBUSER = rsb.getString("DBUSER");
        DBPASSWORD = rsb.getString("DBPASSWORD");
        try {
            log.info("开始加载驱动");
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            log.error("驱动加载失败");
        }

    }

    public static Connection getCon() {
        try {
            log.info("开始获得连接");
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
            System.out.println(con);
        } catch (SQLException e) {

            e.printStackTrace();
            log.error("数据库连接失败");
        }
        return con;

    }

    public static void main(String[] args) {
        getCon();
    }

    /* 关闭连接 */
    public static void closeConnection(Connection con) {
        try {
            if (con != null && (!con.isClosed())) {
                con.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 关闭结果集
    public static void closeResultSet(ResultSet res) {
        if (rs != null) {
            try {
                rs.close();
                rs = null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
