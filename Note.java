import javax.swing.JOptionPane;
public class Note
{
 public static void main(String [] args)
 {
  int [] array = new int[7];
  String result = "";
  int aNumber = 0;
  int input = JOptionPane.showInputMessage(null,"How many random notes would you like?"+"\n"
    +"(Input must be in range 1 to 50)");
  if (input < 1 || input > 50 )
    result = "Invalid input";
  else 
   {
	for(int i = 1; i <= input; i++)
      {
	   aNumber = (int)(math.random() * 7);
	   array [aNumber]++;
	  }
     result = "Count of each note is as follows" + "\n"
	                +"A: "+ array[0]+"\n"
					+"B: "+ array[1]+"\n"
					+"C: "+ array[2]+"\n"
					+"D: "+ array[3]+"\n"
					+"E: "+ array[4]+"\n"
					+"F: "+ array[5]+"\n"
					+"G: "+ array[6]+"\n"
   }
   JOptionPane.showMessageDialog(null,result); 
 }
}