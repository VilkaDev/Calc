package main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println(calc(scanner.nextLine()));
        }
    }

    public static String calc(String input) {
        int num1 = 0;
        int num2 = 0;
        String rez;
        String operator;
        String [] data = input.split(" ");
        if (data.length > 3) {
            throw new IllegalArgumentException("Допущена ошибка при вводе выражения");
        }

        operator = data[1];
        num1 = convertRomanToArab(data[0]);
        num2 = convertRomanToArab(data[2]);

            if (num1 == -1 && num2 == -1) {
                num1 = Integer.parseInt(data[0]);
                num2 = Integer.parseInt(data[2]);
                if (num1>10 || num1<1 || num2>10 || num2<1) {
                    throw new IllegalArgumentException("Допущена ошибка при вводе выражения");
                }
                int result = calculation(num1, num2, operator);
                return String.valueOf(result);
            } else if (num1 > 0 && num2 > 0) {
                int result = calculation(num1, num2, operator);
                rez = convertArabToRoman(result);
                return rez;
            } else {
                throw new IllegalArgumentException("Допущена ошибка при вводе выражения");
            }
    }

    public static String convertArabToRoman(int a) {
        String[] roman = {"пустая клетка", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        return roman[a];
    }



    public static int convertRomanToArab(String roman) {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }

    public static int calculation (int num1, int num2, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new IllegalArgumentException("Некорректное выражение! Введите заново.");
        };
    }
}
