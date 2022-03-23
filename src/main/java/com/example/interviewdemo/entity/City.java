package com.example.interviewdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City implements Cloneable {
  private String name;
  private String state;
  private int pin;
  private int population;

  public static List<City> getCityList() {
    return Arrays.asList(
        City.builder().name("Pune").state("Maharashtra").pin(411001).population(3124458).build(),
        City.builder().name("Hyderabad").state("Telangana").pin(500001).population(9482000).build(),
        City.builder().name("Mumbai").state("Maharashtra").pin(400001).population(12478447).build(),
        City.builder().name("Mumbai").state("Maharashtra").pin(400001).population(12478448).build(),
        City.builder()
            .name("bangalore")
            .state("Karnataka")
            .pin(560001)
            .population(8443675)
            .build());
  }

  public City cloning() {
    try {
      return (City) super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
      System.out.println("CloneNotSupportedException is caught");
      return this;
    }
  }

  @Override
  protected City clone() throws CloneNotSupportedException {
    return (City) super.clone();
  }
}
