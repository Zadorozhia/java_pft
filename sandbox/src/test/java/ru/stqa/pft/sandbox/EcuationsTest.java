package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Виктория on 04.08.2016.
 */
public class EcuationsTest {
  @Test
  public void test0(){
    Ecuation e=new Ecuation(1,1,1);
    Assert.assertEquals(e.rootNumber(),0);
  }
  @Test
  public void test1(){
    Ecuation e=new Ecuation(1,2,1);
    Assert.assertEquals(e.rootNumber(),1);
  }
  @Test
  public void test2(){
    Ecuation e=new Ecuation(1,5,6);
    Assert.assertEquals(e.rootNumber(),2);
  }
}
