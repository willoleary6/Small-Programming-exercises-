import javax.swing.JOptionPane;
public class Sum
{
 public static void main(String [] args)
 {
 int N;
 N = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter a 6 digit number"));
 int result;
 int N1, N2, N3, N4, N5, N6;
 N1 = (N%10);
 N2 = ((N/10)%10);
 N3 = ((N/100)%10);
 N4 = ((N/1000)%10);
 N5 = ((N/10000)%10);
 N6 = ((N/100000)%10);
 result = N1+N2+N3+N4+N5+N6;
 JOptionPane.showMessageDialog(null, result);
 }
}
 