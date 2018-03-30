/*
package exercise.dip;

import org.junit.Test;

public class WeatherAggregatorTest {

    public static class WeatherApiStub implements WeatherApi {
        private final double v;

        public WeatherApiStub(double v) {
            this.v = v;
        }

        @Override
        public double getTemperature() {
            return v;
        }
    }

    @Test
    public void getAverage() {
        WeatherApi weatherApi1 = new WeatherApiStub(4.0f);
        WeatherApi weatherApi2 = new WeatherApiStub(6.0f);
        WeatherAggregator weatherAggregator = new WeatherAggregator(weatherApis);

        double average = weatherAggregator.getAverage();

        assert average == 5.0f;
    }
}
*/
