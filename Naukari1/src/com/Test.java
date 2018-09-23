package com;

import java.io.PrintStream;

public class Test
{
  public Test() {}
  
  static int add()
  {
    try {
      System.err.println("in try");

    }
    catch (Exception e) {}finally
    {
      System.out.println("in finally"); }
    return 3;
  }
  

  public static void main(String[] args)
    throws java.sql.SQLException
  {
    System.out.println("Done " + add());
  }
}