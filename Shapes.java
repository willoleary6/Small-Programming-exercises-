import javax.swing.JOptionPane;
public class Shapes
{
 public static void main(String [] args)
 {
  String menuMessage, error;
  error = "User error, please restart program and try again";
  double pi = 3.14, sideLength, base, height, radius, area;
  menuMessage = "Choose an option from the following menu:";
  menuMessage += "\n"+"1. Calculate area of circle";
  menuMessage += "\n"+"2. Calculate area of square";
  menuMessage += "\n"+"3. Calculate area of triangle";
  int option;
  option = Integer.parseInt(JOptionPane.showInputDialog(null, menuMessage));
  if (option == 1)
   {
     radius = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter radius", 1 ));
     area = (pi*radius*radius);
     JOptionPane.showMessageDialog(null, "The circle area is "+ area);
   }
  else if (option == 2)
   {
	 sideLength = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter length of side"));
	 area = (sideLength*sideLength);
	 JOptionPane.showMessageDialog(null, "The square area is "+ area );
   }
  else if (option == 3)
  {
	 base = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter base length"));
	 height = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter height length"));
	 area = (.5*base*height);
	 JOptionPane.showMessageDialog(null, "The triangle's area is "+ area );
  }
  else
	  JOptionPane.showMessageDialog(null, error );
 }
}