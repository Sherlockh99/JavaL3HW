package lesson1HW3;

import lesson1HW3.Fruits.Fruit;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits;

    public Box(ArrayList<T> fruits){
        this.fruits = new ArrayList<T>();
        this.fruits.addAll(fruits);
    }

    public Box(T fruit){
        fruits = new ArrayList<T>();
        fruits.add(fruit);
    }


    public void addFruits(Box<T> box){
        fruits.addAll(box.fruits);
        box.fruits.clear();
    }

    public void addFruit(T fruit){
        fruits.add(fruit);
    }


    public double getWeight(){
        double weight = 0;
        for (int i = 0; i < fruits.size(); i++) {
            weight+=fruits.get(i).getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> box){
        return getWeight() == box.getWeight();
    }

    /*
    public void addFruit(Box<T> fromBox){
        //addFruit(fromBox.fruits);
        fromBox.fruits.clear();
    }
    */
}
