package com.acker.wallet.ui.statistics

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.acker.wallet.R
import com.acker.wallet.ui.home.Bills
import com.acker.wallet.ui.home.BillsAdapter
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import kotlinx.android.synthetic.main.fragment_currency.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_statistics.*


class StatisticsFragment : Fragment() {

    private lateinit var statisticsViewModel: StatisticsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        statisticsViewModel =
            ViewModelProvider(this).get(StatisticsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_statistics, container, false)
        return root
    }

    private fun generateList(): List<Bills> {
        val list = ArrayList<Bills>()
        for (i in 0 until 20) {
            val item = Bills("Bill $i", "July 01, 2020")
            list += item
        }
        return list
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val exampleList = generateList()
        payment.adapter = BillsAdapter(exampleList)
        payment.layoutManager = LinearLayoutManager(activity)
        payment.setHasFixedSize(true)

        val entries: MutableList<BarEntry> = ArrayList()
        entries.add(BarEntry(0f, 15f))
        entries.add(BarEntry(1f, 20f))
        entries.add(BarEntry(2f, 60f))
        entries.add(BarEntry(3f, 50f))
        entries.add(BarEntry(4f, 70f))
        entries.add(BarEntry(5f, 60f))
        entries.add(BarEntry(6f, 60f))


        val bardataset = BarDataSet(entries, "BarDataSet")
        bardataset.color = Color.WHITE
        bardataset.setDrawValues(false)
        val data = BarData(bardataset)
        data.barWidth = 0.1f // set custom bar width

        barchart.setData(data)
        barchart.setBackgroundColor(Color.parseColor("#3642DA"))
        barchart.getAxisLeft().setDrawLabels(false)
        barchart.getAxisRight().setDrawLabels(false)
        barchart.getXAxis().setDrawLabels(true)
        barchart.getAxisLeft().setDrawGridLines(false)
        barchart.getXAxis().setDrawGridLines(false)
        barchart.getAxisRight().setDrawGridLines(false)

        val xAxis: XAxis = barchart.getXAxis()
        xAxis.isEnabled = true
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        xAxis.textColor = Color.parseColor("#F7F7F7")
        val xAxisLabels = listOf("S", "M", "T", "W", "T", "F", "S")
        barchart.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisLabels)
        barchart.setExtraOffsets(0f,0f,0f,24f)


        val yAxis: YAxis = barchart.getAxisLeft()
        yAxis.isEnabled = false

        val yAxis2: YAxis = barchart.getAxisRight()
        yAxis2.isEnabled = false

        barchart.setDrawBorders(false)
        barchart.setDrawGridBackground(false)

        barchart.getLegend().setEnabled(false)

        barchart.getDescription().setEnabled(false)

        barchart.setTouchEnabled(true)

        barchart.setDragEnabled(false)
        barchart.setScaleEnabled(false)

        barchart.setPinchZoom(false)
        barchart.setAutoScaleMinMaxEnabled(true)

        val legend: Legend = barchart.getLegend()
        legend.isEnabled = false

        barchart.invalidate() // refresh

    }
}
