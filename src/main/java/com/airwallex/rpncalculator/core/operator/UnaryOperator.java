package com.airwallex.rpncalculator.core.operator;

import com.airwallex.rpncalculator.core.exception.DividedByZeroException;
import com.airwallex.rpncalculator.core.exception.InsufficientParametersException;

import java.util.Deque;

/**
 * @author zhangchao
 * @version UnaryOperator.java, v 0.1 2020/7/1 11:08 下午
 */
public abstract class UnaryOperator extends AbstractOperator {
    /**
     * operand
     */
    private double operand;

    /**
     * constructor to build AbstractOperator
     *
     * @param stack the stack storing the operands
     */
    public UnaryOperator(Deque<Double> stack) {
        super(stack);
    }

    @Override
    public void undo() throws InsufficientParametersException {
        // the stack must at least has one operand
        checkStack(1);

        // pop the result and push the two operands
        stack.pop();
        stack.push(operand);
    }

    @Override
    public void execute() throws InsufficientParametersException, DividedByZeroException {
        // the stack must at least has one operand
        checkStack(1);
        operand = stack.pop();

        // calculate the result
        double result = calculate(operand);

        // push the results onto the stack
        stack.push(result);
    }

    /**
     * calculate the results
     *
     * @param operand the operand of the operation
     * @return result
     */
    protected abstract double calculate(double operand);

}
