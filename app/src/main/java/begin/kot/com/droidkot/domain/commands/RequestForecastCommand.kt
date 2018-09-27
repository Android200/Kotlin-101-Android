package begin.kot.com.droidkot.domain.commands

import begin.kot.com.droidkot.data.server.ForecastByZipCodeRequest
import begin.kot.com.droidkot.data.server.ServerDataMapper
import begin.kot.com.droidkot.domain.datasource.ForecastProvider
import begin.kot.com.droidkot.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: Long,
                             private val forecastProvider: ForecastProvider = ForecastProvider()): Command<ForecastList>{

    companion object {
        val DAYS = 7
    }

    override fun execute(): ForecastList = forecastProvider.requestByZipCode(zipCode, DAYS)
}