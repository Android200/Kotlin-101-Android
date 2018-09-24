package begin.kot.com.droidkot.domain.commands

import begin.kot.com.droidkot.data.ForecastRequest
import begin.kot.com.droidkot.domain.mappers.ForecastDataMapper
import begin.kot.com.droidkot.domain.model.ForecastList

class RequestForecastCommand(val zipCode: String): Command<ForecastList>{
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}