package cs2901.utec.edu.pe;

public class Main {
  public static void main(String[] args) {

    WeatherData weatherData = new WeatherData();

    CurrentConditions cc = new CurrentConditions(weatherData);
    StatisticsDisplay sd = new StatisticsDisplay(weatherData);
    ForecastDisplay fd = new ForecastDisplay(weatherData);
    ThirdPartyDisplay tpd = new ThirdPartyDisplay(weatherData);

    weatherData.registerObserver(cc);
    weatherData.registerObserver(sd);
    weatherData.registerObserver(fd);
    weatherData.registerObserver(tpd);

    weatherData.start();
  }
}
