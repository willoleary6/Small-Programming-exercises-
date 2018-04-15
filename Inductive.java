import java.lang.*;
import javax.swing.*;
public class Inductive
{
 public static void main(String [] args)
 {
  int a = NumberGenerator();
  int n = NumberGenerator();
  int Q1 = iterate(a,n);
  int Q2 = recursive(a,n);
  int Q3 = iterate2(a,n);
 }
 public static int NumberGenerator()
 {
  int a = Integer.parseInt(JOptionPane.showInputDialog(null," enter value"));
  return a;
 }
 public static int iterate(int a, int n)
 {
   System.out.println("");
   System.out.println("iterative implementation");
   int i = 1;
   int total = 0;
   int power = 1;
   while(i <= n)
   {
	power = power*a;
	total = power;
    i++;
   }
  System.out.println(total);
  return power;
 }
 public static int recursive(int a, int n)
 {
   System.out.println("");
   System.out.println("recursive implementation");
   int i = 1;
   int total = 0;
   int power = 1;
   while(i <= n)
   {
	power = power * a;
    n--;
   }
  total = power;
  System.out.println(total);
  return power;
 }
 public static int iterate2(int a, int n)
 {
  System.out.println("");
  System.out.println("iterative implementation (for loop)");
  int power = 1;
  int total = 0;
  for(int i = 1; i <=n;i++)
  {
	power = power*a;
  }	  
  total = power;
  System.out.println(total);
  return power;
 } 
}