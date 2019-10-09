package cs2901.utec.edu.pe;

public class ForecastDisplay implements Observer, DisplayElement {

  private WeatherData subject;
  private double forecastTemperature;
  private double forecastHumidity;
  private double currentPressure;

  public ForecastDisplay(WeatherData wd) {
    subject = wd;
  }

  @Override
  public void update() {
    currentPressure = subject.getPressure();
    forecastTemperature = subject.getTemperature() + (0.5 * currentPressure / 0.1);
    forecastHumidity = subject.getHumidity() + (0.1 * currentPressure / 0.7);
  }

  @Override
  public void display() {
    System.out.println("Forecast:");
    System.out.println("Pressure: " + currentPressure);
    System.out.println("Temperature: " + forecastTemperature);
    System.out.println("Humidity: " + forecastHumidity);
  }
}
