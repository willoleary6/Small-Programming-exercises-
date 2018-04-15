import javax.swing.JOptionPane;
public class Length2
{
 public static void main(String [] args)
 {
 int L;
 int W;
 String result;
 L = Integer.parseInt(JOptionPane.showInputDialog(null, " Enter the length of the room in metres"));
 W = Integer.parseInt(JOptionPane.showInputDialog(null, " Enter the Width of the room in metres"));
 result = " The area of the room is "+ L*W+" metres squared";
 JOptionPane.showMessageDialog(null,result);
 }
}