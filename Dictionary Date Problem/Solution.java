import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.io.*;
public class Solution {
    public static void Dictionary(String []D)
    {
        ArrayList<String> date= new ArrayList<String>();
        ArrayList<Long> number= new ArrayList<Long>();
        ArrayList<Long> perform= new ArrayList<Long>();
        ArrayList<Long> perform2= new ArrayList<Long>();
        ArrayList<Long> average= new ArrayList<Long>();
        ArrayList<String> date_array= new ArrayList<String>();
        ArrayList<Long> int_array= new ArrayList<Long>();
        for(int i=0;i<D.length;i++)
        {
           String[] Value = D[i].split(":");//splitting the date and corresponding integer
          date.add(Value[0]);//adding the date to arraylist
          number.add(Long.parseLong(Value[1]));//adding corresponding integer to separate arraylist
        }
        //converting the numbers into date format
       for(int i=0;i<D.length-1;i++)
       {
        LocalDate dateBefore = LocalDate.parse(date.get(i));
     	LocalDate dateAfter = LocalDate.parse(date.get(i+1));
	//calculating number of days in between
     	long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
	//adding the difference of dates and integers into arraylist's
       perform.add(noOfDaysBetween);
       perform2.add(number.get(i+1)-number.get(i));
       average.add(perform2.get(i)/perform.get(i));
       }
        String dt = date.get(0); 
        date_array.add(dt);
        int index=0;
        int_array.add(number.get(0));
       int k=0;
       for(int i=0;i<perform.size();++i){
      int p=perform.get(i).intValue();
      for(int j=0;j<p;j++){
     dt=LocalDate.parse(dt).plusDays(1).toString();//incrementing date according to difference
      date_array.add(dt);
       Long a=average.get(i);
       Long t=int_array.get(k++);
       int_array.add(t+a);//calculation of average
      } 
    }
    //printing the dates and integers
    System.out.print("{");
      for(int i=0;i<date_array.size();i++){
        System.out.print(date_array.get(i)+":"+int_array.get(i)+" ");
    }
    System.out.print("}");
    }
   public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String dates;
        int n=sc.nextInt();//no of dates to input
        sc.nextLine();
          String []D=new String[n];
        for(int i=0;i<n;i++){
           dates = sc.nextLine();//input the dates and corresponding integer one by one
           D[i]=dates;//Storing the input dates and integers into array
            }
       Dictionary(D);//Goes into Function
 }    
}
