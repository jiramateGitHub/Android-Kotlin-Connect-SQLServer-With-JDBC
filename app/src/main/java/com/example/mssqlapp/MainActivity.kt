package com.example.mssqlapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    companion object{
        val db = DatabaseHelper()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db.connectionClass = ConnectionClass()
    }

    fun CustomersOnClick (view: View){
        val i = Intent ( this, CustomersActivity:: class .java)
        startActivity(i)
    }

    fun ProductsOnClick (view: View){
        val i = Intent ( this, ProductsActivity:: class .java)
        startActivity(i)
    }

}