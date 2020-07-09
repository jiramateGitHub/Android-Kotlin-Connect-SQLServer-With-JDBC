package com.example.mssqlapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CustomersActivity : AppCompatActivity() {

    lateinit var rv : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customers)

        rv = findViewById(R.id.rvCustomers)
        rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        MainActivity.db.ctx = this
        MainActivity.db.getCustomers(rv)
    }
}