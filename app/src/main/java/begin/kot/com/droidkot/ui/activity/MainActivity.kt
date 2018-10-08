package begin.kot.com.droidkot.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import begin.kot.com.droidkot.R
import begin.kot.com.droidkot.domain.commands.RequestForecastCommand
import begin.kot.com.droidkot.ui.adapter.ForecastListAdapter
import org.jetbrains.anko.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ToolbarManager {

    override val toolbar by lazy { find<Toolbar> (R.id.toolbar) }

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
        initToolbar()

        //val forcastList = find<RecyclerView>(R.id.forcast_list)// using anko library
        forcastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forcastList)




        doAsync {
            val result = RequestForecastCommand(94043).execute()
            uiThread { it ->
                val adapter = ForecastListAdapter(result) {
                    startActivity<DetailActivity>(DetailActivity.ID to it.id, DetailActivity.CITY_NAME to result.city)
                }
                forcastList.adapter = adapter
                toolbarTitle = "${result.city} (${result.country})"
            }
        }

    }

}
