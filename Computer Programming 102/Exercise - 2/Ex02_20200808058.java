import java.util.ArrayList;

public class Ex02_20200808058 {
    public static void main(String[] args){
    }
}
abstract class Vehicle{
    private Engine engine;
    private int speed;
    protected int maxSpeed;
    protected int changeInSpeed;
    protected int gasTankCapacity;
    protected double currentGasInTank;
    public Vehicle(int gearCount,int maxSpeed,int changeInSpeed,int gasTankCapacity){
        this.engine = new Engine(gearCount);
        this.maxSpeed = maxSpeed;
        this.changeInSpeed = changeInSpeed;
        this.gasTankCapacity = gasTankCapacity;
        this.currentGasInTank = gasTankCapacity - (Math.random()*10) + 5;
    }
    public Vehicle() {
    }
    public final void setGear(){
        int a = maxSpeed / engine.getGearCount();
        while((speed / a) + 1  == engine.getCurrentGear()){
            if (engine.getCurrentGear() > (speed / a) + 1)
                engine.shiftDown();
            else
                engine.shiftUp();
        }
    }
    public void accelerate(){
        this.speed=getSpeed() + getChangeInSpeed();
    }
    public void decelerate(){
        this.speed = getSpeed() - getChangeInSpeed();
    }
    public int getChangeInSpeed() {
        return changeInSpeed;
    }
    public void setChangeInSpeed(int changeInSpeed) {
        this.changeInSpeed = changeInSpeed;
    }
    public double getGasPercentage(){
        return currentGasInTank/gasTankCapacity*100;
    }
    public final void consumeGas(){
        if(this instanceof Car)
            currentGasInTank -= 2*engine.currentGear;
        else if(this instanceof Motorcycle)
            currentGasInTank -= 3*engine.currentGear;
        else if(this instanceof Bus)
            currentGasInTank -= 5*engine.currentGear;
    }
    public int getSpeed() {
        return speed;
    }
    abstract double refuel();
    @Override
    public String toString(){
        return "Class name is " + getClass().getName() + " Speed is " +
                speed + " change in speed is " + changeInSpeed +
                " maximum speed is " + maxSpeed + "gas percentage is " +
                getGasPercentage() + " and " + engine.toString();
    }
    class Engine{
        private int gearCount;
        private int currentGear;
        private Engine(int gearCount){
            this.gearCount = gearCount;
            this.currentGear = 0;
        }
        private int getGearCount() {
            return gearCount;
        }
        private int getCurrentGear() {
            return currentGear;
        }
        private void shiftUp(){
            currentGear++;
        }
        private void shiftDown(){
            currentGear--;
        }
        @Override
        public String toString(){
            return "Current gear is " + currentGear +
                    " and number of gears are " + gearCount;
        }
    }
}
class Car extends Vehicle{
    static final private int NUMBER_OF_GEARS = 6;
    static final private int GAS_TANK_CAPACITY = 50;
    private int doorCount = 4;
    public Car(){
        super();

        super.maxSpeed = 250;
        super.changeInSpeed = 20;
    }
    public Car(int maxSpeed,int changeInSpeed){
        super(NUMBER_OF_GEARS,maxSpeed,changeInSpeed,GAS_TANK_CAPACITY);
    }
    public Car(int maxSpeed,int changeInSpeed,int doorCount){
        super.maxSpeed = maxSpeed;
        super.changeInSpeed =changeInSpeed;
        this.doorCount = doorCount;
    }
    public void accelerate(int changeInSpeed){
        setChangeInSpeed(changeInSpeed);
        super.accelerate();
        if(super.getGasPercentage() <= 10 )
            System.out.println("FUEL WARNING!");
    }
    public void decelerate(int changeInSpeed){
        setChangeInSpeed(changeInSpeed);
        super.decelerate();
    }

    public double refuel(){
        return 50 / 18.32;
    }
    @Override
    public String toString(){
        return super.toString() + " number of doors are " + this.doorCount;
    }
}
class Motorcycle extends Vehicle{
    static final private int NUMBER_OF_GEARS = 6;
    static final private int GAS_TANK_CAPACITY = 50;
    private String color;
    @Override
    public String toString(){
        return super.toString() + " color of motorcycle is " + this.color;
    }
    public double refuel(){
        currentGasInTank = GAS_TANK_CAPACITY;
        return GAS_TANK_CAPACITY - currentGasInTank;
    }
}
class Bus extends Vehicle{
    static final private int NUMBER_OF_GEARS = 6;
    static final private int GAS_TANK_CAPACITY = 50;
    private int standingPassengerCount;
    @Override
    public String toString() {
        return super.toString() + " standing passenger count is " + this.standingPassengerCount;
    }
    public double refuel(){
        double a = GAS_TANK_CAPACITY / 5 * 4;
        currentGasInTank = a;
        return a - currentGasInTank;
    }
}
class GasStation{
    ArrayList<Vehicle> vehicles;
    static final private double costPerLiter= 20.40;
    private int vehicleLimit;
    public GasStation(int vehicleLimit){
        this.vehicleLimit = vehicleLimit;
    }
    public GasStation(){
        this.vehicleLimit = 20;
    }
    public void fuelUpAll(){
        for(int i = 0; i < vehicles.size();i++){
            if(vehicles.get(i).currentGasInTank <= vehicleLimit) {
                vehicles.get(i).currentGasInTank = vehicles.get(i).gasTankCapacity;
                System.out.println(vehicles.toString() +
                        " cost is " +
                        (vehicles.get(i).gasTankCapacity
                                - vehicles.get(i).currentGasInTank)
                                / costPerLiter);
            }
        }
    }
    public void fuelUpAll(ArrayList<Vehicle> vehicles){
        for(int i = 0; i < vehicles.size();i++){
            vehicles.get(i).currentGasInTank = vehicles.get(i).gasTankCapacity;
            System.out.println(vehicles.toString() +
                    " cost is " +
                    (vehicles.get(i).gasTankCapacity
                            - vehicles.get(i).currentGasInTank)
                            / costPerLiter);
        }
    }
}
