package begin.kot.com.droidkot.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import begin.kot.com.droidkot.R
import begin.kot.com.droidkot.adapter.ForecastListAdapter
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import javax.xml.datatype.Duration


class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val forcastList = findViewById<RecyclerView>(R.id.forcast_list) using kotlin
        val forcastList = find<RecyclerView>(R.id.forcast_list)// using anko library
        forcastList.layoutManager = LinearLayoutManager(this)
        forcastList.adapter = ForecastListAdapter(items)

        toast("Hello Mars", Toast.LENGTH_SHORT)// extension function
        toast("Hello Earth",Toast.LENGTH_SHORT)// kotlin
        toast("Hello Jupiter",Toast.LENGTH_SHORT)// Anko Library
        longToast("Hello Pluto")// Anko Library
        longToast("Hello Sun")// kotlin
    }

    // Extension Function
    fun Context.toast(message: CharSequence,duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this,message,duration).show()
    }


}
