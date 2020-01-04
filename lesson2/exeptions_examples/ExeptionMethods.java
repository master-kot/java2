package lesson2.exeptions_examples;

public class ExeptionMethods {

    //TODO
    /**
     * Написать метод, на вход которого подаётся строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0",
     * метод должен преобразовать строку в двумерный массив типа String[][];
     * Ваши методы должны бросить исключения в случаях:
     * Если размер матрицы, полученной из строки, не равен 4x4;
     * Если в одной из ячеек полученной матрицы не число; (например символ или слово)
     */

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

    private static final int MATRIX_ROWS = 4;
    private static final int MATRIX_COLS = 4;

    /**
     * Преобразование строки в двумерный массив типа String[][]
     */
    private static String[][] stringToArray(String inputString) throws MyArraySizeException {
        String[] splittedArray = inputString.split("\n");
        if (splittedArray.length != MATRIX_ROWS) {
            throw new MyArraySizeException (String.format("Incoming String is wrong and does not contain %s rows!", MATRIX_ROWS));
        }
        String[][] splittedTwiceArray = new String[splittedArray.length][];
        for (int i = 0; i < splittedArray.length; i++) {
            splittedTwiceArray[i] = splittedArray[i].split(" ");
            if (splittedTwiceArray[i].length != 4) {
                throw new MyArraySizeException (String.format("Incoming String is wrong and does not contain %s columns!", MATRIX_COLS));
            }
        }
        return splittedTwiceArray;
    }

    /**
     * Преобразование массива типа String[][] любого размера в тип int[][]
     */
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

    //TODO
    /**
     * Преобразовать строки, просуммировать, поделить полученную сумму на 2 и вернуть результат;
     */
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

    /**
     * метод печати двумерного массива int, использовался для проверки работы кода
     */
    private static void printArray(int[][] inputArray) throws NullPointerException {
        for (int[] ints : inputArray) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
