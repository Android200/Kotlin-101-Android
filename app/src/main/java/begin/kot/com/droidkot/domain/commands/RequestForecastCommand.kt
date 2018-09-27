package begin.kot.com.droidkot.domain.commands

import begin.kot.com.droidkot.data.server.ForecastRequest
import begin.kot.com.droidkot.domain.mappers.ForecastDataMapper
import begin.kot.com.droidkot.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: Long): Command<ForecastList>{
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(zipCode, forecastRequest.execute())
    }
}