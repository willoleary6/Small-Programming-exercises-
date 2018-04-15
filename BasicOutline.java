import java.util.*;
import java.io.*;
public class BasicOutline
{
	/* **Added in some validation methods. Let me know if they're not compatible with your methods.
		I have no problem changing them ** */
	public static ArrayList<ArrayList<String>> contactInfo = new ArrayList<ArrayList<String>>();	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String [] args) throws IOException
	{	
		String pattern = ".*\\.txt";
		boolean alreadyExisted = true;
		
		if(args.length != 1)
			System.out.print("Java Usage: java ContactsApp Anyfile.txt");//these check the user's input.
		else if(!(args[0].matches(pattern)))
			System.out.print("Your command line argument must be a .txt file.");
		else
		{	
			String [] fromMenu;
			String createFile = "", fileName = args[0], input = "";
			File contacts = new File(fileName);
	
			if(!contacts.exists())
			{
				alreadyExisted = false;
				System.out.print("No such file found. Would you like to create a file? (Y/y/N/n): ");
				createFile = valOne();
				if(createFile.equals("y"))
				{
					FileWriter aFileWriter = new FileWriter(fileName);
					PrintWriter out = new PrintWriter(aFileWriter);
					out.print("");
					out.close();
					aFileWriter.close(); //(not sure if these should be closed here or later on)
				}
			}
				
			
			if(contacts.exists())//this is where the main part of the program begins.
			{	
				for(int i = 0; i < 6; i++)
					contactInfo.add(new ArrayList<String>());	//arrayList with ONLY!!!!!!!! 6 columns
				
				if(alreadyExisted)
					getData(contacts);
				
				input = menuMethod();//validate(should probably call from the menuMethod itself)
				fromMenu = input.split(",");
				while(!fromMenu[0].equals("q"))
				{	
					if(fromMenu[0].equals("i"))
						insert();
					else if(fromMenu[0].equals("r"))
						remove();
					else if(fromMenu[0].equals("e"))
						edit();
					else if(fromMenu[0].equals("d"))
						display(contactInfo);
					else if(fromMenu[0].equals("s"))
						search(contactInfo);
			
					input = menuMethod();//validate
					fromMenu = input.split(",| ");
				}
				moveToFile(fileName);
			}		
		}
	}	
	
	public static void insert()
	{
		/*
			to validate each non name entry you should call the findType() method then call the relevant validation method.
			if all the entries are valid then insert them into the arraylist.
		*/
		
	}
	
	public static void remove() throws IOException 
	{
		/*
			to validate the non name entry you should call the findType() method then call the relevant validation method.
			if the entry are valid then remove the contact from the arraylist.
		*/
		System.out.println("To remove a contact please enter surname, forename, "+"\n"
		+" and a landline or mobile or email or address" + "ie blogs,Joe,JBlogs@gmail.com");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		int Choice;
		boolean cran = true;
		boolean correct = true;
		String [] selection = input.split(",");
		if(selection[2].startsWith("08"))
		{
         Choice = 3; 
        }
	    else if(selection[2].startsWith("0"))
        {
        Choice = 2;
        }
	    else if(selection[2].contains("@")) 
        {
        Choice = 4;
        }
	    else
	    {
        Choice = 5; 
       }	
       for(int i = 0; i < contactInfo.size(); i++)
	    {  
		   if(contactInfo.get(Choice).get(i).contains(selection[2])) 
			{
			 for(int j = 0; j < contactInfo.size(); j++)
			 {
		       System.out.println(contactInfo.get(j).get(i));  
		     }
		    }
		}   
	}
 	
	
	public static void edit()
	{
		/*
			check if the data entered is in the multi d arrayList
			if it is then call the validation method for the piece of information that will be replacing the old information.
		*/
		
	}
	
    public static void display(ArrayList<ArrayList<String>> contactInfo) throws IOException
	{
     String [] InfoTypes = {"Surname:   \t","Forename:\t","Landline:\t",
     "Mobile:     \t", "Email address:\t", "postal address:\t"};
     int counter = 0;  
     int TotalContacts = contactInfo.size();
     int Screens = 0;
	 for(int i = 0; i <contactInfo.size(); i++)
     {
	  DisplayProcess(contactInfo,counter,TotalContacts,Screens, InfoTypes, i);
	  counter++;
	 }  
       System.out.println("\n"+ "All contacts displayed,"+"\n"+"Returning to menu:");	 
    }	
	
	public static void search(ArrayList<ArrayList<String>> contactInfo)throws IOException
	{
	 // main search driver calls on the searchmenu and searchdisplay methods - William O'Leary
	 System.out.println("please enter either "+
	 "\n"+"the first letter of desired contacts surname i.e 'W'"+
	 "\n"+"the area code of their landline ie. '066'"+
	 "\n"+"the prefix of there mobile phone ie. '087'"+
	 "\n"+"the domain of their email ie. @ul.ie");
	 String [] options = {"s","f","l","m","e","q"};
	 Scanner in = new Scanner(System.in);
	 int Choice;
	 String	Input = in.nextLine(); 
	 if(Input.startsWith("08"))
	 {
       Choice = 3; 
     }
	 else if(Input.startsWith("0"))
     {
      Choice = 2;
     }
	 else if(Input.startsWith("@")) 
     {
      Choice = 4;
     }
	 else
	 {
      Choice = 0; 
     }	
	 SearchDisplay(Choice,contactInfo, Input);
	 System.out.println("\n"+"Returning to main menu"+"\n");	
    } 
	public static String menuMethod() throws IOException
	{
	     //Main menu method written by william o leary, method prints options to user and calls the menuprocess method to process selection
		 boolean Valid = false;
         String input= "";
		 String options = "iredsq";
		while(Valid == false)
         {
          System.out.println("MAIN MENU:");
		  System.out.println("Please enter the operation "+"\n"+
		  "you wish to use.");
		  System.out.println("i(nsert)"+"\t"+"r(emove)"+"\t"+"e(dit)"+"\n"+
          "d(isplay)"+"\t"+"s(earch)"+"\t"+"q(uit)");
          Scanner in = new Scanner(System.in);
		  input = in.nextLine();
		  Valid = MenuProcess(options, input, Valid);
        }    	 
       return input;
	}
	
	public static String valOne()
	{
		String createFile = "";
		
		createFile = sc.nextLine();
		createFile = createFile.toLowerCase().trim();
		while(!createFile.equals("y") && !createFile.equals("n"))
		{
			System.out.print("\nInvalid Input. Enter (Y/y/N/n): ");
			createFile = sc.nextLine();
		}
		return createFile;
	}
	
	public static boolean valNumber(String number, int type) //one argument is the number one indicates if it's a landline or mobile. 0=mobile
	{		
		String [] numberSplit;
		String [] validCases;
		int length = 0;
		boolean valid = false;
		if(type == 0)
			validCases = new String[]{"083", "085", "086", "087", "089"};
		
		else
			validCases = new String[]{"01", "02", "021", "023", "024", "025", "026", "027", "028", "029", "0402", "0404", "041", "042", 
				"043", "044", "045", "046", "047", "049", "0504", "0505", "051", "052", "053", "056", "057", "058", "059",
				"061", "062", "063", "064", "065", "066", "067", "068", "069", "071", "074", "090", "091", "093", "094",
				"095","096", "097", "098", "099"};
		
			number = number.trim();
			numberSplit = number.split(" |-");
			length = numberSplit[1].length();
			if((length ==  7 && type == 0)|| type == 1 && (length > 4 && length < 8))
				for(int i = 0;i < validCases.length; i++)
					if(validCases[i].equals(numberSplit[0]))
						valid = true;		
		return valid;
	}
	
	public static String valEmail(String email) 
	{
		String pattern  = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
		boolean valid = false;
		
		while(!valid)
		{
			if(email.matches(pattern))
				valid = true;
			else
			{
				System.out.print("\nInvalid email address. Try again: ");
				email = sc.nextLine();
			}	
		}	
		return email;
	}
    
	
	public static void getData(File contacts) throws IOException
	{
		Scanner in = new Scanner(contacts);
		String [] lineOfFile;
		
		while(in.hasNext())
		{
			lineOfFile = in.nextLine().split(",", -1); 
			for(int i = 0; i < 6; i++)
				contactInfo.get(i).add(lineOfFile[i]);
		}
	}
	
	
	public static void moveToFile(String fileName) throws IOException
	{
		PrintWriter toFile = new PrintWriter(fileName);
		
		for(int i = 0; i < contactInfo.get(0).size(); i++)
		{
			for(int j = 0;j < 5; j++)
				toFile.print(contactInfo.get(j).get(i) + ",");
			toFile.println(contactInfo.get(5).get(i));//so that no comma is put at the end of the line.
		}
		toFile.close();
	}
	
	public static int findType(String pieceOfData)
	{
		//types landline = 2, mobile = 3, emaill = 4, postal = 5.I chose theese numbers because they
		//can be used as a subscript for the multi D arraylist(not sure if useful).
		int type = 0;
		String pattern1 = "{2,4}[0-9]-{5,7}[0-9]";
		pieceOfData = pieceOfData.trim();
		
		if(pieceOfData.matches(pattern1))
			type = 2;
		else if(pieceOfData.startsWith("08"))
			type = 3;
		else if(pieceOfData.contains("@"))
			type = 4;
		else if(pieceOfData.contains(" "))
			type = 5;
		
		//if type is zero we can assume it's an invalid piece of data(once you're not passing the wrong arguments to it)
		return type;
	}
    public static boolean MenuProcess(String options, String input, boolean Valid)
	{
	  // simple process of the menu method put into its own array as the code was used multiple times
          if (!(options.contains(input)))
	      {
            System.out.println("Error!! please enter the first letter of one of the menu options"); 
            Valid = false;
	      }
	      else 
		  {     
		   Valid = true;		
	      }
		 return Valid;
	}
    public static void SearchDisplay(int TypeNum,ArrayList<ArrayList<String>> contactInfo, String Input) throws IOException
	{
	  /*display method for the search operation checks if the input the user 
	  provided is in the file and displays the contact that matches or else states contact not found - William O'Leary*/
	  String [] searchTypes = {"surname","forename","landline","mobile","email"};
	  String [] InfoTypes = {"Surname:   \t","Forename:\t","Landline:\t",
      "Mobile:     \t", "Email address:\t", "postal address:\t"};
      int counter = 0;  
      int TotalContacts = contactInfo.size();
      int Screens = 0;
	  boolean found = false;
	  for(int i = 0; i <contactInfo.size(); i++)
      {
	   if(contactInfo.get(TypeNum).get(i).contains(Input))
	   {
        DisplayProcess(contactInfo,counter,TotalContacts,Screens, InfoTypes, i);
  	    counter++;
	    found = true;
	   }
	  }  
	  if(found == false)
	  {
		System.out.println("\n"+"Contact not found");  
	  }
	 }
	public static void DisplayProcess(ArrayList<ArrayList<String>> contactInfo,int counter,int TotalContacts, int Screens, String [] InfoTypes, int i)
    {
	 // display processing method which is called upon to print contacts wanted- in seperate method as its used multiple times - William O'Leary
	 System.out.println("_______________________"+
     "\n"+"contact "+(counter+1));
	 for(int j = 0; j < contactInfo.get(i).size(); j++ )
     {
	  System.out.println(InfoTypes[j]+contactInfo.get(j).get(i));
	 }
     if((counter+1) % 4 == 0)
	 {
     Screens++;
	 System.out.println("_______________________"+
	 "\n"+ TotalContacts+" total contacts.");
     if(!(TotalContacts % 4 == 0 ))
     {
     System.out.println(Screens+" out of "+ ((TotalContacts/4)+1)+" Screens displayed.");
     }
     else
     {
	  System.out.println(Screens+" out of "+ ((TotalContacts/4))+" Screens displayed.");  
     }
     System.out.println("Hit any character to continue.");
     Scanner red = new Scanner(System.in);
     String next = red.nextLine();	
     }  
    }
}