package begin.kot.com.droidkot.domain.datasource

import begin.kot.com.droidkot.domain.model.ForecastList

interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
}