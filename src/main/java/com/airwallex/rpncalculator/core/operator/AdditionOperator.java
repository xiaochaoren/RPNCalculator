package com.airwallex.rpncalculator.core.operator;

import java.util.Deque;

/**
 * @author zhangchao
 * @version AdditionOperator.java, v 0.1 2020/7/1 10:12 下午
 */
public class AdditionOperator extends BinaryOperator {

    /**
     * constructor to build AbstractOperator
     *
     * @param stack the stack storing the operands
     */
    public AdditionOperator(Deque<Double> stack) {
        super(stack);
    }

    @Override
    protected double calculate(double operandA, double operandB) {
        return operandA + operandB;
    }
}
