package lesson1HW1;

import java.util.Arrays;
/**
 * 1. Написать метод, который меняет два элемента массива местами
 * (массив может быть любого ссылочного типа);
 */
public class MainClass {

    public static void main(String[] args) {

        Integer[] aa = {5, 8, 9, 10};
        swapArray(aa,3,2);
        System.out.println(Arrays.toString(aa));

        String[] ss = {"s5", "s8", "s9", "s10"};
        swapArray(ss,3,1);
        System.out.println(Arrays.toString(ss));

    }

    public static <T> void swapArray(T[] arr, int index1, int index2) {
        if(index1>= arr.length || index2>=arr.length || index1<0 || index2<0){
            throw new IndexOutOfBoundsException();
        }
        T t;
        t = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = t;
    }

}