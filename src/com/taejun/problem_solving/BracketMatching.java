package com.taejun.problem_solving;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by leetaejun on 2016. 10. 24..
 */
public class BracketMatching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String bracketString = scanner.next();
            System.out.println(new BracketMatching().isMatching(bracketString));
        }
    }

    public boolean isMatching(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }

        Stack<Character> matchingStack = new Stack<>();
        char[] inputCharArray = input.toCharArray();
        for (char c : inputCharArray) {
            if (BracketType.isOpenChar(c)){
                matchingStack.push(c);
            } else {
                if (matchingStack.isEmpty()) {
                    return false;
                }
                Character popedBracket = matchingStack.pop();
                if(!BracketType.isMatch(popedBracket,c)) return false;
            }
        }

        return matchingStack.isEmpty();
    }

    public enum BracketType {
        SMALL('(', ')'),
        MEDIUM('{', '}'),
        BIG('[', ']');
        private char open;
        private char close;
        private static Map<Character, Character> matchMap = new HashMap<>();

        static {
            for (BracketType bracketType : BracketType.values()) {
                matchMap.put(bracketType.open, bracketType.close);
            }
        }

        BracketType(char open, char close) {
            this.open = open;
            this.close = close;
        }

        public static boolean isOpenChar(char c) {
            for(BracketType bracketType : BracketType.values()) {
                if(c==bracketType.open) return true;
            }
            return false;
        }

        public static boolean isMatch(char open, char close) {
            return matchMap.get(open) != null && matchMap.get(open).equals(close);
        }

    }
}
