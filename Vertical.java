public class Vertical
{
 public static void main(String[] args)
 {
  int numbers[] = {12,6,8,13,3,5,11};
  int max = numbers [4];
  int lines;
  for (int i = 1; i<numbers.length; i++)
    {
	 if (numbers[i]>max)
	       max = numbers[i];
	}
  lines = max;
  for (int i = 0; i < lines; i++)
  {
   for(int j = 0; j < numbers.length; j++)
   {
    if (numbers[j]== max)
	{
     System.out.print("*");
     numbers[j]--;	 
	}
     else
	 System.out.print(" ");
   }
   max--;
   System.out.println();
  
  }
 
 
 }
}
