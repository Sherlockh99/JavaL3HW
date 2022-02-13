package lesson6;

import java.io.IOException;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        try {
            task1();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        task2();
    }

    public static void task1(){
        int[] arr = {1,2,4,4,2,3,4,1,7};
        int[] arr_res = newArrayAfterLastNumber(arr,4);
        System.out.println(Arrays.toString(arr_res));
        int[] arr2 = {1, 2, 4, 1, 7, 5, 3, 2};
        int[] arr2_res = newArrayAfterLastNumber(arr2,4);
        System.out.println(Arrays.toString(arr2_res));
        int[] arr3 = {1, 2, 4};
        int[] arr3_res = newArrayAfterLastNumber(arr3,4);
        System.out.println(Arrays.toString(arr3_res));
        int[] arr4 = {1, 2, 5, 6};
        int[] arr4_res = newArrayAfterLastNumber(arr4,4);
        System.out.println(Arrays.toString(arr4_res));
    }

    public static int[] newArrayAfterLastNumber(int[] array, int lastFindNumber){
        for (int i = array.length; i > 0; i--) {
            if(array[i-1]==lastFindNumber){
                return Arrays.copyOfRange(array, i, array.length);
            }
        }
        throw new RuntimeException("Не найдено в массиве цифры: " + lastFindNumber);
    }

    public static void task2(){
        int[] arr1 = {1,1,1,4,4,1,4,4};
        int[] arr2 = {1,1,1,1,1,1};
        int[] arr3 = {4,4,4,4};
        int[] arr4 = {1,4,4,1,1,4,3};
        int[] arr5 = {1,1,1,5,5,1,5,5};

        System.out.println(checkFirstLastNumbers(arr1));
        System.out.println(checkFirstLastNumbers(arr2));
        System.out.println(checkFirstLastNumbers(arr3));
        System.out.println(checkFirstLastNumbers(arr4));
        System.out.println(checkFirstLastNumbers(arr5,1,5));
    }


    public static boolean checkFirstLastNumbers(int[] array) {
        return checkFirstLastNumbers(array,1,4);
    }

    public static boolean checkFirstLastNumbers(int[] array, int firstNumber, int secondNumber) {
        if (array.length < 2) {
            return false;
        }
        if (firstNumber > secondNumber) {
            firstNumber += secondNumber;
            secondNumber = firstNumber - secondNumber;
            firstNumber = firstNumber - secondNumber;
        }
        int[] sortArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortArray);
        if (!(sortArray[0] == firstNumber && sortArray[sortArray.length - 1] == secondNumber)) {
            return false;
        }
        for (int i = sortArray[1]; i < sortArray.length-1; i++) {
            if(!(sortArray[i]==firstNumber || sortArray[i]==secondNumber)){
                return false;
            }
        }
        return true;
    }
}
