package com.airwallex.rpncalculator.operator;

import com.airwallex.rpncalculator.exception.DividedByZeroException;

import java.util.Deque;

/**
 * @author zhangchao
 * @version DivisionOperator.java, v 0.1 2020/7/1 10:59 下午
 */
public class DivisionOperator extends BinaryOperator {
    /**
     * constructor to build AbstractOperator
     *
     * @param stack the stack storing the operands
     */
    public DivisionOperator(Deque<Double> stack) {
        super(stack);
    }

    @Override
    protected double calculate(double operandA, double operandB) throws DividedByZeroException {
        if (operandB == 0) {
            throw new DividedByZeroException();
        }
        return operandA / operandB;
    }
}
