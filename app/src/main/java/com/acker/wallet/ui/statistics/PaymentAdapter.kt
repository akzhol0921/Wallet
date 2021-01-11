package com.acker.wallet.ui.statistics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acker.wallet.R

class PaymentAdapter(private val PaymentList: List<Payments>): RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder>() {
    class PaymentViewHolder(PaymentView: View) : RecyclerView.ViewHolder(PaymentView) {
        val textView1 : TextView = PaymentView.findViewById(R.id.textView1)
        val textView2 : TextView = PaymentView.findViewById(R.id.textView2)
        val textView3 : TextView = PaymentView.findViewById(R.id.textView3)
    }

    override fun getItemCount() = PaymentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val PaymentView = LayoutInflater.from(parent.context).inflate(R.layout.payment_layout,parent,false)
        return PaymentViewHolder(PaymentView)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val currentItem = PaymentList[position]
        holder.textView1.text = currentItem.Description
        holder.textView2.text = currentItem.Date
        holder.textView3.text = currentItem.Amount.toString()
    }
}