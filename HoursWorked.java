import java.util.Scanner;
public class HoursWorked
{
 public static void main(String [] args)
 {
  Scanner in = new Scanner(System.in);
  int N;
  System.out.print("Enter the minutes you have worked");
  N = Integer.parseInt(in.nextLine());
  System.out.print("The minutes you have worked are "+N+
  "\n"+" The Hours and minutes you have worked are "+ N/60+" Hours and "+ N%60+" minutes");
  }
}