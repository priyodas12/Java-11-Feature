package collectionApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayConversion {
    public static void main(String[] args) {
        List<Integer> numbers=new ArrayList<>();

        numbers.add(1);
        numbers.add(4);
        numbers.add(7);

        System.out.println(numbers);
        // Java 8 Approach with lambda expression;
        Integer[] arrayOfNumbersJ8=numbers.stream().toArray(value -> new Integer[numbers.size()]);
        System.out.println(Arrays.toString(arrayOfNumbersJ8));

        // Java 11 Approach;
        Integer[] arrayOfNumbersJ11=numbers.toArray(value -> new Integer[value]);
        // or using method reference;
        arrayOfNumbersJ11=numbers.toArray(Integer[]::new);
        System.out.println(Arrays.toString(arrayOfNumbersJ11));

    }
}
