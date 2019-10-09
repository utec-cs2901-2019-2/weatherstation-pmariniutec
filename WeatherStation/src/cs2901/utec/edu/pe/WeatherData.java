package cs2901.utec.edu.pe;

import java.util.*;

public class WeatherData implements Subject {

  double temperature;
  double humidity;
  double pressure;

  private List<Observer> observers = new ArrayList<>();

  public void start() {
    while (true) {
      temperature = (int) ((Math.random() * ((50 - 1) + 1)) + 1);
      humidity = (int) ((Math.random() * ((80 - 1) + 1)) + 1);
      pressure = (int) ((Math.random() * ((200 - 1) + 1)) + 1);

      try {
        Thread.sleep(2 * 1000);
        measurementsChanged();
      } catch (Exception e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update();
    }
  }

  public double getTemperature() {
    return temperature;
  }

  public double getHumidity() {
    return humidity;
  }

  public double getPressure() {
    return pressure;
  }

  public void measurementsChanged() {
    notifyObservers();
  }
}
