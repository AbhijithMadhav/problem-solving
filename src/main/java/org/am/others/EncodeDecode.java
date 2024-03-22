package org.am.others;

import java.util.LinkedList;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 * Please implement encode and decode
 */
public class EncodeDecode {


    // Crux is to recognise that any special delimiter between the words will not work on the account
    // of the same being included in the string itself
    // However encoding length of words as prefix to each word can't be circumvented as the end boundary
    // of the word is obtained by counting and not looking up for a special delimiter
    // The third point to recognize is that a delimiter is needed inbetween the prefix(the length of the word)
    // and the start of the word itself to account for a word starting with a number
    public String encode(List<String> strs) {
        String result = "";
        for(String str : strs) {
            result = result.concat(str.length() + "#" + str);
        }
        return result;
    }

    public List<String> decode(String str) {

        int i = 0;
        List<String> result = new LinkedList<>();
        while (i < str.length()) {
            String len = "";
            char c = str.charAt(i);
            while (!Character.isDigit(c)) {
                len = len.concat(String.valueOf(c));
                i++;
            }
            assert c == '#';
            int n = Integer.parseInt(len);
            result.add(str.substring(i + 1, i + 1 + n));
            i = i + 1 + n;
        }
        return result;
    }
}
