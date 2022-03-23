package com.example.interviewdemo.exceptions;

import java.io.IOException;

public class TestExp1 {
  public static void main(String[] args) {
    //
      A a=new B();
      //-- a.m1();
  }
}

class A
{
    public void m1() throws IOException
    {
        System.out.println("In m1 A");
    }

    public void m2()
    {
        System.out.println("In m2 A");
    }

    // throws checked exception
    public void m3() throws IOException
    {
        System.out.println("In m3 A");
    }

    // throws runtime exception or unchecked exception
    public void m4() throws NullPointerException
    {
        System.out.println("In m4 A");
    }
}


class B extends A
{
    public void m1() /*throws IOException*/
    {
        System.out.println("In m1 B");

    }

    // gives compile time error because overridden method
    // does not throw given checked exception
   /* public void m2() throws IOException
    {
        System.out.println("In m2 A");
    }

    // gives compile time error because overridden method
    // does not throw given checked exception
    public void m3() throws Exception
    {
        System.out.println("In m3 A");
    }*/

    // does not gives compile time error because overridden method
    // does throw any runtime family exception or unchecked exception
    public void m4() throws ArrayIndexOutOfBoundsException
    {
        System.out.println("In m4 A");
    }
}


class C
{
    public void m1() throws ArrayIndexOutOfBoundsException
    {
        System.out.println("In m1 A");
    }
}


class D extends C
{
    public void m1() throws IndexOutOfBoundsException
    {
        System.out.println("In m1 B");
    }
}

