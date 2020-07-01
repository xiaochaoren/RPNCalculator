package com.airwallex.rpncalculator.main;

import com.airwallex.rpncalculator.core.Calculator;
import com.airwallex.rpncalculator.core.exception.DividedByZeroException;
import com.airwallex.rpncalculator.core.exception.InsufficientParametersException;
import com.airwallex.rpncalculator.core.exception.UnknownOperatorException;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @author zhangchao
 * @version CommandLineProcessor.java, v 0.1 2020/7/1 9:30 下午
 */
public class CommandLineProcessor {

    /**
     * start the command line processor
     */
    public void start() {
        System.out.println("RPN Calculator has started! Please input RPN expressions.");

        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<Token> tokens = processLine(line);
            for (Token token : tokens) {
                try {
                    // send the token to the calculator to process
                    calculator.input(token.str);
                } catch (UnknownOperatorException e) {
                    System.out.println("Currently the calculator does not support operator: " + token.getStr());
                    // terminate the current processing
                    break;
                } catch (InsufficientParametersException e) {
                    String message = String.format("operator %s (position: %d): insufficient parameters", token.getStr(), token.getIndex() + 1);
                    System.out.println(message);
                    // terminate the current processing
                    break;
                } catch (DividedByZeroException e) {
                    System.out.println("Divided by zero!");
                    // terminate the current processing
                    break;
                }
            }

            // print the stack
            Deque<Double> stack = calculator.getStack();
            printStack(stack);
        }
        scanner.close();
    }

    /**
     * decimal formatter
     */
    private static DecimalFormat df = new DecimalFormat("#.##########");

    /**
     * print the stack content
     */
    private void printStack(Deque<Double> stack) {
        if (stack == null) {
            System.out.println("Stack is null");
            return;
        }

        System.out.print("Stack: ");

        Iterator<Double> iterator = stack.descendingIterator();
        while (iterator.hasNext()) {
            String formattedDouble = df.format(iterator.next());
            System.out.print(formattedDouble + " ");
        }
        System.out.println();
    }

    /**
     * process the line
     */
    private List<Token> processLine(String line) {
        List<Token> tokens = new ArrayList<>();
        if (line == null || line.length() == 0) {
            return tokens;
        }

        int length = line.length();
        int start = 0;
        int i = 0;
        while (i < length) {
            while (i < length && line.charAt(i) != ' ') {
                i++;
            }
            if (start != i) {
                String str = line.substring(start, i);
                Token token = new Token(start, str);
                tokens.add(token);
            }
            i++;
            start = i;
        }

        return tokens;
    }

    /**
     * object to store the token got from the input string
     */
    class Token {
        /**
         * index of the token
         */
        private int index;

        /**
         * str
         */
        private String str;

        /**
         * constructor to build Token
         * @param index the index of the token
         * @param str the detailed content of the token
         */
        public Token(int index, String str) {
            this.index = index;
            this.str = str;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }
}
