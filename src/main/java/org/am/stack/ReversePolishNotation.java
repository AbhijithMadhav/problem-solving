package org.am.stack;

import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {

    private static final Set<String> OPERANDS = Set.of("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens)
            if (isOperand(token)) {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(eval(token, op1, op2)));
            } else
                stack.push(token);
        return Integer.parseInt(stack.pop());
    }

    private Integer eval(String operand, int op1, int op2) {
        return switch (operand) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "*" -> op1 * op2;
            case "/" -> op1 / op2;
            default -> null;
        };
    }

    private boolean isOperand(String token) {
        return OPERANDS.contains(token);
    }
}
