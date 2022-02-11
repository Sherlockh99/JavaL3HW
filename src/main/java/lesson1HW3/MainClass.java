package lesson1HW3;

import com.sun.org.apache.xpath.internal.operations.Or;
import lesson1HW3.Fruits.Apple;
import lesson1HW3.Fruits.Fruit;
import lesson1HW3.Fruits.Orange;

import java.util.ArrayList;

public class MainClass {
    //private ArrayList<Fruit> fruits;
    public static void main(String[] args) {
        //fruits = new ArrayList<>();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple(1.2);
        Apple apple3 = new Apple(1.5);
        Apple apple5 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange(1.3);
        Orange orange3 = new Orange(1.7);
        Orange orange4 = new Orange(1.0);

        ArrayList<Apple> arrApples = new ArrayList<Apple>();
        arrApples.add(apple2);
        arrApples.add(apple3);

        ArrayList<Orange> arrOranges = new ArrayList<>();
        arrOranges.add(orange1);
        arrOranges.add(orange2);
        arrOranges.add(orange3);


        Box<Apple> boxApple1 = new Box<Apple>(apple1);
        Box<Apple> boxApple2 = new Box<Apple>(arrApples);

        Box<Orange> boxOrange1 = new Box<Orange>(arrOranges);
        Box<Orange> boxOrange2 = new Box<Orange>(orange4);

        System.out.println("Weight box apple1: " + boxApple1.getWeight());
        System.out.println("Weight box apple2: " + boxApple2.getWeight());

        System.out.println("Weight box orange1: " + boxOrange1.getWeight());
        System.out.println("Weight box orange2: " + boxOrange2.getWeight());

        System.out.println(boxApple1.compare(boxOrange1));
        System.out.println(boxApple1.compare(boxOrange2));

        boxApple1.addFruits(boxApple2);

        System.out.println("Weight box apple1: " + boxApple1.getWeight());
        System.out.println("Weight box apple2: " + boxApple2.getWeight());
        boxApple1.addFruit(apple5);
        System.out.println("Weight box apple1: " + boxApple1.getWeight());
    }
}
