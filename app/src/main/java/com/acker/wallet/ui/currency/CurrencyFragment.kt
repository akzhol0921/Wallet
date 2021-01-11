package com.acker.wallet.ui.currency


import android.os.Bundle
import android.os.StrictMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.acker.wallet.R
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import kotlinx.android.synthetic.main.fragment_currency.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException
import org.json.JSONObject
import kotlin.collections.ArrayList


class CurrencyFragment : Fragment() {

    var rate1: Double = 0.0
    var rate2: Double = 0.0
    var rate3: Double = 0.0
    var rate4: Double = 0.0
    var rate5: Double = 0.0
    var rate6: Double = 0.0
    var rate7: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        getCurrency()


    }

    fun getCurrency(currency1: String = "USD", currency2: String = "PLN") {
        val startDate = "2020-12-01"
        val endDate = "2020-12-07"
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.exchangeratesapi.io/history?base=$currency1&start_at=$startDate&end_at=$endDate&symbols=$currency2")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            val resStr = response.body!!.string()
            val json = JSONObject(resStr)

            rate1 = json.getJSONObject("rates").getJSONObject("2020-12-01").get("PLN") as Double
            rate2 = json.getJSONObject("rates").getJSONObject("2020-12-02").get("PLN") as Double
            rate3 = json.getJSONObject("rates").getJSONObject("2020-12-03").get("PLN") as Double
            rate4 = json.getJSONObject("rates").getJSONObject("2020-12-04").get("PLN") as Double
            rate5 = json.getJSONObject("rates").getJSONObject("2020-12-04").get("PLN") as Double
            rate6 = json.getJSONObject("rates").getJSONObject("2020-12-07").get("PLN") as Double
            rate7 = json.getJSONObject("rates").getJSONObject("2020-12-07").get("PLN") as Double

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        querybtn.setOnClickListener {
            getCurrency(BaseCur.text.toString(), TargetCur.text.toString())
            curchart.clearValues();

            val entries = ArrayList<Entry>()
            entries.add(Entry(0f, rate1.toFloat()))
            entries.add(Entry(1f, rate2.toFloat()))
            entries.add(Entry(2f, rate3.toFloat()))
            entries.add(Entry(3f, rate4.toFloat()))
            entries.add(Entry(4f, rate5.toFloat()))
            entries.add(Entry(5f, rate6.toFloat()))
            entries.add(Entry(6f, rate7.toFloat()))
            val linedataset = LineDataSet(entries, "")
            curchart.data = LineData(linedataset)
            curchart.invalidate()
        }
        val entries = ArrayList<Entry>()
        entries.add(Entry(0f, rate1.toFloat()))
        entries.add(Entry(1f, rate2.toFloat()))
        entries.add(Entry(2f, rate3.toFloat()))
        entries.add(Entry(3f, rate4.toFloat()))
        entries.add(Entry(4f, rate5.toFloat()))
        entries.add(Entry(5f, rate6.toFloat()))
        entries.add(Entry(6f, rate7.toFloat()))
        val linedataset = LineDataSet(entries, "")
        curchart.getLegend().setEnabled(false)

        val xAxis: XAxis = curchart.getXAxis()
        xAxis.isEnabled = true
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        val xAxisLabels = listOf("S", "M", "T", "W", "T", "F", "S")
        curchart.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisLabels)
        curchart.setExtraOffsets(0f, 0f, 0f, 24f)

        linedataset.setDrawValues(false)
        linedataset.setDrawFilled(true)
        linedataset.lineWidth = 3f

        curchart.getAxisRight().setDrawGridLines(false);
        curchart.getAxisLeft().setDrawGridLines(false);
        curchart.getXAxis().setDrawGridLines(false);
        curchart.getAxisRight().setDrawLabels(false)
        curchart.getDescription().setEnabled(false);

        curchart.data = LineData(linedataset)
        curchart.invalidate()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currency, container, false)
    }
}