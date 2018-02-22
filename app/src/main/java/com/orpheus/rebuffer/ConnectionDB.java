package com.orpheus.rebuffer;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Johan Siau on 2/17/2018.
 */

public class ConnectionDB {

    String classs = "com.mysql.jdbc.Driver";

    /*
    * url nanti harus diganti ke server yg dipake, ada kemungkinan bakalan ditembak ke azure
    * todo: make a new db based on MariaDB
    * */
    String url = "jdbc:mysql://192.168.43.91/andro";
    String un = "root";
    String password = "";



    @SuppressLint("NewApi")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {

            Class.forName(classs);

            conn = DriverManager.getConnection(url, un, password);


            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;
    }
}
