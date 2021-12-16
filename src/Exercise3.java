public class Exercise3 {

    public static void main(String[] args) {
        int number = 340;
        int[] Array = arrayOfOnlyDivisors(number);
        System.out.println("The primary numbers are: ");
        for (int i = 0; i < Array.length; i++) {
            System.out.print(Array[i] + ",");
        }
    }

    public static int numberOfDivisors(int number) {
        int counter = 0;
        int divisor = 2;
        while (number != 1) {
            if (number % divisor == 0) {
                number = number / divisor;
                counter++;
            } else
                divisor++;
        }
        return counter;
    }

    public static int[] arrayOfOnlyDivisors(int num) {
        int[] arrayOfDivisors = new int[numberOfDivisors(num)];
        int index = 0;
        int divisor = 2;
        while (num != 1) {
            if (num % divisor == 0) {
                num = num / divisor;
                arrayOfDivisors[index] = divisor;
                index++;
            } else divisor++;
        }
        return arrayOfDivisors;
    }
}
