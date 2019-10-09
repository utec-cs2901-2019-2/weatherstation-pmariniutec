package cs2901.utec.edu.pe;

public class ThirdPartyDisplay implements Observer, DisplayElement {

  private WeatherData subject;
  private double lastTemp;
  private double lastHumidity;
  private double lastPressure;
  private double currentTemp;
  private double currentHumidity;
  private double currentPressure;

  public ThirdPartyDisplay(WeatherData wd) {
    subject = wd;
  }

  @Override
  public void update() {
    currentTemp = subject.getTemperature();
    currentHumidity = subject.getHumidity();
    currentPressure = subject.getPressure();
  }

  @Override
  public void display() {
    if (Math.abs(currentTemp - lastTemp) >= 3) {
      System.out.println("Temperature warning: Changed from " + lastTemp + " to " + currentTemp);
    }
    if (Math.abs(currentHumidity - lastHumidity) >= 7) {
      System.out.println(
          "Temperature warning: Changed from " + lastHumidity + " to " + currentHumidity);
    }
    if (Math.abs(currentPressure - lastPressure) >= 10) {
      System.out.println(
          "Pressure warning: Changed from " + lastPressure + " to " + currentPressure);
    }
    updateLastStats();
  }

  private void updateLastStats() {
    lastTemp = currentTemp;
    lastHumidity = currentHumidity;
    lastPressure = currentPressure;
  }
}
