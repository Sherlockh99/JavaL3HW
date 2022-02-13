package Testings;
import lesson6.MainClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test {

    public static Stream<Arguments> dataForSumArr(){
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(true, new int[]{1,1,1,4,4,1,4,4},1,4));
        list.add(Arguments.arguments(false, new int[]{1,1,1,1,1,1},1,4));
        list.add(Arguments.arguments(false, new int[]{4,4,4,4},1,4));
        list.add(Arguments.arguments(false, new int[]{1,4,4,1,1,4,3},1,4));
        list.add(Arguments.arguments(true, new int[]{1,1,1,5,5,1,5,5},1,5));

        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForSumArr")
    public void massTestSumArr(boolean result, int[] arr, int firstNumber, int lastNumber){
        Assertions.assertEquals(result, MainClass.checkFirstLastNumbers(arr,firstNumber,lastNumber));
    }
}
