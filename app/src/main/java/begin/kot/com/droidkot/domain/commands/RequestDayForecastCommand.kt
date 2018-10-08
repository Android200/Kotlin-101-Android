package begin.kot.com.droidkot.domain.commands

import begin.kot.com.droidkot.domain.datasource.ForecastProvider
import begin.kot.com.droidkot.domain.model.Forecast

class RequestDayForecastCommand(
        val id: Long,
        private val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {
    override fun execute() = forecastProvider.requestForecast(id)
}