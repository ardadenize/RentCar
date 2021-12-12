/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje3;

/**
 *
 * @author arda
 */
public class Truck extends Vehicle {
    private int loadingCap;

    public Truck(int plateNumber, int numberOfTires, double dailyFee, boolean bookable,int loadingCap) {
        super(plateNumber, numberOfTires, dailyFee, bookable);
        this.loadingCap = loadingCap;
        
    }
    public int getLoadingCap() {
        return loadingCap;
    }

    public void setLoadingCap(int loadingCap) {
        this.loadingCap = loadingCap;
    }
}
class SmallTrucks extends Truck {

    public SmallTrucks(int plateNumber, int numberOfTires, double dailyFee, boolean bookable,int loadingCap) {
        super(plateNumber, numberOfTires, dailyFee, bookable,loadingCap);
    }
}
class TransportTrucks extends Truck{

    public TransportTrucks(int plateNumber, int numberOfTires, double dailyFee, boolean bookable, int loadingCap) {
        super(plateNumber, numberOfTires, dailyFee, bookable,loadingCap);
    }

    

    
    
}
