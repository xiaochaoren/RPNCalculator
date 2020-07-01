package com.airwallex.rpncalculator.core.operator;

import java.util.Deque;

/**
 * @author zhangchao
 * @version SqrtOperator.java, v 0.1 2020/7/1 11:12 下午
 */
public class SqrtOperator extends UnaryOperator {
    /**
     * constructor to build AbstractOperator
     *
     * @param stack the stack storing the operands
     */
    public SqrtOperator(Deque<Double> stack) {
        super(stack);
    }

    @Override
    protected double calculate(double operand) {
        return Math.sqrt(operand);
    }
}
