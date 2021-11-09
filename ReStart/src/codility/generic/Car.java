package codility.generic;

public class Car {
    protected String name;
    public Car(String name){
        this.name = name;
    }

    public String toString(){
        return "Car name = "+ name;
    }

}

class Bus extends Car{
    public Bus(String name) {
        super(name);
    }
    public String toString(){
        return "Bus name = "+name;
    }
}


class CarWildcardSample{
    public static void main(String[] args) {
        CarWildcardSample sample = new CarWildcardSample();
        sample.callBoundedWildcardMethod();
    }
    public void callBoundedWildcardMethod(){
        WildcardGeneric<Car> wildcard = new WildcardGeneric<>();
        wildcard.setWildcard(new Car("Mustang"));
        boundedWildcardMethod(wildcard);
    }

    public void boundedWildcardMethod(WildcardGeneric<? extends Car> c){
        Car value = c.getWildcard();
        System.out.println(value);
    } 
}