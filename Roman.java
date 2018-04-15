import javax.swing.JOptionPane;
public class Roman
{
 public static void main(String [] args)
 {
  int UI;
  String result, errorMessage;
  result = " the equivalent Roman Numeral is ";
  errorMessage = "invalid input";
  UI = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number you wish to be converted between 1 - 10"));
  if (UI < 1 || UI > 10)
     result = " Invalid input - rerun program and try again";
  else
  {
    if       (UI == 1) result = result + "I";
	else if  (UI == 2) result = result + "II";
	else if  (UI == 3) result = result + "III";
	else if  (UI == 4) result = result + "IV";
	else if  (UI == 5) result = result + "V";
	else if  (UI == 6) result = result + "VI";
	else if  (UI == 7) result = result + "VII";
	else if  (UI == 8) result = result + "VIII";
	else if  (UI == 9) result = result + "IX";
	else               result = result + "X";
  }
  JOptionPane.showMessageDialog(null,result,1);
 }
}