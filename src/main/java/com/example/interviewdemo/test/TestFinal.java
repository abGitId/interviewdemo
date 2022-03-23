package com.example.interviewdemo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFinal {

  public static void main(String[] args) {
    //
      final String[] strArr = {"tata","kia","maruti suzuki","mahindra"};
      final List<String> autoCompanies = Arrays.asList(strArr);
      System.out.println("strArr = " + Arrays.asList(strArr));
      System.out.println("autoCompanies = " + autoCompanies);
      strArr[0]="hyundai";
      autoCompanies.add("hyundai");
      System.out.println("strArr = " + Arrays.asList(strArr));
      System.out.println("autoCompanies = " + autoCompanies);
  }
}
