package com.acker.wallet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.acker.wallet.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

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
        val exampleList = generateList()
        upcomingbill.adapter = BillsAdapter(exampleList)
        upcomingbill.layoutManager = LinearLayoutManager(activity)
        upcomingbill.setHasFixedSize(true)
    }

    private fun generateList(): List<Bills> {
        val list = ArrayList<Bills>()
        list.add(Bills("Rent Bill","January 01, 2021",R.drawable.ic_action_home))
        list.add(Bills("Rent Bill","January 01, 2021",R.drawable.ic_action_home))
        list.add(Bills("Rent Bill","January 01, 2021",R.drawable.ic_action_home))
        list.add(Bills("Rent Bill","January 01, 2021",R.drawable.ic_action_home))
        return list
    }
}