public class Dice
{
 public static void main(String [] args)
 {
  int x, y, n1 = 0, n2 = 0, n3 = 0, n4 = 0, n5 =0, n6 = 0;
   for( y = 0; y < 600; y++)
    {
	 x = (int)(math.random()*6)+1;
	  if (x == 1) n1++;
	  else if (x == 2) n2++;
	  else if (x == 3) n3++;
	  else if (x == 4) n4++;
	  else if (x == 5) n5++;
	  else if (x == 6) n6++;
	}
  System.out.print("Face"+"\t"+"Frequency");
 }
}