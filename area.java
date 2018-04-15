import javax.swing.JOptionPane;
public class Area
{
 public static void main(String [] args)
 {
  double ROC, LOS , BOT , HOT;
  ROC = 25;
  LOS = 5;
  BOT = 5;
  HOT = 5;
  JOptionPane.showMessageDialog(null," Area of a circle: "+(3.14 * (ROC * ROC))+
  "\n"+"Area of square: "+(LOS * LOS)+
  "\n"+"Area of triangle: "+(.5 * (BOT * HOT)) ,1);
  
  }
}