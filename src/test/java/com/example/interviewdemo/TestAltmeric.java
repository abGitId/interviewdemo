package com.example.interviewdemo;

import java.util.Arrays;
import java.util.List;

public class TestAltmeric {

  public static void main(String[] args) {
    //
    List<Integer> nos = Arrays.asList(0, 1, 3, 4, 5, 7);

    int counter = 0;
    for (int i = 0; i < nos.size() - 1; i++) {

      if (counter == nos.get(i)) {
        i = nos.get(i);
        counter++;
        continue;
      } else {
          System.out.println("missing nos is = " + counter);
          counter = nos.get(i);
          //-- i = nos.get(i);
      }
    }
  }

  /*public static void main(String[] args) {
    //
      //String input = "Vedanti";
      //-- String input = "aabaa";
      StringBuilder out= new StringBuilder();
      for(int i=input.length()-1 ; i>=0  ; i--){
          out.append(input.charAt(i));
      }
    System.out.println("out = " + out);
      if(input.equals(out.toString())){
      System.out.println(String.format("%s string is palindrome", input));
      }else {
          System.out.println(String.format("%s string is not palindrome", input));
      }
  }*/
}
