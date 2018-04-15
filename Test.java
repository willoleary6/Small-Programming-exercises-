import javax.swing.JOptionPane;
public class Test
{
 public static void main(String [] args)
 {
  JOptionPane.showMessageDialog(null, Duration[1]);
 } 
 public static double populate()
 {
  double [] Tune = new double [2];
  double [] Duration = new double [2];
  for (int i = 0; i < Tune.length; i++)
   {
	Tune[i] = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Tune number"));
    Duration [i] = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter duration of Tune "+Tune[i]));
   }
  return Duration [] 
 }
} 