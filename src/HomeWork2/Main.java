package HomeWork2;

public class Main {
    public static void main(String[] args) {
        String[][] array = {{"1", "4", "1", "3"}, {"1", "1", "hhh", "1"}};
        try {
            if(!(array[0].length == 4) || !(array[1].length == 4)) {
                throw new MyArraySizeException();
            }
            System.out.println(myMethod(array));
        } catch (MyArraySizeException e) {
            System.out.println("Wrong array size");
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static int myMethod(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int res = 0;
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    num = Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    System.out.println("Error in cell " + i + " " + j);
                    throw new MyArrayDataException();
                }
                res += num;
            }
        }
        return res;
    }
}
