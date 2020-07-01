package com.airwallex.rpncalculator.operator;

import com.airwallex.rpncalculator.exception.DividedByZeroException;
import com.airwallex.rpncalculator.exception.InsufficientParametersException;

/**
 * @author zhangchao
 * @version Command.java, v 0.1 2020/7/1 9:06 下午
 */
public interface Operate {
    /**
     * undo an execution
     */
    void undo() throws InsufficientParametersException;

    /**
     * execute
     */
    void execute() throws InsufficientParametersException, DividedByZeroException;

}
