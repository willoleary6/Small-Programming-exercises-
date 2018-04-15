import javax.swing.*;
//  William O'Leary, 15155528
public class ArrayManip3
{
 public static void main(String [] args)
 { 
   int [] bits = bitArrayGeneration();
	 //int [] Array1 = arrayGeneration();
   //int [] Array2 = arrayGeneration();
   //testSearchNum();
   //testHasDuplicates(); 
   //removeDuplicates();
   //boolean match = ContainsAll();
   //System.out.print(match);
   //commonElements();
   // int [] union = union();
 }
 public static int [] arrayGeneration()
 {
  // generates arrays
  int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter size of array"));
  int [] Array = new int [size];
  for(int i = 0; i< Array.length; i++)
  {
    Array[i] =Integer.parseInt(JOptionPane.showInputDialog(null, "Enter value in position "+ i));  
  }
  return Array;
 }
 public static  void testSearchNum(int [] MyArray)
 {
  //tests to see if number is inside array
  int num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number you wish to check"));
  boolean inside = SearchNum(MyArray, num2);
  if(inside = true)
	System.out.println("Number is contained in array");
  else
	System.out.println("Number is not contained in array");  
 }
 
 public static boolean SearchNum(int [] MyArray, int num )
 {
  // boolean operation if number is inside array
  boolean Valid = false;
  for(int i = 0; i < MyArray.length; i++)
  {
   if(num == MyArray[i]);
   {
	System.out.println("num= "+ num + "    MyArray Elt="+ MyArray[i]);
	  Valid = true;
   }  
  }  
  return Valid;
 }
 public static boolean hasDuplicates(int [] MyArray)
 {
  // method to check for duplicates
  boolean duplicate = false;
  for(int i = 0; i< MyArray.length; i++)
  {
   for(int j = 0; i<MyArray.length; i++)
   {
    if(!(i == j))	   
    {
	 if(MyArray[i] == MyArray[j])
     duplicate = true;		 
	}
   }  
  }	  
  return duplicate;
 }
 public static void testHasDuplicates(int [] MyArray)
 {
	// testing the hasduplicates method
	boolean Duplicates = hasDuplicates(MyArray);
	if (Duplicates == true)
	 System.out.println("There are duplicates in array");
    else
	 System.out.println("There are no duplicates in array");
 }
 public static int [] removeDuplicates(int [] listA)
 {
   int [] listB = new int [listA.length];
   boolean valid = false;
   int counter = 0;
   for(int i = 0; i< listA.length; i++)
   {
	valid = false;
	for(int j = i+1; j<listA.length; j++)
    {
	 if(listA[i] == listA[j])
	 {
      valid = true; 
     }
	
	}  
    if(valid == false)
     {
      listB[counter] = listA[i];	 
      counter++;
	 }
   
   }	   
  for(int k = 0; k < listB.length; k++ )
  {
	 System.out.print(listB[k]);
  }
  return listB;
 }
 public static boolean ContainsAll(int [] Array1, int [] Array2)
 {
   boolean match = false;
   boolean [] check = new boolean[Array1.length];
       for(int i = 0; i < Array1.length;i++)
	   {
	     match = false;
		 for(int j = 0; j < Array2.length; j++)
		 { 
	      if(Array1[i] == Array2[j])
	         {
              match = true; 
             } 			 
	     }
	    check[i] = match;
	   }
       for(int k = 0; k < Array1.length; k++)
	   {
	    if (check[k] == false)
	    {
		 match = false;  
	    }		  
	   }
   return match;
 }
 public static int [] commonElements(int [] Array1, int [] Array2)
 {
   boolean found = true;
   int counter = 0;
   int counter2 =0;
   int [] Array3;
   if(Array1.length <= Array2.length)
   {
	 Array3 = new int[Array1.length];   
   }
   else
   {
	 Array3 = new int[Array2.length];   
   }
   for(int i = 0; i < Array1.length;i++)
	{
	 found = false;
	 for(int j = 0; j < Array2.length; j++)
	 { 
	   if(Array1[i] == Array2[j])
	    {
         Array3[counter] = Array1[i]; 
	     counter++;
		} 			 
	}
   for(int k = 0; k < Array3.length; k++)
   {
	if(!(Array3[k] == 0 ))
	System.out.print(Array3[k]);  
   }
  } 
  return Array3;
 }
 public static int [] union(int [] Array1, int [] Array2)
 {
   int [] Array3 = new int [Array1.length+Array2.length];
   int num = Array1.length;
   for(int i = 0; i < Array1.length;i++)
   {
	 Array3[i] = Array1[i]; 
   }	   
   for(int j = num; j < (Array2.length+num);j++)
   {
	 Array3[j] = Array2[j-num]; 
   }	   
   return Array3;
 }
 public static int [] bitArrayGeneration()
 {
  // generates arrays
  int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter size of the bit array"));
  boolean valid = false;
	int [] Array = new int [size];
  for(int i = 0; i< Array.length; i++)
   {
     Array[i] =Integer.parseInt(JOptionPane.showInputDialog(null, "Enter value in position "+ i));  
   }
	return Array;
 }
}