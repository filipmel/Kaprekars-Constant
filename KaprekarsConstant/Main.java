package KaprekarsConstant;

import java.util.*;

/*
Program performs the following routine on the number:
Arrange the digits in descending order and in ascending order and subtract the smaller number from the bigger number.
Then repeat the previous step. Performing this routine will always cause you to reach a fixed number: 6174.
Then performing the routine on 6174 will always give you 6174 (7641 - 1467 = 6174).
Your program returns the number of times this routine must be performed until 6174 is reached.
 */

class Main {
    public static int changeToArr(int num) {

        Integer[] digitArr = new Integer[4];
        for (int i = 0; i < 4; i++) {
            digitArr[i] = num % 10;
            num = num / 10;
        }

        int counter = 0;
        for (int i = 0; i < 4; i++) {
            if (digitArr[0] == digitArr[i]) {
                counter++;
            }
        }

        System.out.println("Counter: " + counter);
        if (counter == 4) {
            System.out.println("Error. Needed 4 digit number with at least 2 distinct digits.");
            System.exit(1);
        }

        Arrays.sort(digitArr);
        Integer[] normalArr = new Integer[4];
        for (int i = 0; i < digitArr.length; i++) {
            normalArr[i] = digitArr[i];
        }

        Arrays.sort(digitArr, Collections.reverseOrder());
        Integer[] reversedArr = new Integer[4];
        for (int i = 0; i < digitArr.length; i++) {
            reversedArr[i] = digitArr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (Integer el : normalArr) {
            sb.append(el);
        }

        String normal = sb.toString();
        int normalI = Integer.parseInt(normal);

        StringBuilder sb1 = new StringBuilder();

        for (Integer el : reversedArr) {
            sb1.append(el);
        }

        String reversed = sb1.toString();
        int reversedI = Integer.parseInt(reversed);
        System.out.println(normalI);
        System.out.println(reversedI);

        int result;

        if (normalI > reversedI) {
            result = normalI - reversedI;
        } else {
            result = reversedI - normalI;
        }

        return result;
    }

    public static void main(String[] args) {
        int howManyTimes = 1;
        Scanner s = new Scanner(System.in);
        System.out.println("Input a 4 digit number with at least 2 distinct digits:");
        int output = changeToArr(s.nextInt());
        while (output != 6174) {
            output = changeToArr(output);
            howManyTimes++;
        }

        System.out.println("It took "+howManyTimes+" steps to reach 6174 from the number you choose.");
    }
}