public class Cmd1
{
 public static void main(String [] args)
 {
   boolean validInput = validateInput(args);	 
   int p, s;
   if (validInput)
   {
	  p = Integer.parseInt(args[0]);
	  s = Integer.parseInt(args[1]);
      calculateProjectCost(p, s);
   }	   
  /*int service = 0;
  int category = 0;
  double projectCost;
  
  category = Integer.parseInt(args[0]);
  if(validInput)
  {
    switch(category)
	{
	  case 1 : 
	}	
  }
  */
 }
 public static void calculateProjectCost(int category, int service)
 {
	 switch(p)
	{
	  case 1 : 
	}	
	 
	 
 }
 
 public static boolean validateInput(String args[])	 
 {
   boolean validInput = false;
   String result, pattern = "1|2|3";
   String msg1 = "Usage: java Cmd1 projectCategory serviceType"; 
   String msg2 = "Two command-line arguments only.";
   String msg3 = "Format of input for project category is invalid";
   String msg4 = "Format of input for service type is invalid";
   if (args.length == 0)   result = msg1;
   else if (args.length < 2 || args.length > 2)  result = msg2;
   else
   {
	  if      (!(args[0].matches(pattern)))     result = msg3; 
	  else if (!(args[1].matches(pattern)))     result = msg4; 
	  else
		      validInput = true;
   }	  
   if(!validInput) System.out.print(result);
   return validInput; 
 }
}