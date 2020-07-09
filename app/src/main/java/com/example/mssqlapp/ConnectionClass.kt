package com.example.mssqlapp

import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class ConnectionClass {
    private val ip = "192.168.228.146:1433"
    private val db = "App"
    private val username = "sa"
    private val password = "123456"

    fun dbCon() : Connection? {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn : Connection? = null
        var connString : String? = null
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver")
            connString = "jdbc:jtds:sqlserver://$ip;databaseName=$db;user=$username;password=$password;"
            conn = DriverManager.getConnection(connString)
        }catch (ex : SQLException){
            Log.d("Error", "SQLException: "+ex.message)
        }catch (ex : Exception){
            Log.d("Error", "Exception: "+ex.message)
        }
        return conn
    }
}