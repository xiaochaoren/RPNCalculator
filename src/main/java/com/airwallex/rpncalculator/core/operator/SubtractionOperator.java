package com.airwallex.rpncalculator.core.operator;

import java.util.Deque;

/**
 * @author zhangchao
 * @version SubtractionOperator.java, v 0.1 2020/7/1 10:13 下午
 */
public class SubtractionOperator extends BinaryOperator {
    /**
     * constructor to build AbstractOperator
     *
     * @param stack the stack storing the operands
     */
    public SubtractionOperator(Deque<Double> stack) {
        super(stack);
    }

    @Override
    protected double calculate(double operandA, double operandB) {
        return operandA - operandB;
    }
}
