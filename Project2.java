import java.util.*;
import java.io.*;

//**Things we still need to look at**
		//if two pieces of information of the same type added?
		//if two contacts have the same name/data.
		//if user completely messes up the order?
		//Should the user's input when searching be case sensitive? 
		//making it more efficient


public class Project2
{
    public static String firstLetter = "";
    public static ArrayList<ArrayList<String>> contactInfo = new ArrayList<ArrayList<String>>();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args) throws IOException
    {
        String pattern = ".*\\.txt";
        boolean alreadyExisted = true;
        int antiRemove = 0;
        if(args.length != 1)
        System.out.print("Java Usage: java ContactsApp Anyfile.txt");//these check the user's input.
        else if(!(args[0].matches(pattern)))
        System.out.print("Your command line argument must be a .txt file.");
        else
        {
            String [] elements;
            String createFile = "", fileName = args[0];
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
                contactInfo.add(new ArrayList<String>());
                
                if(alreadyExisted)
                getData(contacts);
                
                elements = menuMethod();
                while(!firstLetter.equals("q"))
                {
                    if(firstLetter.equals("i"))
						insert(elements);
                    else if(firstLetter.equals("r"))
						antiRemove = remove(antiRemove,elements);
					else if(firstLetter.equals("e"))
						edit(elements);
                    else if(firstLetter.equals("d"))
						display(antiRemove);
                    else if(firstLetter.equals("s"))
						search(elements,antiRemove);
                    
                    elements = menuMethod();
                }
                moveToFile(fileName);
            }
        }
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
    
    public static String [] menuMethod()
    {
        /* Simple menu method that will repeat if user enters an invalid inpuut - William O'Leary*/
        boolean valid = false;
        String input= "";
        String [] elements = new String[0];
        while(valid == false)
        {
            System.out.println("\nMAIN MENU:");
            System.out.println("Please enter an operation "+"\n"+
            "you wish to use.");
            System.out.println("i(nsert)"+"\t"+"r(emove)"+"\t"+"e(dit)"+"\n"+
            "d(isplay)"+"\t"+"s(earch)"+"\t"+"q(uit)");
            input = sc.nextLine();
            valid = validateAll(input);
            if(valid)
            {
                
                input = input.trim().replaceFirst(firstLetter + " ", "");
                elements = input.split(",");
            }
        }
        return elements;
    }
    
    public static boolean validateAll(String input)
    {	
        String options = "iredsq";
        String alphabetic = "\\w+\\.?";
		String pattern = "[i|r|e|d|s|q] .+";
		String pattern2 = "[a-zA-Z]{1}";
        String [] elements;
        boolean valid = true;
		
		input = input.trim();
		if(!(input.equals("q") || input.equals("d")))
		{
			if(input.length() < 3)
			{	
				valid = false;
				System.out.print("Error! No input or appropriate arguments found.\n");
			}
			else if(!input.matches(pattern))
			{
				valid = false;
				System.out.print("Error! Invalid input or incorrect format.\n");
			}
		}
		if(valid)
		{
			firstLetter = input.substring(0,1).toLowerCase();
			input = input.trim().replaceFirst(firstLetter + " ", "");
			elements = input.split(",");
			if(elements.length > 6)
			{
				System.out.print("Error! your contact cannot have more than 6 pieces of information.");
				valid = false;
			}
			else if(elements.length < 3)
			{
				if(firstLetter.equals("e") || firstLetter.equals("i") || firstLetter.equals("r"))
				{
					System.out.print("Error! This action requires between three and six pieces of contact information.\n");
					valid = false;
				}
				else if(firstLetter.equals("s"))
				{
					if((elements[0].startsWith("0")) && elements[0].length() > 4)
					{
						valid = false;
						System.out.print("Error! Number prefixes can be at most 4 numbers long.\n");
					}	
					else if(elements[0].length() != 1 && elements[0].matches(pattern2))
					{	
						valid = false;
						System.out.print("Error! You can only search by name using first letters of surnames.\n");
					}	
				}
			}	
			if(valid)
				valid = checkTypes(elements ,valid);//method was getting horrifically long.
		}
		return valid;
    }
    
    public static int findType(String pieceOfData)
    {
        //types; names = 1, landline = 2, mobile = 3, emaill = 4, postal = 5.I chose theese numbers because they
        //can be used as a subscript for the multi D arraylist(not sure if useful).
        int type = 0;
        String namePattern = "^[\\p{L} .'-]+$";
        pieceOfData = pieceOfData.trim();
        
        if(pieceOfData.startsWith("08"))
			type = 3;
        else if(pieceOfData.startsWith("0"))
			type = 2;
        else if(pieceOfData.contains("@"))
			type = 4;
        else
		  type = 5;
        return type;
    }
	
	public static boolean checkTypes(String [] elements, boolean valid)
	{
		int type;
		for(int i = 0; i < elements.length && valid; i++)
		{
			type = findType(elements[i]);
			if((type != 0 && elements.length == 1 && firstLetter.equals("s")))
				valid = true;
			else if(type == 2)
				valid = valNumber(elements[i], 1);
			else if(type == 3)
				valid = valNumber(elements[i], 0);
			else if(type == 4)
				valid = valEmail(elements[i]);
			else if(!(type == 1 || type == 5))
			{	
				valid = false;
				System.out.print("We could not determine the type of contact data you entered.\n");
			}	
		}
		return valid;
	}
    
    public static boolean valEmail(String email)
    {
        String pattern  = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
        boolean valid = false;
        if(email.matches(pattern))
			valid = true;
        
		if(!valid)
			System.out.print("Invalid email address.\n");
        return valid;
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
		/*	Takes the mobile number as a string and the type(landline or mobile) and returns whether or not it is vaild.
			Written by jamie mac manus
		*/
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
        
        numberSplit = number.split("-");
        length = numberSplit[1].length();
        if((length ==  7 && type == 0)|| type == 1 && (length > 4 && length < 8))
			for(int i = 0;i < validCases.length; i++)
				if(validCases[i].equals(numberSplit[0]))
					valid = true;
        
        if(!valid)
			System.out.print("Invalid phone number.\n");
        return valid;
    }
    
    public static void display(int antiRemove)
    {
        String [] InfoTypes = {"Surname:   \t","Forename:\t","Landline:\t",
        "Mobile:     \t", "Email address:\t", "postal address:\t"};
        int counter = 0;
        int TotalContacts = contactInfo.get(0).size();
        int Screens = 0;
        for(int i = 0; i <contactInfo.get(0).size(); i++)
        {
            DisplayProcess(counter,TotalContacts,Screens, InfoTypes, i, antiRemove);
            counter++;
        }
		if(contactInfo.get(0).size() > 0)
			System.out.println("\n"+ "All contacts displayed,"+"\n"+"Returning to menu:");
		else
			System.out.println("\nNo contacts found.\nReturning to menu:");
    }
    
	public static void insert(String[] elementsFromMenu)
	{
		//written by Rory *cough**annette**cough* Egan.
        int index;
		int type = 0;
        String current, next;
		String [] elements = new String[6];
        boolean locationFound = false;
		
		Arrays.fill(elements,"");
		
		for(int i = 0; i < elementsFromMenu.length; i++)
		{
			type = findType(elementsFromMenu[i]);
			if(i == 0)
				elements[0] = elementsFromMenu[0];
			else
				elements[type] = elementsFromMenu[i];
		}
		
        if (contactInfo.get(0).size() == 0) 
		{
            for (int i = 0; i < elements.length; i++)
                contactInfo.get(i).add(0, elements[i]);
        } 
		else if (elements[0].compareToIgnoreCase(contactInfo.get(0).get(0)) < 0)
		{
            for (int i = 0; i < elements.length; i++)
                contactInfo.get(i).add(0, elements[i]);
        } 
        else if (((contactInfo.get(0).get(contactInfo.get(0).size() - 1)).compareToIgnoreCase(elements[0])) < 0)
		{
            for (int i = 0; i < elements.length; i++)
                contactInfo.get(i).add(contactInfo.get(i).size(), elements[i]);
        } 
		else 
		{
           for (index = 0; index < contactInfo.size() - 1 && !locationFound; index++) {
				current = contactInfo.get(0).get(index);
				next = contactInfo.get(0).get(index + 1);
                if (elements[0].compareToIgnoreCase(current) > 0 &&
                    elements[0].compareToIgnoreCase(next) < 0) {
                    for (int i = 0; i < elements.length; i++)
                        contactInfo.get(i).add(index + 1, elements[i]);
                    locationFound = true;
                }
            }
        }
    }
    
    public static int remove(int antiRemove, String [] elements)
    {
	int Choice;
	boolean found = false;
	String word = elements[2];
	Choice = findType(word);
	   for(int i = 0; i < contactInfo.size()-(antiRemove+1); i++)
	    {  
		   if(contactInfo.get(Choice).get(i).contains(elements[2])) 
			{
			 found = true;
			 for(int j = 0; j < contactInfo.size(); j++)
			 {
		      contactInfo.get(j).remove(i);
		     }
			}
		} 
       if(found == true)
	   {
		antiRemove++;   
	   }		   
	  return antiRemove;	    
    }
    
    public static void edit(String [] elements)
    {
       int Choice;
	   boolean found = false;
	   String word = elements[2];
	   Choice = findType(word);
	   for(int i = 0; i < contactInfo.size(); i++)
	    {  
		   if(contactInfo.get(Choice).get(i).contains(elements[2])) 
			{
		     contactInfo.get(Choice).set(i, elements[3]);
			}
		}   
        
    }
    
    public static void search(String [] elements, int antiRemove)
    {
        // main search driver calls on the searchmenu and searchdisplay methods - William O'Leary
        int Choice;
        String Input = elements[0];
		
        if(Input.startsWith("08"))
        Choice = 3;
        else if(Input.startsWith("0"))
        Choice = 2;
        else if(Input.contains("@"))
        Choice = 4;
        else
            Choice = 0;
        SearchDisplay(Choice, Input, antiRemove);
        System.out.println("\n"+"Returning to main menu.");
    }
    
    public static void SearchDisplay(int TypeNum, String Input,int antiRemove)
    {
        /*display method for the search operation checks if the input the user
        provided is in the file and displays the contact that matches or else states contact not found - William O'Leary*/
        String [] InfoTypes = {"Surname:   \t","Forename:\t","Landline:\t",
        "Mobile:     \t", "Email address:\t", "postal address:\t"};
        int counter = 0;
        int TotalContacts = contactInfo.get(0).size();
        int Screens = 0;
        boolean found = false;
        for(int i = 0; i <TotalContacts; i++)
        {
            if(contactInfo.get(TypeNum).get(i).contains(Input))
            {
                DisplayProcess(counter,TotalContacts,Screens, InfoTypes, i, antiRemove);
                counter++;
                found = true;
            }
        }
        if(found == false)
        System.out.println("\nContact not found.");
    }
    
    public static void DisplayProcess(int counter,int TotalContacts, int Screens, String [] InfoTypes, int i,int antiRemove)
    {
        // display processing method which is called upon to print contacts wanted- in seperate method as its used multiple times - William O'Leary
        System.out.println("_______________________"+
        "\n"+"contact "+(counter+1));
        for(int j = 0; j < contactInfo.size(); j++ )
			System.out.println(InfoTypes[j]+contactInfo.get(j).get(i));
        if((counter+1) % 4 == 0)
        {
            Screens++;
            System.out.println("_______________________"+
            "\n"+ TotalContacts+" total contacts.");
            if(!(TotalContacts % 4 == 0 ))
				System.out.println(Screens+" out of "+ ((TotalContacts/4)+1)+" Screens displayed.");
            else
                System.out.println(Screens+" out of "+ ((TotalContacts/4))+" Screens displayed.");
            System.out.println("Hit any character to continue.");
            String next = sc.nextLine();
        }
    }
    
    public static void moveToFile(String fileName) throws IOException
    {
		//Finally moving data from the multi D arraylist to the file using a nested for loop.Takes filename and has no return.
        PrintWriter toFile = new PrintWriter(fileName);
        
        for(int i = 0; i < contactInfo.get(0).size(); i++)
        {
            for(int j = 0;j < 5; j++)
            toFile.print(contactInfo.get(j).get(i) + ",");
            toFile.println(contactInfo.get(5).get(i));//so that no comma is put at the end of the line.
        }
        toFile.close();
    }
}