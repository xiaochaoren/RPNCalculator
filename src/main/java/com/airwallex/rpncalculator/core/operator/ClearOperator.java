package com.airwallex.rpncalculator.core.operator;

import com.airwallex.rpncalculator.core.exception.InsufficientParametersException;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author zhangchao
 * @version ClearOperator.java, v 0.1 2020/7/1 11:12 下午
 */
public class ClearOperator extends AbstractOperator {
    /**
     * backup of the current stack
     */
    private Deque<Double> backup;

    /**
     * constructor to build AbstractOperator
     *
     * @param stack the stack storing the operands
     */
    public ClearOperator(Deque<Double> stack) {
        super(stack);
        backup = new LinkedList<>();
    }

    @Override
    public void undo() {
        restore(stack, backup);
    }

    @Override
    public void execute() throws InsufficientParametersException {
        // only check if the stack is null or not
        checkStack(0);

        // backup the current stack and clear it
        restore(backup, stack);

        stack.clear();
    }

    /**
     * restore the queue from the backup
     * @param queue the target queue to restore
     * @param backup from which the queue is restore
     */
    private void restore(Deque<Double> queue, Deque<Double> backup) {
        // clear the target queue and restore it from the backup
        queue.clear();
        Iterator<Double> iterator = backup.descendingIterator();
        while (iterator.hasNext()) {
            queue.push(iterator.next());
        }
    }
}
