package ru.stqa.pft.sandbox;

/**
 * Created by Виктория on 07.08.2016.
 */
public class Primes {
  public static boolean isPrimes(int n){
    for(int i=2;i<n;i++){
      if(n%i==0){
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimesWhile(int n){
    int i=2;
    while(i<n){
      if(n%i==0){
        return false;
      }
      i++;
    }
    return true;
  }

  public static boolean isPrimes(long n){
    for(long i=2;i<n;i++){
      if(n%i==0){
        return false;
      }
    }
    return true;
  }
}
