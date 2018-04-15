import java.util.Scanner;
public class Stars
{
 public static void main(String [] args)
 {
  // Input and array
  String[] graph = new String[10];
  for (int i = 0; i < graph.length; i++)
	  graph[i] = "";
  
  int aNumber = 0;  
  int x;
  Scanner input = new Scanner(System.in);
  System.out.print("Enter input between 1 to 300"+"\n");
  x = Integer.parseInt(input.nextLine());
  String result = "", Error = "Error";
  if (x < 1 || x > 300)
	result = Error;
 //for main for loop
 else
   for ( int i = 1; i < x; i++)
	 {
		 aNumber = (int)((Math.random() * 100)/10);
		 graph[aNumber] += "*";
	 } 
	 for (int i = 0; i < graph.length; i++)
	System.out.println(graph[i]);
	
  
 }
}