package lesson1HW3.Fruits;

public abstract class Fruit {
    //protected double weight;
    private double weight;

    public Fruit(double weight){
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
