package proje3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author arda
 */
public class Vehicle {

private int plateNumber;
private int numberOfTires;
private double dailyFee;
private int numberOfDays;
private boolean bookable;
private boolean bookStatus;
private boolean rentStatus;
private String bookStarting;
private String bookEnding;
private String rentStarting;
private String rentEnding;
private String bookeduser;

    public String getBookeduser() {
        return bookeduser;
    }

    public void setBookeduser(String bookeduser) {
        this.bookeduser = bookeduser;
    }

    public String getRenteduser() {
        return renteduser;
    }

    public void setRenteduser(String renteduser) {
        this.renteduser = renteduser;
    }
private String renteduser;


public Vehicle(int plateNumber, int numberOfTires, double dailyFee, boolean bookable){
 this.plateNumber=plateNumber;
 this.numberOfTires = numberOfTires;
 this.dailyFee = dailyFee;
 this.bookable = bookable;
 bookStatus= true;
 rentStatus = true; 
}

public void bookMe(String dateStart, String dateFinish, Person user){
    if ((bookStatus = false) || (rentStatus= false)){
         throw new ArithmeticException(""); 

    }else{
            setBookStarting(dateStart);
            setBookEnding(dateFinish);
            setBookStatus(false);
            bookeduser = user.getName();
    }
  }
public void cancelMe(String cancelDate) throws ParseException{
    Date date1=new SimpleDateFormat("dd.MM.yyyy").parse(cancelDate);  
      Date date2=new SimpleDateFormat("dd.MM.yyyy").parse(getBookStarting());  
    if(date1.after(date2)) {
        throw new ArithmeticException("");
        
    } else {
            setBookStatus(false);
    }
}
public void rentMe(String dateStart, String dateFinish, Person user) throws ParseException{
      Date date1=new SimpleDateFormat("dd.MM.yyyy").parse(dateStart);  
      Date date2=new SimpleDateFormat("dd.MM.yyyy").parse(dateFinish);  
     if ((rentStatus = false)){
         throw new ArithmeticException("The vehicle you want is not available."); 

    }else{
         if(bookStatus=false){
             if(bookeduser==user.getName()){
                 setRentStarting(dateStart);
            setRentEnding(dateFinish); 
            setRentStatus(false);
             long difference = date2.getTime() - date1.getTime();
               float daysBetween = (difference / (1000*60*60*24));
            setNumberOfDays((int)daysBetween);
            renteduser = user.getName();
            bookStatus =  true;
             }
         }else{
            setRentStarting(dateStart);
            setRentEnding(dateFinish);
            setRentStatus(false);
            long difference = date2.getTime() - date1.getTime();
               float daysBetween = (difference / (1000*60*60*24));
            setNumberOfDays((int)daysBetween);
            renteduser = user.getName();
         }
    }
}
public double dropMe(){
    
    double price = getNumberOfDays() * getDailyFee();
    rentStatus = true;
    bookStatus = true;
    renteduser = null;
    return price;
}

    
    /**
     * @return the plateNumber
     */
    public int getPlateNumber() {
        return plateNumber;
    }

    /**
     * @param plateNumber the plateNumber to set
     */
    public void setPlateNumber(int plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * @return the numberOfTires
     */
    public int getNumberOfTires() {
        return numberOfTires;
    }

    /**
     * @param numberOfTires the numberOfTires to set
     */
    public void setNumberOfTires(int numberOfTires) {
        this.numberOfTires = numberOfTires;
    }

    /**
     * @return the dailyFee
     */
    public double getDailyFee() {
        return dailyFee * getNumberOfDays();
    }

    /**
     * @param dailyFee the dailyFee to set
     */
    public void setDailyFee(int dailyFee) {
        this.dailyFee = dailyFee;
    }

    /**
     * @return the numberOfDays
     */
    public int getNumberOfDays() {
        return numberOfDays;
    }

    /**
     * @param numberOfDays the numberOfDays to set
     */
    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
     public boolean isBookable() {
        return bookable;
    }

    public void setBookable(boolean bookable) {
        this.bookable = bookable;
    }

    /**
     * @return the bookStatus
     */
    public boolean isBookStatus() {
        return bookStatus;
    }

    /**
     * @param bookStatus the bookStatus to set
     */
    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    /**
     * @return the rentStatus
     */
    public boolean isRentStatus() {
        return rentStatus;
    }

    /**
     * @param rentStatus the rentStatus to set
     */
    public void setRentStatus(boolean rentStatus) {
        this.rentStatus = rentStatus;
    }

    /**
     * @return the bookStarting
     */
    public String getBookStarting() {
        return bookStarting;
    }

    /**
     * @param bookStarting the bookStarting to set
     */
    public void setBookStarting(String bookStarting) {
        this.bookStarting = bookStarting;
    }

    /**
     * @return the bookEnding
     */
    public String getBookEnding() {
        return bookEnding;
    }

    /**
     * @param bookEnding the bookEnding to set
     */
    public void setBookEnding(String bookEnding) {
        this.bookEnding = bookEnding;
    }

    /**
     * @return the rentStarting
     */
    public String getRentStarting() {
        return rentStarting;
    }

    /**
     * @param rentStarting the rentStarting to set
     */
    public void setRentStarting(String rentStarting) {
        this.rentStarting = rentStarting;
    }

    /**
     * @return the rentEnding
     */
    public String getRentEnding() {
        return rentEnding;
    }

    /**
     * @param rentEnding the rentEnding to set
     */
    public void setRentEnding(String rentEnding) {
        this.rentEnding = rentEnding;
    }

}
