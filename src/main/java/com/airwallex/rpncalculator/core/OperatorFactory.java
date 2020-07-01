package com.airwallex.rpncalculator.core;

import com.airwallex.rpncalculator.exception.UnknownOperatorException;
import com.airwallex.rpncalculator.operator.*;

import java.util.Deque;

/**
 * @author zhangchao
 * @version OperatorFactory.java, v 0.1 2020/7/1 10:02 下午
 */
public class OperatorFactory {

    /**
     * create operators
     */
    public static Operate create(String token, Deque<Double> stack, Deque<Operate> histories) throws UnknownOperatorException {
        // firstly try to parse the token to number
        boolean isNumber = true;
        double number = 0;
        try {
            number = Double.parseDouble(token);
        } catch (NumberFormatException e) {
            isNumber = false;
        }

        if (isNumber) {
            // if the token is a number, return the input operator in which the number will be pushed onto the stack
            return new InputOperator(stack, number);
        }

        OperatorEnum operator = OperatorEnum.getByOperator(token);
        if (operator == null) {
            throw new UnknownOperatorException();
        }

        switch (operator) {
            case addition:
                return new AdditionOperator(stack);
            case subtraction:
                return new SubtractionOperator(stack);
            case multiplication:
                return new MultiplicationOperator(stack);
            case division:
                return new DivisionOperator(stack);
            case sqrt:
                return new SqrtOperator(stack);
            case clear:
                return new ClearOperator(stack);
            case undo:
                return new UndoOperator(stack, histories);
            default:
                throw new UnknownOperatorException();
        }
    }
}
