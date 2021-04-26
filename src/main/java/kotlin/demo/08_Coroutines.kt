package kotlin.demo

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.util.*

fun main(args: Array<String>) {
    val weatherService = WeatherService()


    listOf("Brussels", "Miami", "Moscow", "London")
            .forEach { l ->
                GlobalScope.async {
                    printWeather(weatherService, l)
                }
            }
    Thread.sleep(2000)
}

suspend fun printWeather(weatherService: WeatherService, location: String) {
    val start = System.currentTimeMillis()
    val weather = weatherService.weatherFor(location)
    val duration = System.currentTimeMillis() - start
    println("$location: $weather ($duration ms)")
}

class WeatherService {
    suspend fun weatherFor(location: String): Weather {
        sleep(Random().nextInt(2000).toLong())
        if (location == "Miami") return Weather.SUNNY
        if (location == "Brussels") return Weather.RAIN
        if (location == "Moscow") return Weather.SNOW
        return Weather.CLOUDED
    }

}

suspend fun sleep(millis: Long) {
    Thread.sleep(millis)
}

enum class Weather {
    SUNNY, CLOUDED, RAIN, SNOW
}
