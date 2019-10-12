package lesson2;

public class lesson2 {
    //В данном коде я не использовал блоки try / catch внутри методов обработки массивов
    //здесь я их ловил на в теле метода main()
    //Очень прошу максимально поругать все косяки моего кода, в следующий раз буду его делать лучше

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

    private static int summarizeArray(int[][] inputArray) throws NumberFormatException, NullPointerException {
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

    public static void main (String[] args){
        //String[][] newArray1 = {{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"}};
        //printArray(stringArrayToInt(newArray1));
        String newString1 = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        try {
            System.out.println("The result is " + summarizeArray(stringArrayToInt(stringToArray(newString1))));
        }
        catch (NullPointerException | NumberFormatException | MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        catch (MyArrayDataException e) {
            System.out.println(e.getMessage() +  "\nThe element '" + e.getWrongElement() + "' is located in: row number " + e.getNumberRow() + ", column number " + e.getNumberCol());
        }
    }
}