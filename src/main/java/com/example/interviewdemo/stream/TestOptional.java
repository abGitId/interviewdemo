package com.example.interviewdemo.stream;

import java.util.Optional;

public class TestOptional {
  public static void main(String[] args) {
    //
      String str = null;
      String str1 = null;

      Optional<String> stringOptional1 = Optional.ofNullable(str1);
      //-- System.out.println("str = " + Optional.of(str));
      System.out.println("str1 = " + stringOptional1);
      if(stringOptional1.isPresent()){
      System.out.println("stringOptional1.get() = " + stringOptional1.get());
      }
      //-- Optional<String> stringOptional = Optional.of(str);
  }
}
