package lesson2.exeptions_examples;

public class ExeptionMethods {

    static class MyArraySizeException extends Exception{
        MyArraySizeException(String message){
            super(message);
        }
    }

    static class MyArrayDataException extends Exception{
        private int numberRow;
        private int numberCol;
        private String wrongElement;
        int getNumberRow(){return numberRow;}
        int getNumberCol(){return numberCol;}
        String getWrongElement(){return wrongElement;}
        MyArrayDataException(String message, String wrongElement, int numberRow, int numberCol){
            super(message);
            this.wrongElement = wrongElement;
            this.numberRow = numberRow;
            this.numberCol = numberCol;
        }
    }

    private static String[][] stringToArray(String inputString) throws MyArraySizeException {
        String[] splittedOnceArray = inputString.split("\n");
        if (splittedOnceArray.length != 4) {
            throw new MyArraySizeException ("Incoming String is wrong, so output array doesn't contain 4 rows!");
        }
        String[][] splittedTwiceArray = new String[splittedOnceArray.length][];
        for (int i = 0; i < splittedOnceArray.length; i++) {
            splittedTwiceArray[i] = splittedOnceArray[i].split(" ");
            if (splittedTwiceArray[i].length != 4) {
                throw new MyArraySizeException ("Incoming String is wrong, so output array doesn't contain 4 columns!");
            }
        }
        return splittedTwiceArray;
    }

    //Метод может преобразовать массив типа String[][] любого размера в тип int[][]
    private static int[][] stringArrayToInt(String[][] inputArray) throws NumberFormatException, NullPointerException, MyArrayDataException {
        int[][] changedArray = new int[inputArray.length][];
        for (int i = 0; i < inputArray.length; i++) {
            changedArray[i] = new int[inputArray[i].length];
            for (int j = 0; j < inputArray[i].length; j++) {
                try {
                    changedArray[i][j] = Integer.parseInt(inputArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException ("The array contains an element, that cannot be changed to int type!", inputArray[i][j], i, j);
                }
            }
        }
        return changedArray;
    }

    public static int summarizeArray(String in) throws NumberFormatException, NullPointerException, MyArraySizeException, MyArrayDataException {
        int[][] inputArray = stringArrayToInt(stringToArray(in));

        int result = 0;

        for (int[] ints : inputArray) {
            for (int anInt : ints) {
                result += anInt;
            }
        }
        return result / 2;
    }

    //Это просто метод печати двумерного массива int, использовался для проверки работы кода
    private static void printArray(int[][] inputArray) throws NullPointerException {
        for (int[] ints : inputArray) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
