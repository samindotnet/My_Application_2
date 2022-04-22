package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import net.sourceforge.jtds.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    Connection conn;
    @SuppressLint("NewApi")
    public Connection connClass(){
        String ip="192.168.1.183",port="1433",db="mydatabase",username="sa",password="12345";
        StrictMode.ThreadPolicy a = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(a);
        String ConnectURL = null;
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectURL="jdbc:jtds:sqlserver://"+ip+":"+port+";"+"databasename="+db+";user="+username+";"+"password="+password+";";
            conn= DriverManager.getConnection(ConnectURL);
        }
        catch(Exception e){
            Log.e("Error is ", e.getMessage());
        }
        return conn;
    }
}
