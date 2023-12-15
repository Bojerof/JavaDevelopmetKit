package Lecture.Lesson_3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private Number[] numbers;
    private char operator = ' ';

    public Calculator(String formula) {
        String regex = "(\\d+\\.?\\d*)\\s*([+-/*//])\\s*(\\d+\\.?\\d*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(formula);

        if (matcher.matches()) {
            System.out.println(matcher.matches());
            System.out.println(matcher.groupCount());
            int j = 0;
            numbers = new Number[matcher.groupCount() - 1];
            for (int i = 1; i <= matcher.groupCount(); i++) {
                String elem = matcher.group(i);
                if (elem.equals("*") || elem.equals("/") || elem.equals("+") || elem.equals("-")) {
                    this.operator = elem.charAt(0);
                    continue;
                } else {
                    this.numbers[j] = checkNumberType(elem);
                    j++;
                }
            }
            System.out.println("a: " + numbers[0] + " Class: " + numbers[0].getClass().getSimpleName());
            System.out.println("b: " + numbers[1] + " Class: " + numbers[1].getClass().getSimpleName());
            System.out.println("Operator: " + operator);
        } else {
            throw new ArithmeticException("Некорреткная формула");
        }
        switch (operator) {
            case '*':
                Number multipled = multiply(numbers[0], numbers[1]);
                System.out.println("Итог умножения: " + multipled + " Class: " + multipled.getClass().getSimpleName());
                break;
            case '-':
                Number substracted = substract(numbers[0], numbers[1]);
                System.out.println("Итог вычитания: " + substracted + " Class: " + substracted.getClass().getSimpleName());
                break;
            case '+':
                Number summ = sum(numbers[0], numbers[1]);
                System.out.println("Итог суммирования: " + summ + " Class: " + summ.getClass().getSimpleName());
                break;
            case '/':
                Number divided = divide(numbers[0], numbers[1]);
                System.out.println("Итог деления: " + divided + " Class: " + divided.getClass().getSimpleName());
                break;
        }


    }

    public <E extends Number> E checkNumberType(String strNumber) {
        E curNumber;
        try {
            curNumber = (E) new Integer((int) Integer.valueOf(strNumber));
        } catch (NumberFormatException e) {
            try {
                curNumber = (E) new Long((long) Long.valueOf(strNumber));
            } catch (NumberFormatException f) {
                try {
                    curNumber = (E) new Float((float) Float.valueOf(strNumber));
                } catch (NumberFormatException ex) {
                    try {
                        curNumber = (E) new Double((double) Double.valueOf(strNumber));
                    } catch (NumberFormatException ef) {
                        throw new RuntimeException(ef);
                    }
                }
            }
        }
        return curNumber;
    }

    public <T extends Number, K extends Number, E extends Number> E[] checkMaxType(T a, K b) {
        if (a instanceof Double || b instanceof Double) {
            Double[] curArray = new Double[2];
            curArray[0] = a.doubleValue();
            curArray[1] = b.doubleValue();
            return (E[]) curArray;
        }
        if (a instanceof Float || b instanceof Float) {
            Float[] curArray = new Float[2];
            curArray[0] = a.floatValue();
            curArray[1] = b.floatValue();
            return (E[]) curArray;
        }
        if (a instanceof Long || b instanceof Long) {
            Long[] curArray = new Long[2];
            curArray[0] = a.longValue();
            curArray[1] = b.longValue();
            return (E[]) curArray;
        } else {
            Integer[] curArray = new Integer[2];
            curArray[0] = a.intValue();
            curArray[1] = b.intValue();
            return (E[]) curArray;
        }

    }

    public <T extends Number, K extends Number, E extends Number> E sum(T a, K b) {
        E[] curNumbers = checkMaxType(a, b);
        System.out.println("a: " + curNumbers[0] + " Class: " + curNumbers[0].getClass().getSimpleName());
        System.out.println("b: " + curNumbers[1] + " Class: " + curNumbers[1].getClass().getSimpleName());
        if (curNumbers[0] instanceof Double) {
            return (E) (Double) (curNumbers[0].doubleValue() + curNumbers[1].doubleValue());
        } else if (curNumbers[0] instanceof Float) {
            return (E) (Float) (curNumbers[0].floatValue() + curNumbers[1].floatValue());
        } else {
            return (E) (Long) (curNumbers[0].longValue() + curNumbers[1].longValue());
        }
    }

    public <T extends Number, K extends Number, E extends Number> E divide(T a, K b) {
        E[] curNumbers = checkMaxType(a, b);
        System.out.println("a: " + curNumbers[0] + " Class: " + curNumbers[0].getClass().getSimpleName());
        System.out.println("b: " + curNumbers[1] + " Class: " + curNumbers[1].getClass().getSimpleName());
        if (curNumbers[0] instanceof Double) {
            return (E) (Double) (curNumbers[0].doubleValue() / curNumbers[1].doubleValue());
        } else if (curNumbers[0] instanceof Float) {
            return (E) (Float) (curNumbers[0].floatValue() / curNumbers[1].floatValue());
        } else {
            return (E) (Float) (curNumbers[0].floatValue() / curNumbers[1].floatValue());
        }
    }

    public <T extends Number, K extends Number, E extends Number> Number multiply(T a, K b) {
        E[] curNumbers = checkMaxType(a, b);
        System.out.println("a: " + curNumbers[0] + " Class: " + curNumbers[0].getClass().getSimpleName());
        System.out.println("b: " + curNumbers[1] + " Class: " + curNumbers[1].getClass().getSimpleName());
        if (curNumbers[0] instanceof Double) {
            return (E) (Double) (curNumbers[0].doubleValue() * curNumbers[1].doubleValue());
        } else if (curNumbers[0] instanceof Float) {
            return (E) (Float) (curNumbers[0].floatValue() * curNumbers[1].floatValue());
        } else {
            return (E) (Long) (curNumbers[0].longValue() * curNumbers[1].longValue());
        }
    }

    public <T extends Number, K extends Number, E extends Number> Number substract(T a, K b) {
        E[] curNumbers = checkMaxType(a, b);
        System.out.println("a: " + curNumbers[0] + " Class: " + curNumbers[0].getClass().getSimpleName());
        System.out.println("b: " + curNumbers[1] + " Class: " + curNumbers[1].getClass().getSimpleName());
        if (curNumbers[0] instanceof Double) {
            return (E) (Double) (curNumbers[0].doubleValue() - curNumbers[1].doubleValue());
        } else if (curNumbers[0] instanceof Float) {
            return (E) (Float) (curNumbers[0].floatValue() - curNumbers[1].floatValue());
        } else {
            return (E) (Long) (curNumbers[0].longValue() - curNumbers[1].longValue());
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите формулу: ");
        String formula = scn.nextLine();
        new Calculator(formula);
    }
}
