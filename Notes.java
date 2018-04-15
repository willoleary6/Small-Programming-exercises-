import javax.swing.JOptionPane;
public class Notes
{
 public static void main(String [] args)
 {
  int aNumber = 0;
  int [] notes = new int [7];
  String result = "", Error = "Error input outside of bounds";
  int n = Integer.parseInt(JOptionPane.showInputDialog(null,"How many random notes would you like"+"\n"
  +"(Input must be in the range 1 to 50)?"));
  if ( n < 1 || n > 50 ) 
    result = Error;
   else 
   { 
      for ( int i = 1; i<=n; i++)
       {
        aNumber = (int)(Math.random() * 7);
	    notes [aNumber]++;
       }
     
    result = "Count of each note is as follows:"+"\n"
                + "A: "+ notes[0]+"\n"
                + "B: "+ notes[1]+"\n"
       		    + "C: "+ notes[2]+"\n"
                + "D: "+ notes[3]+"\n"
                + "E: "+ notes[4]+"\n"
                + "F: "+ notes[5]+"\n"
                + "G: "+ notes[6];
   }
  JOptionPane.showMessageDialog(null, result);			
  }  
}