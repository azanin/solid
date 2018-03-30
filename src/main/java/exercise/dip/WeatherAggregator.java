package exercise.dip;

import java.util.List;

public class WeatherAggregator {

    private final List<WeatherApi> weatherApis;


    public WeatherAggregator(List<WeatherApi> weatherApis) {
        this.weatherApis = weatherApis;
    }

    public double getAverage() {
        double res = 0.0d;
        for (WeatherApi weatherApi : weatherApis) {
            res += weatherApi.getTemperature();
        }
        return res / weatherApis.size();
    }

}

