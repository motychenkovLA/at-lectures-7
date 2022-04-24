package helloWorld;

public class Main {

    public static void main(String[] args) {

        Car lada = new Car("lada", "green");

        Car lada2 = cloneCar(lada);

        lada2.model = "bmw";
        System.out.println(lada.getModel());
        System.out.println(lada2.getModel());

    }

    public static Car cloneCar(Car car1) {
        return new Car(car1.getModel(), car1.getColor());
    }
}
