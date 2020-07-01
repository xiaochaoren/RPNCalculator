package com.airwallex.rpncalculator.operator;

import com.airwallex.rpncalculator.exception.InsufficientParametersException;

import java.util.Deque;

/**
 * @author zhangchao
 * @version AbstractOperator.java, v 0.1 2020/7/1 9:09 下午
 */
public abstract class AbstractOperator implements Operate {

    /**
     * stack to store the operands
     */
    protected Deque<Double> stack;

    /**
     * constructor to build AbstractOperator
     *
     * @param stack the stack storing the operands
     */
    public AbstractOperator(Deque<Double> stack) {
        this.stack = stack;
    }

    /**
     * check the stack
     */
    protected void checkStack(int minimalSize) throws InsufficientParametersException {
        if (stack == null || stack.size() < minimalSize) {
            throw new InsufficientParametersException();
        }
    }

}
