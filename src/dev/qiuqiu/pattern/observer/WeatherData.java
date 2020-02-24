package dev.qiuqiu.pattern.observer;

import java.util.Observable;

public class WeatherData extends Observable {
    private String temperature;
    private String humidity;
    private String pressure;

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }

    public void setMeasurementsChanged(String temperature,String humidity, String pressure){

        this.temperature =  temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }
}
