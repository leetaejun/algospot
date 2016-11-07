package com.taejun.problem_solving;

/**
 * Integer 입력 시, String으로 바꾸는 메소드 만들기
 * String 입력 시, Integer로 바꾸는 메소드 만들기
 *
 * Created by leetaejun on 2016. 10. 23..
 */
public class IntegerStringConvertor {
    public static void main(String[] args) {
        System.out.println(new IntegerStringConvertor().getStringByInteger(154));
        System.out.println(new IntegerStringConvertor().getStringByInteger(-154));
        System.out.println(new IntegerStringConvertor().getIntegerByString("1533"));
        System.out.println(new IntegerStringConvertor().getIntegerByString("-1533"));
    }

    public String getStringByInteger(Integer integer) {
        if (integer == null) {
            return null;
        }

        boolean isNagativeNumber = false;
        if (integer < 0) {
            isNagativeNumber = true;
            integer = Math.abs(integer);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (integer > 0) {
            stringBuilder.append(integer % 10);
            integer /= 10;
        }

        if (isNagativeNumber) {
            stringBuilder.append("-");
        }

        return stringBuilder.reverse().toString();
    }

    public Integer getIntegerByString(String string) {
        if (string == null || string.length() <= 0) {
            return 0;
        }

        boolean isNagativeNumber = false;
        if (string.contains("-")) {
            isNagativeNumber = true;
        }

        char[] reverseStringCharArray = new StringBuilder(string).reverse().toString().toCharArray();
        int resultInteger = 0;

        int setNumber = 1;
        if (isNagativeNumber) {
            for (int i = 0; i < reverseStringCharArray.length-1; i++) {
                resultInteger += (reverseStringCharArray[i] - '0') * setNumber;
                setNumber *= 10;
            }

            resultInteger = -(resultInteger);
        } else {
            for (int i = 0; i < reverseStringCharArray.length; i++) {
                resultInteger += (reverseStringCharArray[i] - '0') * setNumber;
                setNumber *= 10;
            }
        }

        return resultInteger;
    }
}
