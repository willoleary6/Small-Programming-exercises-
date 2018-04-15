import javax.swing.JOptionPane;
public class Copy
{
 public static void main(String [] args)
 {
  int Copies, Cost;
  
  Copies = Integer.parseInt(JOptionPane.showInputDialog(null, " Please enter the number of copies to be copied"));
  if (Copies <= 100)
   Cost = Copies*(.05);
  else if (Copies > 100)
   Cost = (100*.05)+((Copies - 100)*.03);
  JOptionPane.showMessageDialog(null, Cost);
  }
}