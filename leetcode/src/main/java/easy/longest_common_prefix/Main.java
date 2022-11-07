package easy.longest_common_prefix;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    private static final String BREAKER = " ";

    public static void main(String[] args) {
        String[] strings = {"car", "car", "cir"};
        String result = longestCommonPrefix(strings);
        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, Comparator.comparingInt(String::length));

        String result = "";
        char[] shortest = strs[0].toCharArray();

        for (int ch1 = 0; ch1 < shortest.length; ch1++) {
            boolean isContains = true;

            for (int i = 1; i < strs.length; i++) {
                // check if char with the same index equal
                if (strs[i].charAt(ch1) != shortest[ch1]) {
                    isContains = false;
                    break;
                }
            }

            if (isContains) {
                result = result + shortest[ch1];
            } else {
                break;
            }
        }

        return result;
    }
}
