package com.example.interviewdemo.interfacedemo;

import lombok.Data;

public class TestInterface {

  public static void main(String[] args) {
    //
    I1 i1 = new IImpl();
    i1.show();
  }
}

interface I1 {
  default void show() {
    System.out.println("Executing I1 -> show");
  }
}

interface I2 {
  default void show() {
    System.out.println("Executing I2 -> show");
  }
}

@Data
class IImpl implements I1, I2 {

  @Override
  public void show() {
    System.out.println("Executing IImpl -> show");
    I1.super.show();
    I2.super.show();
  }
}
