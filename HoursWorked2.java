import javax.swing.JOptionPane;
public class HoursWorked2
{
 public static void main(String [] args)
 {
  int N;
  String result;
  N = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter minutes worked"));
  result = "The minutes you have worked are "+N+ " minutes"+
  "\n"+ "The hours and minutes you have worked are "+N/60+" Hours and "+ N%60+" Minutes";
 JOptionPane.showMessageDialog(null, result);
 }
}