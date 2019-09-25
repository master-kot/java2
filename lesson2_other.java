public class lesson2_other {

    private static String[][] stringToArray(String inputString) throws ArrayIndexOutOfBoundsException {
        String[] splittedOnceArray = inputString.split("\n");
        if (splittedOnceArray.length != 4) {
            throw new ArrayIndexOutOfBoundsException ("Incoming String is wrong, so output array doesn't contain 4 rows!");
        }
        String[][] splittedTwiceArray = new String[splittedOnceArray.length][];
        try {
            for (int i = 0; i < splittedOnceArray.length; i++) {
                splittedTwiceArray[i] = splittedOnceArray[i].split(" ");
                if (splittedTwiceArray[i].length != 4) {
                    throw new ArrayIndexOutOfBoundsException ("Incoming String is wrong, so output array doesn't contain 4 columns!");
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return splittedTwiceArray;
    }

    //Метод может преобразовать массив типа String[][] любого размера
    private static int[][] stringArrayToInt(String[][] inputArray) throws NullPointerException {
        int[][] changedArray = new int[inputArray.length][];
        try {
            for (int i = 0; i < inputArray.length; i++) {
                changedArray[i] = new int[inputArray[i].length];
                for (int j = 0; j < inputArray[i].length; j++) {
                    changedArray[i][j] = Integer.parseInt(inputArray[i][j]);
                }
            }
        }
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException happened. Incoming array contains some elements of type String, that cannot be changed to int type!");
        }
        catch (NullPointerException e){
            System.out.println("NullPointerException happened. Incoming array contains some empty (not defined) elements!");
        }
        return changedArray;
    }

    //Обработаны исключения если на вход подается массив содержащий элементы, отличные от цифр
    //а также если на вход подается массив, содержащий неопределенные элементы
    private static int summarizeArray(int[][] inputArray) {
        int result = 0;
        try {
            for (int[] ints : inputArray) {
                for (int anInt : ints) {
                    result += anInt;
                }
            }
        }
        catch (NumberFormatException e){
            System.out.println("NumberFormatException happened. Incoming array contains some elements of type String, that cannot be changed to int type!");
        }
        catch (NullPointerException e){
            System.out.println("NullPointerException happened. Incoming array contains some empty (not defined) elements!");
        }
        return result / 2;
    }

    //Это просто метод печати двумерного массива int, использовался для проверки работы кода
    private static void printArray(int[][] inputArray) {
        try {
            for (int[] ints : inputArray) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        }
        catch (NullPointerException e){
            System.out.println("NullPointerException happened. Incoming array contains some empty (not defined) elements!");
        }
    }

    public static void main (String[] args){
        String[][] newArray1 = {{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"}};
        printArray(stringArrayToInt(newArray1));
        String newString1 = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        System.out.println("The result is " + summarizeArray(stringArrayToInt(stringToArray(newString1))));
    }
}