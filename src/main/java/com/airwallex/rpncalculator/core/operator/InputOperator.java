package com.airwallex.rpncalculator.core.operator;

import com.airwallex.rpncalculator.core.exception.DividedByZeroException;
import com.airwallex.rpncalculator.core.exception.InsufficientParametersException;

import java.util.Deque;

/**
 * @author zhangchao
 * @version InputOperator.java, v 0.1 2020/7/1 11:51 下午
 */
public class InputOperator extends AbstractOperator {
    /**
     * the operand
     */
    private double operand;

    /**
     * constructor to build AbstractOperator
     *
     * @param stack the stack storing the operands
     */
    public InputOperator(Deque<Double> stack, double operand) {
        super(stack);
        this.operand = operand;
    }

    @Override
    public void undo() throws InsufficientParametersException {
        // make sure the stack has at least 1 operand
        checkStack(1);

        stack.pop();
    }

    @Override
    public void execute() throws InsufficientParametersException, DividedByZeroException {
        // make sure the stack is not null
        checkStack(0);

        // push the operand onto the stack
        stack.push(operand);
    }
}
