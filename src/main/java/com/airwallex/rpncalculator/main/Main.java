package com.airwallex.rpncalculator.main;

import com.airwallex.rpncalculator.core.CommandLineProcessor;

/**
 * @author zhangchao
 * @version Main.java, v 0.1 2020/7/1 9:06 下午
 */
public class Main {

    public static void main(String[] args) {
        CommandLineProcessor processor = new CommandLineProcessor();
        processor.start();
    }
}
