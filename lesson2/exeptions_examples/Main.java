package lesson2.exeptions_examples;

public class Main {
    public static void main(String[] args) {
        //TODO
        /**
         * В методе main необходимо вызвать полученные методы,
         * обработать возможные исключения и вывести результат расчета.
         */
        //String[][] newArray1 = {{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"}};
        //printArray(stringArrayToInt(newArray1));
        String newString1 = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        try {
            System.out.println("The result is " + ExeptionMethods.summarizeArray(newString1));
        }
        catch (NullPointerException | NumberFormatException | ExeptionMethods.MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        catch (ExeptionMethods.MyArrayDataException e) {
            System.out.println(e.getMessage() +  "\nThe element '" + e.getWrongElement() + "' is located in: row number " + e.getNumberRow() + ", column number " + e.getNumberCol());
        }
    }
}
