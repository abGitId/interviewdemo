package com.example.interviewdemo.collection;

import com.example.interviewdemo.entity.City;
import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class TestTreeSet {

  public static void main(String[] args) {
    //
    TreeSet<City> cityTree = new TreeSet<>(cityPopulationComparator);
    cityTree.addAll(City.getCityList());

    System.out.println("cityTree = " + cityTree);
  }

  static Comparator<City> cityPopulationComparator =
      Comparator.comparingInt(City::getPopulation).reversed();
}
