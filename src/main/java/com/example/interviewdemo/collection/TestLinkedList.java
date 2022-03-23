package com.example.interviewdemo.collection;

import java.util.LinkedList;

public class TestLinkedList {
  public static void main(String[] args) {
    //
      LinkedList<String> populatedCityList = new LinkedList<>();

      populatedCityList.add("Mumbai");
      populatedCityList.add("Pune");
      populatedCityList.add("Nashik");
      populatedCityList.add("Aurangabad");
      populatedCityList.add(2,"Nagpur");

    System.out.println("populatedCityList = " + populatedCityList);

    populatedCityList.addFirst("Navi mumbai");
    populatedCityList.addLast("Kolhapur");

      System.out.println("populatedCityList = " + populatedCityList);
      populatedCityList.remove(2);
      System.out.println("populatedCityList = " + populatedCityList);

    System.out.println("populatedCityList 1st index= " + populatedCityList.get(1));
      populatedCityList.getFirst();

  }

    /*public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] >= 5)
            {
                System.out.println("exit...");

                // Terminate JVM
                System.exit(0);
            }
            else
                System.out.println("arr["+i+"] = " +
                        arr[i]);
        }
        System.out.println("End of Program");
    }*/
}
