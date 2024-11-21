package com.quest.oops.casestudy;

public class City {

    private String cityName;
    private double temp;
    private int humidity;
    private String weatherCondition;

    public City(String cityName, double temp, int humidity, String weatherCondition) {
        this.cityName = cityName;
        this.temp = temp;
        this.humidity = humidity;
        this.weatherCondition = weatherCondition;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    @Override
    public String toString() {
        return String.format("City: %s%n" +
                        "Temperature: %f °C%n" +
                        "Humidity: %d%%%n" +
                        "Weather Condition: %s%n",
                cityName, temp, humidity, weatherCondition);
    }
}
