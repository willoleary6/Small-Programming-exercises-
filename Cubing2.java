import javax.swing.JOptionPane;
public class Cubing2
{
 public static void main(String [] args)
 {
  int N;
  String result;
  N = Integer.parseInt(JOptionPane.showInputDialog(null, " Enter number to be cubed"));
  result = N + " Cubed =" + (N*N*N);
  JOptionPane.showMessageDialog(null, result);
  }
}