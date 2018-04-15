import javax.swing.JOptionPane;
public class Wages
{
 public static void main(String [] args)
 {
  int x = 100;
  double y = 1;
  String result;
  for (int i = 0; i < 9; i++)
    {
	 x += 100;
	}
   for (int z = 0; z < 10; z++)
    {
     y = (y*2);	
	}
   if ( x > y) result = " Option 1 pays better.";
   else result = "Option 2 pays better.";
   JOptionPane.showMessageDialog(null, result);
  }
}