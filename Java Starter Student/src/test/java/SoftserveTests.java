/**
 * Created by Виктория on 21.11.2016.
 */
public class SoftserveTests {
  //for____________________________________________________________________
  static void example1(){
    int y=1;
    int k;
    int i=0;
    for(k=6;k>=3;k--){
      y=y+k;
      i++;
    }
    System.out.println("Пример №1");
    System.out.println("y= "+y);
    System.out.println("k= "+k);
    System.out.println("i= "+i);
  }
  static void example2(){
    int y=6;
    int k;
    int i=0;
    for(k=1;k<=6;k++){
      y=y+k;
      y=y*10;
      i++;
    }
    System.out.println("Пример №2");
    System.out.println("y= "+y);
    System.out.println("k= "+k);
    System.out.println("i= "+i);
  }
  static void example3(){
    int y=2;
    int k;
    int i=0;
    for(k=7;k<=2;k++){
      y=y+k;
      i++;
    }
    System.out.println("Пример №3");
    System.out.println("y= "+y);
    System.out.println("k= "+k);
    System.out.println("i= "+i);
  }
  static void example6(){
    int y=0;
    int k;
    int i=0;
    for(k=1;k<=4;k++){
      y=y*10;
      y=y+k;
      i++;
    }
    System.out.println("Пример №6");
    System.out.println("y= "+y);
    System.out.println("k= "+k);
    System.out.println("i= "+i);
  }
  static void example7(){
    int y=0;
    int k;
    int i=0;
    for(k=2;k<=6;k++){
      y=y+k;
      i++;
    }
    System.out.println("Пример №7");
    System.out.println("y= "+y);
    System.out.println("k= "+k);
    System.out.println("i= "+i);
  }
  static void example10(){
    int y=1;
    int k;
    int i=0;
    for(k=6;k<=3;k++){
      y=y+k;
      i++;
    }
    System.out.println("Пример №10");
    System.out.println("y= "+y);
    System.out.println("k= "+k);
    System.out.println("i= "+i);
  }
  //while_______________________________________________________________________________
  static void example4(){
    int y=0;
    int k=4;
    int i=0;
    while (k>1){
      y=y+1/k;
      k=k-1;
      i++;
    }
    System.out.println("Пример №4");
    System.out.println("y= "+y);
    System.out.println("k= "+k);
    System.out.println("i= "+i);
  }
  static void example8(){
    int y=0;
    int k=10;
    int i=0;
    while (k>1){
      k=k-2;
      y=y+k;
      i++;
    }
    System.out.println("Пример №8");
    System.out.println("y= "+y);
    System.out.println("k= "+k);
    System.out.println("i= "+i);
  }
  //do while__________________________________________________________________________
  static void example5(){
    int y=0;
    int k=3;
    int i=0;
    do{
      k=k*2;
      y=y+k;
      i++;
    }
    while (k<7);
    System.out.println("Пример №5");
    System.out.println("y= "+y);
    System.out.println("k= "+k);
    System.out.println("i= "+i);
  }
  static void example9(){
    int y=1;
    int k=2;
    int i=0;
    do{
      k=k*2;
      y=y+k;
      i++;
    }
    while (k<5);
    System.out.println("Пример №9");
    System.out.println("y= "+y);
    System.out.println("k= "+k);
    System.out.println("i= "+i);
  }

  public static void main(String[] args) {
    example1();
    example2();
    example3();
    example4();
    example5();
    example6();
    example7();
    example8();
    example9();
    example10();
  }


}
