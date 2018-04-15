import javax.swing.JOptionPane;
public class CorrectDate
{
 public static void main(String [] args)
 {
  int d = 0,m = 0,y = 0;
  int [] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
  boolean ValidDate = true;
  boolean LeapYear = false;
  d = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the date of the month"+"\n"
  +"between 1-31 depending on month or year"));
  if (d <= 0 || d > 31)
    ValidDate = false;
  else 
  m =Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the month of the year"+"\n"
  +"between 1-12 "));
  if (m <= 0 || m >12)
  ValidDate = true;
  else
  y = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the year"));
  if(d <= 0 || m<= 0 || y <=0)
   ValidDate = false;
  else if (m == 2 && d == 29 && LeapYear == false)	
   ValidDate = false; 
  else if (d > days[m - 1])               
   ValidDate = false;
  else if ((y % 4 == 0) && (y % 100 != 0) || (y % 400 == 0));
   LeapYear = true;
   
   
   JOptionPane.showMessageDialog(null, ValidDate);
  }
}