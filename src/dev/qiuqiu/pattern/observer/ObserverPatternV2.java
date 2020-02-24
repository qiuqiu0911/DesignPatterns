package dev.qiuqiu.pattern.observer;

public class ObserverPatternV2 {
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        GeneralDisplay generalDisplay = new GeneralDisplay();
        weatherData.addObserver(generalDisplay);
        weatherData.setMeasurementsChanged("1", "23", "333");
    }
}
