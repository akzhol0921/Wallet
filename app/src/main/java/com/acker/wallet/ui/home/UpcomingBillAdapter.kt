package com.acker.wallet.ui.home

import android.R
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class UpcomingBillAdapter(private val mBills : List<Bills>) :
    RecyclerView.Adapter<UpcomingBillAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val nameTextView = itemView.findViewById<TextView>(R.id.text2)
    }

    override fun getItemCount() = mBills.size

    override fun onBindViewHolder(holder: UpcomingBillAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

}