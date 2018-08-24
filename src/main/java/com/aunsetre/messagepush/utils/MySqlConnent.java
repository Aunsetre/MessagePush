package com.aunsetre.messagepush.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Description:
 *
 * @author Aunsetre
 * @date 2018-08-22
 */
public class MySqlConnent {
    public final String driver="com.jdbc.mysql.Driver";
    public final String url="jdbc:mysql://localhost:3306/message";
    public final String user="root";
    public final String password="a0646146553/";
    private Connection conn;
    public static MySqlConnent mySqlConnent=null;
    private MySqlConnent(){

    }
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return conn=DriverManager.getConnection(url,user,password);
    }
    public static synchronized MySqlConnent getInstace(){
        if (mySqlConnent!=null) {
            mySqlConnent = new MySqlConnent();
        }
        return mySqlConnent;
    }
}
