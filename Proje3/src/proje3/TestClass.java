
package proje3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author arda
 */
public class TestClass {
     public static ArrayList<Person> persons = new ArrayList<Person>();
      public static String PersonfileName =  "resources//persons.txt";
      public static Person loggeduser = null;
      public static int lastid=0;
      public static VehiclePark park = new VehiclePark();
      public static void getpersons(){
             try {
                 
			File Personfile = new File(PersonfileName);
			persons = readPersonfile(Personfile);
                        persons.forEach((person) -> System.out.println(person.getName() + " " + person.getId()) );
       } catch (Exception  e) {
			
			System.out.println(e.getMessage());
		}
      }
       public  static ArrayList<Person> readPersonfile(File file) throws Exception {

		ArrayList<Person> PersonDatabase = new ArrayList<>();
		
		Scanner scan = new Scanner(file); 
             scan.nextLine();
                while (scan.hasNextLine()) {
			
				String Line = scan.nextLine();
				
				StringTokenizer parser = new StringTokenizer(Line, ";");
                                int id = Integer.parseInt(parser.nextToken());
                                String name = parser.nextToken();
                                int phone = Integer.parseInt(parser.nextToken());
                                int type = Integer.parseInt(parser.nextToken());
                                
                               if (type==1){
                               RegisteredUser line = new RegisteredUser(name,phone,id);
                                PersonDatabase.add(line);
                               }else{
                                   Admin line = new Admin(name,phone,id);
                                    PersonDatabase.add(line);
                               }
                            lastid = id;
                }
                
                return PersonDatabase;
        }
    public static void main(String[] args) throws ParseException, Exception {
        
        getpersons();
        menu1();
        
    }
    public static void menu1() throws ParseException, IOException{
        loggeduser= null;
        String selection;
        Scanner input = new Scanner(System.in);
        
        System.out.println("-------------------------\n");
        System.out.println("(Press 1) Display all vehicles.");
        System.out.println("(Press 2) Display available vehiceles: asks the dates, returns to the main menu.");
        System.out.println("(Press 3) Register me: asks the  name and contact info,returns to the main menu.");
        System.out.println("(Press 4) Continue as registered user.");
        System.out.println("(Press 5) Continue as admin.");
        System.out.println("(Press 6) Quit.");
        System.out.println("-------------------------\n");
        
                 selection = input.next();
        
      switch (selection) {
          case "0":
          
            break;
        case "1":
           park.displayVehicles();
           menu1();
            break;
        case "2":
        {
           park.displayAvaibleVehicles();
            menu1();
        }
            break;
        case "3":
        {
            try {
                RegisterMe(persons);
                 menu1();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
            break;
        case "4":
             try {
      login();
       } catch (Exception ex) {
                System.out.println(ex);
            }
            break;
        case "5":
          try {
      login();
       } catch (Exception ex) {
                System.out.println(ex);
            }
         
            break;
        case "6":
        
            break;
        case "7":
       
          
            break;
        case "8":
         System.exit(0);
            break;
        default:
         System.out.println("Incorrect process, please try again.");
         menu1();
            break;
    }
    }
    public static void login() throws IOException, ParseException{
         Scanner input = new Scanner(System.in);
        System.out.println("(Please enter your name : ");
        String name = input.next();
         System.out.println("Please enter your phone number : ");
         int phone = input.nextInt();
         for(int i=0;i<persons.size();i++){
             if(persons.get(i).getName().equals(name)  && persons.get(i).getTelNum() == phone){
                 loggeduser = persons.get(i);
             }
         }
         if(loggeduser == null)
             System.out.println("Incorrect user details.");
         else
             System.out.println("logged in as " + loggeduser.getName());
         if(loggeduser !=null){
          if(loggeduser.getClass().getSimpleName().equals("Admin")){
            menu3();
         }else{
            menu2();
         }
      }else {
             menu1();
         }
    }
    public static void RegisterMe(ArrayList<Person> persons) throws Exception{
          Scanner input = new Scanner(System.in);
        System.out.println("(Please enter name : ");
        String name = input.next();
         System.out.println("Please enter phone number : ");
        int phone = input.nextInt();
        int id  = lastid+1;
      
        Path p = Paths.get(PersonfileName);
        String s = System.lineSeparator() + id +";"+ name + ";"+ phone + ";1";
        try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {
     writer.write(s);
} catch (IOException ioe) {
    System.err.format("IOException: %s%n", ioe);
}
 getpersons();
     
        
    }
    public static void menu3() throws IOException{
         String selection;
         Scanner input = new Scanner(System.in);
         System.out.println("-------------------------\n");
        System.out.println("(Press 1) Display all vehicles.");
        System.out.println("(Press 2) Display available vehicles.");
        System.out.println("(Press 3) Add a new vehicle to the system.");
        System.out.println("(Press 4) Remove vehicle.");
        System.out.println("(Press 5) Reports.");
        System.out.println("(Press 6) Main Menu");
        System.out.println("(Press 1) Quit"); 
        System.out.println("-------------------------\n");
         selection = input.next();
     switch (selection) {

        case "1":
           park.displayVehicles();
           menu3();
            break;
        case "2":
        {
                 try {
                     park.displayAvaibleVehicles();
                 } catch (ParseException ex) {
                     System.out.println(ex);
                 }
        }
        menu3();
            break;
        case "3":
      addVehicle();
      park.displayVehicles();
      menu3();
            break;
        case "4":
      removeVehicle();
         menu3();
            break;
        case "6":
         try {
      menu1();
       } catch (Exception ex) {
                System.out.println(ex);
            }
         
            break;
        default:
         }
         }
    public static void removeVehicle(){
         park.displayVehicles();
          Scanner input = new Scanner(System.in);
         System.out.println("Which one do you want to delete ?");
         int removeid = input.nextInt();
         park.removeVehicle(removeid);
    }
    public static void addVehicle() throws IOException{
         
        Scanner input = new Scanner(System.in);
         int plateNumber;
 int numberOfTires;
 double dailyFee;
 String color;
 int seatingCap;
 int numOfDoors;

boolean bookable;

         System.out.println("What is the Vehicle Type ?");
         System.out.println("1.Car");
         System.out.println("2.Truck");
         System.out.println("Please enter 1 or 2 ");
        int Vehicletype =input.nextInt();
        if(Vehicletype == 2 ){
         System.out.println("What is the Truck Type ?");
         System.out.println("1.Small Truck");
         System.out.println("2.Transport Truck");
         System.out.println("Please enter 1 or 2 ");
         int TruckType =input.nextInt();
         if(TruckType == 1){
         System.out.println("Please enter Plate Number (plate number must be number) :");
         plateNumber =input.nextInt();
         System.out.println("Please enter Number of Tires :");
         numberOfTires =input.nextInt();
        
         System.out.println("Please enter Daily Fee");
         dailyFee =input.nextDouble();
         System.out.println("Please enter loading Capacity (Kg):");
         int loadingcap =input.nextInt();
          System.out.println("Is it bookable or noy (Enter Y or N) :");
          String booka = input.next();
          if(booka =="Y"){
              bookable = true;
          }else{
              bookable = false;
          }
          SmallTrucks a = new SmallTrucks(plateNumber,numberOfTires,dailyFee,bookable,loadingcap);
     park.addVehicle(a);
         }else if(TruckType == 2){
              System.out.println("Please enter Plate Number (plate number must be number) :");
              plateNumber =input.nextInt();
         System.out.println("Please enter Number of Tires :");
         numberOfTires =input.nextInt();
         
         System.out.println("Please enter Daily Fee");
          dailyFee =input.nextDouble();
          System.out.println("Please enter loading Capacity (Kg) :");
         int loadingcap =input.nextInt();
          System.out.println("Is it bookable or noy (Enter Y or N) :");
          String booka = input.next();
          if(booka =="Y"){
              bookable = true;
          }else{
              bookable = false;
          }
          TransportTrucks a = new TransportTrucks(plateNumber,numberOfTires,dailyFee,bookable,loadingcap);
     park.addVehicle(a);
         }
        }
        else if(Vehicletype == 1){
              System.out.println("What is the Car Type ?");
         System.out.println("1.Sport");
         System.out.println("2.Station Wagon");
          System.out.println("3.SUV");
         System.out.println("Please enter 1 or 2 or 3 ");
         int CarType =input.nextInt();
         if(CarType == 1){
              System.out.println("Please enter Plate Number : (plate number must be number) ");
              plateNumber =input.nextInt();
         System.out.println("Please enter Number of Tires : ");
         numberOfTires =input.nextInt();
             System.out.println("Please enter the color of car : ");
             String color1 = input.next();
             System.out.println("Please enter the seating capacity of car : ");
             seatingCap = input.nextInt();
             System.out.println("Please enter the door number of car : ");
             numOfDoors = input.nextInt();
             
         
         System.out.println("Please enter Daily Fee");
          dailyFee =input.nextDouble();
    System.out.println("Please enter HorsePower(HP)");
          int HP =input.nextInt();
          
              bookable = true;
          Sports a = new Sports(plateNumber,numberOfTires,color1,seatingCap,numOfDoors,dailyFee,bookable,HP);
     park.addVehicle(a);
         }else if(CarType == 2){
              System.out.println("Please enter Plate Number (plate number must be number) :");
              plateNumber =input.nextInt();
         System.out.println("Please enter Number of Tires :");
         numberOfTires =input.nextInt();
         System.out.println("Please enter the color of car : ");
             String color2 = input.nextLine();
             System.out.println("Please enter the seating capacity of car : ");
             seatingCap = input.nextInt();
             System.out.println("Please enter the door number of car : ");
             numOfDoors = input.nextInt();
         
         System.out.println("Please enter Daily Fee");
          dailyFee =input.nextDouble();
          System.out.println("Please enter loading Capacity : (Kg)");
         int loadingcap =input.nextInt();
          
              bookable = false;
          SW a = new SW(plateNumber,numberOfTires,color2,seatingCap,numOfDoors,dailyFee,bookable,loadingcap);
     park.addVehicle(a);
        }else if(CarType == 3){
                System.out.println("Please enter Plate Number (plate number must be number) :");
              plateNumber =input.nextInt();
         System.out.println("Please enter Number of Tires :");
         numberOfTires =input.nextInt();
         System.out.println("Please enter the color of car : ");
             String color3 = input.nextLine();
             System.out.println("Please enter the seating capacity of car : ");
             seatingCap = input.nextInt();
             System.out.println("Please enter the door number of car : ");
             numOfDoors = input.nextInt();
         
         System.out.println("Please enter Daily Fee");
          dailyFee =input.nextDouble();
          System.out.println("Please enter WD (4 or 2) :");
         int WD =input.nextInt();
          
              bookable = false;
          SUV a = new SUV(plateNumber,numberOfTires,color3,seatingCap,numOfDoors,dailyFee,bookable,WD);
     park.addVehicle(a);
        }
       
    }
    }
    
         public static void menu2() throws IOException{
             String selection;
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------\n");
              System.out.println("(Press 1) Display all vehicles.");
        System.out.println("(Press 2) Display available vehicles.");
        System.out.println("(Press 3) Display available vehicles by type.");
        System.out.println("(Press 4) Book vehicle");
        System.out.println("(Press 5) Cancel my booking");
        System.out.println("(Press 6) Rent a vehicle");
        System.out.println("(Press 7) Drop vehicle. ");
        System.out.println("(Press 8) Main Menu ");
        System.out.println("(Press 9) Quit");
        System.out.println("-------------------------\n");
         selection = input.next();
        
      switch (selection) {

        case "1":
           park.displayVehicles();
           menu2();
            break;
        case "2":
        {
                 try {
                     park.displayAvaibleVehicles();
                      menu2();
                 } catch (ParseException ex) {
                     System.out.println(ex);
                 }
        }
            break;
        case "3":
         
            break;
        case "4":
      //bookvehicle();
      rentVehicle();
      menu2();
            break;
            case "5":
      bookvehicle();
      menu2();
            break;
                case "6":
      rentVehicle();
      menu2();
            break;
                      case "7":
      park.displayrentedbyuser(loggeduser);
      menu2();
            break;
                 
        case "8":
            try{
                
            
         menu1();
            } catch (ParseException ex) {
                     System.out.println(ex);
                 }
            break;
        default:
         }
         }
         public static void bookvehicle(){
             try {
                     park.displayAvaibleVehicles();
                      Scanner input = new Scanner(System.in);
              System.out.println("Which vehicle do you want to book ? ");
        int vehicleindex = input.nextInt();
          System.out.println("What is your start date of booking ? (DD.MM.YYYY)");
        String firstdate = input.next();
          System.out.println("What is your last date of booking ? (DD.MM.YYYY)");
       String lastdate = input.next();
        park.bookVehicle(vehicleindex, loggeduser, firstdate, lastdate);
                 } catch (ParseException ex) {
                     System.out.println(ex);
                 }
         }
         public static void rentVehicle(){
             try {
                     park.displayAvaibleVehicles();
                      Scanner input = new Scanner(System.in);
              System.out.println("Which vehicle do you want to rent/book ? ");
        int vehicleindex = input.nextInt();
          System.out.println("What is your start date of renting/booking ? (DD.MM.YYYY)");
        String ilktarih = input.next();
          System.out.println("What is your last date of renting/booking ? (DD.MM.YYYY)");
       String sontarih = input.next();
        park.rentVehicle(vehicleindex, loggeduser, ilktarih, sontarih);
                 } catch (ParseException ex) {
                     System.out.println(ex);
                 }
         }
}
