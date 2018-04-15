import javax.swing.JOptionPane;
public class Min
{
 public static void main(String [] args)
 {
  int min, N1, N2, N3, N4;
  N1 = Integer.parseInt(JOptionPane.showInputDialog(null, " Enter the first number"));
  N2 = Integer.parseInt(JOptionPane.showInputDialog(null, " Enter the second number"));
  N3 = Integer.parseInt(JOptionPane.showInputDialog(null, " Enter the third number"));
  N4 = Integer.parseInt(JOptionPane.showInputDialog(null, " Enter the fourth number"));
  min = N1;
  if (N2<min)  min = N2;
  if (N3<min)  min = N3;
  if (N4<min)  min = N4;
  JOptionPane.showMessageDialog(null, min );
 }
}