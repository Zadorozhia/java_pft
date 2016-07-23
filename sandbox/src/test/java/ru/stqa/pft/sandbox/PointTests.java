package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Виктория on 23.07.2016.
 */
public class PointTests {

  @Test
  public void testDistance1()

  {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 5);
    Assert.assertEquals(p1.distance(p2), 5.0);
  }

  @Test
  public void testDistance2()

  {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, -5);
    Assert.assertEquals(p1.distance(p2), 5.0);
  }

  @Test
  public void testDistance3()

  {
    Point p1 = new Point(3, 4);
    Point p2 = new Point(-3, -4);
    Assert.assertEquals(p1.distance(p2), 10.0);
  }
  @Test
  public void testDistance4()

  {
    Point p1 = new Point(1, 2);
    Point p2 = new Point(9, 6);
    Assert.assertEquals(p1.distance(p2), 8.94427190999916);
  }
}

