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

class ForecastListAdapter(private val weekForecast: ForecastList, private val itemClick: ForecastListAdapter.OnItemClickListener): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast,parent,false)
        return ViewHolder(view,itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]){
            holder.bindForecast(weekForecast[position])
        }

    }

    override fun getItemCount(): Int = weekForecast.size

    class ViewHolder(view: View,private val itemClick: OnItemClickListener ): RecyclerView.ViewHolder(view){
        private val iconView: ImageView = view.findViewById(R.id.icon)
        private val dateView: TextView = view.findViewById(R.id.date)
        private val descriptionView: TextView = view.find(R.id.description)
        private val maxTemperatureView: TextView = view.findViewById(R.id.maxTemperature)
        private  val minTemperature: TextView = view.findViewById(R.id.minTemperature)

        fun bindForecast(forecast: Forecast){
            with(forecast){
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high}º"
                minTemperature.text = "${low}º"
                itemView.setOnClickListener{
                    itemClick(this)
                }
            }
        }
    }

    interface OnItemClickListener{
        operator fun invoke(forecast: Forecast)
    }
}