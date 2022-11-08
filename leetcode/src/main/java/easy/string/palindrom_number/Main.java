package easy.string.palindrom_number;

/**
 * 9. Palindrome Number
 *
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward.
 *
 *
 * EXAMPLE
 *
 *      121 is a palindrome while 123 is not.
 *
 *
 * LINK
 *
 * https://leetcode.com/problems/palindrome-number/
 */
public class Main {
    public static void main(String[] args) {
       String input = "121";

        char[] numbers = input.toCharArray();
        int mid = numbers.length/2;
        int count = 0;
        int position = 0;
        boolean result = true;

        while (mid != count){
            char left = numbers[position];
            char right = numbers[numbers.length - position - 1];

            if(left != right){
               result = false;
               break;
            }

            count++;
            position++;
        }

        System.out.println(result);
    }
}
