package begin.kot.com.droidkot.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import begin.kot.com.droidkot.R
import begin.kot.com.droidkot.domain.model.Forecast
import begin.kot.com.droidkot.domain.model.ForecastList
import begin.kot.com.droidkot.ui.utils.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*
import org.jetbrains.anko.find
import java.text.DateFormat
import java.util.*

class ForecastListAdapter(private val weekForecast: ForecastList, private val itemClick: (Forecast)-> Unit): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast,parent,false)
        return ViewHolder(view,itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]){
            holder.bindForecast(weekForecast[position])
        }

    }

    override fun getItemCount() = weekForecast.size

    class ViewHolder(view: View,private val itemClick:(Forecast) -> Unit ): RecyclerView.ViewHolder(view){

        fun bindForecast(forecast: Forecast){
            with(forecast){
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = convertDate(date)
                itemView.description.text = description
                itemView.maxTemperature.text =  "${high}º"
                itemView.minTemperature.text =  "${low}º"
                itemView.setOnClickListener{itemClick(this)}
            }
        }

        private fun convertDate(date: Long): String {
            val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
            return df.format(date)
        }

    }


}