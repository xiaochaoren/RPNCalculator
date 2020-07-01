package com.airwallex.rpncalculator.operator;

import com.airwallex.rpncalculator.exception.InsufficientParametersException;

import java.util.Deque;

/**
 * @author zhangchao
 * @version UndoOperator.java, v 0.1 2020/7/1 11:22 下午
 */
public class UndoOperator extends AbstractOperator {
    /**
     * history of the operations
     */
    private Deque<Operate> histories;

    /**
     * constructor to build AbstractOperator
     *
     * @param stack the stack storing the operands
     */
    public UndoOperator(Deque<Double> stack, Deque<Operate> histories) {
        super(stack);
        this.histories = histories;
    }

    @Override
    public void undo() {
        // do nothing, do not undo an undo operation
    }

    @Override
    public void execute() throws InsufficientParametersException {
        if (histories != null && !histories.isEmpty()) {
            Operate operation = histories.pop();
            operation.undo();
        }
    }
}
