package com.airwallex.rpncalculator.core;

import com.airwallex.rpncalculator.core.exception.DividedByZeroException;
import com.airwallex.rpncalculator.core.exception.InsufficientParametersException;
import com.airwallex.rpncalculator.core.exception.UnknownOperatorException;
import com.airwallex.rpncalculator.core.operator.Operate;
import com.airwallex.rpncalculator.core.operator.UndoOperator;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangchao
 * @version Calculator.java, v 0.1 2020/7/1 9:22 下午
 */
public class Calculator {
    /**
     * the stack storing the numbers
     */
    private Deque<Double> stack;

    /**
     * histories of the operations
     */
    private Deque<Operate> histories;

    /**
     * constructor to build Calculator
     */
    public Calculator() {
        stack = new LinkedList<>();
        histories = new LinkedList<>();
    }

    /**
     * input numbers or operators to the calculator
     */
    public void input(String token) throws UnknownOperatorException, InsufficientParametersException, DividedByZeroException {
        // get the operator according to the token and then execute it
        Operate operator = OperatorFactory.create(token, stack, histories);

        operator.execute();

        // record the operation if it is not undo
        if (!(operator instanceof UndoOperator)) {
            histories.push(operator);
        }
    }

    /**
     * return the current stack
     * @return the stack
     */
    public Deque<Double> getStack() {
        return stack;
    }
}
