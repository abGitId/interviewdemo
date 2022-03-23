package com.example.interviewdemo.example;

public class DuplicateNoTest {

  public static void main(String[] args) {
    // identify duplicate nos from array
    int[] inputArr = {1, 5, 6, 9, 1, 4, 3, 5, 7, 8, 2, 8, 5};

    findDuplicateNosUsingForLoop(inputArr);
  }

  /*
   * identify duplicate nos from array using for loos
   * */
  public static void findDuplicateNosUsingForLoop(int[] noArr) {

    for (int i = 0; i < noArr.length; i++) {

      for (int j = i + 1; j < noArr.length; j++) {
        if (noArr[i] == noArr[j]) {
          System.out.println(" " + noArr[i]);
        }
      }
    }
  }

  /*
   * identify duplicate nos from array using for another intArray
   * */
}
