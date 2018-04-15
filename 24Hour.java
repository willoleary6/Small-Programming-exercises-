import javax.swing.JOptionPane;
public class 24Hour
{
 public static void main(String [] args)
 {
  int h, min;
  String result, ErrorMessage1, ErrorMessage2;
  ErrorMessage1 =" error you have not entered a valid hour";
  ErrorMessage2 =" error you have not entered a valid minute";
  h = JOptionPane.showInputDialog(null, please enter the hour in 24 hour format);
  min = JOptionPane.showInputDialog(null, please enter the minutes);
  if (h < 0 || h > 23 ) result = ErrorMessage1;
  if (min < 0 || min > 59)  result = ErrorMessage2;
  else 
     if ( h > 12 ) result = h-12+":"+min+"pm"; 
     else if ( min < 10) result =  h+":"+"0"+min;
  JOptionPane.showMessageDialog(null, result);
 }
}