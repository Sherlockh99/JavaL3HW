package lesson1HW2;

import java.util.ArrayList;
import java.util.Arrays;

/**
2.Написать метод, который преобразует массив в ArrayList;
 */
public class MainClass {

    public static void main(String[] args) {

        String[] arrayOfStrings = {"1", "2", "3", "4"};
        ArrayList<String> arrayList = arrayToArrayList(arrayOfStrings);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i)+ " ");
        }
    }

    public static <T> ArrayList<T> arrayToArrayList(T[] array){
        return new ArrayList<T>(Arrays.asList(array));
    }
}