package com.java8.demo.stream;

 class A { 
  int x = 20;
}
 class B extends A {
  int x = 30;
}
public class Test {
public static void main(String[] args) 
{
  int[] ip = {-3, -4, 5, -1, 2, -4, 6, -1};
      //Output: 8


      //Input: [-2, 3, -1, 2]
      //Output: 4
      //
  int sum = 0;
      for (int i=0; i<ip.length; i++) {
        sum = ip[i];
        int temp = ip[i]; 
        for (int j=i+1; j<ip.length; j++) {
            temp += ip[j]; 
            if(temp > sum) {
              continue;   
            }else{
              sum = temp;   
            }
        } 
      }
      System.out.println(sum);
 }
}