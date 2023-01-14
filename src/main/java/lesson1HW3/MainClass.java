package lesson1HW3;

import lesson1HW3.Fruits.Apple;
import lesson1HW3.Fruits.Orange;

import java.util.ArrayList;

/**
 * Задача:
 * Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 *
 * Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
 * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 *
 * Для хранения фруктов внутри коробки можно использовать ArrayList;
 *
 * Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
 * вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 *
 * Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
 * которую подадут в compare() в качестве параметра.
 * true – если их массы равны, false в противоположном случае.
 * Можно сравнивать коробки с яблоками и апельсинами;
 *
 * Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
 * Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
 * Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
 *
 * Не забываем про метод добавления фрукта в коробку.
 */
public class MainClass {
    public static void main(String[] args) {

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
