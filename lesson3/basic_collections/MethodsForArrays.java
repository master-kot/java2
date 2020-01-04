package lesson3.basic_collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MethodsForArrays {

    private static void listFromArray(String[] inputString) {
//Это позволяет нам получить запрашиваемый список неповторяющихся членов массива
//Не использую LinkedHashSet потому что в условиях не стояло упорядочить список
        HashSet<String> listArrayParts = new HashSet<>(Arrays.asList(inputString));

        System.out.println("The list of array's part: " + listArrayParts);
    }

    private static void countArrayParts (String[] inputString) {
//почитал какие методы нам могут помочь выполнить задание и решил использовать встроенные
        HashMap<String, Integer> mapArrayParts = new HashMap<>();
        for (String s : inputString) {
            if (mapArrayParts.containsKey(s)) {
                int j = mapArrayParts.get(s);
                mapArrayParts.replace(s, ++j);
            } else {
                mapArrayParts.put(s, 1);
            }
        }
        System.out.println("The list of array's part and number of their presence: " + mapArrayParts);
    }

    public static void main(String[] args) {
        String[] someArray = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth", "first", "second", "third", "fourth", "fifth", "sixth", "first", "second", "third", "fourth", "first", "second"};
        listFromArray(someArray);
        countArrayParts(someArray);
    }
}
