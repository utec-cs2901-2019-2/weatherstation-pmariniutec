package cs2901.utec.edu.pe;

import java.util.*;

public class StatisticsDisplay implements Observer, DisplayElement {

  private WeatherData subject;

  private List<Double> temperatures = new ArrayList<>();
  private List<Double> humidities = new ArrayList<>();
  private List<Double> pressures = new ArrayList<>();

  public StatisticsDisplay(WeatherData wd) {
    subject = wd;
  }

  private double calculateListAverage(List<Double> values) {
    Double sum = 0.0;
    for (Double d : values) {
      sum += d;
    }
    return sum;
  }

  @Override
  public void update() {
    temperatures.add(subject.getTemperature());
    humidities.add(subject.getHumidity());
    pressures.add(subject.getPressure());
    display();
  }

  @Override
  public void display() {
    double tempAvg = calculateListAverage(temperatures);
    double humidityAvg = calculateListAverage(humidities);
    double pressureAvg = calculateListAverage(pressures);

    System.out.println("Max:");
    System.out.println("Temperature: " + Collections.max(temperatures));
    System.out.println("Humidity: " + Collections.max(humidities));
    System.out.println("Pressure: " + Collections.max(pressures));

    System.out.println("Min:");
    System.out.println("Temperature: " + Collections.min(temperatures));
    System.out.println("Humidity: " + Collections.min(humidities));
    System.out.println("Pressure: " + Collections.min(pressures));

    System.out.println("Averages:");
    System.out.println("Temperature: " + tempAvg);
    System.out.println("Humidity: " + humidityAvg);
    System.out.println("Pressure: " + pressureAvg);
  }
}
