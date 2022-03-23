package com.example.interviewdemo.stream;

import com.example.interviewdemo.entity.City;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {

  public static void main(String[] args) {
    //

    List<City> cityList = City.getCityList();
    /*System.out.println("USING for loop");
    for (City city : cityList) {
        if ("Maharashtra".equals(city.getState())) {
            System.out.println("city = " + city);
        }
    }*/
      System.out.println("USING stream");

      List<City> cities = cityList.stream().filter(city -> "Maharashtra".equals(city.getState())).collect(Collectors.toList());
      System.out.println("cities = " + cities);


      List<String> States =
        cityList.stream()
            .map(city -> city.getState())
            .collect(Collectors.toList());
    System.out.println("States = " + States);
      long stateCount =
              cityList.stream()
                      .map(city -> city.getState())
                      .count();
    System.out.println("stateCount = " + stateCount);

      Map<String, List<City>> listMap = cityList.stream().collect(Collectors.groupingBy(city -> city.getState()));
    System.out.println("=============================\n");
    System.out.println("listMap = " + listMap);
  }
}
