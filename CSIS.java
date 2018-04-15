import javax.swing.JOptionPane;
public class CSIS
{
 public static void main(String [] args)
 {
  int BookCategory;
  String result;
  BookCategory = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Book category"));
  if (BookCategory < 1 || BookCategory > 3)
       result =  "Please enter a valid book category";
       JOptionPane.showMessageDialog(null, result);
	  else if (BookCategory == 1) 
       JOptionPane.showMessageDialog(null, "Subject area = Fitness "+
	  "\n"+"number of books = 2 "+
	  "\n"+"total cost including packaging =\u20AC75 ");
	   else if (BookCategory == 2) 
	   JOptionPane.showMessageDialog(null, "Subject area = Computing "+
	  "\n"+"number of books = 2 "+
	  "\n"+"total cost including packaging =\u20AC70 ");
	   else if (BookCategory == 3) 
	   JOptionPane.showMessageDialog(null, "Subject area = Arts and crafts "+
	  "\n"+"number of books = 2 "+
	  "\n"+"total cost including packaging =\u20AC61.5 ");
  }
}