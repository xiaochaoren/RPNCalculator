package com.airwallex.rpncalculator.test;

import com.airwallex.rpncalculator.core.Calculator;
import com.airwallex.rpncalculator.core.exception.DividedByZeroException;
import com.airwallex.rpncalculator.core.exception.InsufficientParametersException;
import com.airwallex.rpncalculator.core.exception.UnknownOperatorException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;

/**
 * @author zhangchao
 * @version CalculatorTest.java, v 0.1 2020/7/2 1:38 下午
 */
public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        try {
            calculator.input("1");
            calculator.input("2");
            calculator.input("+");
            Deque<Double> stack = calculator.getStack();
            Assert.assertEquals(1, stack.size());
            Assert.assertEquals(3, (double) stack.pop(), 0.0);
        } catch (UnknownOperatorException | InsufficientParametersException | DividedByZeroException e) {
            Assert.fail();
        }

    }

    @Test
    public void testAdditionInsufficientParameters() {
        Calculator calculator = new Calculator();
        Deque<Double> stack = calculator.getStack();
        try {
            calculator.input("1");
            calculator.input("+");
            Assert.fail();
        } catch (UnknownOperatorException | DividedByZeroException e) {
            Assert.fail();
        } catch (InsufficientParametersException ignored) {

        }
        Assert.assertEquals(1, (double) stack.pop(), 0);
    }

    @Test
    public void testAdditionUndo() {
        Calculator calculator = new Calculator();
        try {
            calculator.input("1");
            calculator.input("2");
            calculator.input("+");
            calculator.input("undo");
            Deque<Double> stack = calculator.getStack();
            Assert.assertEquals(2, stack.size());
            Assert.assertEquals(2, (double) stack.pop(), 0.0);
            Assert.assertEquals(1, (double) stack.pop(), 0.0);
        } catch (UnknownOperatorException | InsufficientParametersException | DividedByZeroException e) {
            Assert.fail();
        }
    }

    @Test
    public void testSubtraction() {
        Calculator calculator = new Calculator();
        try {
            calculator.input("5");
            calculator.input("2");
            calculator.input("-");
            Deque<Double> stack = calculator.getStack();
            Assert.assertEquals(1, stack.size());
            Assert.assertEquals(3, (double) stack.pop(), 0.0);
        } catch (UnknownOperatorException e) {
            e.printStackTrace();
            Assert.fail();
        } catch (InsufficientParametersException | DividedByZeroException e) {
            Assert.fail();
        }
    }

    @Test
    public void testSubtractionInsufficientParameters() {
        Calculator calculator = new Calculator();
        Deque<Double> stack = calculator.getStack();
        try {
            calculator.input("5");
            calculator.input("-");
            Assert.fail();
        } catch (UnknownOperatorException | DividedByZeroException e) {
            Assert.fail();
        } catch (InsufficientParametersException ignored) {

        }
        Assert.assertEquals(5, (double) stack.pop(), 0);
    }

    @Test
    public void testSubtractionUndo() {
        Calculator calculator = new Calculator();
        try {
            calculator.input("5");
            calculator.input("2");
            calculator.input("-");
            calculator.input("undo");
            Deque<Double> stack = calculator.getStack();
            Assert.assertEquals(2, stack.size());
            Assert.assertEquals(2, (double) stack.pop(), 0.0);
            Assert.assertEquals(5, (double) stack.pop(), 0.0);
        } catch (UnknownOperatorException | InsufficientParametersException | DividedByZeroException e) {
            Assert.fail();
        }
    }

    @Test
    public void testMultiplication() {
        Calculator calculator = new Calculator();
        try {
            calculator.input("2");
            calculator.input("3");
            calculator.input("*");
            Deque<Double> stack = calculator.getStack();
            Assert.assertEquals(1, stack.size());
            Assert.assertEquals(6, (double) stack.pop(), 0.0);
        } catch (UnknownOperatorException | InsufficientParametersException | DividedByZeroException e) {
            Assert.fail();
        }
    }

    @Test
    public void testMultiplicationInsufficientParameters() {
        Calculator calculator = new Calculator();
        Deque<Double> stack = calculator.getStack();
        try {
            calculator.input("2");
            calculator.input("*");
            Assert.fail();
        } catch (UnknownOperatorException | DividedByZeroException e) {
            Assert.fail();
        } catch (InsufficientParametersException ignored) {

        }
        Assert.assertEquals(2, (double) stack.pop(), 0);
    }

    @Test
    public void testMultiplicationUndo() {
        Calculator calculator = new Calculator();
        try {
            calculator.input("2");
            calculator.input("3");
            calculator.input("*");
            calculator.input("undo");
            Deque<Double> stack = calculator.getStack();
            Assert.assertEquals(2, stack.size());
            Assert.assertEquals(3, (double) stack.pop(), 0.0);
            Assert.assertEquals(2, (double) stack.pop(), 0.0);
        } catch (UnknownOperatorException | InsufficientParametersException | DividedByZeroException e) {
            Assert.fail();
        }
    }

    @Test
    public void testDivision() {
        Calculator calculator = new Calculator();
        try {
            calculator.input("6");
            calculator.input("3");
            calculator.input("/");
            Deque<Double> stack = calculator.getStack();
            Assert.assertEquals(1, stack.size());
            Assert.assertEquals(2, (double) stack.pop(), 0.0);
        } catch (UnknownOperatorException | InsufficientParametersException | DividedByZeroException e) {
            Assert.fail();
        }
    }

    @Test
    public void testDivisionInsufficientParameters() {
        Calculator calculator = new Calculator();
        Deque<Double> stack = calculator.getStack();
        try {
            calculator.input("6");
            calculator.input("*");
            Assert.fail();
        } catch (UnknownOperatorException | DividedByZeroException e) {
            Assert.fail();
        } catch (InsufficientParametersException ignored) {

        }
        Assert.assertEquals(6, (double) stack.pop(), 0);
    }

    @Test
    public void testDivisionUndo() {
        Calculator calculator = new Calculator();
        try {
            calculator.input("6");
            calculator.input("2");
            calculator.input("/");
            calculator.input("undo");
            Deque<Double> stack = calculator.getStack();
            Assert.assertEquals(2, stack.size());
            Assert.assertEquals(2, (double) stack.pop(), 0.0);
            Assert.assertEquals(6, (double) stack.pop(), 0.0);
        } catch (UnknownOperatorException | InsufficientParametersException | DividedByZeroException e) {
            Assert.fail();
        }
    }

    @Test
    public void testDividedByZero() {
        Calculator calculator = new Calculator();
        Deque<Double> stack = calculator.getStack();
        try {
            calculator.input("6");
            calculator.input("0");
            calculator.input("/");
            Assert.fail();
        } catch (UnknownOperatorException | InsufficientParametersException e) {
            Assert.fail();
        } catch (DividedByZeroException e) {
            Assert.assertEquals(0, stack.size());
        }
    }

    @Test
    public void testSqrt() {
        Calculator calculator = new Calculator();
        try {
            calculator.input("9");
            calculator.input("sqrt");
            Deque<Double> stack = calculator.getStack();
            Assert.assertEquals(1, stack.size());
            Assert.assertEquals(3, (double) stack.pop(), 0.0);
        } catch (UnknownOperatorException | InsufficientParametersException | DividedByZeroException e) {
            Assert.fail();
        }
    }

    @Test
    public void testSqrtInsufficientParameters() {
        Calculator calculator = new Calculator();
        Deque<Double> stack = calculator.getStack();
        try {
            calculator.input("sqrt");
            Assert.fail();
        } catch (UnknownOperatorException | DividedByZeroException e) {
            Assert.fail();
        } catch (InsufficientParametersException ignored) {

        }
        Assert.assertEquals(0, stack.size());
    }

    @Test
    public void testSqrtUndo() {
        Calculator calculator = new Calculator();
        try {
            calculator.input("9");
            calculator.input("sqrt");
            calculator.input("undo");
            Deque<Double> stack = calculator.getStack();
            Assert.assertEquals(1, stack.size());
            Assert.assertEquals(9, (double) stack.pop(), 0.0);
        } catch (UnknownOperatorException | InsufficientParametersException | DividedByZeroException e) {
            Assert.fail();
        }
    }

    @Test
    public void testClear() {
        Calculator calculator = new Calculator();
        try {
            calculator.input("1");
            calculator.input("2");
            calculator.input("clear");
            Deque<Double> stack = calculator.getStack();
            Assert.assertEquals(0, stack.size());
        } catch (UnknownOperatorException | InsufficientParametersException | DividedByZeroException e) {
            Assert.fail();
        }
    }

    @Test
    public void testClearEmpty() {
        Calculator calculator = new Calculator();
        try {
            calculator.input("clear");
            Deque<Double> stack = calculator.getStack();
            Assert.assertEquals(0, stack.size());
        } catch (UnknownOperatorException | InsufficientParametersException | DividedByZeroException e) {
            Assert.fail();
        }
    }

    @Test
    public void testClearUndo() {
        Calculator calculator = new Calculator();
        try {
            calculator.input("1");
            calculator.input("2");
            calculator.input("clear");
            calculator.input("undo");
            Deque<Double> stack = calculator.getStack();
            Assert.assertEquals(2, stack.size());
            Assert.assertEquals(2, (double) stack.pop(), 0);
            Assert.assertEquals(1, (double) stack.pop(), 0);
        } catch (UnknownOperatorException | InsufficientParametersException | DividedByZeroException e) {
            Assert.fail();
        }
    }

    @Test
    public void testUndoUndo() {
        Calculator calculator = new Calculator();
        try {
            calculator.input("1");
            calculator.input("2");
            calculator.input("+");
            calculator.input("3");
            calculator.input("*");
            calculator.input("undo");
            calculator.input("undo");
            Deque<Double> stack = calculator.getStack();
            Assert.assertEquals(1, stack.size());
            Assert.assertEquals(3, (double) stack.pop(), 0.0);
        } catch (UnknownOperatorException | InsufficientParametersException | DividedByZeroException e) {
            Assert.fail();
        }
    }

    @Test
    public void testUnknownOperator() {
        Calculator calculator = new Calculator();
        try {
            calculator.input("operator");
            Assert.fail();
        } catch (InsufficientParametersException | DividedByZeroException e) {
            Assert.fail();
        } catch (UnknownOperatorException ignored) {

        }
    }
}
