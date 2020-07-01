package com.airwallex.rpncalculator.core.operator;

import com.airwallex.rpncalculator.core.exception.DividedByZeroException;
import com.airwallex.rpncalculator.core.exception.InsufficientParametersException;

import java.util.Deque;

/**
 * @author zhangchao
 * @version BinaryOperator.java, v 0.1 2020/7/1 10:24 下午
 */
public abstract class BinaryOperator extends AbstractOperator {

    /**
     * operand A
     */
    private double operandA;

    /**
     * operand B
     */
    private double operandB;

    /**
     * constructor to build AbstractOperator
     *
     * @param stack the stack storing the operands
     */
    public BinaryOperator(Deque<Double> stack) {
        super(stack);
    }

    @Override
    public void undo() throws InsufficientParametersException {
        // the stack must at least has one operand
        checkStack(1);

        // pop the result and push the two operands
        stack.pop();
        stack.push(operandA);
        stack.push(operandB);
    }

    @Override
    public void execute() throws InsufficientParametersException, DividedByZeroException {
        // the stack must at least has two operands
        checkStack(2);
        operandB = stack.pop();
        operandA = stack.pop();

        // calculate
        double result = calculate(operandA, operandB);

        // push the result onto the stack
        stack.push(result);
    }

    /**
     * calculate the results
     *
     * @param operandA the first operand of the operation
     * @param operandB the second operand of the operation
     * @return result
     */
    protected abstract double calculate(double operandA, double operandB) throws DividedByZeroException;
}
