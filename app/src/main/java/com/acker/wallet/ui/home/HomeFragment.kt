package com.acker.wallet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.acker.wallet.R
import com.acker.wallet.ui.statistics.Payments
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    val list = ArrayList<Bills>()
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.add(Bills("Rent Bill","January 01, 2021",R.drawable.iconhome))
        list.add(Bills("Water Payment","January 01, 2021",R.drawable.iconheart))
        list.add(Bills("Subscription","January 01, 2021",R.drawable.shoppingcart))
        list.add(Bills("Tuition Fee","January 01, 2021",R.drawable.paymenticon))
        upcomingbill.adapter = BillsAdapter(list)
        upcomingbill.layoutManager = LinearLayoutManager(activity)
        upcomingbill.setHasFixedSize(true)
    }

}