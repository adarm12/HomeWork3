import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {

        int numberToCheck;
        boolean answer;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter integer number: ");
            numberToCheck = scanner.nextInt();
        } while (numberToCheck < 0);

        for (int i = 0; i < checkDigit(numberToCheck) - 1; i++)
            System.out.println(checkDigit(i));
        answer = checkParity(prepareNumber(checkDigit(numberToCheck), numberToCheck));
        if (answer == false)
            System.out.println("false");
        else
            System.out.println("true");

        int[] test = {22, 555, 44, 88, 795};
        int minIndex = index(test);
        System.out.println("The smallest index is: " + minIndex);
    }

    public static int checkDigit(int numberToCheck) {
        int counter = 0;
        int numberOfDigit = numberToCheck;
        while (numberOfDigit != 0) {
            numberOfDigit = numberOfDigit / 10;
            counter++;
        }
        return counter;
    }

    public static int[] prepareNumber(int sizeArray, int inputNumber) {
        int[] numbersArray = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            numbersArray[i] = inputNumber % 10;
            inputNumber = inputNumber / 10;
            //     System.out.println(numbersArray[i]);
        }
        return numbersArray;
    }

    public static boolean checkParity(int[] numbersArray) {
        int firstNumber = 0;
        int secondNumber = 0;
        if (numbersArray.length == 1) {
            return true;
        }
        for (int j = 0; j < numbersArray.length - 1; j++) {
            firstNumber = numbersArray[j] % 2;
            secondNumber = numbersArray[j + 1] % 2;
            if (firstNumber == secondNumber) {
                return false;
            }
        }
        return true;
    }

    public static int returnSumOfDigits(int[] numberToCheck) {
        int firstNum = 0;
        int secondNum = 0;
        int sumOfDigits = 0;

        for (int j = 0; j < numberToCheck.length - 1; j++) {
            firstNum = numberToCheck[j] % 2;
            secondNum = numberToCheck[j + 1] % 2;
            if (firstNum == secondNum) {
                sumOfDigits = -1;
                return sumOfDigits;
            }
        }
        for (int k = 0; k < numberToCheck.length; k++) {
            sumOfDigits = sumOfDigits + numberToCheck[k];
        }
        return sumOfDigits;
    }


    public static int index(int[] arrayOfNumbers) {
        int[] arrayOfSum = new int[arrayOfNumbers.length];
        int indexOfChangingNumber = -1;
        int theSmallestSum = -1;
        for (int k = 0; k < arrayOfNumbers.length; k++) {
            arrayOfSum[k] = returnSumOfDigits(prepareNumber(checkDigit(arrayOfNumbers[k]), arrayOfNumbers[k]));
        }
        for (int i = 0; i < arrayOfSum.length; i++) {
            if (arrayOfSum[i] != -1) {
                if (theSmallestSum == -1) {
                    theSmallestSum = arrayOfSum[i];
                    indexOfChangingNumber = i;
                } else if (arrayOfSum[i] < theSmallestSum) {
                    theSmallestSum = arrayOfSum[i];
                    indexOfChangingNumber = i;
                }
            }
        }
        return indexOfChangingNumber;
    }
}



