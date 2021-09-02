package com.stacey.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        StringProcessor processor = new StringProcessor();

        System.out.println("1) Reverse order of strings in file");
        processor.reverseStringsInFile("1in.txt", "1out.txt");

        System.out.println("2) Reverse digits in number: ");
        processor.stackDigits(in.nextInt());

        System.out.println("3) List of files in directory: ");
        processor.printTree("d://1root/");

        System.out.println("4) Put positive numbers to beginning, negative to end");
        processor.sortList2(new ArrayList<>(List.of(-1, 2, 0, -4, 22, -33, 2, 98)));

        System.out.println("6) Check brackets: ");
        for (String b : BRACKETS) {
            System.out.printf("expression: %-10s result: %s;\n", b, processor.checkBrackets(b));
        }

        System.out.println("7) Count number of each word: ");
        processor.countWords("7in.txt");

        System.out.println("8) Find closest number to entered: ");
        processor.findClosestNumber(in.nextInt(), new ArrayList<>(List.of(-1, 2, 0, -4, 22, -33, 2, 98)));
    }

    private static final String[] BRACKETS = {
            "()",
            "[]",
            "{}",
            "(())",
            "([])",
            "{()}",
            "((()))",
            "([()])",
            "({[]})",
            "(",
            ")",
            ")(",
            "(()",
            "())",
            "{()",
            "([)]",
            "([(}])",
            "([{]})",
            "( []  { () () ( [] )  })",
            "  "
    };
}
