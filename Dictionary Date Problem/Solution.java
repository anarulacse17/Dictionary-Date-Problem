import java.io.*;
import java.util.*;
public class Solution { 
   public static void main(String args[]) { 
         Scanner sc= new Scanner(System.in);
         String dates;
         System.out.println("Enter the dates with average one by one");
         System.out.println();
         int n=sc.nextInt();
         sc.nextLine();
        ArrayList<Long> date= new ArrayList<Long>();
        ArrayList<Long> number= new ArrayList<Long>();
        ArrayList<Long> perform= new ArrayList<Long>();
        ArrayList<Long> perform2= new ArrayList<Long>();
        ArrayList<Long> date_array= new ArrayList<Long>();
        ArrayList<Long> int_array= new ArrayList<Long>();
        ArrayList<Long> average= new ArrayList<Long>();
           for (int i=0;i<n;i++){
           dates = sc.nextLine();//input the dates and corresponding integer one by one
           dates=dates.replaceAll("[- ']",""); //removing the colons in date
        String[] Value = dates.split(":");//splitting the date and corresponding integer
         date.add(Long.parseLong(Value[0]));//adding the date to arraylist
        number.add(Long.parseLong(Value[1]));//adding the corresponding integer to arraylist
           }
    
    //Defining the logic and storing everything index by index 
     for(int i=0;i<date.size()-1;i++){ 
      perform.add(i,date.get(i+1)-date.get(i));//subtracting the next date with previous one and storing into arraylist
      perform2.add(i,number.get(i+1)-number.get(i));//subtracting the next corresponding integer with previous one and storing into arraylist
      average.add(i,perform2.get(i)/perform.get(i)); //dividing the result of corresponding integer by result of date and storing into arraylist

         
     }
    
      date_array.add(date.get(0)); // initially giving value to new arrayL which will store the result of date 
      int_array.add(number.get(0));//initially giving value to new arrayL which will store the result of corresponding integer
    //performing the operation and incrementing date according to difference
       Long val=date_array.get(0);
       for(int i=0;i<perform.size();i++){
      Long p=perform.get(i);
           for(int j=0;j<p;j++){
               val++;
         date_array.add(val);
       }  
   }
   int k=0;
    //performing the operation and adding avg value according to the result stores in average arrayL corresponding according to difference
   for(int i=0;i<perform.size();++i){
    int p=perform.get(i).intValue();

     for(int j=0;j<p;j++){
          Long a=average.get(i);
          System.out.println(a+" this is avg");
          Long t=int_array.get(k++);
          System.out.println(t+" this is t");
          int_array.add(t+a);
  } 
    }
    //For printing the list in Date format so converting it into stringbuffer and string
     System.out.print("{ ");
     
    for(int i=0;i<date_array.size();i++){
        StringBuffer output_inFormat=new StringBuffer();
        String output_date=Long.toString(date_array.get(i));//getting each element of date into string
        output_inFormat.append(output_date);
        output_inFormat.insert(4,'-');
        output_inFormat.insert(7,'-');
        String output_intAvg=Long.toString(int_array.get(i));//getting each element of integer into string
        System.out.print(output_inFormat+":"+output_intAvg+" ");
        
    }
    System.out.print("}");
   }
}
