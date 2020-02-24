package dev.qiuqiu.pattern.observer;

import java.util.HashSet;
import java.util.Set;

/**
 * 观察者模式
 * 定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时
 * 它的所有依赖者都会收到通知并自动更新
 *
 * @author qiuqiu
 */
public class ObserverPattern {

    public static void main(String[] args) {
        WeatherDataV1 weatherData = new WeatherDataV1();
        DefaultObserver defaultObserver = new DefaultObserver();
        SecondObserver secondObserver = new SecondObserver();
        weatherData.registerObserver(defaultObserver);
        weatherData.registerObserver(secondObserver);
        weatherData.setTemperature("hahaha");
        weatherData.setPressure("heiheihei");
        weatherData.removeObserver(defaultObserver);
        weatherData.setHumidity("h1111");
    }
}

/**
 * 主题
 */
interface Subject {
    /**
     * 注册观察者
     */
    void registerObserver(ObserverV1 observer);

    /**
     * 取消注册观察者
     */
    void removeObserver(ObserverV1 observer);

    /**
     * 通知观察者
     */
    void notifyObservers();
}

/**
 * 所有观察者都必须实现
 */
interface ObserverV1 {
    void update(String temperature, String humidity, String pressure);
}

class DefaultObserver implements ObserverV1 {

    @Override
    public void update(String temperature, String humidity, String pressure) {
        System.out.println(DefaultObserver.class.toGenericString() + ":" + temperature + "   " + humidity + "   " + pressure);
    }
}

class SecondObserver implements ObserverV1 {

    @Override
    public void update(String temperature, String humidity, String pressure) {
        System.out.println(SecondObserver.class.toGenericString()+":气温是:" + temperature + ", 气压是:" + pressure);
    }
}

/**
 * 天气数据
 */
class WeatherDataV1 implements Subject {

    private Set<ObserverV1> observers = new HashSet<>();

    @Override
    public void registerObserver(ObserverV1 observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverV1 observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(temperature, humidity, pressure));
    }

    private String temperature;
    private String humidity;
    private String pressure;

    public void setTemperature(String temperature) {
        this.temperature = temperature;
        onKeyChanged();
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
        onKeyChanged();
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
        onKeyChanged();
    }

    public void onKeyChanged() {
        notifyObservers();
    }
}