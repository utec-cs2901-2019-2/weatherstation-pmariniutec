package cs2901.utec.edu.pe;

public class CurrentConditions implements Observer, DisplayElement {

  private WeatherData subject;

  public CurrentConditions(WeatherData wd) {
    subject = wd;
  }

  @Override
  public void update() {
    display();
  }

  @Override
  public void display() {
    System.out.println("Temperature: " + subject.getTemperature());
    System.out.println("Humidity: " + subject.getHumidity());
    System.out.println("Pressure: " + subject.getPressure());
  }
}
