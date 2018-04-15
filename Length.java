import java.util.Scanner;
public class Length
{
 public static void main(String [] args)
 {
 Scanner in = new Scanner(System.in);
 int Length;
 System.out.print("Enter the length of the room");
 Length = Integer.parseInt(in.nextLine());
 Scanner in2 = new Scanner(System.in);
 int Width;
 System.out.print("Enter the width of the room");
 Width = Integer.parseInt(in.nextLine());
 System.out.print(Length*Width);
 }
}