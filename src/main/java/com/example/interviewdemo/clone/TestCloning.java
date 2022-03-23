package com.example.interviewdemo.clone;

import com.example.interviewdemo.entity.City;

public class TestCloning {
  public static void main(String[] args) {
    City city1 =
        City.builder().name("Pune").state("Maharashtra").pin(411001).population(3124458).build();

    //-- City cityClone = city1.cloning();
    City cityClone = city1;

    System.out.println("city1 = " + city1);
    System.out.println("cityClone = " + cityClone);
    System.out.println("city1.hashCode() = " + city1.hashCode());
    System.out.println("cityClone.hashCode() = " + cityClone.hashCode());
    city1.setName("satara");
    System.out.println("after updating city data");
    System.out.println("city1 = " + city1);
    System.out.println("cityClone = " + cityClone);
    System.out.println("city1.hashCode() = " + city1.hashCode());
    System.out.println("cityClone.hashCode() = " + cityClone.hashCode());
  }
}
