package com.example.mssqlapp

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.io.PrintWriter
import java.io.StringWriter
import java.lang.Exception

class DatabaseHelper (){
    lateinit var ctx : Context
    private var isConnected = false
    private lateinit var rv : RecyclerView
    private lateinit var query : String
    private lateinit var adapter : RecyclerView.Adapter<*>
    private var recordCount : Int = 0
    private var functionType : Int = 0
    private lateinit var records : ArrayList<Any>
    lateinit var connectionClass : ConnectionClass


    inner class SyncData: AsyncTask<String, String, String>() {
        private var message = "Wo Connection or Windows fireWall, not enough permissions Error!"
        lateinit var prog: ProgressDialog

        override fun onPreExecute (){
            records.clear ()
            recordCount = 0
            prog =  ProgressDialog.show (ctx,"Reading Data. . . . ", " Loading.. Please Wait.", true)
        }


        override fun doInBackground (vararg params: String?) : String{
            try {

                var myCon = connectionClass?.dbCon()
                if (myCon == null) {
                    isConnected = false
                } else {
                    val statement = myCon!!.createStatement()
                    val cursor = statement.executeQuery(query)
                    if (cursor != null) {
                        while (cursor!!.next()) {
                            try {
                                when (functionType) {
                                    1 -> records?.add(
                                        Customer(
                                            cursor!!.getInt("CustomerNo"),
                                            cursor!!.getString("CustomerName")
                                        )
                                    )
                                    2 -> records?.add(
                                        Product(
                                            cursor!!.getInt("ProductID"),
                                            cursor!!.getString("Barcode"),
                                            cursor!!.getString("ProductName")
                                        )
                                    )
                                }
                                recordCount++
                            } catch (ex: Exception) {
                                ex.printStackTrace()
                            }
                        }
                        message = "Found $recordCount"
                        isConnected = true
                    } else {
                        message = "No Records"
                        isConnected = false
                    }
                }
            }catch (ex : Exception){
                ex.printStackTrace()
                val writer = StringWriter()
                ex.printStackTrace(PrintWriter(writer))
                message = writer.toString()
                isConnected = false
            }
            return message
        } // doInBackground

        override fun onPostExecute(result: String?) {
            prog.dismiss()
            Toast.makeText(ctx,message,Toast.LENGTH_SHORT).show()
            if(isConnected == false){

            }else{
                try {
                    rv.adapter = adapter
                }catch (ex : Exception){

                }
            }
        }
    } // inner class SyncData

    fun getCustomers(rv : RecyclerView){
        this.rv = rv
        query = "SELECT * FROM Customers"
        records = ArrayList<Customer>() as ArrayList<Any>
        adapter = Customeradapter(records as ArrayList<Customer>)
        functionType = 1
        SyncData().execute("")
    }

    fun getProducts(rv : RecyclerView){
        this.rv = rv
        query = "SELECT * FROM Customers"
        records = ArrayList<Product>() as ArrayList<Any>
        adapter = Productadapter(records as ArrayList<Product>)
        functionType = 2
        SyncData().execute("")
    }
}




