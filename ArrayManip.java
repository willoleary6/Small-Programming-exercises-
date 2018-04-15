import javax.swing.JOptionPane;
public class ArrayManip
{
 public static void main(String [] args)
 {
  int [] MyArray ={1, 2, 3, 4, 5};
  int num = 3;
  boolean result = searchNum(MyArray, num);
  if( result = true)
	{
	 JOptionPane.showMessageDialog(null,"number found" );
    }
  else if(result = false)
	{
	 JOptionPane.showMessageDialog(null,"number not found" );
    }  
  testSearchNum();
 }
  public static boolean searchNum(int [] MyArray, int num)
  {
   boolean result = true;
   for(int i = 0; i < MyArray.length; i++)
   {
    if ( num == MyArray[i])
	 result = false;
   }   
   return result;  
  }  
  public static void testSearchNum()
  {
   int [] InputArray = new int [Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the size of your array"))];
   for(int j = 0; j < InputArray.length; j++)
   {
    InputArray[j] = Integer.parseInt(JOptionPane.showInputDialog(null," please enter the number for position "+ j));
   }
   int YourNum = Integer.parseInt(JOptionPane.showInputDialog(null,"enter number"));
   boolean result = true;
   for(int i = 0; i < InputArray.length; i++)
   {
    if ( YourNum == InputArray[i])
	result = false;
   } 
   if(result = true)
	 JOptionPane.showMessageDialog(null,"number found" );
   else
     JOptionPane.showMessageDialog(null,"number not found" );  
  }
}