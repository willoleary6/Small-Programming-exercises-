import java.util.Scanner;
public class Cubing1
{
 public static void main(String [] args)
 {
  int N;
  Scanner in = new Scanner(System.in);
  System.out.print("Enter number to be cubed");
  N = Integer.parseInt(in.nextLine());
  System.out.print(N+"  cubed is  "+(N * N * N));
  }
}