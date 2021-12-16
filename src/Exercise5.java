public class Exercise5 {

    public static void main(String args[]) {
        String str1 = "adar maman";
        //  char letter = 'a';
        //  System.out.println(counterOfTimesTheLetterAppears(str1,letter));
        System.out.println(returnLetterWithHighestAppearance(str1));
        //   System.out.println(returnStringWithoutHighestAppearance(str1, 't'));
        System.out.println(changeLettersInStr(str1));
    }

    public static int counterOfTimesTheLetterAppears(String str, char letter) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == letter) {
                counter++;
            }
        }
        return counter;
    }

    public static char returnLetterWithHighestAppearance(String str) {
        int letterTimes = counterOfTimesTheLetterAppears(str, str.charAt(0));
        char letterWhitHighestAppearance = str.charAt(0);
        for (int j = 1; j < str.length(); j++) {
            if (counterOfTimesTheLetterAppears(str, str.charAt(j)) > letterTimes) {
                letterTimes = counterOfTimesTheLetterAppears(str, str.charAt(j));
                letterWhitHighestAppearance = str.charAt(j);
            }

        }
        return letterWhitHighestAppearance;
    }

    public static String returnStringWithoutHighestAppearance(String str, char deleteLetter) {
        String strWithoutLetter = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != deleteLetter)
                strWithoutLetter = strWithoutLetter + str.charAt(i);
        }
        return strWithoutLetter;
    }

    public static String changeLettersInStr(String strToChange) {
        char firstHighestLetter = returnLetterWithHighestAppearance(strToChange);
        char secondHighestLetter;
        String newString = "";
        String strWithoutLetter = returnStringWithoutHighestAppearance(strToChange, firstHighestLetter);
        if (strWithoutLetter == "") {
            newString = strToChange;
        } else {
            secondHighestLetter = returnLetterWithHighestAppearance(strWithoutLetter);
            int nextCharInStr = 0;
            for (int i = 0; i < strToChange.length(); i++) {
                if (strToChange.charAt(i) == firstHighestLetter) {
                    newString = newString + secondHighestLetter;
                    nextCharInStr++;
                } else if (strToChange.charAt(i) == secondHighestLetter) {
                    newString = newString + firstHighestLetter;
                    nextCharInStr++;
                } else
                    newString = newString + strToChange.charAt(i);
            }
        }
        return newString;

    }
}
