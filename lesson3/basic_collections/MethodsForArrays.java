package lesson3.basic_collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MethodsForArrays {

    //TODO
    /**
     * Задан массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
     * Найти список слов, из которых состоит текст (дубликаты не считать);
     */
    public static HashSet<String> transformArrayToSet (String[] inputArray) {
        return new HashSet<String>(Arrays.asList(inputArray));
    }

    //TODO
    /**
     * Посчитать сколько раз встречается каждое слово (использовать HashMap);
     */
    public static HashMap<String, Integer> countArrayParts (String[] inputArray) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String s : inputArray) {
            if (result.containsKey(s)) {
                result.replace(s, result.get(s) + 1);
            } else {
                result.put(s, 1);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String[] someArray = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth", "first", "second", "third", "fourth", "fifth", "sixth", "first", "second", "third", "fourth", "first", "second"};
        System.out.println(MethodsForArrays.transformArrayToSet(someArray));
        System.out.println(MethodsForArrays.countArrayParts(someArray));
    }
}
