package com.example.mssqlapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Customeradapter (val customers: ArrayList<Customer>) : RecyclerView.Adapter<Customeradapter.ViewHolder> ()
{
    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        val txtCustomerNo = itemView.findViewById (R.id.txtCustomersNo) as TextView
        val txtCustomerName = itemView.findViewById (R.id.txtCustomersName) as TextView
    }

    override fun onCreateViewHolder (p0 : ViewGroup, p1: Int) : Customeradapter .ViewHolder{
        val v = LayoutInflater.from(p0.context).inflate(R.layout.lo_customers, p0, false)
        return ViewHolder (v)
    }

    override fun getItemCount () : Int {
        return customers.size
    }

    override fun onBindViewHolder (p0 : Customeradapter.ViewHolder, p1: Int){
        val customer : Customer = customers [p1]
        p0?.txtCustomerNo.text = customer.CustomerNo.toString ()
        p0?.txtCustomerName.text = customer.CustomerName
    }
}

class Productadapter (val products: ArrayList<Product>) : RecyclerView.Adapter<Productadapter.ViewHolder> ()
{
    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        val txtProductNo = itemView.findViewById (R.id.txtProductsNo) as TextView
        val txtProductName = itemView.findViewById (R.id.txtProductsName) as TextView
    }

    override fun onCreateViewHolder (p0 : ViewGroup, p1: Int) : Productadapter.ViewHolder{
        val v = LayoutInflater.from(p0.context).inflate(R.layout.lo_products, p0, false)
        return ViewHolder (v)
    }

    override fun getItemCount () : Int {
        return products.size
    }

    override fun onBindViewHolder (p0 : Productadapter.ViewHolder, p1: Int){
        val product : Product = products[p1]
        p0?.txtProductNo.text = product.ProductNo.toString ()
        p0?.txtProductName.text = product.ProductName
    }
}



