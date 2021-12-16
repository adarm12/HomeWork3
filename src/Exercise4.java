public class Exercise4 {

    public static void main(String[] args) {
        int[] array = {15, 19, 17, 16, 18};
        /*
        System.out.println(checkIfTheArrayIsFull(array));
        System.out.println(biggestNumberOnTheArray(array));
        System.out.println(fullDescendingArray(array));
        */
    }

    public static int smallestNumberOnTheArray(int[] array) {
        int smallestNumberOnTheArray = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            if (smallestNumberOnTheArray < array[i + 1])
                array[i]++;
            else
                smallestNumberOnTheArray = array[i + 1];
        }
        return smallestNumberOnTheArray;
    }

    public static int biggestNumberOnTheArray(int[] array) {
        int biggestNumberOnTheArray = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            if (biggestNumberOnTheArray > array[i + 1])
                array[i]++;
            else
                biggestNumberOnTheArray = array[i + 1];
        }
        return biggestNumberOnTheArray;
    }

    public static boolean checkNumberOnTheArray(int[] arrayOfNumbers, int numberToCheck) {
        boolean numberOnTheArray = false;
        for (int j = 0; j < arrayOfNumbers.length; j++) {
            if (numberToCheck == arrayOfNumbers[j]) {
                numberOnTheArray = true;
            }
        }
        return numberOnTheArray;
    }

    public static boolean checkIfTheArrayIsFull(int[] arrayToCheck) {
        int smallestNumber = smallestNumberOnTheArray(arrayToCheck);
        int biggestNumber = biggestNumberOnTheArray(arrayToCheck);
        int arrayLength = (biggestNumber - smallestNumber);
        int counter = 1;
        boolean ifIsFull = false;
        if (arrayLength == arrayToCheck.length) {
            for (int k = 1; k < arrayLength; k++) {
                if (checkNumberOnTheArray(arrayToCheck, smallestNumber + k) == true) {
                    counter++;
                }
                ifIsFull = true;
            }
        }
        return ifIsFull;
    }

    public static boolean isFullDescendingArray(int[] descendingArray) {
        boolean fullDescendingArray = true;
        int newCounter = 1;
        for (int j = 1; j < descendingArray.length - 1; j++) {
            if (descendingArray[j + 1] - descendingArray[j] == 1) {
                newCounter++;
            }
            if (newCounter + 1 == descendingArray.length) {
                fullDescendingArray = false;
            }
        }
        return fullDescendingArray;
    }
}

