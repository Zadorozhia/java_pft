package ru.stqa.pft.sandbox;

/**
 * Created by Виктория on 19.07.2016.
 */
public class Point {
  public double x;
  public double y;

  public Point(double x,double y){
    this.x=x;
    this.y=y;
  }
  public double distance(){
    double dx=this.x-x;
    double dy=this.y-y;
    return Math.sqrt(dx*dx+dy*dy) ;
  }

}
