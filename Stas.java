import java.util.Scanner;
public class Stas
{
 public static void main(String [] args)
 {
  // Input and array
  int[] array = new int[10];
  String[] graph = new String[10];
  for (int i = 0; i < graph.length; i++)
	  graph[i] = "";
  
  int aNumber = 0;  
  int x, max = 0, lines;
  Scanner input = new Scanner(System.in);
  System.out.print("Enter input between 1 to 300"+"\n");
  x = Integer.parseInt(input.nextLine());
  String result = "", Error = "Error";
  if (x < 1 || x > 300)
	result = Error;
 // main for loop
 else
   for (int i = 1; i<array.length; i++)
    {
	 if (array[i]>max)
	       max = array[i];
	}
  lines = max;
  for (int i = 0; i < lines; i++)
  {
   for(int j = 0; j < array.length; j++)
   {
    if (array[j]== max)
	{
     System.out.print("*");
     array[j]--;	 
	}
     else
	 System.out.print(" ");
   }
   max--;
   System.out.println();
  
  }
 
 
 }
}
