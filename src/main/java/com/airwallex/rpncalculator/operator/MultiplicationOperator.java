package com.airwallex.rpncalculator.operator;

import java.util.Deque;

/**
 * @author zhangchao
 * @version MultiplicationOperator.java, v 0.1 2020/7/1 10:59 下午
 */
public class MultiplicationOperator extends BinaryOperator {
    /**
     * constructor to build AbstractOperator
     *
     * @param stack the stack storing the operands
     */
    public MultiplicationOperator(Deque<Double> stack) {
        super(stack);
    }

    @Override
    protected double calculate(double operandA, double operandB) {
        return operandA * operandB;
    }
}
