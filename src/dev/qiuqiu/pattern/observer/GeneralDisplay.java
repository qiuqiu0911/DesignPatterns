package dev.qiuqiu.pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class GeneralDisplay implements Observer, ObserverV1 {
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getTemperature());

        }
    }


    @Override
    public void update(String temperature, String humidity, String pressure) {
        System.out.println(GeneralDisplay.class.toGenericString() + " shows : " + temperature + " ");
    }
}
