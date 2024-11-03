
import java.util.*;

public class Q2_20200808058 {
    public static void main(String[] args){

    }
}
abstract class Product{
    String name;
    Date manufacture;
    int serialNumber;
    int durability;
    Product(String name,Date manufacture,int durability) throws Exception {
        this.name = name;
        this.manufacture = manufacture;
        this.serialNumber = Math.random();
        if(name.equals("CPU") && durability > 60)
            throw new Exception("ERROR");
        else
            this.durability = durability;
        if(name.equals("GPU") && durability > 80)
            throw new Exception("ERROR");
        else
            this.durability = durability;
    }
    Product(String name,Date manufacture) {
        this.name = name;
        this.manufacture = manufacture;
        this.serialNumber = (int)(Math.random());
        this.durability = 0;
    }

    public int getDurability() {
        return durability;
    }

    public String getName() {
        return name;
    }

}
class graphicCard extends Product{
    String name;
    Date manufacture;
    int serialNumber;
    int durability;
    String memoryType;
    int memorySize;
    int numberOfCores;
    graphicCard(String name,Date manufacture,int durability,String memoryType,int memorySize,int numberOfCores) throws Exception {
        super(name, manufacture, durability);
        this.memorySize = memorySize;
        this.memoryType = memoryType;
        this.numberOfCores = numberOfCores;
    }
}
class processor extends Product{
    String name;
    Date manufacture;
    int serialNumber;
    int durability;
    int cacheSize;
    double frequency;
    processor(String name,Date manufacture,int durability,int cacheSize,double frequency) throws Exception {
        super(name, manufacture, durability);
        this.cacheSize = cacheSize;
        this.frequency = frequency;
    }
}
abstract class Employee{
    String name;
    String surname;
    int registrationNumber;
    Employee(String name,String surname){
        this.name = name;
        this.surname = surname;
        this.registrationNumber = (int)(Math.random());
    }
}
class qualityAssuranceSpecialists extends Employee{
    String name;
    String surname;
    int registrationNumber;
    qualityAssuranceSpecialists(String name ,String surname){
        super(name,surname);
    }
    public <E extends Product> void test(E product, Stack<E> sellingProducts, Queue<E> anotherOrder){
        double qualityScore = product.durability*100/60;
        if(qualityScore > 85)
            sellingProducts.push(product);
        else
            anotherOrder.add(product);
    }
 }
 class Engineer extends Employee{
     String name;
     String surname;
     int registrationNumber;
     int experienceYear;
     Product productType;
     Engineer(String name ,String surname,int experienceYear){
         super(name,surname);
         this.experienceYear = experienceYear;
     }
     public int productionDurability(ArrayList<Engineer> engineers,Product product){
         for(int i = 0; i < engineers.size();i++){
             product.durability = engineers.get(i).experienceYear + 10;
         }
         return product.durability;
     }
     public <E extends Product> void hiredEngineers(E product,ArrayList<Engineer> productGroup){
         productGroup.add(engineer);
     }
 }
class chiefEngineer extends Engineer {
    String name;
    String surname;
    int registrationNumber;
    int experienceYear;
    Product productType;

    chiefEngineer(String name, String surname, int experienceYear) {
        super(name, surname,experienceYear);
    }
    public void hire (ArrayList<Engineer> engineers, Engineer engineer){
        engineers.add(engineer);
    }
    public void fire (ArrayList<Engineer> engineers, Engineer engineer){
        engineers.remove(engineer);
    }
}
class Facility{
    String[] cpuNames = {"i31220PE", "i512600HX", "i712700K", "i912900E" };
    String[] gpuNames = { "GTX980", "GTX1080", "GTX2080", "GTX3080"};
    public <E extends Product> void makeProduct(Queue<E> requestedProduct){

    }
}