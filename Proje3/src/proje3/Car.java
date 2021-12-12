
package proje3;

/**
 *
 * @author arda
 */
public class Car extends Vehicle {
    private String color;
    private int seatingCap;
    private int numOfDoors;

    public Car(int plateNumber, int numberOfTires,String color,int seatingCap,int numOfDoors, double dailyFee, boolean bookable) {
        super(plateNumber, numberOfTires, dailyFee, bookable);
        this.numOfDoors = numOfDoors;
        this.seatingCap = seatingCap;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeatingCap() {
        return seatingCap;
    }

    public void setSeatingCap(int seatingCap) {
        this.seatingCap = seatingCap;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }
 }

class Sports extends Car{
    private int hp;

    public Sports(int plateNumber, int numberOfTires, String color, int seatingCap, int numOfDoors, double dailyFee, boolean bookable,int hp) {
        super(plateNumber, numberOfTires, color, seatingCap, numOfDoors, dailyFee, bookable);
        this.hp =hp;
    }

   
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

 }

class SW extends Car{
    private int loadingCap;

    public SW(int plateNumber, int numberOfTires, String color, int seatingCap, int numOfDoors, double dailyFee, boolean bookable, int loadingCap) {
        super(plateNumber, numberOfTires, color, seatingCap, numOfDoors, dailyFee, bookable);
        this.loadingCap = loadingCap;
    }

    

    public void loadMe(int loadperson){
    if(loadperson>loadingCap){
        throw new ArithmeticException("You have exceeded the loading capacity"); 
    }
}
    public int getLoadingCap() {
        return loadingCap;
    }

    public void setLoadingCap(int loadingCap) {
        this.loadingCap = loadingCap;
    }

 }
class SUV extends Car{
    private int wd;

    public SUV(int plateNumber, int numberOfTires, String color, int seatingCap, int numOfDoors, double dailyFee, boolean bookable,int wd) {
        super(plateNumber, numberOfTires, color, seatingCap, numOfDoors, dailyFee, bookable);
        this.wd = wd;
    }

    
    public int getWd() {
        return wd;
    }
    public void setWd(int wd) {
        this.wd = wd;
    }
}
