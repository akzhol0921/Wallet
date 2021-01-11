package com.acker.wallet.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acker.wallet.R

class BillsAdapter(private val BillList: List<Bills>): RecyclerView.Adapter<BillsAdapter.BillsViewHolder>() {
    class BillsViewHolder(BillView: View) : RecyclerView.ViewHolder(BillView) {
        val textView1 : TextView = BillView.findViewById(R.id.textView1)
        val textView2 : TextView = BillView.findViewById(R.id.textView2)
        val img: ImageView = BillView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BillsViewHolder {
        val BillView = LayoutInflater.from(parent.context).inflate(R.layout.bill_layout,parent,false)
        return BillsViewHolder(BillView)
    }

    override fun onBindViewHolder(holder: BillsViewHolder, position: Int) {
        val currentItem = BillList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.img.setImageResource(currentItem.img)
    }

    override fun getItemCount() = BillList.size
}