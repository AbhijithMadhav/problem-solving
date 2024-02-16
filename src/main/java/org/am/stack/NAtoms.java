package org.am.stack;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NAtoms {

    public static final String CLOSE_P = ")";
    public static final String OPEN_P = "(";
    private static final String ELEMENT_PATTERN = "([A-Z][a-z]*\\d*)";
    private static final String OPEN_P_PATTERN = "(\\()";
    private static final String CLOSE_P_PATTERN = "(\\)\\d*)";

    private final Deque<Token> stack = new LinkedList<>();
    private record Token(String name, int freq) implements Comparable<Token>{
        @Override
        public int compareTo(Token o) {
            return this.name.compareTo(o.name);
        }
    }

    public String simplify(String formula) {

        List<String> tokens = tokenize(formula);
        for (String token : tokens) {
            if (token.startsWith(CLOSE_P)) {
                    simplifySubExpression(getMultiplicity(token));
            }
            else
                stack.push(getToken(token));
        }

        Map<String, Integer> freqMap = stack.stream().collect(Collectors.toMap(Token::name, Token::freq, Integer::sum));
        List<String> elements = new ArrayList<>(freqMap.keySet());
        Collections.sort(elements);
        StringJoiner str = new StringJoiner("");
        elements.forEach(element -> {
            str.add(element);
            int freq = freqMap.get(element);
            if (freq > 1)
                str.add(String.valueOf(freq));
        });
        return str.toString();
    }

    private static List<String> tokenize(String formula) {
        Pattern p = Pattern.compile(ELEMENT_PATTERN + "|" + OPEN_P_PATTERN + "|" + CLOSE_P_PATTERN);
        Matcher m = p.matcher(formula);
        List<String> tokens = new LinkedList<>();
        while(m.find())
        {
            String token = m.group();
            tokens.add(token);
        }
        return tokens;
    }

    private static Token getToken(String token) {
        if (token.equals(OPEN_P) || token.equals(CLOSE_P))
            return new Token(token, 1);

        Pattern pattern = Pattern.compile("([A-Z][a-z]*)|(\\d*)");
        Matcher matcher = pattern.matcher(token);
        matcher.find();
        String name = matcher.group();
        matcher.find();
        int freq = 1;
        if (!Objects.equals(matcher.group(), "")) {
            freq = Integer.parseInt(matcher.group());
        }
        return new Token(name, freq);
    }

    private static int getMultiplicity(String token) {
        String[] split = token.split("\\)");
        int freq = 1;
        if (split.length > 0)
            freq = Integer.parseInt(split[1]);
        return freq;
    }

    private void simplifySubExpression(int n) {
        Deque<Token> subExprStack = new LinkedList<>();
        Token token;
        do {
            token = stack.pop();
            if (!token.name.equals(OPEN_P) && !token.name.equals(CLOSE_P)) {
                subExprStack.push(new Token(token.name, token.freq * n));
            }
        } while (!token.name.equals(OPEN_P));
        while (!subExprStack.isEmpty()) {
            stack.push(subExprStack.pop());
        }
    }


}
