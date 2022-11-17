package medium.string.encode_and_decode_strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 271. Encode and Decode Strings (Premium)
 *
 * Design  an algorithm to encode a list of strings to a string.The encoded string
 * is then sent over the network and is decoded back to the original of strings.
 *
 * SOLUTION
 *
 *  1. Variant
 *
 *  Add before each sting length of string and any separator: 4#test4#word8#sequence
 *
 *  2. Variant
 *
 *  Add instruction before encoded string with the index of each string begin and end: [0-4;5-9;10-18]testwordsequence
 *
 *  COMPLEXITY
 *
 *  1. Variant
 *  Time complexity:    O(N)
 *  Space complexity:   O(N)
 *
 *  2. Variant
 *  Time complexity:    O(N)
 *  Space complexity:   O(N)
 *
 *  LINK
 *
 *  https://leetcode.com/problems/encode-and-decode-strings/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<String> input = List.of("test1", "test2");
        Codec codec = new Codec();
        String encode = codec.encode(input);
        List<String> decode = codec.decode(encode);
        System.out.println(encode);
        System.out.println(decode);
    }

    static class Codec {
        public String encode(List<String> str) {
            StringBuilder instruction = new StringBuilder();
            StringBuilder sequence = new StringBuilder();
            int index = 0;
            for (String s : str) {
                instruction
                        .append(index)
                        .append("-")
                        .append(index + s.length() - 1)
                        .append(";");
                index = index + s.length() - 1;
                index++;

                sequence.append(s);
            }

            return instruction.toString() + "#" + sequence.toString();
        }

        public List<String> decode(String s) {
            String instruction = s.split("#")[0];
            String sequence = s.substring(instruction.length() + 1, s.length());

            List<String> result = new ArrayList<>();
            String[] indexes = instruction.split(";");
            for (String index : indexes) {
                int start = Integer.valueOf(index.split("-")[0]);
                int end = Integer.valueOf(index.split("-")[1]);
                result.add(sequence.substring(start, end + 1));
            }

            return result;
        }
    }
}
