package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Виктория on 07.08.2016.
 */
public class Collections {
  public static void main(String[]args){
    List<String> langs= Arrays.asList("Java","C#","Python","PHP");

    for(String l:langs){
      System.out.println("Я хочу выучить "+l);
    }
  }
}
