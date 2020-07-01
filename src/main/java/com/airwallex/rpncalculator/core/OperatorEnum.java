package com.airwallex.rpncalculator.core;

/**
 * @author zhangchao
 * @version CalculatorConstants.java, v 0.1 2020/7/1 10:03 下午
 */
public enum OperatorEnum {
    /**
     * addition operator
     */
    addition("+"),

    /**
     * subtraction operator
     */
    subtraction("-"),

    /**
     * multiplication operator
     */
    multiplication("*"),

    /**
     * division operator
     */
    division("/"),

    /**
     * square root
     */
    sqrt("sqrt"),

    /**
     * undo
     */
    undo("undo"),

    /**
     * clear
     */
    clear("clear"),
    ;

    private String operator;

    OperatorEnum(String operator) {
        this.operator = operator;
    }

    public static OperatorEnum getByOperator(String operator) {
        if (operator != null) {
            for (OperatorEnum value : values()) {
                if (value.getOperator().equals(operator)) {
                    return value;
                }
            }
        }
        return null;
    }

    public String getOperator() {
        return operator;
    }
}
