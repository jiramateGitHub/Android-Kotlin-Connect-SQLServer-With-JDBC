package com.example.mssqlapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductsActivity : AppCompatActivity() {

    lateinit var rv : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        rv = findViewById(R.id.rvProducts)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        MainActivity.db.ctx = this
        MainActivity.db.getProducts(rv)
    }
}