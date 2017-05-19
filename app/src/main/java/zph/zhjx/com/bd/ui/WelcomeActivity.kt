package zph.zhjx.com.bd.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import zph.zhjx.com.bd.R
import zph.zhjx.com.bd.adapter.ForecastListAdapter
import zph.zhjx.com.bd.base.BaseActivity
class WelcomeActivity : BaseActivity() {

    private val items = listOf(
            "Kotlin Kotlin Kotlin Kotlin ",
            "Kotlin Kotlin Kotlin Kotlin ",
            "Kotlin Kotlin Kotlin Kotlin ",
            "Kotlin Kotlin Kotlin Kotlin ",
            "Kotlin Kotlin Kotlin Kotlin ",
            "Kotlin Kotlin Kotlin Kotlin ",
            "Kotlin Kotlin Kotlin Kotlin ",
            "Kotlin Kotlin Kotlin Kotlin ",
            "Kotlin Kotlin Kotlin Kotlin ",
            "Kotlin Kotlin Kotlin Kotlin ",
            "Kotlin for Android testData 0",
            "Kotlin for Android testData 1",
            "Kotlin for Android testData 2",
            "Kotlin for Android testData 3",
            "Kotlin for Android testData 4",
            "Kotlin for Android testData 5",
            "Kotlin for Android testData 6",
            "Kotlin for Android testData 7",
            "Kotlin for Android testData 8",
            "Kotlin for Android testData 9",
            "Kotlin Kotlin Kotlin Kotlin ",
    "Kotlin Kotlin Kotlin Kotlin ",
    "Kotlin Kotlin Kotlin Kotlin ",
    "Kotlin Kotlin Kotlin Kotlin ",
    "Kotlin Kotlin Kotlin Kotlin ",
    "Kotlin Kotlin Kotlin Kotlin ",
    "Kotlin for Android testData 0",
    "Kotlin for Android testData 1",
    "Kotlin for Android testData 2",
    "Kotlin for Android testData 3",
    "Kotlin for Android testData 4",
    "Kotlin for Android testData 5",
    "Kotlin for Android testData 6",
    "Kotlin for Android testData 7",
    "Kotlin for Android testData 8",
    "Kotlin for Android testData 9",
            "Kotlin Kotlin Kotlin Kotlin ",
            "Kotlin Kotlin Kotlin Kotlin ",
            "Kotlin Kotlin Kotlin Kotlin ",
            "Kotlin Kotlin Kotlin Kotlin ",
            "Kotlin Kotlin Kotlin Kotlin ",
            "Kotlin Kotlin Kotlin Kotlin ",
            "Kotlin for Android testData 0",
            "Kotlin for Android testData 1",
            "Kotlin for Android testData 2",
            "Kotlin for Android testData 3",
            "Kotlin for Android testData 4",
            "Kotlin for Android testData 5",
            "Kotlin for Android testData 6",
            "Kotlin for Android testData 7",
            "Kotlin for Android testData 8",
            "Kotlin for Android testData 9"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        setstatusbarcolor();
        setReceiverDate();
    }

    fun setReceiverDate(){
        val forecastList = findViewById(R.id.recyclerView) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)
    }
}
