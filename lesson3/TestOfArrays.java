package lesson3;

import java.util.Arrays;
import java.util.HashSet;

public class lesson3 {

    public void listFromArray (String[] inputString) {
        HashSet<String> listArrayParts = new HashSet<>(Arrays.asList(inputString));
        System.out.println(listArrayParts);

//  HashSet<String> listArrayParts = new HashSet<>();
//        for (int i = 0; i < inputString.length; i++) {
//            listArrayParts.add(inputString[i]);
//        }
    }

    public static void main(String[] args) {
        String[] someArray = {"first", "second", "third", "forth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth", "first", "second", "third", "forth", "firth", "sixth", "first", "second", "third", "fourth", "first", "second"};
    }
}
