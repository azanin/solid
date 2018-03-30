package exercise.dip;

public class WeatherApi2 implements WeatherApi {

    @Override
    public double getTemperature() {
        return toCelcius(2.0d);
    }

    private double toCelcius(double temperatureFahrenheit) {
        return (temperatureFahrenheit - 32) / 1.8f;
    }

}
