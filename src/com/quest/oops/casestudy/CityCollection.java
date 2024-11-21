package com.quest.oops.casestudy;

import java.util.Scanner;

public class CityCollection extends WeatherOperations {

    private City[] CityList; //array to hold city objects
    private int currentIndex;   //index for array

    public CityCollection(int numOfCity) {
        CityList = new City[numOfCity];
        currentIndex = 0;
    }


    //method to add city object to array
    @Override
    public void addCity(String cityName, double temp, int humidity, String weatherCondition) {
        if (currentIndex < CityList.length) {
            CityList[currentIndex] = new City(cityName, temp, humidity, weatherCondition);
            currentIndex++;
        } else {
            System.out.println("Array is full");
        }
    }

    //display single city based on name
    @Override
    public void displaySingleCity(String cityName) {
        City city = findCityByName(cityName);
        if (city != null) {
            System.out.println(city.toString());
        } else {
            System.out.println("City not found.");
        }
    }

    //display every city
    @Override
    public void displayAllCities() {
        System.out.println("--------------------------------------");
        for (City city : CityList) {
            System.out.println("City: " + city.getCityName());
            System.out.println("Temperature: " + city.getTemp() + "°C");
            System.out.println("Humidity: " + city.getHumidity() + "%");
            System.out.println("Weather Condition: " + city.getWeatherCondition());
            System.out.println("--------------------------------------");
        }
        System.out.println("--------------------------------------");
    }

    //update city details based on name
    @Override
    public void updateCityDetails(String cityName) {

        City city = findCityByName(cityName);

        System.out.println("enter the option to update\n" +
                "1)temperature\n" +
                "2)Humidity\n" +
                "3)weather condition");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter the new temperature");
                int newTemp = sc.nextInt();
                city.setTemp(newTemp);
                System.out.println("temperature updated to: " + newTemp + "°C");
                break;
            case 2:
                System.out.println("Enter the new humidity");
                int newHumidity = sc.nextInt();
                city.setHumidity(newHumidity);
                System.out.println("humidity updated to: " + newHumidity + "%");
                break;
            case 3:
                sc.nextLine();
                System.out.println("Enter the new weather condition");
                String newWeatherCondition = sc.nextLine();
                city.setWeatherCondition(newWeatherCondition);
                System.out.println("weather condition updated to: " + newWeatherCondition + "%");
                break;
        }
    }

    //method to identify city with highest and lowest temp
    @Override
    public void hightempLowtemp() {
        System.out.println("city with highest temperature:\n");
        City city = findHighTempCity();
        System.out.println(city.toString());

        System.out.println("city with lowest temperature:\n");
        city = findLowTempCity();
        System.out.println(city.toString());
    }

    //method to identify city with higher threshold
    @Override
    public void humidtyMorethan(int humidity) {
        boolean isfound = false;
        for (City city : CityList) {
            if (city != null && city.getHumidity() >= humidity) {
                System.out.println(city.toString());
                isfound = true;
            }
        }
        if (!isfound) {
            System.out.println("City not found");
        }
    }

    //method to print group of cities based on condition
    @Override
    public void groupCityOnCondition(String weatherCondition) {
        boolean isFound = false;
        for (int i = 0; i < currentIndex; i++) {
            City city = CityList[i];
            if (city.getWeatherCondition().equalsIgnoreCase(weatherCondition)) {
                System.out.println(city.toString());
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("No cities found with the weather condition " + weatherCondition + ".");
        }
    }

    //calculating average temperature across every city
    @Override
    public void calculateAvgTemperature() {
        int avgTEmp = 0;
        for (City city : CityList) {
            avgTEmp += city.getTemp();
        }
        avgTEmp /= currentIndex;
        System.out.println("average temperature across all cities: " + avgTEmp);
    }

    //to issue temp warning to city with a temp higher
    @Override
    public void tempWarning(double temp) {
        boolean isFound = false;
        for (City city : CityList) {
            if (city != null && city.getTemp() >= temp) {
                System.out.println("Heatwave Alert: " + city.getCityName() + " is experiencing extreme heat (" + city.getTemp() + "°C).");
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("No cities found with temperatures above " + temp + "°C.");
        }
    }

    //to find city with low humidity
    @Override
    public void humidityDrop(int humidity) {
        boolean isFound = false;
        for (City city : CityList) {
            if (city != null && city.getHumidity() < humidity) {
                System.out.println("Alert: " + city.getCityName() + " is experiencing low humidity (" + city.getHumidity() + "%).");
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("No cities found with humidity below " + humidity + "%.");
        }
    }


    //helper methods

    public City findCityByName(String cityName) {
        for (City city : CityList) {
            if (city != null && city.getCityName().equalsIgnoreCase(cityName)) {
                return city;
            }
        }
        System.out.println("City not found.");
        return null;
    }

    public City findHighTempCity() {
        City cityHighTemp = CityList[0];
        for (City city : CityList) {
            if (city != null && city.getTemp() > cityHighTemp.getTemp()) {
                cityHighTemp = city;
            }
        }
        return cityHighTemp;
    }

    public City findLowTempCity() {
        City cityLowTemp = CityList[0];
        for (City city : CityList) {
            if (city != null && city.getTemp() < cityLowTemp.getTemp()) {
                cityLowTemp = city;
            }
        }
        return cityLowTemp;
    }

    public City[] getCityList() {
        return CityList;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }
}
