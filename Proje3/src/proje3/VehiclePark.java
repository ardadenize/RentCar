
package proje3;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author arda
 */
public class VehiclePark {
    private ArrayList<Vehicle> allVehicles;
    private ArrayList<Person> registeredusers;
    private Person user;
    
     public VehiclePark() {
        allVehicles = new ArrayList<>();
       
        registeredusers = new ArrayList<>();
        //Sports a = new Sports(444,4444,444,true,44);
     //allVehicles.add(a);
        
    }
    public void displayVehicles(){
    if(allVehicles.size()>0){
    for (int i = 0; i < allVehicles.size() ; i++) {
        
       System.out.println(i + ". The plate of vehicle : " +allVehicles.get(i).getPlateNumber());  
    }  
    }else{
        System.out.println("There is no vehicle.");
    }
}
   
    public void displayAvaibleVehicles() throws ParseException{
        
      
       
    if(allVehicles.size()>0){
    for (int i = 0; i < allVehicles.size() ; i++) {
      if(allVehicles.get(i).isRentStatus() == false){
          System.out.println(allVehicles.get(i).getPlateNumber() + " "+ allVehicles.get(i).getClass().getSimpleName() + " rented by " + allVehicles.get(i).getRenteduser()+" rentable after " + allVehicles.get(i).getRentEnding());
    }else if  (allVehicles.get(i).isRentStatus() == true){
        if(allVehicles.get(i).isBookStatus()== false){
            System.out.println(allVehicles.get(i).getPlateNumber() + " "+ allVehicles.get(i).getClass().getSimpleName() + " booked by "+allVehicles.get(i).getBookeduser()+"bookable after " + allVehicles.get(i).getBookEnding());
        }else if(allVehicles.get(i).isBookStatus()== true){
        System.out.println(i + "." +allVehicles.get(i).getPlateNumber() + " " + allVehicles.get(i).getClass().getSimpleName() + " Bookable Status :" + allVehicles.get(i).isBookable());
        }
        }
      
    }
    }else{
        System.out.println("There is no vehicle.");
    }
}
  
    public void addVehicle(Vehicle m) throws IOException{
       allVehicles.add(m);

}
    public void displayrentedbyuser(Person p){
    for (int i = 0; i < allVehicles.size() ; i++) {
            if(allVehicles.get(i).getRenteduser() == p.getName()){
             System.out.println(i +" " +allVehicles.get(i).getClass().getSimpleName() + " rented in " + allVehicles.get(i).getRentStarting() + " to " +  allVehicles.get(i).getRentEnding() + " at " +allVehicles.get(i).getNumberOfDays() +" days.");
            }
               
        }
     Scanner input = new Scanner(System.in);
              System.out.println("(Which one do you want to drop ?");
              int indexx = input.nextInt();
              dropvehicle(indexx,p);
}
    public void dropvehicle(int m,Person p){

        double cost = allVehicles.get(m).dropMe();
        
        System.out.println("YOU SHOULD PAY " + cost + " TL");
    }
     public void removeVehicle(int m){
       allVehicles.remove(m);
 
}
     public void bookVehicle(int m, Person user,String Startdate,String Enddate){
         if(allVehicles.get(m).isBookable() == true){
             allVehicles.get(m).bookMe(Startdate, Enddate, user);
         }
     }
     public void rentVehicle(int m, Person user,String Startdate,String Enddate) throws ParseException{
      try {
  allVehicles.get(m).rentMe(Startdate, Enddate, user);
}
catch(Exception e) {
 System.out.println(e);
}
           
    }
 }
