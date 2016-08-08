package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Виктория on 07.08.2016.
 */
public class PrimesTests {
  @Test
  public void testPrimes(){
    Assert.assertTrue(Primes.isPrimes(Integer.MAX_VALUE));
  }

  @Test(enabled=false)
  public void testPrimesLong(){
    long n=Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrimes(n));
  }

  @Test
  public void testNonPrimes(){
    Assert.assertFalse(Primes.isPrimes(Integer.MAX_VALUE-2));
  }
}
