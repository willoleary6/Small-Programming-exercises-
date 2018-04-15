public class sorter
{
 public static void main(String [] args)
 {
  
  boolean Assending = true;
  int [] data = {5,3,6,2,1,4};
  String [] names = {"fifth","third","sixth","second","first","fourth"};
  String NameTemp;
  int i, temp;
  int j, min;
  for(i = 0; i < data.length - 1; i++)
  {
   min = SortProcess(i, data , min)
   temp = data[i];
   data[i] = data[min];
   data[min] = temp;
   NameTemp = names[i];
   names[i] = names[min];
   names[min]= NameTemp;
  }
  for(int k = 0; k < data.length; k++)
  {
    System.out.println(names[k]+"\t"+data[k]);
  }
 }
 public static int SortProcess(int i, int [] data, int min)
 {
   min = i;
   for(j = i + 1; j < data.length; j++)
   {
    if(Assending == true)
	{
     if (data[j] < data[min])
	   min = j;
    }
    else
	{
     if (data[j] > data[min])
	   min = j;
    }	
   }
   return min;
 }
}