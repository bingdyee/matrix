package io.hikari.labs.gof23.behavioral.interpreter;

import com.google.common.base.Strings;

import java.util.Stack;

/**
 * Interpreter Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-16
 */
public class InterpreterPattern {

    public static void main(String[] args) {
        Context context = new Context();
        context.setInput("98+811+3-3");
        BaseExpression expression = new MathExpression();
        expression.interpreter(context);
        System.err.println(context.getOutput());

        expression = new AutoMathExpression();
        context.setInput("++" + context.getOutput());
        expression.interpreter(context);
        System.err.println(context.getOutput());
    }

}

class Context {

    private String input;
    private int output;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

}

abstract class BaseExpression {
    public abstract void interpreter(Context context);
}

class MathExpression extends BaseExpression {

    @Override
    public void interpreter(Context context) {
        String expression = context.getInput();
        Stack<String> stack = new Stack<>();
        String numStr = "";
        for (char ch : expression.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                numStr += ch;
            } else {
                if (!Strings.isNullOrEmpty(numStr)) {
                    stack.push(numStr);
                    numStr = "";
                }
                stack.push(ch + "");
            }
        }
        stack.push(numStr);
        System.err.println(stack);
        int result = Integer.parseInt(stack.pop());
        String action;
        while (!stack.empty()) {
            action = stack.pop();
            if (!action.matches("[0-9]*")) {
                int value = Integer.parseInt(stack.pop());
                if ("+".equals(action)) {
                    result += value;
                }
                if ("-".equals(action)) {
                    result -= value;
                }
                if ("*".equals(action)) {
                    result *= value;
                }
                if ("/".equals(action)) {
                    result /= value;
                }
            }
        }
        context.setOutput(result);
    }

}

class AutoMathExpression extends BaseExpression {

    @Override
    public void interpreter(Context context) {
        String expression = context.getInput();
        if (expression.contains("++")) {
            int n = Integer.parseInt(expression.replace("++", ""));
            context.setOutput(++n);
        }
        if (expression.contains("--")) {
            int n = Integer.parseInt(expression.replace("--", ""));
            context.setOutput(--n);
        }
    }

}

